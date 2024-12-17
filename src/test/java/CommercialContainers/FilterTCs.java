package CommercialContainers;

import MainRequests.RequestSetup;
import Services.CommercialContainersReports;
import org.testng.annotations.Test;

public class FilterTCs extends RequestSetup {
    CommercialContainersReports reports = new CommercialContainersReports();

    @Test
    public void checkFilterByUnitName() {
        reports.makeApiCallWithFilter(accessToken, CommercialContainersReports.filterByUnitName())
                .then().assertThat().statusCode(200).extract().response().prettyPrint();
    }

//    @Test
//    public void checkFilterByMainFactor() {
//        reports.makeApiCallWithFilter(accessToken, CommercialContainersReports.filterByMainFactor())
//                .then().assertThat().statusCode(200).extract().response().prettyPrint();
//    }

//    @Test
//    public void checkFilterBySubFactor() {
//        reports.makeApiCallWithFilter(accessToken, CommercialContainersReports.filterBySubFactor())
//                .then().assertThat().statusCode(200).extract().response().prettyPrint();
//    }

    @Test
    public void checkFilterWithInvalidAccessToken() {
        reports.makeApiCallWithFilter("invalidToken", CommercialContainersReports.filterByUnitName())
                .then().assertThat().statusCode(401);
    }

//    @Test
//    public void checkFilterWithEmptyFilter() {
//        reports.makeApiCallWithFilter(accessToken, new RequestDataForReportInDashBoard("", new int[0], new int[0], new int[0], new int[0], new int[0], new int[0], new int[0], new String[0], new String[0], new String[0], new int[0], "", "", "", ""))
//                .then().assertThat().statusCode(200).extract().response().prettyPrint();
//    }

    // check the cascading ceases
}