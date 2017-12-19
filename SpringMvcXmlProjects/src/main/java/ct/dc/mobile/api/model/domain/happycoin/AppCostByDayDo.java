package ct.dc.mobile.api.model.domain.happycoin;

import java.io.Serializable;

/**
 * Created by CTWLPC on 2017/5/11.
 */
public class AppCostByDayDo implements Serializable{
    private Integer date;
    private Integer num;
    private Double cost;
    private Integer times;

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }
}
