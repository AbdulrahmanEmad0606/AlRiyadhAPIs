package Lighting;


import Data.CommercialContainers.ReportData;
import Data.Lighting.ReportData2;
import MainRequests.RequestSetup;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CommercialContainersKPIs extends RequestSetup {
     ReportData2 setBody() {

        ReportData2 reportData = new ReportData2(
                "",
                new int[]{},
                new int[]{},
                new int[]{},
                new int[]{},
                new int[]{},
                new int[]{},
                new int[]{},
                new int[]{},
                "",
                "",
                "",
                "",
                "",
                "");
       return reportData;
    }
    @Test
    public void checkThatStatusCodeIs200() {

        Response response = given()
                .headers(setHeaders(accessToken))
                .baseUri(baseURI)
                .basePath("API/api/RiyadhReports/LightingReportKPIs")
                .body(setBody()).post()
                .then()
                .assertThat().statusCode(200)
                .contentType(ContentType.JSON)
                .extract().response();
        response.getBody().prettyPrint();
    }

}
