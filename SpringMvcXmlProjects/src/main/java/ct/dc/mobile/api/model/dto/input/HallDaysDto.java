package ct.dc.mobile.api.model.dto.input;

import java.io.Serializable;

/**
 * Created by B41-80 on 2017/1/13.
 */
public class HallDaysDto implements Serializable{
    private Integer hallId;
    private Integer beginDate;
    private Integer endDate;

    public HallDaysDto() {
    }

    public HallDaysDto(Integer hallId, Integer beginDate, Integer endDate) {
        this.hallId = hallId;
        this.beginDate = beginDate;
        this.endDate = endDate;
    }

    public Integer getHallId() {
        return hallId;
    }

    public void setHallId(Integer hallId) {
        this.hallId = hallId;
    }

    public Integer getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Integer beginDate) {
        this.beginDate = beginDate;
    }

    public Integer getEndDate() {
        return endDate;
    }

    public void setEndDate(Integer endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "HallDaysDto{" +
                "hallId=" + hallId +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                '}';
    }
}
