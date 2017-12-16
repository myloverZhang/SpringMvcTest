package ct.dc.pc.api.model.domain.hall;

import java.io.Serializable;

/**
 * Created by B41-80 on 2017/4/6.
 */
public class HallRegByDayDo implements Serializable{
    private Integer date;
    private Integer users;
    private Integer hards;

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
        return "ReportHallRegByDayDo{" +
                "date=" + date +
                ", users=" + users +
                ", hards=" + hards +
                '}';
    }
}
