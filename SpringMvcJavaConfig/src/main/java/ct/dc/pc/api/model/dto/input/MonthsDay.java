package ct.dc.pc.api.model.dto.input;

/**
 * Created by B41-80 on 2017/4/5.
 */
public class MonthsDay {
    private Integer beginMonth;
    private Integer endMonth;

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
        return "MonthsDay{" +
                "beginMonth=" + beginMonth +
                ", endMonth=" + endMonth +
                '}';
    }
}
