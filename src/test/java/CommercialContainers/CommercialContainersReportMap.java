//package CommercialContainers;
//
//import MainRequests.RequestSetup;
//import io.restassured.RestAssured;
//import io.restassured.http.ContentType;
//import io.restassured.response.Response;
//import org.testng.annotations.Test;
//
//public class CommercialContainersReportMap extends RequestSetup {
//    /** Commercial containers KPIS Attributes **/
//    // Base path for KPIs related to commercial containers
//    private static String KPIsBaseBath = "API/api/RiyadhReports/CommercialContainersReportKPIs";
//
//    /** Commercial containers KPIS Methods **/
//
//    /**
//     * Test to check if the status code of the response is 200.
//     */
//    @Test(priority = 1)
//    public void checkThatStatusCodeIs200() {
//        Response response = makeApiCallWithFilter(KPIsBaseBath);
//        response.then().assertThat().statusCode(200);
//    }
//
//}
