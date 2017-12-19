package ct.dc.mobile.api.model.po.mobileapp;

import java.io.Serializable;

/**
 * Created by B41-80 on 2017/1/10.
 */
public class AppAreaLoginByDayPo implements Serializable{
    private String id;
    private Integer loginUnitNum;
    private Integer times;
    private Integer type;

    public AppAreaLoginByDayPo() {
    }

    public AppAreaLoginByDayPo(String id, Integer loginUnitNum, Integer times, Integer type) {
        this.id = id;
        this.loginUnitNum = loginUnitNum;
        this.times = times;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        return "AppAreaLoginByDayPo{" +
                "id='" + id + '\'' +
                ", loginUnitNum=" + loginUnitNum +
                ", times=" + times +
                ", type=" + type +
                '}';
    }
}
