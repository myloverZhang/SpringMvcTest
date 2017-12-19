package ct.dc.mobile.api.model.po.mobilehall;

import java.io.Serializable;

/**
 * Created by B41-80 on 2017/1/13.
 */
public class HallLoginPerDayPo implements Serializable{
    private Integer date;
    private Integer group;
    private Integer trange;
    private Integer users;
    private Integer hards;
    private Integer times;


    public HallLoginPerDayPo() {
    }

    public HallLoginPerDayPo(Integer date, Integer group, Integer trange, Integer users, Integer hards, Integer times) {
        this.date = date;
        this.group = group;
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

    public Integer getGroup() {
        return group;
    }

    public void setGroup(Integer group) {
        this.group = group;
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
        return "HallLoginPerDayPo{" +
                "date=" + date +
                ", group=" + group +
                ", trange=" + trange +
                ", users=" + users +
                ", hards=" + hards +
                ", times=" + times +
                '}';
    }
}
