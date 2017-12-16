package ct.dc.pc.api.model.po.hall;

import java.io.Serializable;

/**
 * Created by B41-80 on 2017/4/1.
 */
public class HallRegByDayPo implements Serializable{
    private Integer date;
    private Integer group;
    private Integer users;
    private Integer hards;

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Integer getGroup() {
        return group;
    }

    public void setGroup(Integer group) {
        this.group = group;
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
        return "HallRegByDayPo{" +
                "date=" + date +
                ", group=" + group +
                ", users=" + users +
                ", hards=" + hards +
                '}';
    }
}
