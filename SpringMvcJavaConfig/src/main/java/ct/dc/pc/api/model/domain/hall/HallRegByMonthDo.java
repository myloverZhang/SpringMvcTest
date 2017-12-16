package ct.dc.pc.api.model.domain.hall;

import java.io.Serializable;

/**
 * Created by B41-80 on 2017/4/6.
 */
public class HallRegByMonthDo implements Serializable{
    private Integer month;
    private Integer users;
    private Integer hards;

    public HallRegByMonthDo(Integer month, Integer users, Integer hards) {
        this.month = month;
        this.users = users;
        this.hards = hards;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
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
        return "HallRegByMonthDo{" +
                "month=" + month +
                ", users=" + users +
                ", hards=" + hards +
                '}';
    }
}
