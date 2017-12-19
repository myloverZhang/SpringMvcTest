package ct.dc.mobile.api.model.dto.input;

import java.io.Serializable;

/**
 * Created by B41-80 on 2017/1/11.
 */
public class AreaDaysDto implements Serializable{
    private String areaId;
    private Integer beginDate;
    private Integer endDate;

    public AreaDaysDto() {
    }

    public AreaDaysDto(String areaId, Integer beginDate, Integer endDate) {
        this.areaId = areaId;
        this.beginDate = beginDate;
        this.endDate = endDate;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
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
        return "AreaDaysDto{" +
                "areaId='" + areaId + '\'' +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                '}';
    }
}
