package MainRequests;

import Data.CommercialContainers.ReportData;
import Data.CommercialContainers.UserData;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class RequestSetup {
    public String baseURI = "http://yxdemo.eastus.cloudapp.azure.com/Check/Demo/AlRiyadh/";
   public String accessToken;
    UserData userData = new UserData();
    @BeforeTest
    public void login() {
        Response response = given()
                .headers(Map.of(
                        "Allow-Headers", "Authorization, Content-Type, Allow-Origin",
                        "Enabled", "true",
                        "DNT", "1",
                        "User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/126.0.0.0 Safari/537.36",
                        "Authorization", "bearer undefined",
                        "Allow-Origin", "*",
                        "Content-Type", "application/json",
                        "Accept", "application/json",
                        "Referer", "http://yxdemo.eastus.cloudapp.azure.com/CHECK/Demo/AlRiyadh/Site/login?prevUrl=home"
                ))
                .baseUri(baseURI)
                .basePath("/API/token")
                .body("username="+userData.username+"&"+"password="+userData.password+"&"+"grant_type=password")
                .post();

        accessToken = response.jsonPath().getString("access_token");
        System.out.println(accessToken);
        response.getBody().prettyPrint();
    }

    public Map<String, String> setHeaders(String accessToken) {
        return Map.of(
                "Accept", "application/json",
                "Accept-Language", "en-GB,en;q=0.9,ar-EG;q=0.8,ar;q=0.7,en-US;q=0.6",
                "Allow-Headers", "Authorization, Content-Type,Allow-Origin",
                "Allow-Origin", "*",
                "Authorization", "bearer " + accessToken,
                "Connection", "keep-alive",
                "Content-Type", "application/json",
                "DNT", "1",
                "Enabled", "true",
                "Origin", "http://yxdemo.eastus.cloudapp.azure.com"
        );
    }
    public ReportData setBody() {
        /**
         * @param searchString The search string for the report data
         * @param unitIds The unit IDs for the report data
         * @param campaignIds The campaign IDs for the report data
         * @param municipalityIds The municipality IDs for the report data
         * @param districtIds The district IDs for the report data
         * @param streetIds The street IDs for the report data
         * @param majorStatusIds The major status IDs for the report data
         * @param eventStatusIds The event status IDs for the report data
         * @param subFactorIds The sub factor IDs for the report data
         * @param serviceProviderIds The service provider IDs for the report data
         * @param containerTypeIds The container type IDs for the report data
         * @param reporterIds The reporter IDs for the report data
         * @param lastUpdateDateFrom The start date for the last update date range
         * @param lastUpdateDateTo The end date for the last update date range
         * @param submitionDateFrom The start date for the submission date range
         * @param submitionDateTo The end date for the submission date range
         */
        ReportData reportData = new ReportData(
                "",
                new int[]{1080},
                new int[]{},
                new int[]{},
                new int[]{},
                new int[]{},
                new int[]{},
                new int[]{},
                new String[]{},
                new String[]{},
                new String[]{},
                new int[]{},
                "",
                "",
                "",
                "");
        return reportData;
    }
}
