package ct.dc.pc.api.model.po.game;

import java.io.Serializable;

/**
 * Created by B41-80 on 2017/4/1.
 */
public class GameLoginPerDayPo implements Serializable{
    private Integer date;
    private Integer game;
    private Integer trange;
    private Integer users;
    private Integer times;
    private Integer hards;

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Integer getGame() {
        return game;
    }

    public void setGame(Integer game) {
        this.game = game;
    }

    public Integer getTrange() {
        return trange;
    }

    public void setTrange(Integer trange) {
        this.trange = trange;
    }

    public Integer getUsers() {
        return users;
    }

    public void setUsers(Integer users) {
        this.users = users;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    public Integer getHards() {
        return hards;
    }

    public void setHards(Integer hards) {
        this.hards = hards;
    }

    @Override
    public String toString() {
        return "GameLoginPerDayPo{" +
                "date=" + date +
                ", game=" + game +
                ", trange=" + trange +
                ", users=" + users +
                ", times=" + times +
                ", hards=" + hards +
                '}';
    }
}
