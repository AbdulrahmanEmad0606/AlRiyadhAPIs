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
   // CommercialContainersReports commercialContainersReports = new CommercialContainersReports();
    public GenericRequest(String endpoint) {
        this.endpoint = endpoint;
    }
    public String baseURI = "http://yxdemo.eastus.cloudapp.azure.com/Check/Demo/AlRiyadh/";
    protected RequestDataForReportInDashBoard setBody() {
        return new RequestDataForReportInDashBoard(
                "", new int[]{}, new int[]{}, new int[]{}, new int[]{}, new int[]{}, new int[]{}, new int[]{}, new String[]{}, new String[]{}, new String[]{}, new int[]{}, "", "", "", ""
        );
    }
    protected Map<String, String> setHeaders(String accessToken) {
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


    public Response call(String accessToken) {

        return given()
                .headers(setHeaders(accessToken))
                .baseUri(baseURI)
                .queryParam("pageSize", 5000)
                .basePath(endpoint)
                .body(setBody())
                .post();
    }
    public Response makeApiCallWithFilter(String accessToken, RequestDataForReportInDashBoard filterType) {
        return given()
                .headers(setHeaders(accessToken))
                .baseUri(baseURI)
                .queryParam("pageSize", 5000)
                .basePath(endpoint)
                .body(filterType)
                .post();
    }




    public Response makeApiCallWithSort(String accessToken, String sortKey, RequestDataForReportInDashBoard JSONBody) {
        return given()
                .headers(setHeaders(accessToken))
                .baseUri(baseURI)
                .queryParam("SortOrder",sortKey)
                .queryParam("lang", "0")
                .queryParam("pageSize", 5000)
                .basePath(endpoint)
                .body(JSONBody)
                .post();
    }


}
