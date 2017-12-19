package ct.dc.mobile.api.model.domain.areaApp;

import java.io.Serializable;

/**
 * Created by B41-80 on 2017/1/10.
 */
public class AppAreaLoginDetailsByDayDo implements Serializable{
    private Integer date;
    private Integer loginUnitNum;
    private Integer times;
    private Integer type;

    public AppAreaLoginDetailsByDayDo() {
    }

    public AppAreaLoginDetailsByDayDo(Integer date, Integer loginUnitNum, Integer times, Integer type) {
        this.date = date;
        this.loginUnitNum = loginUnitNum;
        this.times = times;
        this.type = type;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Integer getLoginUnitNum() {
        return loginUnitNum;
    }

    public void setLoginUnitNum(Integer loginUnitNum) {
        this.loginUnitNum = loginUnitNum;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "AppAreaLoginDetailsByDayDo{" +
                "date=" + date +
                ", loginUnitNum=" + loginUnitNum +
                ", times=" + times +
                ", type=" + type +
                '}';
    }
}
