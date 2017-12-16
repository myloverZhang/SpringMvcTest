package ct.dc.pc.api.model.dto.input;

/**
 * Created by CTWLPC on 2017/6/13.
 */
public class HallChannelByDayDto {
    private Integer beginDate;
    private Integer endDate;
    private Long channelId;
    private Long hallId;

    public HallChannelByDayDto() {
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

    public Long getHallId() {
        return hallId;
    }

    public void setHallId(Long hallId) {
        this.hallId = hallId;
    }

    @Override
    public String toString() {
        return "HallChannelByDayDto{" +
                "beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", channelId=" + channelId +
                ", hallId=" + hallId +
                '}';
    }
}
