package ct.dc.mobile.api.model.po.mobileapp;

import java.io.Serializable;

/**
 * Created by B41-80 on 2017/1/9.
 */
public class AppRegByDayPo implements Serializable{
    private Integer date;//日期
    private Long app;//应用
    private Integer users;//账户数
    private Integer hards;//设备数


    public AppRegByDayPo() {
    }

    public AppRegByDayPo(Integer date, Long app, Integer users, Integer hards) {
        this.date = date;
        this.app = app;
        this.users = users;
        this.hards = hards;
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

    @Override
    public String toString() {
        return "AppRegByDayPo{" +
                "date=" + date +
                ", app=" + app +
                ", users=" + users +
                ", hards=" + hards +
                '}';
    }
}
