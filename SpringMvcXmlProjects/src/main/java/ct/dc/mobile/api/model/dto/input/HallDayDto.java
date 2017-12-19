package ct.dc.mobile.api.model.dto.input;

import java.io.Serializable;

/**
 * Created by B41-80 on 2017/1/13.
 */
public class HallDayDto implements Serializable{
    private Integer hallId;
    private Integer date;

    public HallDayDto() {
    }

    public HallDayDto(Integer hallId, Integer date) {
        this.hallId = hallId;
        this.date = date;
    }

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

    @Override
    public String toString() {
        return "HallDayDto{" +
                "hallId=" + hallId +
                ", date=" + date +
                '}';
    }
}
