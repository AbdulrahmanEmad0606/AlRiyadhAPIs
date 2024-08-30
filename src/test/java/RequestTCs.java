import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class RequestTCs {
    String baseURI = "http://yxdemo.eastus.cloudapp.azure.com/Check/Demo/AlRiyadh/";
    String accessToken = "";

    @BeforeTest
    public void testPost() {
        Response response = given()
                .headers(Map.of(
                        "Allow-Headers", "Authorization, Content-Type, Allow-Origin",
                        "Enabled", "true",
                        "DNT", "1",
                        "User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/126.0.0.0 Safari/537.36",
                        "Authorization", "bearer undefined",
                        "Allow-Origin", "*",
                        "Content-Type", "application/json",
                        "Accept", "application/json",
                        "Referer", "http://yxdemo.eastus.cloudapp.azure.com/CHECK/Demo/AlRiyadh/Site/login?prevUrl=home"
                ))
                .baseUri(baseURI)
                .basePath("/API/token")
                .body("username=container.rep&password=123456&grant_type=password")
                .post();
        accessToken = response.jsonPath().getString("access_token");
        System.out.println(accessToken);
        response.getBody().prettyPrint();
    }

    @Test
    public void CommercialContainersReportKPIs() {
        Response response = RestAssured
                .given()
                .headers(Map.of(
                        "Accept", "application/json",
                        "Accept-Language", "en-GB,en;q=0.9,ar-EG;q=0.8,ar;q=0.7,en-US;q=0.6",
                        "Allow-Headers", "Authorization, Content-Type,Allow-Origin",
                        "Allow-Origin", "*",
                        "Authorization", "bearer " + accessToken,
                        "Connection", "keep-alive",
                        "Content-Type", "application/json",
                        "DNT", "1",
                        "Enabled", "true",
                        "Referer", "http://yxdemo.eastus.cloudapp.azure.com/CHECK/Demo/AlRiyadh/Site/login?prevUrl=home"
                ))
                .baseUri(baseURI).basePath("API/api/RiyadhReports/CommercialContainersReportKPIs?timeOffset=-180&[object%20Object]")
                .body(
                        "{\"SearchString\":\"\",\"UnitIds\":[],\"CampaignIds\":[],\"MunicipalityIds\":[],\"DistrictIds\":[],\"StreetIds\":[],\"MajorStatusIds\":[],\"EventStatusIds\":[],\"SubFactorIds\":[],\"ServiceProviderIds\":[],\"ContainerTypeIds\":[],\"ReporterIds\":[],\"LastUpdateDateFrom\":\"\",\"LastUpdateDateTo\":\"\",\"SubmitionDateFrom\":\"\",\"SubmitionDateTo\":\"\"}")
                .post()
                .then()
                .assertThat().statusCode(200)
                .contentType(ContentType.JSON)
                .extract().response();
        response.getBody().prettyPrint();
    }

    @Test
    public void CommercialContainersReport() {
        Response response = RestAssured
                .given()
                .headers(Map.of(
                        "Accept", "application/json",
                        "Accept-Language", "en-GB,en;q=0.9,ar-EG;q=0.8,ar;q=0.7,en-US;q=0.6",
                        "Allow-Headers", "Authorization, Content-Type,Allow-Origin",
                        "Allow-Origin", "*",
                        "Authorization", "bearer " + accessToken,
                        "Connection", "keep-alive",
                        "Content-Type", "application/json",
                        "DNT", "1",
                        "Enabled", "true",
                        "Origin", "http://yxdemo.eastus.cloudapp.azure.com"
                ))
                .baseUri(baseURI).basePath("API/api/RiyadhReports/CommercialContainersReport?lang=0&timeOffSet=0&pageIndex=0&pageSize=20&sortOrder=id")
                .body("{\"UnitIds\":[],\"MunicipalityIds\":[],\"DistrictIds\":[],\"StreetIds\":[],\"CampaignIds\":[],\"MajorStatusIds\":[],\"EventStatusIds\":[],\"ReporterIds\":[],\"SubmitionDateFrom\":\"\",\"SubmitionDateTo\":\"\",\"LastUpdateDateFrom\":\"\",\"LastUpdateDateTo\":\"\",\"WorkflowIds\":[],\"SubSupervisoryWorkflowIds\":[],\"SupervisoryTypesIds\":[],\"MainSupervisoryWorkflowIds\":[]}")
                .post()
                .then()
                .assertThat()
                .statusCode(200) // or the expected status code
                .contentType(ContentType.JSON)
                .extract().response();
        response.getBody().prettyPrint();
    }


@Test
public void CommercialContainersReportMap() {

    Response response = RestAssured
            .given()
            .headers(Map.of(
                    "Accept", "application/json",
                    "Accept-Language", "en-GB,en;q=0.9,ar-EG;q=0.8,ar;q=0.7,en-US;q=0.6",
                    "Allow-Headers", "Authorization, Content-Type,Allow-Origin",
                    "Allow-Origin", "*",
                    "Authorization", "bearer " + accessToken,
                    "Connection", "keep-alive",
                    "Content-Type", "application/json",
                    "DNT", "1",
                    "Enabled", "true",
                    "Origin", "http://yxdemo.eastus.cloudapp.azure.com"
            ))
            .baseUri(baseURI).basePath("API/api/RiyadhReports/CommercialContainersReportMap?lang=0&timeOffset=-180&PageIndex=0&pageSize=300&SortOrder=submitDate_desc&[object%20Object]")
            .body("{\"SearchString\":\"\",\"UnitIds\":[],\"CampaignIds\":[],\"MunicipalityIds\":[],\"DistrictIds\":[],\"StreetIds\":[],\"MajorStatusIds\":[],\"EventStatusIds\":[],\"SubFactorIds\":[],\"ServiceProviderIds\":[],\"ContainerTypeIds\":[],\"ReporterIds\":[],\"LastUpdateDateFrom\":\"\",\"LastUpdateDateTo\":\"\",\"SubmitionDateFrom\":\"\",\"SubmitionDateTo\":\"\"}")
            .post()
            .then()
            .assertThat()
            .statusCode(200) // Adjust this if you expect a different status code
            .contentType(ContentType.JSON)
            .extract().response();

    response.getBody().prettyPrint();
}
}


