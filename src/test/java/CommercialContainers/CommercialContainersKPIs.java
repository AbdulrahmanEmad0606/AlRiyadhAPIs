package CommercialContainers;

import Data.CommercialContainers.ResponseDataForDashBoard;
import Data.CommercialContainers.KPISResponseData;
import Data.CommercialContainers.ResponseDataForGeneralReports;
import MainRequests.RequestSetup;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

import static io.restassured.RestAssured.given;

public class CommercialContainersKPIs extends RequestSetup {
    private static String GenaricReportsBasePath = "API/api/Event/GetReports";
    private static String KPIsBaseBath = "API/api/RiyadhReports/CommercialContainersReportKPIs";
    private static String commercialContainersReportsBasePath = "API/api/RiyadhReports/CommercialContainersReport";

    @Test(priority = 1)
    public void checkThatStatusCodeIs200() {
        Response response = makeApiCallWithFilter(KPIsBaseBath);
        response.then().assertThat().statusCode(200);
    }

    @Test(priority = 2)
    public void checkDistinctStreets() {
        Response response = makeApiCall(GenaricReportsBasePath);
        ResponseDataForDashBoard dataTableData = response.as(ResponseDataForDashBoard.class);
        Response kpisResponse = makeApiCall(KPIsBaseBath);
        KPISResponseData kpisData = kpisResponse.as(KPISResponseData.class);

        Set<String> distinctNames = new HashSet<>();
        if (dataTableData != null && dataTableData.data != null) {
            for (ResponseDataForDashBoard.ReportData reportData : dataTableData.data.reportData) {
                distinctNames.add(reportData.streetName);
            }
        }
        Assert.assertEquals(distinctNames.size(), kpisData.data.NumberOfStreets, "Street count is not correct");
    }

    @Test(priority = 3)
    public void checkTotalNumberOfCommercialContainers() {
        Response genaricReportsResponse = makeApiCallWithFilter(GenaricReportsBasePath);
        ResponseDataForGeneralReports reportsData = genaricReportsResponse.as(ResponseDataForGeneralReports.class);
        Response kpisResponse = makeApiCall(KPIsBaseBath);
        KPISResponseData kpisData = kpisResponse.as(KPISResponseData.class);
        Assert.assertEquals(reportsData.Data.eventsCount, kpisData.data.NumberOfCommercialContainers, "The number of reports is not correct");
    }

    @Test(priority = 4)
    public void checkCountOfCommercialWasteTransportation() {
        Response response = makeApiCall(commercialContainersReportsBasePath);
        ResponseDataForDashBoard dataTableData = response.as(ResponseDataForDashBoard.class);
        long count = dataTableData.data.reportData.stream()
                .filter(report -> "حاوية نفايات تجارية".trim().equals(report.containerTypeName))
                .count();
        Response kpisResponse = makeApiCall(KPIsBaseBath);
        KPISResponseData kpisData = kpisResponse.as(KPISResponseData.class);
        Assert.assertEquals(kpisData.data.NumberOfCommercialWasteContainers, count, "Number Of Commercial Waste Containers is not correct");
    }

    @Test(priority = 5)
    public void checkCountOfRestorationContainers() {
        Response response = makeApiCall(commercialContainersReportsBasePath);
        ResponseDataForDashBoard dataTableData = response.as(ResponseDataForDashBoard.class);
        long count = dataTableData.data.reportData.stream()
                .filter(report -> "حاوية ترميم".trim().equals(report.containerTypeName))
                .count();
        Response kpisResponse = makeApiCall(KPIsBaseBath);
        KPISResponseData kpisData = kpisResponse.as(KPISResponseData.class);
        Assert.assertEquals(kpisData.data.NumberOfCommercialRestorationContainers, count, "Number Of Commercial Restoration Containers is not correct");
    }

    @Test(priority = 6)
    public void checkThatUserIsNotAuthorized() {
        Response response = makeApiCall(KPIsBaseBath);
        KPISResponseData reportsData = response.as(KPISResponseData.class);
        boolean isAuthorized = !(reportsData.data.NumberOfCommercialContainers == 0 &&
                reportsData.data.NumberOfCommercialRestorationContainers == 0 &&
                reportsData.data.NumberOfStreets == 0 &&
                reportsData.data.NumberOfCommercialWasteContainers == 0 &&
                reportsData.data.NumberOfViolationsForServiceProvider == 0);
        Assert.assertFalse(isAuthorized, "The user is authorized to view the data");
    }
}