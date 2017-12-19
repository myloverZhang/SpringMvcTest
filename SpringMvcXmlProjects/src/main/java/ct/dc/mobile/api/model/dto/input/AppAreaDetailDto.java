package ct.dc.mobile.api.model.dto.input;

import java.io.Serializable;

/**
 * Created by B41-80 on 2017/1/10.
 */
public class AppAreaDetailDto implements Serializable{
    private String areaId;
    private Integer beginDate;
    private Integer endDate;
    private Long appId;

    public AppAreaDetailDto() {
    }

    public AppAreaDetailDto(String areaId, Integer beginDate, Integer endDate, Long appId) {
        this.areaId = areaId;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.appId = appId;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public Integer getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Integer beginDate) {
        this.beginDate = beginDate;
    }

    public Integer getEndDate() {
        return endDate;
    }

    public void setEndDate(Integer endDate) {
        this.endDate = endDate;
    }

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    @Override
    public String toString() {
        return "AppAreaDetailDto{" +
                "areaId='" + areaId + '\'' +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", appId=" + appId +
                '}';
    }
}
