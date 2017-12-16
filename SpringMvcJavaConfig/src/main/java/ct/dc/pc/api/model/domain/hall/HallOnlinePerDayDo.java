package ct.dc.pc.api.model.domain.hall;

import java.io.Serializable;

/**
 * Created by B41-80 on 2017/3/2.
 */
public class HallOnlinePerDayDo implements Serializable{
    private Integer date;
    private Integer time;
    private Integer users;

    public HallOnlinePerDayDo() {
    }

    public HallOnlinePerDayDo(Integer date, Integer time, Integer users) {
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
        return "HallOnlinePerDayDo{" +
                "date=" + date +
                ", time=" + time +
                ", users=" + users +
                '}';
    }
}
