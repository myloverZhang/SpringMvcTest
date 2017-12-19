package ct.dc.mobile.api.model.domain.hall;

import java.io.Serializable;

/**
 * Created by B41-80 on 2017/1/13.
 */
public class HallOnlineByMonthDo implements Serializable{
    private Integer month;
    private Integer standardUsers;

    public HallOnlineByMonthDo() {
    }

    public HallOnlineByMonthDo(Integer month, Integer standardUsers) {
        this.month = month;
        this.standardUsers = standardUsers;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getStandardUsers() {
        return standardUsers;
    }

    public void setStandardUsers(Integer standardUsers) {
        this.standardUsers = standardUsers;
    }

    @Override
    public String toString() {
        return "HallOnlineByMonthDo{" +
                "month=" + month +
                ", standardUsers=" + standardUsers +
                '}';
    }
}
