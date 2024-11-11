package CommercialContainers;


import Data.CommercialContainers.ResponseDataForDashBoard;
import Data.CommercialContainers.KPISResponseData;
import Data.CommercialContainers.ResponseDataForGeneralReports;
import MainRequests.RequestSetup;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

import static io.restassured.RestAssured.given;

public class CommercialContainersKPIs extends RequestSetup {
    @Test
    public void getTotalNumberOfReports() {
        RequestSpecification requestSpecification = given()
                .headers(setHeaders(accessToken))
                .baseUri(baseURI)
                .basePath("API/api/Event/GetReports")
                .body(setBody());
        Response response = requestSpecification.post();
        ResponseDataForGeneralReports reportsData = response.as(ResponseDataForGeneralReports.class);
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


        ResponseDataForDashBoard dataTableData = response.as(ResponseDataForDashBoard.class);
        KPISResponseData kpisResponseData = response.as(KPISResponseData.class);

        // Extract distinct street names
        Set<String> distinctNames = new HashSet<>();
        if (dataTableData != null && dataTableData.data != null) {
            for (ResponseDataForDashBoard.ReportData reportData : dataTableData.data.reportData) {
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

        if (kpisResponseData != null && kpisResponseData.data != null) {
            if (kpisResponseData.data.NumberOfCommercialContainers != 0) {
                System.out.println(kpisResponseData.data.NumberOfCommercialContainers);
            }
            Assert.assertEquals(kpisResponseData.data.NumberOfCommercialContainers, getTotalCountOfGeneralReportsForCommercialContainersReports());
        } else {
            System.err.println("KPISResponseData or its data field is null");
        }
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
        ResponseDataForDashBoard dataTableData = response.as(ResponseDataForDashBoard.class);
        int count = 0;

        // Iterating through the ReportData list to count the occurrences of "حاوية ترميم"
        for (ResponseDataForDashBoard.ReportData report : dataTableData.data.reportData) {
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
        ResponseDataForDashBoard dataTableData = response.as(ResponseDataForDashBoard.class);
        KPISResponseData KPISResponseData = response.as(KPISResponseData.class);
        int count = 0;

        // Iterating through the ReportData list to count the occurrences of "حاوية ترميم"
        for (ResponseDataForDashBoard.ReportData report : dataTableData.data.reportData) {
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
                .body(setBody());
        Response response = requestSpecification.post();
        ResponseDataForGeneralReports dataTableData = response.as(ResponseDataForGeneralReports.class);
        return dataTableData.Data.eventsCount;
    }

    @Test
    public void checkavailabilityOfKey() {

    }
}

