package ct.dc.pc.api.model.dto.input;

import java.io.Serializable;

/**
 * Created by B41-80 on 2017/4/5.
 */
public class DaysDto implements Serializable{
    private Integer beginDate;
    private Integer endDate;

    public void setBeginDate(Integer beginDate) {
        this.beginDate = beginDate;
    }

    public void setEndDate(Integer endDate) {
        this.endDate = endDate;
    }

    public Integer getBeginDate() {
        return beginDate;
    }

    public Integer getEndDate() {
        return endDate;
    }

    @Override
    public String toString() {
        return "DaysDto{" +
                "beginDate=" + beginDate +
                ", endDate=" + endDate +
                '}';
    }
}
