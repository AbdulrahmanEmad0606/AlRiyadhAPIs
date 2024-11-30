package Services;
import Data.CommercialContainers.RequestDataForReportInDashBoard;
import Data.CommercialContainers.RequstDataForGenericReports;
import Data.CommercialContainers.ResponseDataForDashBoard;
import Data.CommercialContainers.UserData;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

import java.util.List;
import java.util.Map;


import static io.restassured.RestAssured.given;

public class GenericRequest {
   public String endpoint, accessToken;
    UserData userData = new UserData();

    public GenericRequest(String endpoint) {
        this.endpoint = endpoint;
    }
    public String baseURI = "http://yxdemo.eastus.cloudapp.azure.com/Check/Demo/AlRiyadh/";
    protected RequestDataForReportInDashBoard setBody() {
        return new RequestDataForReportInDashBoard(
                "", new int[]{}, new int[]{}, new int[]{}, new int[]{}, new int[]{}, new int[]{}, new int[]{}, new String[]{}, new String[]{}, new String[]{}, new int[]{}, "", "", "", ""
        );
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
    protected RequstDataForGenericReports setBodyForGenericReports() {
        return new RequstDataForGenericReports(
                null, "date_desc", 0, 1000, 5422, null, 0, 3, null, null, new int[]{1038}, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, -180
        );
    }
    public Response call(String accessToken) {

        return given()
                .headers(setHeaders(accessToken))
                .baseUri(baseURI)
                .queryParam("pageSize", 5000)
                .basePath(endpoint)
                .body(setBody())
                .post();
    }
    public Response makeApiCallWithFilter(String accessToken) {
        return given()
                .headers(setHeaders(accessToken))
                .baseUri(baseURI)
                .queryParam("pageSize", 5000)
                .basePath(endpoint)
                .body(setBodyForGenericReports())
                .post();
    }
    public Response makeApiCallWithSort(String accessToken, String sortKey) {
        return given()
                .headers(setHeaders(accessToken))
                .baseUri(baseURI)
                .queryParam("SortOrder",sortKey)
                .queryParam("lang", "0")
                .queryParam("pageSize", 5000)
                .basePath(endpoint)
                .body(setBodyForGenericReports())
                .post();
    }
    public Response callWithPagination(String accessToken, int pageIndex) {
        return given()
                .headers(setHeaders(accessToken))
                .baseUri(baseURI)
                .queryParam("pageSize", 10)
                .queryParam("pageIndex", pageIndex)
                .queryParam("sortKey", "submitDate_desc")
                .basePath(endpoint)
                .body(setBodyForGenericReports())
                .post();
    }
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
}
