package Data.CommercialContainers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RequstDataForGenericReports {
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

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Integer getUserTenantId() {
        return userTenantId;
    }

    public void setUserTenantId(Integer userTenantId) {
        this.userTenantId = userTenantId;
    }

    public int getLang() {
        return lang;
    }

    public void setLang(int lang) {
        this.lang = lang;
    }

    public int getReportViewType() {
        return reportViewType;
    }

    public void setReportViewType(int reportViewType) {
        this.reportViewType = reportViewType;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public Integer getEventNo() {
        return eventNo;
    }

    public void setEventNo(Integer eventNo) {
        this.eventNo = eventNo;
    }

    public int[] getEventTypeId() {
        return eventTypeId;
    }

    public void setEventTypeId(int[] eventTypeId) {
        this.eventTypeId = eventTypeId;
    }

    public Integer getOwnerTenantId() {
        return ownerTenantId;
    }

    public void setOwnerTenantId(Integer ownerTenantId) {
        this.ownerTenantId = ownerTenantId;
    }

    public Integer getReporterId() {
        return reporterId;
    }

    public void setReporterId(Integer reporterId) {
        this.reporterId = reporterId;
    }

    public Integer getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(Integer assignedTo) {
        this.assignedTo = assignedTo;
    }

    public Integer getAssignedUnit() {
        return assignedUnit;
    }

    public void setAssignedUnit(Integer assignedUnit) {
        this.assignedUnit = assignedUnit;
    }

    public Integer getAssignedSubunit() {
        return assignedSubunit;
    }

    public void setAssignedSubunit(Integer assignedSubunit) {
        this.assignedSubunit = assignedSubunit;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Integer getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(Integer campaignId) {
        this.campaignId = campaignId;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public Integer getLocationTypeId() {
        return locationTypeId;
    }

    public void setLocationTypeId(Integer locationTypeId) {
        this.locationTypeId = locationTypeId;
    }

    public List<Integer> getMunicipalityIds() {
        return municipalityIds;
    }

    public void setMunicipalityIds(List<Integer> municipalityIds) {
        this.municipalityIds = municipalityIds;
    }

    public List<Integer> getDistrictIds() {
        return districtIds;
    }

    public void setDistrictIds(List<Integer> districtIds) {
        this.districtIds = districtIds;
    }

    public List<Integer> getStreetIds() {
        return streetIds;
    }

    public void setStreetIds(List<Integer> streetIds) {
        this.streetIds = streetIds;
    }

    public Integer getReadinessIndicatorId() {
        return readinessIndicatorId;
    }

    public void setReadinessIndicatorId(Integer readinessIndicatorId) {
        this.readinessIndicatorId = readinessIndicatorId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getIssueCount() {
        return issueCount;
    }

    public void setIssueCount(Integer issueCount) {
        this.issueCount = issueCount;
    }

    public Integer getCriticalIssueCount() {
        return criticalIssueCount;
    }

    public void setCriticalIssueCount(Integer criticalIssueCount) {
        this.criticalIssueCount = criticalIssueCount;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public int getReportType() {
        return reportType;
    }

    public void setReportType(int reportType) {
        this.reportType = reportType;
    }

    public int getTimeOffset() {
        return timeOffset;
    }

    public void setTimeOffset(int timeOffset) {
        this.timeOffset = timeOffset;
    }

    public RequstDataForGenericReports
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
