package ct.dc.pc.api.model.domain.area;

import java.io.Serializable;

/**
 * Created by B41-80 on 2017/3/6.
 */
public class AreaLoginPerDayDo implements Serializable{
    private Integer trange;
    private Integer times;
    private Integer users;
    private Integer hards;

    public AreaLoginPerDayDo() {
    }

    public AreaLoginPerDayDo(Integer trange, Integer times, Integer users, Integer hards) {
        this.trange = trange;
        this.times = times;
        this.users = users;
        this.hards = hards;
    }

    public Integer getTrange() {
        return trange;
    }

    public void setTrange(Integer trange) {
        this.trange = trange;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
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
        return "AreaLoginPerDayDo{" +
                "trange=" + trange +
                ", times=" + times +
                ", users=" + users +
                ", hards=" + hards +
                '}';
    }
}
