package ct.dc.mobile.api.model.domain.playtogether;

import java.io.Serializable;

/**
 * Created by CTWLPC on 2017/5/11.
 */
public class AppActiveByDayDo implements Serializable{
    private Integer date;
    private Integer active;
    private Integer type;
    private Integer times;

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }
}
