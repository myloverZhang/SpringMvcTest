package ct.dc.mobile.api.model.domain.hall;

import java.io.Serializable;

/**
 * Created by B41-80 on 2017/1/13.
 */
public class HallOnlineByPerDayDo implements Serializable{
    private Integer date;
    private Integer time;//时间
    private Integer users;

    public HallOnlineByPerDayDo() {
    }

    public HallOnlineByPerDayDo(Integer date, Integer time, Integer users) {
        this.date = date;
        this.time = time;
        this.users = users;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getUsers() {
        return users;
    }

    public void setUsers(Integer users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "HallOnlineByPerDayDo{" +
                "date=" + date +
                ", time=" + time +
                ", users=" + users +
                '}';
    }
}
