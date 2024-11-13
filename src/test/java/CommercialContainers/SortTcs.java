//package CommercialContainers;
//
//import Data.CommercialContainers.ResponseDataForDashBoard;
//import MainRequests.RequestSetup;
//import io.restassured.RestAssured;
//import io.restassured.http.ContentType;
//import io.restassured.response.Response;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import java.util.Date;
//import java.util.List;
//
//public class SortTcs extends RequestSetup {
//
//
//    @Test
//    public void checkSortingByEventId() {
//        Response response = makeApiCallWithFilter("API/api/RiyadhReports/CommercialContainersReport","eventNo");
//        ResponseDataForDashBoard dataTableData = response.as(ResponseDataForDashBoard.class);
//        List<ResponseDataForDashBoard.ReportData> list = dataTableData.data.reportData;
//        boolean isSorted = true;
//        for (int i = 1; i < list.size(); i++) {
//            if (list.get(i).eventId < list.get(i - 1).eventId) {
//                isSorted = false;
//                break;
//            }
//        }
//        Assert.assertTrue(isSorted, "The list is not sorted by event ID");
//    }
//
//    @Test
//    public void checkSortingByUnitNameDesc() {
//        Response response = makeApiCall("unit_desc");
//        ResponseDataForDashBoard dataTableData = response.as(ResponseDataForDashBoard.class);
//        List<ResponseDataForDashBoard.ReportData> list = dataTableData.data.reportData;
//
//        boolean isSorted = true;
//        for (int i = 1; i < list.size(); i++) {
//            if (list.get(i).unitName.compareTo(list.get(i - 1).unitName) > 0) {
//                isSorted = false;
//                break;
//            }
//        }
//        Assert.assertTrue(isSorted, "The list is not sorted by unit name");
//    }
//
//  @Test
//public void checkSortingByReporterName() {
//    Response response = makeApiCall("reporterName");
//    makeApiCall("reporterName");
//    ResponseDataForDashBoard dataTableData = response.as(ResponseDataForDashBoard.class);
//    List<ResponseDataForDashBoard.ReportData> list = dataTableData.data.reportData;
//
//    boolean isSorted = true;
//    for (int i = 1; i < list.size(); i++) {
//        if (list.get(i).reporterName.compareTo(list.get(i - 1).reporterName) > 0) {
//            isSorted = false;
//            break;
//        }
//    }
//    Assert.assertTrue(isSorted, "The list is not sorted by reporter name");
//}
//
//@Test
//public void checkSortingBySubmitionDate() {
//    Response response = makeApiCall("submitionDate");
//    ResponseDataForDashBoard dataTableData = response.as(ResponseDataForDashBoard.class);
//    List<ResponseDataForDashBoard.ReportData> list = dataTableData.data.reportData;
//
//    boolean isSorted = true;
//    for (int i = 1; i < list.size(); i++) {
//        if (list.get(i).submitionDate.before(list.get(i - 1).submitionDate)) {
//            isSorted = false;
//            break;
//        }
//    }
//    Assert.assertTrue(isSorted, "The list is not sorted by submition date");
//}
//@Test
//public void checkSortingByEventStatusName() {
//    Response response = makeApiCall("eventStatus");
//    ResponseDataForDashBoard dataTableData = response.as(ResponseDataForDashBoard.class);
//    List<ResponseDataForDashBoard.ReportData> list = dataTableData.data.reportData;
//
//    boolean isSorted = true;
//    for (int i = 1; i < list.size(); i++) {
//        if (list.get(i).eventStatusName.compareTo(list.get(i - 1).eventStatusName) < 0) {
//            isSorted = false;
//            break;
//        }
//    }
//    Assert.assertTrue(isSorted, "The list is not sorted by event status name");
//}
//
//
//@Test
//public void checkSortingByLastUpdateDate() {
//    Response response = makeApiCall("updateDate_desc");
//    ResponseDataForDashBoard dataTableData = response.as(ResponseDataForDashBoard.class);
//    List<ResponseDataForDashBoard.ReportData> list = dataTableData.data.reportData;
//
//    boolean isSorted = true;
//    for (int i = 1; i < list.size(); i++) {
//        if (list.get(i).lastUpdateDate.after(list.get(i - 1).lastUpdateDate)) {
//            isSorted = false;
//            break;
//        }
//    }
//    Assert.assertTrue(isSorted, "The list is not sorted by last update date");
//}
//
//@Test
//public void checkSortingByContainerTypeName() {
//    Response response = makeApiCall("containertype");
//    ResponseDataForDashBoard dataTableData = response.as(ResponseDataForDashBoard.class);
//    List<ResponseDataForDashBoard.ReportData> list = dataTableData.data.reportData;
//
//    boolean isSorted = true;
//    for (int i = 1; i < list.size(); i++) {
//        if (list.get(i).containerTypeName.compareTo(list.get(i - 1).containerTypeName) < 0) {
//            isSorted = false;
//            break;
//        }
//    }
//    Assert.assertTrue(isSorted, "The list is not sorted by container type name");
//}
//
//}
//
