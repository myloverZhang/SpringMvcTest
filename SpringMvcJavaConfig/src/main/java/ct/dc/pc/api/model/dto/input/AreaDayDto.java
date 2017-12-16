package ct.dc.pc.api.model.dto.input;

import java.io.Serializable;

/**
 * Created by B41-80 on 2017/4/5.
 */
public class AreaDayDto implements Serializable{
    private Integer date;
    private String areaId;

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    @Override
    public String toString() {
        return "AreaDayDto{" +
                "date=" + date +
                ", areaId='" + areaId + '\'' +
                '}';
    }
}
