package CommercialContainers;

import Data.CommercialContainers.ResponseDataForDashBoard;
import MainRequests.RequestSetup;
import Services.CommercialContainersReports;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

public class SortTcs extends RequestSetup {
    final CommercialContainersReports reports = new CommercialContainersReports();
    @Test
    public void checkSortingByEventNumber() {
        List<ResponseDataForDashBoard.ReportData> list = reports.makeApiCallWithSort(accessToken, "eventNo")
                .as(ResponseDataForDashBoard.class).data.reportData;
        boolean isSorted = true;
        for (int i = 1; i < list.size(); i++) {
            System.out.println(list.get(i-1).eventNo);
            if (list.get(i).eventNo.compareTo(list.get(i - 1).eventNo) <= 0) {
                isSorted = false;
                break;
            }
        }
        Assert.assertTrue(isSorted, "The list is not sorted by event ID");
    }
    @Test
    public void checkSortingByEventNumberDesc() {
        List<ResponseDataForDashBoard.ReportData> list = reports.makeApiCallWithSort(accessToken, "eventNo_desc")
                .as(ResponseDataForDashBoard.class).data.reportData;
        boolean isSorted = true;
        for (int i = 1; i < list.size(); i++) {
            System.out.println(list.get(i-1).eventNo);
            if (list.get(i).eventNo.compareTo(list.get(i - 1).eventNo) >= 0) {
                isSorted = false;
                break;
            }
        }
        Assert.assertTrue(isSorted, "The list is not sorted by event ID");
    }
    @Test
    public void checkSortingByUnitName() {
        List<ResponseDataForDashBoard.ReportData> list = reports.makeApiCallWithSort(accessToken, "unit")
                .as(ResponseDataForDashBoard.class).data.reportData;
        boolean isSorted = true;
        for (int i = 1; i < list.size(); i++) {
            System.out.println(list.get(i-1).unitName);
            if (list.get(i).unitName.compareTo(list.get(i - 1).unitName) < 0) {
                isSorted = false;
                break;
            }
        }
        Assert.assertTrue(isSorted, "The list is not sorted by event ID");
    }
    @Test
    public void checkSortingByUnitNameDesc() {
        List<ResponseDataForDashBoard.ReportData> list = reports.makeApiCallWithSort(accessToken, "unit_desc")
                .as(ResponseDataForDashBoard.class).data.reportData;
        boolean isSorted = true;
        for (int i = 1; i < list.size(); i++) {
           System.out.println(list.get(i-1).unitName);
            if (list.get(i).unitName.compareTo(list.get(i - 1).unitName) > 0) {
                isSorted = false;
                break;
            }
        }
        Assert.assertTrue(isSorted, "The list is not sorted by unit name");
    }
    @Test
    public void checkSortingByDistrictName() {
        List<ResponseDataForDashBoard.ReportData> list = reports.makeApiCallWithSort(accessToken, "district")
                .as(ResponseDataForDashBoard.class).data.reportData;
        boolean isSorted = true;
        for (int i = 1; i < list.size(); i++) {
            System.out.println(list.get(i-1).districtName);
            if (list.get(i).districtName.compareTo(list.get(i - 1).districtName) < 0) {
                isSorted = false;
                break;
            }
        }
        Assert.assertTrue(isSorted, "The list is not sorted by District ID");
    }
    @Test
    public void checkSortingByDistrictNameDesc() {
        List<ResponseDataForDashBoard.ReportData> list = reports.makeApiCallWithSort(accessToken, "district_desc")
                .as(ResponseDataForDashBoard.class).data.reportData;
        boolean isSorted = true;
        for (int i = 1; i < list.size(); i++) {
            System.out.println(list.get(i-1).districtName);
            if (list.get(i).districtName.compareTo(list.get(i - 1).districtName) > 0) {
                isSorted = false;
                break;
            }
        }
        Assert.assertTrue(isSorted, "The list is not sorted by District name");
    }
    @Test
    public void checkSortingByStreetName() {
        List<ResponseDataForDashBoard.ReportData> list = reports.makeApiCallWithSort(accessToken, "street")
                .as(ResponseDataForDashBoard.class).data.reportData;
        boolean isSorted = true;
        for (int i = 1; i < list.size(); i++) {
            System.out.println(list.get(i-1).streetName);
            if (list.get(i).streetName.compareTo(list.get(i - 1).streetName) < 0) {
                isSorted = false;
                break;
            }
        }
        Assert.assertTrue(isSorted, "The list is not sorted by Street Name");
    }
    @Test
    public void checkSortingByStreetNameDesc() {
        List<ResponseDataForDashBoard.ReportData> list = reports.makeApiCallWithSort(accessToken, "street_desc")
                .as(ResponseDataForDashBoard.class).data.reportData;
        boolean isSorted = true;
        for (int i = 1; i < list.size(); i++) {
            System.out.println(list.get(i-1).streetName);
            if (list.get(i).streetName.compareTo(list.get(i - 1).streetName) > 0) {
                isSorted = false;
                break;
            }
        }
        Assert.assertTrue(isSorted, "The list is not sorted by Street name");
    }
    @Test
    public void checkSortingByMajorStatus() {
        List<ResponseDataForDashBoard.ReportData> list = reports.makeApiCallWithSort(accessToken, "majorStatus")
                .as(ResponseDataForDashBoard.class).data.reportData;
        boolean isSorted = true;
        for (int i = 1; i < list.size(); i++) {
//            System.out.println(list.get(i-1).majorStatusName);
//            if (list.get(i - 1).majorStatusId == null) {
//                list.get(i - 1).majorStatusName = "يييييييي";
//            }
            if (list.get(i).majorStatusName.compareTo(list.get(i - 1).majorStatusName) < 0) {
                isSorted = false;
            }
        }
        Assert.assertTrue(isSorted, "The list is not sorted by Street Name");
    }
    @Test
    public void checkSortingByMajorStatusDesc() {
        List<ResponseDataForDashBoard.ReportData> list = reports.makeApiCallWithSort(accessToken, "majorStatus_desc")
                .as(ResponseDataForDashBoard.class).data.reportData;
        boolean isSorted = true;
        for (int i = 1; i < list.size(); i++) {
            System.out.println(list.get(i-1).streetName);
            if (list.get(i).streetName.compareTo(list.get(i - 1).streetName) > 0) {
                isSorted = false;
                break;
            }
        }
        Assert.assertTrue(isSorted, "The list is not sorted by Street name");
    }







    @Test
    public void checkSortingByReporterName() {
        List<ResponseDataForDashBoard.ReportData> list = reports.makeApiCallWithSort(accessToken, "reporter")
                .as(ResponseDataForDashBoard.class).data.reportData;
        boolean isSorted = true;
        for (int i = 1; i < list.size(); i++) {
            System.out.println(list.get(i-1).reporterName);
            if (list.get(i).reporterName.compareTo(list.get(i - 1).reporterName) < 0) {
                isSorted = false;
                break;
            }
        }
        Assert.assertTrue(isSorted, "The list is not sorted by event ID");
    }
    @Test
    public void checkSortingByReporterNameDesc() {
        List<ResponseDataForDashBoard.ReportData> list = reports.makeApiCallWithSort(accessToken, "reporter_desc")
                .as(ResponseDataForDashBoard.class).data.reportData;
        boolean isSorted = true;
        for (int i = 1; i < list.size(); i++) {
            System.out.println(list.get(i-1).reporterName);
            if (list.get(i).reporterName.compareTo(list.get(i - 1).reporterName) > 0) {
                isSorted = false;
                break;
            }
        }
        Assert.assertTrue(isSorted, "The list is not sorted by event ID");
    }
    @Test
    public void checkSortingBySubmissionDateDesc() {
        List<ResponseDataForDashBoard.ReportData> list = reports.makeApiCallWithSort(accessToken, "submitDate_desc")
                .as(ResponseDataForDashBoard.class).data.reportData;
        boolean isSorted = true;
        for (int i = 1; i < list.size(); i++) {
            System.out.println(list.get(i-1).submitionDate);
            if (list.get(i).submitionDate.compareTo(list.get(i - 1).submitionDate)>0) {
                isSorted = false;
                break;
            }
        }
        Assert.assertTrue(isSorted, "The list is not sorted by Submission date");
    }
    @Test
    public void checkSortingBySubmissionDate() {
        List<ResponseDataForDashBoard.ReportData> list = reports.makeApiCallWithSort(accessToken, "submitDate")
                .as(ResponseDataForDashBoard.class).data.reportData;
        boolean isSorted = true;
        for (int i = 1; i < list.size(); i++) {
            System.out.println(list.get(i-1).submitionDate);
            if (list.get(i).submitionDate.compareTo(list.get(i - 1).submitionDate)<0) {
                isSorted = false;
                break;
            }
        }
        Assert.assertTrue(isSorted, "The list is not sorted by Submission date");
    }





    @Test
    public void checkSortingByEventStatusName() {
        ResponseDataForDashBoard data1 = reports.makeApiCallWithSort(accessToken, "d").as(ResponseDataForDashBoard.class);
        List<ResponseDataForDashBoard.ReportData> list = data1.data.reportData;
        AtomicBoolean isSorted = new AtomicBoolean(false);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).eventStatusName.compareTo(list.get(i - 1).eventStatusName) >= 0) {
                System.out.println(list.get(i).eventStatusName);
                System.out.println(list.size());
                isSorted.set(true);
            }
        }
        Assert.assertTrue(isSorted.get(), "The list is not sorted by event status name");
    }


    @Test
    public void checkSortingByLastUpdateDate() {
        Response response = makeApiCallWithSort(commercialContainersReportsBasePath, "updateDate_desc");
        ResponseDataForDashBoard dataTableData = response.as(ResponseDataForDashBoard.class);
        List<ResponseDataForDashBoard.ReportData> list = dataTableData.data.reportData;

        boolean isSorted = true;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).lastUpdateDate.after(list.get(i - 1).lastUpdateDate)) {
                isSorted = false;
                break;
            }
        }
        Assert.assertTrue(isSorted, "The list is not sorted by last update date");
    }

    @Test
    public void checkSortingByContainerTypeName() {
        ResponseDataForDashBoard data1 = reports.makeApiCallWithSort(accessToken, "dd").as(ResponseDataForDashBoard.class);
        List<ResponseDataForDashBoard.ReportData> list = data1.data.reportData;
        System.out.println(data1.data.reportData.size());
        boolean isSorted = true;
        for (int i = 1; i < list.size(); i++) {

            if (list.get(i).majorStatusName.compareTo(list.get(i - 1).majorStatusName) >= 0) {
                isSorted = false;
                break;
            }
        }
        Assert.assertTrue(isSorted, "The list is not sorted by container type name");
    }

}

