package ct.dc.pc.api.model.po.area;

import java.io.Serializable;

/**
 * Created by B41-80 on 2017/3/31.
 */
public class AreaRegByDayPo implements Serializable{
    private Integer date;
    private String areaId;
    private Integer users;
    private Integer hards;

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
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
        return "AreaRegByDayPo{" +
                "date=" + date +
                ", areaId='" + areaId + '\'' +
                ", users=" + users +
                ", hards=" + hards +
                '}';
    }
}
