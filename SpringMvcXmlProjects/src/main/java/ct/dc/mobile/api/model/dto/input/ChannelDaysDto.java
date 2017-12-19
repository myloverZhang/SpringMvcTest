package ct.dc.mobile.api.model.dto.input;

import java.io.Serializable;

/**
 * Created by B41-80 on 2017/1/18.
 */
public class ChannelDaysDto implements Serializable{
    private Integer beginDate;
    private Integer endDate;
    private Long appId;
    public Long channelId;

    public ChannelDaysDto() {
    }

    public ChannelDaysDto(Integer beginDate, Integer endDate, Long appId, Long channelId) {
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.appId = appId;
        this.channelId = channelId;
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

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    @Override
    public String toString() {
        return "ChannelDaysDto{" +
                "beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", appId=" + appId +
                ", channelId=" + channelId +
                '}';
    }
}
