package CommercialContainers;

import Data.CommercialContainers.MapResponseData;
import MainRequests.RequestSetup;
import Services.CommercialContainersMap;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class CommercialContainersReportMapTCs extends RequestSetup {

    private final CommercialContainersMap reports = new CommercialContainersMap();

    @Test
    public void checkThatStatusCodeIs200() {
        reports.call(accessToken).then().assertThat().statusCode(200);
    }

    @Test
    public void checkThatTheAddedKeysIsValid() {
        Response response = reports.call(accessToken);
       List<MapResponseData.ReportData> reportDataList = response.as(MapResponseData.class).data.reportData;
        ObjectMapper objectMapper = new ObjectMapper();
        SoftAssert softAssert = new SoftAssert();

        String[] keys = { "Latitude", "Longitude", "EventId", "EventNo", "CampaignId", "CampaignName",
                "SupervisorId", "SupervisorName", "ReporterId", "ReporterName", "SubmitionDate",
                "MajorStatusId", "MajorStatusName", "EventStatusId", "EventStatusName"
        };

        for (MapResponseData.ReportData reportData : reportDataList) {
            Map<String, Object> reportDataMap = objectMapper.convertValue(reportData, Map.class);
            for (String key : keys) {
                softAssert.assertTrue(reportDataMap.containsKey(key), key + " key is missing");
            }
        }
        softAssert.assertAll();
    }
    @Test
    public void checkLatAndLangValues(){
        Response response = reports.call(accessToken);
        List<MapResponseData.ReportData> reportDataList = response.as(MapResponseData.class).data.reportData;
        SoftAssert softAssert = new SoftAssert();
        for (MapResponseData.ReportData reportData : reportDataList) {
            softAssert.assertFalse(Objects.equals(reportData.latitude, "-1"), "Latitude is not valid");
            softAssert.assertFalse(Objects.equals(reportData.longitude, "-1"), "Longitude is not valid");
        }
        softAssert.assertAll();
    }
}