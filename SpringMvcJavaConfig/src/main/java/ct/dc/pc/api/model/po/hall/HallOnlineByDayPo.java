package ct.dc.pc.api.model.po.hall;

import java.io.Serializable;

/**
 * Created by B41-80 on 2017/4/1.
 */
public class HallOnlineByDayPo implements Serializable{
    private Integer date;
    private Integer group;
    private Integer maxUsers;
    private Integer avgUsers;

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

    public Integer getMaxUsers() {
        return maxUsers;
    }

    public void setMaxUsers(Integer maxUsers) {
        this.maxUsers = maxUsers;
    }

    public Integer getAvgUsers() {
        return avgUsers;
    }

    public void setAvgUsers(Integer avgUsers) {
        this.avgUsers = avgUsers;
    }

    @Override
    public String toString() {
        return "HallOnlineByDayPo{" +
                "date=" + date +
                ", group=" + group +
                ", maxUsers=" + maxUsers +
                ", avgUsers=" + avgUsers +
                '}';
    }
}
