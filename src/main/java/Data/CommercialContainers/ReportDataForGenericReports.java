package Data.CommercialContainers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ReportDataForGenericReports {
    public String searchString;
    public String sortOrder;
    public int pageIndex;
    public int pageSize;
    public int userId;
    public Integer userTenantId;
    public int lang;
    public int reportViewType;
    public Integer eventId;
    public Integer eventNo;
    public  int[] eventTypeId;
    public Integer ownerTenantId;
    public Integer reporterId;
    public Integer assignedTo;
    public Integer assignedUnit;
    public Integer assignedSubunit;
    public Integer activityId;
    public Integer campaignId;
    public Integer statusId;
    public Integer locationId;
    public Integer locationTypeId;
    public List<Integer> municipalityIds;
    public List<Integer> districtIds;
    public List<Integer> streetIds;
    public Integer readinessIndicatorId;
    public Integer score;
    public Integer issueCount;
    public Integer criticalIssueCount;
    public String fromDate;
    public String toDate;
    public int reportType;
    public int timeOffset;

    public ReportDataForGenericReports
            (String searchString, String sortOrder, int pageIndex, int pageSize, int userId, Integer userTenantId, int lang, int reportViewType, Integer eventId,
             Integer eventNo, int[] eventTypeId, Integer ownerTenantId, Integer reporterId, Integer assignedTo, Integer assignedUnit, Integer assignedSubunit, Integer activityId, Integer campaignId, Integer statusId, Integer locationId, Integer locationTypeId, List<Integer> municipalityIds, List<Integer> districtIds, List<Integer> streetIds, Integer readinessIndicatorId, Integer score, Integer issueCount, Integer criticalIssueCount, String fromDate, String toDate, int reportType, int timeOffset) {
        this.searchString = searchString;
        this.sortOrder = sortOrder;
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.userId = userId;
        this.userTenantId = userTenantId;
        this.lang = lang;
        this.reportViewType = reportViewType;
        this.eventId = eventId;
        this.eventNo = eventNo;
        this.eventTypeId = eventTypeId;
        this.ownerTenantId = ownerTenantId;
        this.reporterId = reporterId;
        this.assignedTo = assignedTo;
        this.assignedUnit = assignedUnit;
        this.assignedSubunit = assignedSubunit;
        this.activityId = activityId;
        this.campaignId = campaignId;
        this.statusId = statusId;
        this.locationId = locationId;
        this.locationTypeId = locationTypeId;
        this.municipalityIds = municipalityIds;
        this.districtIds = districtIds;
        this.streetIds = streetIds;
        this.readinessIndicatorId = readinessIndicatorId;
        this.score = score;
        this.issueCount = issueCount;
        this.criticalIssueCount = criticalIssueCount;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.reportType = reportType;
        this.timeOffset = timeOffset;
    }
}
