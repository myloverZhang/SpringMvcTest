package ct.dc.mobile.api.model.dto.input;

import java.io.Serializable;

/**
 * Created by B41-80 on 2017/1/17.
 */
public class ReportDaysDto implements Serializable{
    private Integer beginDate;
    private Integer endDate;

    public ReportDaysDto() {
    }

    public ReportDaysDto(Integer beginDate, Integer endDate) {
        this.beginDate = beginDate;
        this.endDate = endDate;
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
        return "ReportDaysDto{" +
                "beginDate=" + beginDate +
                ", endDate=" + endDate +
                '}';
    }
}
