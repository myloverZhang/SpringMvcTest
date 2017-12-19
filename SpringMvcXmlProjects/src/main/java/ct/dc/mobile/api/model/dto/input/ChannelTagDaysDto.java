package ct.dc.mobile.api.model.dto.input;

import java.io.Serializable;

/**
 * Created by B41-80 on 2017/3/13.
 */
public class ChannelTagDaysDto implements Serializable{
    private Integer beginDate;
    private Integer endDate;
    private Long appId;
    private String channelTag;

    public ChannelTagDaysDto() {
    }

    public ChannelTagDaysDto(Integer beginDate, Integer endDate, Long appId, String channelTag) {
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.appId = appId;
        this.channelTag = channelTag;
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

    public String getChannelTag() {
        return channelTag;
    }

    public void setChannelTag(String channelTag) {
        this.channelTag = channelTag;
    }

    @Override
    public String toString() {
        return "ChannelTagDaysDto{" +
                "beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", appId=" + appId +
                ", channelTag='" + channelTag + '\'' +
                '}';
    }
}
