package CommercialContainers;

import MainRequests.RequestSetup;
import Services.CommercialContainersReports;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasKey;

public class CommercialContainersReportsKPIs extends RequestSetup {

    private CommercialContainersReports commercialContainersReports = new CommercialContainersReports();
    @Test
    public void checkThatStatusCodeIs200() {
        Response response = commercialContainersReports.call(accessToken);
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void checkThatTheAddedKeysIsValid() {
        Response response = commercialContainersReports.call(accessToken);
        response.then().assertThat()
                .body("Data", hasKey("ReportData")).extract()
                .response();
    }

}