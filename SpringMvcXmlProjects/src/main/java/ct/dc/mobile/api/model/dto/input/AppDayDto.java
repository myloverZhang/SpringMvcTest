package ct.dc.mobile.api.model.dto.input;

import java.io.Serializable;

/**
 * Created by B41-80 on 2017/1/9.
 */
public class AppDayDto implements Serializable{
    private Long appId;
    private Integer date;

    public AppDayDto() {
    }

    public AppDayDto(Long appId, Integer date) {
        this.appId = appId;
        this.date = date;
    }

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "AppDayDto{" +
                "appId=" + appId +
                ", date=" + date +
                '}';
    }
}
