package ct.dc.mobile.api.model.domain.channel;

import java.io.Serializable;

/**
 * Created by B41-80 on 2017/1/18.
 */
public class LoginDetailDO implements Serializable{
    private Integer date;
    private Long channelId;
    private Long times;
    private Integer type;
    private Integer users1D1;
    private Integer users3D1;
    private Integer users7D1;
    private Integer users14D1;
    private Integer users30D1;

    public LoginDetailDO() {
    }

    public LoginDetailDO(Integer date, Long channelId, Long times, Integer type, Integer users1D1, Integer users3D1,
                         Integer users7D1, Integer users14D1, Integer users30D1) {
        this.date = date;
        this.channelId = channelId;
        this.times = times;
        this.type = type;
        this.users1D1 = users1D1;
        this.users3D1 = users3D1;
        this.users7D1 = users7D1;
        this.users14D1 = users14D1;
        this.users30D1 = users30D1;
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

    public Integer getUsers1D1() {
        return users1D1;
    }

    public void setUsers1D1(Integer users1D1) {
        this.users1D1 = users1D1;
    }

    public Integer getUsers3D1() {
        return users3D1;
    }

    public void setUsers3D1(Integer users3D1) {
        this.users3D1 = users3D1;
    }

    public Integer getUsers7D1() {
        return users7D1;
    }

    public void setUsers7D1(Integer users7D1) {
        this.users7D1 = users7D1;
    }

    public Integer getUsers14D1() {
        return users14D1;
    }

    public void setUsers14D1(Integer users14D1) {
        this.users14D1 = users14D1;
    }

    public Integer getUsers30D1() {
        return users30D1;
    }

    public void setUsers30D1(Integer users30D1) {
        this.users30D1 = users30D1;
    }

    @Override
    public String toString() {
        return "LoginDetailDO{" +
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
