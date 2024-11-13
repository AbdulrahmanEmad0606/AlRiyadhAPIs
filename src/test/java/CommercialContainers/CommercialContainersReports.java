//package CommercialContainers;
//
//import MainRequests.RequestSetup;
//import io.restassured.RestAssured;
//import io.restassured.http.ContentType;
//import io.restassured.response.Response;
//import org.testng.annotations.Test;
//
//import static io.restassured.RestAssured.given;
//
//public class CommercialContainersReports extends RequestSetup {
//    @Test
//    public void checkThatStatusCodeIs200() {
//
//        Response response = RestAssured
//                .given()
//                .headers(setHeaders(accessToken))
//                .baseUri(baseURI).basePath("API/api/RiyadhReports/CommercialContainersReport")
//                .body(setBody())
//                .post()
//                .then()
//                .assertThat()
//                .statusCode(200)
//                .contentType(ContentType.JSON)
//                .extract().response();
//        response.getBody().prettyPrint();
//    }
//
//}
