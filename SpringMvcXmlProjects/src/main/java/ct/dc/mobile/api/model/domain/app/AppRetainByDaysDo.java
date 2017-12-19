package ct.dc.mobile.api.model.domain.app;

import java.io.Serializable;

/**
 * Created by B41-80 on 2017/1/9.
 */
public class AppRetainByDaysDo implements Serializable{
    private Integer date;
    private Integer type;
    private Integer newCount;
    private Integer users1Day;
    private Integer users3Day;
    private Integer users7Day;
    private Integer users14Day;
    private Integer users30Day;

    public AppRetainByDaysDo() {
    }

    public AppRetainByDaysDo(Integer date, Integer type, Integer newCount, Integer users1Day, Integer users3Day, Integer users7Day, Integer users14Day, Integer users30Day) {
        this.date = date;
        this.type = type;
        this.newCount = newCount;
        this.users1Day = users1Day;
        this.users3Day = users3Day;
        this.users7Day = users7Day;
        this.users14Day = users14Day;
        this.users30Day = users30Day;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getNewCount() {
        return newCount;
    }

    public void setNewCount(Integer newCount) {
        this.newCount = newCount;
    }

    public Integer getUsers1Day() {
        return users1Day;
    }

    public void setUsers1Day(Integer users1Day) {
        this.users1Day = users1Day;
    }

    public Integer getUsers3Day() {
        return users3Day;
    }

    public void setUsers3Day(Integer users3Day) {
        this.users3Day = users3Day;
    }

    public Integer getUsers7Day() {
        return users7Day;
    }

    public void setUsers7Day(Integer users7Day) {
        this.users7Day = users7Day;
    }

    public Integer getUsers14Day() {
        return users14Day;
    }

    public void setUsers14Day(Integer users14Day) {
        this.users14Day = users14Day;
    }

    public Integer getUsers30Day() {
        return users30Day;
    }

    public void setUsers30Day(Integer users30Day) {
        this.users30Day = users30Day;
    }

    @Override
    public String toString() {
        return "AppRetainByDaysDo{" +
                "date=" + date +
                ", type=" + type +
                ", newCount=" + newCount +
                ", users1Day=" + users1Day +
                ", users3Day=" + users3Day +
                ", users7Day=" + users7Day +
                ", users14Day=" + users14Day +
                ", users30Day=" + users30Day +
                '}';
    }
}
