package CommercialContainers;


import Data.CommercialContainers.KPISResponseData;
import Data.CommercialContainers.GeneralReportsData;
import MainRequests.RequestSetup;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CommercialContainersKPIs extends RequestSetup {

    public int getTotalNumberOfReports() {
        RequestSpecification requestSpecification = given()
                .headers(setHeaders(accessToken))
                .baseUri(baseURI)
                .basePath("API/api/Event/GetReports")
                .body(setBody());
        Response response = requestSpecification.post();
        GeneralReportsData reportsData = response.as(GeneralReportsData.class);
        return  reportsData.Data.eventsCount;
    }
    @Test
    public void checkThatStatusCodeIs200() {
        RequestSpecification requestSpecification = given()
                .headers(setHeaders(accessToken))
                .baseUri(baseURI)
                .basePath("API/api/RiyadhReports/CommercialContainersReportKPIs?timeOffset=-180&[object%20Object]")
                .body(setBody());
                requestSpecification.post()
                        .then()
                        .assertThat().statusCode(200);
    }

    @Test
    public void checkThatTheTotalNumberOfReportsIsCorrect() {

        RequestSpecification requestSpecification = given()
                .headers(setHeaders(accessToken))
                .baseUri(baseURI)
                .basePath("API/api/RiyadhReports/CommercialContainersReportKPIs?timeOffset=-180&[object%20Object]")
                .body(setBody());
        Response response = requestSpecification.post();
        response.prettyPrint();
        KPISResponseData kpisResponseData = response.as(KPISResponseData.class);
        Assert.assertEquals(kpisResponseData.Data.NumberOfCommercialContainers, getTotalNumberOfReports());
    }

}
