package ct.dc.mobile.api.model.domain.report;

import java.io.Serializable;

/**
 * Created by B41-80 on 2017/1/17.
 */
public class ReportGameRegDo implements Serializable{
    private Integer date;
    private Long app;
    private String appName;
    private Integer users;
    private Integer hards;


    public ReportGameRegDo() {

    }

    public ReportGameRegDo(Integer date, Long app, String appName, Integer users, Integer hards) {
        this.date = date;
        this.app = app;
        this.appName = appName;
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

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
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
        return "ReportGameRegDo{" +
                "date=" + date +
                ", app=" + app +
                ", appName='" + appName + '\'' +
                ", users=" + users +
                ", hards=" + hards +
                '}';
    }
}
