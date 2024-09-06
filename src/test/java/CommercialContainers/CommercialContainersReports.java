package CommercialContainers;

import Data.CommercialContainers.DataTableData;
import Data.CommercialContainers.KPISResponseData;
import Data.CommercialContainers.ReportData;
import MainRequests.RequestSetup;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class CommercialContainersReports extends RequestSetup {
    @Test
    public void checkThatStatusCodeIs200() {

        Response response = RestAssured
                .given()
                .headers(setHeaders(accessToken))
                .baseUri(baseURI).basePath("API/api/RiyadhReports/CommercialContainersReport")
                .body(setBody())
                .post()
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract().response();
        response.getBody().prettyPrint();
    }

    @Test
    public void checkResponse() {
        RequestSpecification requestSpecification = given()
                .headers(setHeaders(accessToken))
                .baseUri(baseURI)
                .basePath("API/api/RiyadhReports/CommercialContainersReport")
                .body(setBody());
        Response response = requestSpecification.post();
        response.prettyPrint();
        DataTableData dataTableData = response.as(DataTableData.class);
        int count = 0;

        // Iterating through the ReportData list to count the occurrences of "حاوية ترميم"
        for (DataTableData.ReportData report : dataTableData.data.reportData) {
            if (report.containerTypeName.equals("حاوية ترميم")) {
                count++;
            }
        }
        System.out.println("Count of ContainerType : " + count);

    }

}
