package MainRequests;

import Data.CommercialContainers.RequestDataForReportInDashBoard;
import Data.CommercialContainers.RequstDataForGenericReports;
import Data.CommercialContainers.UserData;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class RequestSetup {
    public String baseURI = "http://yxdemo.eastus.cloudapp.azure.com/Check/Demo/AlRiyadh/";
    /** Commercial containers KPIS Attributes **/
    // Base path for generic reports API
    protected static String GenaricReportsBasePath = "API/api/Event/GetReports";

    // Base path for KPIs related to commercial containers
    protected static String KPIsBaseBath = "API/api/RiyadhReports/CommercialContainersReportKPIs";

    // Base path for commercial containers reports
    protected static String commercialContainersReportsBasePath = "API/api/RiyadhReports/CommercialContainersReport";

    protected String accessToken;

    protected Response makeApiCallWithSort(String basePath,String sortKey) {
        return given()
                .headers(setHeaders(accessToken))
                .baseUri(baseURI)
                .queryParam(sortKey)
                .basePath(basePath)
                .body(setBodyForGenericReports())
                .post();
    }


    UserData userData = new UserData();

    @BeforeTest
    protected void login() {
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
                .body("username=" + userData.username + "&password=" + userData.password + "&grant_type=password")
                .post();

        accessToken = response.jsonPath().getString("access_token");
          }

    private Map<String, String> setHeaders(String accessToken) {
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

    protected RequestDataForReportInDashBoard setBody() {
        return new RequestDataForReportInDashBoard(
                "", new int[]{}, new int[]{}, new int[]{}, new int[]{}, new int[]{}, new int[]{}, new int[]{}, new String[]{}, new String[]{}, new String[]{}, new int[]{}, "", "", "", ""
        );
    }

    protected RequstDataForGenericReports setBodyForGenericReports() {
        return new RequstDataForGenericReports(
                null, "date_desc", 0, 1000, 5422, null, 0, 3, null, null, new int[]{1038}, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, -180
        );
    }
}