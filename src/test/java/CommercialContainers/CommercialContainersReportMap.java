package CommercialContainers;

import MainRequests.RequestSetup;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class CommercialContainersReportMap extends RequestSetup {
    @Test
    public void checkThatStatusCodeIs200() {

        Response response = RestAssured
                .given()
                .headers(setHeaders(accessToken))
                .baseUri(baseURI).basePath("API/api/RiyadhReports/CommercialContainersReportMap?lang=0&timeOffset=-180&PageIndex=0&pageSize=300&SortOrder=submitDate_desc&[object%20Object]")
                .body(setBody())
                .post()
                .then()
                .assertThat()
                .statusCode(200) // Adjust this if you expect a different status code
                .contentType(ContentType.JSON)
                .extract().response();
        response.getBody().prettyPrint();
    }
}
