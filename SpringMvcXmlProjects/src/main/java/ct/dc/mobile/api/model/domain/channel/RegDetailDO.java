package ct.dc.mobile.api.model.domain.channel;

import java.io.Serializable;

/**
 * Created by B41-80 on 2017/1/18.
 */
public class RegDetailDO implements Serializable{
    private Integer date;
    private Long channelId;
    private Integer type;
    private Long reg;

    public RegDetailDO() {
    }

    public RegDetailDO(Integer date, Long channelId, Integer type, Long reg) {
        this.date = date;
        this.channelId = channelId;
        this.type = type;
        this.reg = reg;
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
        return "RegDetailDO{" +
                "date=" + date +
                ", channelId=" + channelId +
                ", type=" + type +
                ", reg=" + reg +
                '}';
    }
}
