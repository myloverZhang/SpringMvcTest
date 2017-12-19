package ct.dc.mobile.api.model.po.mobilearea;

import java.io.Serializable;

/**
 * Created by B41-80 on 2017/1/11.
 */
public class AreaLoginByPerDayPo implements Serializable{
    private Integer date;
    private String areaId;
    private Integer trange;
    private Integer users;
    private Integer hards;
    private Integer times;

    public AreaLoginByPerDayPo() {
    }

    public AreaLoginByPerDayPo(Integer date, String areaId, Integer trange, Integer users, Integer hards,
                               Integer times) {
        this.date = date;
        this.areaId = areaId;
        this.trange = trange;
        this.users = users;
        this.hards = hards;
        this.times = times;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public Integer getTrange() {
        return trange;
    }

    public void setTrange(Integer trange) {
        this.trange = trange;
    }

    public Integer getUsers() {
        return users;
    }

    public void setUsers(Integer users) {
        this.users = users;
    }

    public Integer getHards() {
        return hards;
    }

    public void setHards(Integer hards) {
        this.hards = hards;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    @Override
    public String toString() {
        return "AreaLoginByPerDayPo{" +
                "date=" + date +
                ", areaId='" + areaId + '\'' +
                ", trange=" + trange +
                ", users=" + users +
                ", hards=" + hards +
                ", times=" + times +
                '}';
    }
}
