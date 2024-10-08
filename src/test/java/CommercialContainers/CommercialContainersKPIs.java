package CommercialContainers;


import Data.CommercialContainers.DataTableData;
import Data.CommercialContainers.KPISResponseData;
import Data.CommercialContainers.GeneralReportsData;
import Data.CommercialContainers.ReportData;
import MainRequests.RequestSetup;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        DataTableData dataTableData = response.as(DataTableData.class);
        System.out.println(kpisResponseData.data.NumberOfCommercialContainers);
        System.out.println(dataTableData.data.totalCount);
        Assert.assertEquals(kpisResponseData.data.NumberOfCommercialContainers, dataTableData.data.totalCount);

    }

    @Test
    public void checkResponse2() {
        RequestSpecification requestSpecification = given()
                .headers(setHeaders(accessToken))
                .baseUri(baseURI)
                .queryParam("pageSize", 50)
                .basePath("API/api/RiyadhReports/CommercialContainersReport")
                .body(setBody());
        Response response = requestSpecification.post();
        response.prettyPrint();
        DataTableData dataTableData = response.as(DataTableData.class);
        KPISResponseData KPISResponseData = response.as(KPISResponseData.class);
        int count = 0;

        // Iterating through the ReportData list to count the occurrences of "حاوية ترميم"
        for (DataTableData.ReportData report : dataTableData.data.reportData) {
            if (report.containerTypeName.equals("حاوية ترميم")) {
                count++;
            }
        }
        Assert.assertEquals(KPISResponseData.data.NumberOfCommercialRestorationContainers,count);
        System.out.println("Count of ContainerType : " + KPISResponseData.data
                .NumberOfCommercialRestorationContainers);
        System.out.println("Count of ContainerType : " + count);

    }
    @Test
    public void checkResponse3() {
        RequestSpecification requestSpecification = given()
                .headers(setHeaders(accessToken))
                .baseUri(baseURI)
                .queryParam("pageSize", 500)
                .basePath("API/api/RiyadhReports/CommercialContainersReport")
                .body(setBody());
        Response response = requestSpecification.post();
        response.prettyPrint();
        DataTableData dataTableData = response.as(DataTableData.class);
        int count = 0;

        // Iterating through the ReportData list to count the occurrences of "حاوية ترميم"
        for (DataTableData.ReportData report : dataTableData.data.reportData) {
            if (report.containerTypeName.equals("حاوية نفايات تجارية")) {
                count++;
            }
        }
        System.out.println("عدد بلاغات حاويات النفايات التجارية : " + count);

    }
    @Test
    public void checkDistincitStreets() {
        RequestSpecification requestSpecification = given()
                .headers(setHeaders(accessToken))
                .baseUri(baseURI)
                .queryParam("pageSize", 500)
                .basePath("API/api/RiyadhReports/CommercialContainersReport")
                .body(setBody());

        // Make the API call and get the response
        Response response = requestSpecification.post();
        String jsonResponse = response.asString(); // Get the raw response as a string

      //  System.out.println("API Response: " + jsonResponse); // Debugging output

        // Deserialize into DataTableData and KPISResponseData
        DataTableData dataTableData = response.as(DataTableData.class);
        KPISResponseData kpisResponseData = response.as(KPISResponseData.class);

        // Extract distinct street names
        Set<String> distinctNames = new HashSet<>();
        if (dataTableData != null && dataTableData.data != null) {
            for (DataTableData.ReportData reportData : dataTableData.data.reportData) {
                distinctNames.add(reportData.streetName);
            }
        }

        System.out.println("Distinct Street Names Count: " + distinctNames.size());

        // Check if KPISResponseData is null
        if (kpisResponseData == null || kpisResponseData.data == null) {
            System.out.println("KPISResponseData or its data field is null");
        } else {
            System.out.println("Number of Streets: " + kpisResponseData.data.NumberOfStreets);
        }
    }

}

