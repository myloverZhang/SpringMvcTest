package ct.dc.mobile.api.model.po.mobileapp;

import java.io.Serializable;

/**
 * Created by B41-80 on 2017/1/9.
 */
public class AppLoginByPerDayPo implements Serializable{
    private Integer date;
    private Long app;
    private Integer trange;//时间
    private Integer users;
    private Integer hards;
    private Integer times;

    public AppLoginByPerDayPo() {
    }

    public AppLoginByPerDayPo(Integer date, Long app, Integer trange, Integer users, Integer hards, Integer times) {
        this.date = date;
        this.app = app;
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

    public Long getApp() {
        return app;
    }

    public void setApp(Long app) {
        this.app = app;
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
        return "AppLoginByPerDayPo{" +
                "date=" + date +
                ", app=" + app +
                ", trange=" + trange +
                ", users=" + users +
                ", hards=" + hards +
                ", times=" + times +
                '}';
    }
}
