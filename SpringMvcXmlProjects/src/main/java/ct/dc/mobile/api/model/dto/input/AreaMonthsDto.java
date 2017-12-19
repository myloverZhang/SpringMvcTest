package ct.dc.mobile.api.model.dto.input;

import java.io.Serializable;

/**
 * Created by B41-80 on 2017/1/12.
 */
public class AreaMonthsDto implements Serializable{
    private Integer beginMonth;
    private Integer endMonth;
    private String areaId;

    public AreaMonthsDto() {
    }

    public AreaMonthsDto(Integer beginMonth, Integer endMonth, String areaId) {
        this.beginMonth = beginMonth;
        this.endMonth = endMonth;
        this.areaId = areaId;
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

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    @Override
    public String toString() {
        return "AreaMonthsDto{" +
                "beginMonth=" + beginMonth +
                ", endMonth=" + endMonth +
                ", areaId='" + areaId + '\'' +
                '}';
    }
}
