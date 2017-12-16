package ct.dc.pc.api.model.domain.hall;

import java.io.Serializable;

/**
 * Created by B41-80 on 2017/3/2.
 */
public class HallOnlineByDayDo implements Serializable{
    private Integer date;
    private Integer avgUsers;
    private Integer maxUsers;

    public HallOnlineByDayDo() {
    }

    public HallOnlineByDayDo(Integer date, Integer avgUsers, Integer maxUsers) {
        this.date = date;
        this.avgUsers = avgUsers;
        this.maxUsers = maxUsers;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Integer getAvgUsers() {
        return avgUsers;
    }

    public void setAvgUsers(Integer avgUsers) {
        this.avgUsers = avgUsers;
    }

    public Integer getMaxUsers() {
        return maxUsers;
    }

    public void setMaxUsers(Integer maxUsers) {
        this.maxUsers = maxUsers;
    }

    @Override
    public String toString() {
        return "HallOnlineByDayDo{" +
                "date=" + date +
                ", avgUsers=" + avgUsers +
                ", maxUsers=" + maxUsers +
                '}';
    }
}
