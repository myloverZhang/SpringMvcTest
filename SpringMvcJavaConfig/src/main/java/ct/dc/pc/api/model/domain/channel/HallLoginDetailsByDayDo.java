package ct.dc.pc.api.model.domain.channel;

import java.io.Serializable;

/**
 * Created by CTWLPC on 2017/6/13.
 */
public class HallLoginDetailsByDayDo implements Serializable{
    private Integer date;
    private Long channelId;
    private Long times;
    private Integer type;
    private Long users1D1;
    private Long users3D1;
    private Long users7D1;
    private Long users14D1;
    private Long users30D1;

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

    public Long getTimes() {
        return times;
    }

    public void setTimes(Long times) {
        this.times = times;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getUsers1D1() {
        return users1D1;
    }

    public void setUsers1D1(Long users1D1) {
        this.users1D1 = users1D1;
    }

    public Long getUsers3D1() {
        return users3D1;
    }

    public void setUsers3D1(Long users3D1) {
        this.users3D1 = users3D1;
    }

    public Long getUsers7D1() {
        return users7D1;
    }

    public void setUsers7D1(Long users7D1) {
        this.users7D1 = users7D1;
    }

    public Long getUsers14D1() {
        return users14D1;
    }

    public void setUsers14D1(Long users14D1) {
        this.users14D1 = users14D1;
    }

    public Long getUsers30D1() {
        return users30D1;
    }

    public void setUsers30D1(Long users30D1) {
        this.users30D1 = users30D1;
    }

    @Override
    public String toString() {
        return "HallLoginDetailsByDayDo{" +
                "date=" + date +
                ", channelId=" + channelId +
                ", times=" + times +
                ", type=" + type +
                ", users1D1=" + users1D1 +
                ", users3D1=" + users3D1 +
                ", users7D1=" + users7D1 +
                ", users14D1=" + users14D1 +
                ", users30D1=" + users30D1 +
                '}';
    }
}
