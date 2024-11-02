package CommercialContainers;


import Data.CommercialContainers.DataTableData;
import Data.CommercialContainers.KPISResponseData;
import Data.CommercialContainers.GeneralReportsData;
import Data.CommercialContainers.ReportData;
import MainRequests.RequestSetup;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.Every.everyItem;
import static org.hamcrest.core.IsEqual.equalTo;

public class CommercialContainersKPIs extends RequestSetup {
    @Test
    public void getTotalNumberOfReports() {
        RequestSpecification requestSpecification = given()
                .headers(setHeaders(accessToken))
                .baseUri(baseURI)
                .basePath("API/api/Event/GetReports")
                .body(setBody());
        Response response = requestSpecification.post();
        GeneralReportsData reportsData = response.as(GeneralReportsData.class);
        System.out.println(reportsData.Data.eventsCount);
        //return  reportsData.Data.eventsCount;
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
            //System.out.println("Number of Streets: " + KPISResponseData.data.NumberOfStreets);
        }
    }

    @Test
    public void checkTotalNumberOfCommercialContainers() {

        RequestSpecification requestSpecification = given()
                .headers(setHeaders(accessToken))
                .baseUri(baseURI)
                .basePath("API/api/RiyadhReports/CommercialContainersReportKPIs")
                .body(setBody());
        Response response = requestSpecification.post();
        response.prettyPrint();
        KPISResponseData kpisResponseData = response.as(KPISResponseData.class);
        System.out.println(kpisResponseData.data.NumberOfCommercialContainers);
        Assert.assertEquals(kpisResponseData.data.NumberOfCommercialContainers,getTotalCountOfGeneralReportsForCommercialContainersReports());

    }

    @Test
    public void checkCountOFCommercialWasteTransportation() {
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
    public void checkCountOFRestorationContainers() {
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
        Assert.assertEquals(KPISResponseData.data.NumberOfCommercialRestorationContainers, count);
        System.out.println("Count of ContainerType : " + KPISResponseData.data
                .NumberOfCommercialRestorationContainers);
        System.out.println("Count of ContainerType : " + count);

    }

    public int getTotalCountOfGeneralReportsForCommercialContainersReports() {

        RequestSpecification requestSpecification = given()
                .headers(setHeaders(accessToken))
                .baseUri(baseURI)
                .basePath("API/api/Event/GetReports")
                .body(setBodyForGenericReports());
        Response response = requestSpecification.post();
        GeneralReportsData dataTableData = response.as(GeneralReportsData.class);
        return dataTableData.Data.eventsCount;
    }
}

