package CommercialContainers;
import Data.CommercialContainers.KPISResponseData;
import Data.CommercialContainers.ResponseDataForDashBoard;
import Data.CommercialContainers.ResponseDataForGeneralReports;
import MainRequests.RequestSetup;
import Services.CommercialContainersReports;
import Services.CommercialContainersKPI;
import Services.GeneralReports;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

public class CommercialContainersKPIsTCs extends RequestSetup {
    private final CommercialContainersKPI kpi = new CommercialContainersKPI();
    private final CommercialContainersReports reports = new CommercialContainersReports();
    private final GeneralReports generalReports = new GeneralReports();

    @Test(priority = 1)
    public void checkThatStatusCodeIs200() {
        kpi.call(accessToken).then().assertThat().statusCode(200);
    }

    @Test(priority = 2)
    public void checkDistinctStreets() {
        ResponseDataForDashBoard data = reports.call(accessToken).as(ResponseDataForDashBoard.class);
        KPISResponseData kpisData = kpi.call(accessToken).as(KPISResponseData.class);
        Set<String> distinctNames = new HashSet<>();
        data.data.reportData.forEach(report -> distinctNames.add(report.streetName));
        Assert.assertEquals(distinctNames.size(), kpisData.data.NumberOfStreets, "Street count is not correct");
    }

    @Test(priority = 3)
    public void checkTotalNumberOfCommercialContainers() {
        ResponseDataForGeneralReports reportsData = generalReports.makeApiCallWithFilter(accessToken).as(ResponseDataForGeneralReports.class);
        KPISResponseData kpisData = kpi.call(accessToken).as(KPISResponseData.class);
        Assert.assertEquals(reportsData.Data.eventsCount, kpisData.data.NumberOfCommercialContainers, "The number of reports is not correct");
    }

    @Test(priority = 4)
    public void checkCountOfCommercialWasteTransportation() {
        ResponseDataForDashBoard data = reports.call(accessToken).as(ResponseDataForDashBoard.class);
        long count = data.data.reportData.stream()
                .filter(report -> "حاوية نفايات تجارية".trim().equals(report.containerTypeName))
                .count();
        KPISResponseData kpisData = kpi.call(accessToken).as(KPISResponseData.class);
        Assert.assertEquals(kpisData.data.NumberOfCommercialWasteContainers, count, "Number Of Commercial Waste Containers is not correct");
    }

    @Test(priority = 5)
    public void checkCountOfRestorationContainers() {
        ResponseDataForDashBoard data = reports.call(accessToken).as(ResponseDataForDashBoard.class);
        long count = data.data.reportData.stream()
                .filter(report -> "حاوية ترميم".trim().equals(report.containerTypeName))
                .count();
        KPISResponseData kpisData = kpi.call(accessToken).as(KPISResponseData.class);
        Assert.assertEquals(kpisData.data.NumberOfCommercialRestorationContainers, count, "Number Of Commercial Restoration Containers is not correct");
    }

    @Test(priority = 6)
    public void checkThatUserIsNotAuthorized() {
        KPISResponseData reportsData = kpi.call(accessToken).as(KPISResponseData.class);
        boolean isAuthorized = !(reportsData.data.NumberOfCommercialContainers == 0 &&
                reportsData.data.NumberOfCommercialRestorationContainers == 0 &&
                reportsData.data.NumberOfStreets == 0 &&
                reportsData.data.NumberOfCommercialWasteContainers == 0 &&
                reportsData.data.NumberOfViolationsForServiceProvider == 0);
        Assert.assertFalse(isAuthorized, "The user is authorized to view the data");
    }
}