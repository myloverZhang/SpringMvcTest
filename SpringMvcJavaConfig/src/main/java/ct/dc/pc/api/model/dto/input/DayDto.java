package ct.dc.pc.api.model.dto.input;

import java.io.Serializable;

/**
 * Created by B41-80 on 2017/4/5.
 */
public class DayDto implements Serializable{
    private Integer date;

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "DayDto{" +
                "date=" + date +
                '}';
    }
}
