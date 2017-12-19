package ct.dc.mobile.api.model.dto.input;

import java.io.Serializable;

/**
 * Created by B41-80 on 2017/1/13.
 */
public class HallMonthsDto implements Serializable{
    private Integer hallId;
    private Integer beginMonth;
    private Integer endMonth;

    public HallMonthsDto() {
    }

    public HallMonthsDto(Integer hallId, Integer beginMonth, Integer endMonth) {
        this.hallId = hallId;
        this.beginMonth = beginMonth;
        this.endMonth = endMonth;
    }

    public Integer getHallId() {
        return hallId;
    }

    public void setHallId(Integer hallId) {
        this.hallId = hallId;
    }

    public Integer getBeginMonth() {
        return beginMonth;
    }

    public void setBeginMonth(Integer beginMonth) {
        this.beginMonth = beginMonth;
    }

    public Integer getEndMonth() {
        return endMonth;
    }

    public void setEndMonth(Integer endMonth) {
        this.endMonth = endMonth;
    }

    @Override
    public String toString() {
        return "HallMonthsDto{" +
                "hallId=" + hallId +
                ", beginMonth=" + beginMonth +
                ", endMonth=" + endMonth +
                '}';
    }
}
