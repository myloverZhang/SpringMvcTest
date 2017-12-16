package ct.dc.pc.api.model.dto.input;

import java.io.Serializable;

/**
 * Created by CTWLPC on 2017/6/13.
 */
public class ChannelTagByDaysDto implements Serializable{
    private Integer beginDate;
    private Integer endDate;
    private String channelTag;
    private Integer limitNum;

    public ChannelTagByDaysDto() {
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



    public String getChannelTag() {
        return channelTag;
    }

    public void setChannelTag(String channelTag) {
        this.channelTag = channelTag;
    }

    @Override
    public String toString() {
        return "ChannelTagByDaysDto{" +
                "beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", channelTag='" + channelTag + '\'' +
                '}';
    }
}
