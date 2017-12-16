package ct.dc.pc.api.model.dto.input;

import java.io.Serializable;

/**
 * Created by CTWLPC on 2017/6/13.
 */
public class HallChannelTagByDaysDto implements Serializable{
    private Integer beginDate;
    private Integer endDate;
    private String channelTag;
    private Long hallId;

    public HallChannelTagByDaysDto() {
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

    public Long getHallId() {
        return hallId;
    }

    public void setHallId(Long hallId) {
        this.hallId = hallId;
    }

    @Override
    public String toString() {
        return "HallChannelTagByDaysDto{" +
                "beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", channelTag='" + channelTag + '\'' +
                ", hallId=" + hallId +
                '}';
    }
}
