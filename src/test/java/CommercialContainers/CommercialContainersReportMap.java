package CommercialContainers;

import Data.CommercialContainers.ReportData;
import MainRequests.RequestSetup;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class CommercialContainersReportMap extends RequestSetup {
    ReportData setBody() {
        /**
         * @param searchString The search string for the report data
         * @param unitIds The unit IDs for the report data
         * @param campaignIds The campaign IDs for the report data
         * @param municipalityIds The municipality IDs for the report data
         * @param districtIds The district IDs for the report data
         * @param streetIds The street IDs for the report data
         * @param majorStatusIds The major status IDs for the report data
         * @param eventStatusIds The event status IDs for the report data
         * @param subFactorIds The sub factor IDs for the report data
         * @param serviceProviderIds The service provider IDs for the report data
         * @param containerTypeIds The container type IDs for the report data
         * @param reporterIds The reporter IDs for the report data
         * @param lastUpdateDateFrom The start date for the last update date range
         * @param lastUpdateDateTo The end date for the last update date range
         * @param submitionDateFrom The start date for the submission date range
         * @param submitionDateTo The end date for the submission date range
         */
        ReportData reportData = new ReportData(
                "",
                new int[]{1080},
                new int[]{},
                new int[]{},
                new int[]{},
                new int[]{},
                new int[]{},
                new int[]{},
                new String[]{},
                new String[]{},
                new String[]{},
                new int[]{},
                "",
                "",
                "",
                "");
        return reportData;
    }
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
