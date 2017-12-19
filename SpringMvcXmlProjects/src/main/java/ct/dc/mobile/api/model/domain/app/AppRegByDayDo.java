package ct.dc.mobile.api.model.domain.app;

import java.io.Serializable;

/**
 * Created by B41-80 on 2017/1/9.
 */
public class AppRegByDayDo implements Serializable{
    private Integer date;
    private Integer users;
    private Integer hards;

    public AppRegByDayDo() {
    }

    public AppRegByDayDo(Integer date, Integer users, Integer hards) {
        this.date = date;
        this.users = users;
        this.hards = hards;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
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
        return "AppRegByDayDo{" +
                "date=" + date +
                ", users=" + users +
                ", hards=" + hards +
                '}';
    }
}
