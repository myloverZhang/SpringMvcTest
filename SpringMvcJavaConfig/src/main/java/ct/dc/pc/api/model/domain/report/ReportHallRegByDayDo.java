package ct.dc.pc.api.model.domain.report;

import java.io.Serializable;

/**
 * Created by B41-80 on 2017/4/7.
 */
public class ReportHallRegByDayDo implements Serializable{
    private Integer date;
    private Integer hallId;
    private String hallName;
    private Integer users;
    private Integer hards;

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Integer getHallId() {
        return hallId;
    }

    public void setHallId(Integer hallId) {
        this.hallId = hallId;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
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
                ", hallId=" + hallId +
                ", hallName='" + hallName + '\'' +
                ", users=" + users +
                ", hards=" + hards +
                '}';
    }
}
