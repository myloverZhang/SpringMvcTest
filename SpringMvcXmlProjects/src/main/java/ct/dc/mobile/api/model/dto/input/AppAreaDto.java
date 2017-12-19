package ct.dc.mobile.api.model.dto.input;

import java.io.Serializable;

/**
 * Created by B41-80 on 2017/1/10.
 */
public class AppAreaDto implements Serializable{
    private Long appId;
    private Integer beginDate;
    private Integer endDate;

    public AppAreaDto() {
    }

    public AppAreaDto(Long appId, Integer beginDate, Integer endDate) {
        this.appId = appId;
        this.beginDate = beginDate;
        this.endDate = endDate;
    }

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
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

    @Override
    public String toString() {
        return "AppAreaDto{" +
                "appId=" + appId +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                '}';
    }
}
