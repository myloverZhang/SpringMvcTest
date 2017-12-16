package ct.dc.pc.api.model.po.hall;

import java.io.Serializable;

/**
 * Created by B41-80 on 2017/4/1.
 */
public class HallLoginByDayPo implements Serializable{
    private Integer date;
    private Integer group;
    private Integer times;
    private Integer users1D1;
    private Integer users3D1;
    private Integer users7D1;
    private Integer users14D1;
    private Integer users30D1;
    private Integer hards1D1;
    private Integer hards3D1;
    private Integer hards7D1;
    private Integer hards14D1;
    private Integer hards30D1;

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

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
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

    public Integer getHards1D1() {
        return hards1D1;
    }

    public void setHards1D1(Integer hards1D1) {
        this.hards1D1 = hards1D1;
    }

    public Integer getHards3D1() {
        return hards3D1;
    }

    public void setHards3D1(Integer hards3D1) {
        this.hards3D1 = hards3D1;
    }

    public Integer getHards7D1() {
        return hards7D1;
    }

    public void setHards7D1(Integer hards7D1) {
        this.hards7D1 = hards7D1;
    }

    public Integer getHards14D1() {
        return hards14D1;
    }

    public void setHards14D1(Integer hards14D1) {
        this.hards14D1 = hards14D1;
    }

    public Integer getHards30D1() {
        return hards30D1;
    }

    public void setHards30D1(Integer hards30D1) {
        this.hards30D1 = hards30D1;
    }

    @Override
    public String toString() {
        return "HallLoginByDayPo{" +
                "date=" + date +
                ", group=" + group +
                ", times=" + times +
                ", users1D1=" + users1D1 +
                ", users3D1=" + users3D1 +
                ", users7D1=" + users7D1 +
                ", users14D1=" + users14D1 +
                ", users30D1=" + users30D1 +
                ", hards1D1=" + hards1D1 +
                ", hards3D1=" + hards3D1 +
                ", hards7D1=" + hards7D1 +
                ", hards14D1=" + hards14D1 +
                ", hards30D1=" + hards30D1 +
                '}';
    }
}
