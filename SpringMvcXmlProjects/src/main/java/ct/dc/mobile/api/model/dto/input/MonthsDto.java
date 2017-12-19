package ct.dc.mobile.api.model.dto.input;

import java.io.Serializable;

/**
 * Created by B41-80 on 2017/1/12.
 */
public class MonthsDto implements Serializable{
    private Integer beginMonth;
    private Integer endMonth;

    public MonthsDto() {
    }

    public MonthsDto(Integer beginMonth, Integer endMonth) {
        this.beginMonth = beginMonth;
        this.endMonth = endMonth;
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
        return "MonthsDto{" +
                "beginMonth=" + beginMonth +
                ", endMonth=" + endMonth +
                '}';
    }
}
