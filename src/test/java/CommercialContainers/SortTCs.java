package CommercialContainers;

import Data.CommercialContainers.ResponseDataForDashBoard;
import MainRequests.RequestSetup;
import Services.CommercialContainersReports;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SortTCs extends RequestSetup {
    final CommercialContainersReports reports = new CommercialContainersReports();

    public void checkSorting(String sortField, boolean ascending) {
        List<ResponseDataForDashBoard.ReportData> list = reports.makeApiCallWithSort(accessToken, sortField)
                .as(ResponseDataForDashBoard.class).data.reportData;
        boolean isSorted = true;
        for (int i = 1; i < list.size(); i++) {
            int comparison = compareReportData(list.get(i), list.get(i - 1), sortField);
            if ((ascending && comparison < 0) || (!ascending && comparison < 0)) {
                isSorted = false;
                break;
            }
            System.out.println(ascending + " " + comparison);
        }
        Assert.assertTrue(isSorted, "The list is not sorted by " + sortField);
    }

    public int compareReportData(ResponseDataForDashBoard.ReportData data1, ResponseDataForDashBoard.ReportData data2, String sortField) {
        return switch (sortField) {
            case "eventNo" -> data1.eventNo.compareTo(data2.eventNo);
            case "eventNo_desc" -> data2.eventNo.compareTo(data1.eventNo);
            case "unit" -> data1.unitName.compareTo(data2.unitName);
            case "unit_desc" -> data2.unitName.compareTo(data1.unitName);
            case "district" -> data1.districtName.compareTo(data2.districtName);
            case "district_desc" -> data2.districtName.compareTo(data1.districtName);
            case "subfactor" -> data1.subFactorName.compareTo(data2.subFactorName);
            case "subfactor_desc" -> data2.subFactorName.compareTo(data1.subFactorName);
            case "reporter" -> data1.reporterName.compareTo(data2.reporterName);
            case "reporter_desc" -> data2.reporterName.compareTo(data1.reporterName);
            case "submitDate" -> data1.submitionDate.compareTo(data2.submitionDate);
            case "submitDate_desc" -> data2.submitionDate.compareTo(data1.submitionDate);
            default -> throw new IllegalArgumentException("Invalid sort field: " + sortField);
        };
    }

    @Test
    public void checkSortingByEventNumber() {
        checkSorting("eventNo", true);
    }

    @Test
    public void checkSortingByEventNumberDesc() {
        checkSorting("eventNo_desc", false);
    }

    @Test
    public void checkSortingByUnitName() {
        checkSorting("unit", true);
    }

    @Test
    public void checkSortingByUnitNameDesc() {
        checkSorting("unit_desc", false);
    }

    @Test
    public void checkSortingByDistrictName() {
        checkSorting("district", true);
    }

    @Test
    public void checkSortingByDistrictNameDesc() {
        checkSorting("district_desc", false);
    }

    @Test
    public void checkSortingBySubFactorName() {
        checkSorting("subfactor", true);
    }

    @Test
    public void checkSortingBySubFactorNameDesc() {
        checkSorting("subfactor_desc", false);
    }

    @Test
    public void checkSortingByReporterName() {
        checkSorting("reporter", true);
    }

    @Test
    public void checkSortingByReporterNameDesc() {
        checkSorting("reporter_desc", false);
    }

    @Test
    public void checkSortingBySubmissionDate() {
        checkSorting("submitDate", true);
    }

    @Test
    public void checkSortingBySubmissionDateDesc() {
        checkSorting("submitDate_desc", false);
    }
}