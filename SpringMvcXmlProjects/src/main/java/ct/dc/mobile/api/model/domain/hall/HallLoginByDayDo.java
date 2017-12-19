package ct.dc.mobile.api.model.domain.hall;

import java.io.Serializable;

/**
 * Created by B41-80 on 2017/1/13.
 */
public class HallLoginByDayDo implements Serializable{
    private Integer date;
    private Integer times;//次数
    private Integer type;//数据类型，1为账号，2位设备
    private Integer users1D1;
    private Integer users3D1;
    private Integer users7D1;
    private Integer users14D1;
    private Integer users30D1;

    public HallLoginByDayDo() {
    }

    public HallLoginByDayDo(Integer date, Integer times, Integer type, Integer users1D1, Integer users3D1, Integer users7D1, Integer users14D1, Integer users30D1) {
        this.date = date;
        this.times = times;
        this.type = type;
        this.users1D1 = users1D1;
        this.users3D1 = users3D1;
        this.users7D1 = users7D1;
        this.users14D1 = users14D1;
        this.users30D1 = users30D1;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getUsers1D1() {
        return users1D1;
    }

    public void setUsers1D1(Integer users1D1) {
        this.users1D1 = users1D1;
    }

    public Integer getUsers3D1() {
        return users3D1;
    }

    public void setUsers3D1(Integer users3D1) {
        this.users3D1 = users3D1;
    }

    public Integer getUsers7D1() {
        return users7D1;
    }

    public void setUsers7D1(Integer users7D1) {
        this.users7D1 = users7D1;
    }

    public Integer getUsers14D1() {
        return users14D1;
    }

    public void setUsers14D1(Integer users14D1) {
        this.users14D1 = users14D1;
    }

    public Integer getUsers30D1() {
        return users30D1;
    }

    public void setUsers30D1(Integer users30D1) {
        this.users30D1 = users30D1;
    }

    @Override
    public String toString() {
        return "HallLoginByDayDo{" +
                "date=" + date +
                ", times=" + times +
                ", type=" + type +
                ", users1D1=" + users1D1 +
                ", users3D1=" + users3D1 +
                ", users7D1=" + users7D1 +
                ", users14D1=" + users14D1 +
                ", users30D1=" + users30D1 +
                '}';
    }
}
