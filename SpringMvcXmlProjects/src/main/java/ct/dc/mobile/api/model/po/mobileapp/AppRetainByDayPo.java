package ct.dc.mobile.api.model.po.mobileapp;

import java.io.Serializable;

/**
 * Created by B41-80 on 2017/1/9.
 */
public class AppRetainByDayPo implements Serializable{
    private Integer date;
    private Long app;
    private Integer usersNew;
    private Integer usersD1;
    private Integer usersD3;
    private Integer usersD7;
    private Integer usersD14;
    private Integer usersD30;
    private Integer hardsNew;
    private Integer hardsD1;
    private Integer hardsD3;
    private Integer hardsD7;
    private Integer hardsD14;
    private Integer hardsD30;

    public AppRetainByDayPo(int date, long app, int usersNew, int usersD1, int usersD3, int usersD7, int usersD14, int usersD30, int hardsNew, int hardsD1, int hardsD3, int hardsD7, int hardsD14, int hardsD30) {
        this.date = date;
        this.app = app;
        this.usersNew = usersNew;
        this.usersD1 = usersD1;
        this.usersD3 = usersD3;
        this.usersD7 = usersD7;
        this.usersD14 = usersD14;
        this.usersD30 = usersD30;
        this.hardsNew = hardsNew;
        this.hardsD1 = hardsD1;
        this.hardsD3 = hardsD3;
        this.hardsD7 = hardsD7;
        this.hardsD14 = hardsD14;
        this.hardsD30 = hardsD30;
    }

    public AppRetainByDayPo() {
    }

    public AppRetainByDayPo(Integer date, Long app, Integer usersNew, Integer usersD1, Integer usersD3, Integer usersD7,
                            Integer usersD14, Integer usersD30, Integer hardsNew, Integer hardsD1, Integer hardsD3,
                            Integer hardsD7, Integer hardsD14, Integer hardsD30) {
        this.date = date;
        this.app = app;
        this.usersNew = usersNew;
        this.usersD1 = usersD1;
        this.usersD3 = usersD3;
        this.usersD7 = usersD7;
        this.usersD14 = usersD14;
        this.usersD30 = usersD30;
        this.hardsNew = hardsNew;
        this.hardsD1 = hardsD1;
        this.hardsD3 = hardsD3;
        this.hardsD7 = hardsD7;
        this.hardsD14 = hardsD14;
        this.hardsD30 = hardsD30;
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

    public Integer getUsersNew() {
        return usersNew;
    }

    public void setUsersNew(Integer usersNew) {
        this.usersNew = usersNew;
    }

    public Integer getUsersD1() {
        return usersD1;
    }

    public void setUsersD1(Integer usersD1) {
        this.usersD1 = usersD1;
    }

    public Integer getUsersD3() {
        return usersD3;
    }

    public void setUsersD3(Integer usersD3) {
        this.usersD3 = usersD3;
    }

    public Integer getUsersD7() {
        return usersD7;
    }

    public void setUsersD7(Integer usersD7) {
        this.usersD7 = usersD7;
    }

    public Integer getUsersD14() {
        return usersD14;
    }

    public void setUsersD14(Integer usersD14) {
        this.usersD14 = usersD14;
    }

    public Integer getUsersD30() {
        return usersD30;
    }

    public void setUsersD30(Integer usersD30) {
        this.usersD30 = usersD30;
    }

    public Integer getHardsNew() {
        return hardsNew;
    }

    public void setHardsNew(Integer hardsNew) {
        this.hardsNew = hardsNew;
    }

    public Integer getHardsD1() {
        return hardsD1;
    }

    public void setHardsD1(Integer hardsD1) {
        this.hardsD1 = hardsD1;
    }

    public Integer getHardsD3() {
        return hardsD3;
    }

    public void setHardsD3(Integer hardsD3) {
        this.hardsD3 = hardsD3;
    }

    public Integer getHardsD7() {
        return hardsD7;
    }

    public void setHardsD7(Integer hardsD7) {
        this.hardsD7 = hardsD7;
    }

    public Integer getHardsD14() {
        return hardsD14;
    }

    public void setHardsD14(Integer hardsD14) {
        this.hardsD14 = hardsD14;
    }

    public Integer getHardsD30() {
        return hardsD30;
    }

    public void setHardsD30(Integer hardsD30) {
        this.hardsD30 = hardsD30;
    }

    @Override
    public String toString() {
        return "AppRetainByDayPo{" +
                "date=" + date +
                ", app=" + app +
                ", usersNew=" + usersNew +
                ", usersD1=" + usersD1 +
                ", usersD3=" + usersD3 +
                ", usersD7=" + usersD7 +
                ", usersD14=" + usersD14 +
                ", usersD30=" + usersD30 +
                ", hardsNew=" + hardsNew +
                ", hardsD1=" + hardsD1 +
                ", hardsD3=" + hardsD3 +
                ", hardsD7=" + hardsD7 +
                ", hardsD14=" + hardsD14 +
                ", hardsD30=" + hardsD30 +
                '}';
    }
}
