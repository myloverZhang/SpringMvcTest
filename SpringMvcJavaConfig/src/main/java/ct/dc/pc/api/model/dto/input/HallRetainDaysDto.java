package ct.dc.pc.api.model.dto.input;

import java.io.Serializable;

/**
 * Created by B41-80 on 2017/4/6.
 */
public class HallRetainDaysDto implements Serializable{
    private Integer hallId;
    private Integer retainType;
    private Integer beginDate;
    private Integer endDate;

    public Integer getHallId() {
        return hallId;
    }

    public void setHallId(Integer hallId) {
        this.hallId = hallId;
    }

    public Integer getRetainType() {
        return retainType;
    }

    public void setRetainType(Integer retainType) {
        this.retainType = retainType;
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
        return "HallRetainDaysDto{" +
                "hallId=" + hallId +
                ", retainType=" + retainType +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                '}';
    }
}
