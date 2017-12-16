package ct.dc.pc.api.model.dto.input;

import java.io.Serializable;

/**
 * Created by CTWLPC on 2017/9/15.
 */
public class WeeksDto implements Serializable{
    private Integer beginWeek;
    private Integer endWeek;

    public Integer getBeginWeek() {
        return beginWeek;
    }

    public void setBeginWeek(Integer beginWeek) {
        this.beginWeek = beginWeek;
    }

    public Integer getEndWeek() {
        return endWeek;
    }

    public void setEndWeek(Integer endWeek) {
        this.endWeek = endWeek;
    }

    @Override
    public String toString() {
        return "WeeksDto{" +
                "beginWeek=" + beginWeek +
                ", endWeek=" + endWeek +
                '}';
    }
}
