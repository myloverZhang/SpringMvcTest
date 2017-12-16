package ct.dc.pc.api.model.domain.area;

import java.io.Serializable;

/**
 * Created by B41-80 on 2017/3/6.
 */
public class AreaRegDayDo implements Serializable{
    private Integer date;
    private Integer users;
    private Integer hards;

    public AreaRegDayDo() {
    }

    public AreaRegDayDo(Integer date, Integer users, Integer hards) {
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
        return "AreaRegDayDo{" +
                "date=" + date +
                ", users=" + users +
                ", hards=" + hards +
                '}';
    }
}
