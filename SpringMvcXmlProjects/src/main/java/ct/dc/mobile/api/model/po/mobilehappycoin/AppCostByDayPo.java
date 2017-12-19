package ct.dc.mobile.api.model.po.mobilehappycoin;

import java.io.Serializable;

/**
 * Created by CTWLPC on 2017/5/11.
 */
public class AppCostByDayPo implements Serializable{
    private Integer date;
    private Long app;
    private Integer num;
    private Long cost;
    private Integer times;

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Long getApp() {
        return app;
    }

    public void setApp(Long app) {
        this.app = app;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }
}
