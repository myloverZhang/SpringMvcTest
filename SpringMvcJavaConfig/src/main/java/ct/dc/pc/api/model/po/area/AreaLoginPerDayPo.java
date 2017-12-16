package ct.dc.pc.api.model.po.area;

import java.io.Serializable;

/**
 * Created by B41-80 on 2017/3/31.
 */
public class AreaLoginPerDayPo implements Serializable{
    private Integer date;
    private String areaId;
    private Integer trange;
    private Integer users;
    private Integer times;
    private Integer hards;

    public AreaLoginPerDayPo() {
    }

    public AreaLoginPerDayPo(Integer date, String areaId, Integer trange, Integer users, Integer times, Integer hards) {
        this.date = date;
        this.areaId = areaId;
        this.trange = trange;
        this.users = users;
        this.times = times;
        this.hards = hards;
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

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    public Integer getHards() {
        return hards;
    }

    public void setHards(Integer hards) {
        this.hards = hards;
    }

    @Override
    public String toString() {
        return "AreaLoginPerDayPo{" +
                "date=" + date +
                ", areaId='" + areaId + '\'' +
                ", trange=" + trange +
                ", users=" + users +
                ", times=" + times +
                ", hards=" + hards +
                '}';
    }
}
