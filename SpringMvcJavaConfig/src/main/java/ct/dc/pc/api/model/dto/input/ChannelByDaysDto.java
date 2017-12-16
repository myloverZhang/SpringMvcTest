package ct.dc.pc.api.model.dto.input;

import io.swagger.models.auth.In;

import java.io.Serializable;

/**
 * Created by CTWLPC on 2017/6/13.
 */
public class ChannelByDaysDto implements Serializable{
    private Integer beginDate;
    private Integer endDate;
    public Long channelId;
    private Integer limitNum;

    public ChannelByDaysDto() {
    }

    public Integer getLimitNum() {
        return limitNum;
    }

    public void setLimitNum(Integer limitNum) {
        this.limitNum = limitNum;
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

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    @Override
    public String toString() {
        return "ChannelByDaysDto{" +
                "beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", channelId=" + channelId +
                '}';
    }
}
