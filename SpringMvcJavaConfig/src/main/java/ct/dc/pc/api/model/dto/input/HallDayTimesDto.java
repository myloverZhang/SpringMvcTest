package ct.dc.pc.api.model.dto.input;

import java.io.Serializable;

/**
 * Created by B41-80 on 2017/4/6.
 */
public class HallDayTimesDto implements Serializable{
    private Integer hallId;
    private Integer date;
    private Integer minTime;

    public Integer getHallId() {
        return hallId;
    }

    public void setHallId(Integer hallId) {
        this.hallId = hallId;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Integer getMinTime() {
        return minTime;
    }

    public void setMinTime(Integer minTime) {
        this.minTime = minTime;
    }

    @Override
    public String toString() {
        return "HallDayTimesDto{" +
                "hallId=" + hallId +
                ", date=" + date +
                ", minTime=" + minTime +
                '}';
    }
}
