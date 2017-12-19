package ct.dc.mobile.api.model.po.mobileapp;

import java.io.Serializable;

/**
 * Created by B41-80 on 2017/1/5.
 */
public class AppLoginByDayPo implements Serializable{
    private Integer date;
    private Long app;
    private Integer times;
    private Integer users1d1;
    private Integer users3d1;
    private Integer users7d1;
    private Integer users14d1;
    private Integer users30d1;
    private Integer hards1d1;
    private Integer hards3d1;
    private Integer hards7d1;
    private Integer hards14d1;
    private Integer hards30d1;

    public AppLoginByDayPo() {
    }

    public AppLoginByDayPo(Integer date, Long app, Integer times, Integer users1d1, Integer users3d1, Integer users7d1,
                           Integer users14d1, Integer users30d1, Integer hards1d1, Integer hards3d1, Integer hards7d1,
                           Integer hards14d1, Integer hards30d1) {
        this.date = date;
        this.app = app;
        this.times = times;
        this.users1d1 = users1d1;
        this.users3d1 = users3d1;
        this.users7d1 = users7d1;
        this.users14d1 = users14d1;
        this.users30d1 = users30d1;
        this.hards1d1 = hards1d1;
        this.hards3d1 = hards3d1;
        this.hards7d1 = hards7d1;
        this.hards14d1 = hards14d1;
        this.hards30d1 = hards30d1;
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

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    public Integer getUsers1d1() {
        return users1d1;
    }

    public void setUsers1d1(Integer users1d1) {
        this.users1d1 = users1d1;
    }

    public Integer getUsers3d1() {
        return users3d1;
    }

    public void setUsers3d1(Integer users3d1) {
        this.users3d1 = users3d1;
    }

    public Integer getUsers7d1() {
        return users7d1;
    }

    public void setUsers7d1(Integer users7d1) {
        this.users7d1 = users7d1;
    }

    public Integer getUsers14d1() {
        return users14d1;
    }

    public void setUsers14d1(Integer users14d1) {
        this.users14d1 = users14d1;
    }

    public Integer getUsers30d1() {
        return users30d1;
    }

    public void setUsers30d1(Integer users30d1) {
        this.users30d1 = users30d1;
    }

    public Integer getHards1d1() {
        return hards1d1;
    }

    public void setHards1d1(Integer hards1d1) {
        this.hards1d1 = hards1d1;
    }

    public Integer getHards3d1() {
        return hards3d1;
    }

    public void setHards3d1(Integer hards3d1) {
        this.hards3d1 = hards3d1;
    }

    public Integer getHards7d1() {
        return hards7d1;
    }

    public void setHards7d1(Integer hards7d1) {
        this.hards7d1 = hards7d1;
    }

    public Integer getHards14d1() {
        return hards14d1;
    }

    public void setHards14d1(Integer hards14d1) {
        this.hards14d1 = hards14d1;
    }

    public Integer getHards30d1() {
        return hards30d1;
    }

    public void setHards30d1(Integer hards30d1) {
        this.hards30d1 = hards30d1;
    }

    @Override
    public String toString() {
        return "AppLoginByDayPo{" +
                "date=" + date +
                ", app=" + app +
                ", times=" + times +
                ", users1d1=" + users1d1 +
                ", users3d1=" + users3d1 +
                ", users7d1=" + users7d1 +
                ", users14d1=" + users14d1 +
                ", users30d1=" + users30d1 +
                ", hards1d1=" + hards1d1 +
                ", hards3d1=" + hards3d1 +
                ", hards7d1=" + hards7d1 +
                ", hards14d1=" + hards14d1 +
                ", hards30d1=" + hards30d1 +
                '}';
    }
}
