package ct.dc.pc.api.model.domain.channel;

/**
 * Created by CTWLPC on 2017/6/13.
 */
public class RegDetailByDayDo {
    private Integer date;
    private Long channelId;
    private Integer type;
    private Long reg;

    public RegDetailByDayDo() {
        this.date = 0;
        this.channelId = 0L;
        this.reg = 0L;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getReg() {
        return reg;
    }

    public void setReg(Long reg) {
        this.reg = reg;
    }

    @Override
    public String toString() {
        return "RegDetailByDayDo{" +
                "date=" + date +
                ", channelId=" + channelId +
                ", type=" + type +
                ", reg=" + reg +
                '}';
    }
}
