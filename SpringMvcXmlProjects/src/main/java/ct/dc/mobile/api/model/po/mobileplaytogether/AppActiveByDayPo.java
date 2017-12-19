package ct.dc.mobile.api.model.po.mobileplaytogether;

import java.io.Serializable;

/**
 * Created by CTWLPC on 2017/5/11.
 */
public class AppActiveByDayPo implements Serializable{
    private Integer date;
    private Long app;
    private Integer hard;
    private Integer account;
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

    public Integer getHard() {
        return hard;
    }

    public void setHard(Integer hard) {
        this.hard = hard;
    }

    public Integer getAccount() {
        return account;
    }

    public void setAccount(Integer account) {
        this.account = account;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }
}
