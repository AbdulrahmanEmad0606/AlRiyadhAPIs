package CommercialContainers;

import Data.CommercialContainers.ResponseDataForDashBoard;
import MainRequests.RequestSetup;
import Services.CommercialContainersReports;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.List;
import java.util.Map;

public class CommercialContainersReportsTCs extends RequestSetup {

    private final CommercialContainersReports reports = new CommercialContainersReports();

    @Test
    public void checkThatStatusCodeIs200() {
        reports.call(accessToken).then().assertThat().statusCode(200);
    }

    @Test
    public void checkThatTheAddedKeysIsValid() {
        Response response = reports.call(accessToken);
        List<ResponseDataForDashBoard.ReportData> reportDataList = response.as(ResponseDataForDashBoard.class).data.reportData;
        ObjectMapper objectMapper = new ObjectMapper();
        SoftAssert softAssert = new SoftAssert();
        String[] keys = {
                "UnitId", "UnitName", "SubFactorId", "SubFactorName", "MainFactorId", "MainFactorName",
                "MunicipalityId", "MunicipalityName", "DistrictId", "DistrictName", "StreetId", "StreetName",
                "ServiceProviderId", "ServiceProviderName", "ContainerTypeId", "ContainerTypeName",
                "ProcessingOwnerId", "ProcessingOwner", "ProcessingDate", "LastUpdateDate", "ClosedDate",
                "EventId", "EventNo", "CampaignId", "CampaignName", "SupervisorId", "SupervisorName",
                "ReporterId", "ReporterName", "SubmitionDate", "MajorStatusId", "MajorStatusName",
                "EventStatusId", "EventStatusName"
        };
        for (ResponseDataForDashBoard.ReportData reportData : reportDataList) {
            Map<String, Object> reportDataMap = objectMapper.convertValue(reportData, Map.class);
            for (String key : keys) {
                softAssert.assertTrue(reportDataMap.containsKey(key), key + " key is missing");
            }
        }
        softAssert.assertAll();
    }

    @Test
    public void validatePaginationParameters() {
        // Test with valid pagination parameters
        Response response = reports.callWithPagination(accessToken, 1);
        List<ResponseDataForDashBoard.ReportData> reportDataList = response.as(ResponseDataForDashBoard.class).data.reportData;
        Assert.assertEquals(reportDataList.size(), 10, "The number of reports is not correct");
    }

    @Test
    public void validateLastPage() {
        Response initialResponse = reports.call(accessToken);
        int lastIndex = reports.getLastPageIndex(initialResponse);
        Response lastPageResponse = reports.callWithPagination(accessToken, lastIndex);
        int lastPageSize = reports.getLastPageSize(lastPageResponse);
        System.out.println(lastIndex + " " + lastPageSize);
        Assert.assertTrue(lastPageSize <= 10, "The number of reports on the last page is not correct");
    }
}