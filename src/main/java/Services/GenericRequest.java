package Services;
import Data.CommercialContainers.RequestDataForReportInDashBoard;
import Data.CommercialContainers.RequstDataForGenericReports;
import io.restassured.response.Response;

import java.util.Map;


import static io.restassured.RestAssured.given;

public class GenericRequest {
    String endpoint, accessToken;
    public GenericRequest(String endpoint) {
        this.endpoint = endpoint;
    }

    //    String endpoint = "API/api/RiyadhReports/CommercialContainersReportKPIs";
    public String baseURI = "http://yxdemo.eastus.cloudapp.azure.com/Check/Demo/AlRiyadh/";
    public Response call(String accessToken) {

     return given()
             .headers(setHeaders(accessToken))
             .baseUri(baseURI)
             .queryParam("pageSize", 5000)
             .basePath(endpoint)
             .body(setBody())
             .post();
 }

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
    public Response makeApiCallWithFilter(String accessToken) {
        return given()
                .headers(setHeaders(accessToken))
                .baseUri(baseURI)
                .queryParam("pageSize", 500)
                .basePath(endpoint)
                .body(setBodyForGenericReports())
                .post();
    }
    protected RequstDataForGenericReports setBodyForGenericReports() {
        return new RequstDataForGenericReports(
                null, "date_desc", 0, 1000, 5422, null, 0, 3, null, null, new int[]{1038}, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, -180
        );
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

}
