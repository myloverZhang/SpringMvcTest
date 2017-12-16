package ct.dc.pc.api.model.domain.merge;

import java.io.Serializable;

/**
 * Created by B41-80 on 2017/4/6.
 */
public class MergeLoginDetailByDayDo implements Serializable{
    private Integer date;
    private Integer type;
    private Integer loginUnitNum;
    private Integer times;

    public MergeLoginDetailByDayDo() {
    }

    public MergeLoginDetailByDayDo(Integer date, Integer type, Integer loginUnitNum, Integer times) {
        this.date = date;
        this.type = type;
        this.loginUnitNum = loginUnitNum;
        this.times = times;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    @Override
    public String toString() {
        return "MergeLoginDetailByDayDo{" +
                "date=" + date +
                ", type=" + type +
                ", loginUnitNum=" + loginUnitNum +
                ", times=" + times +
                '}';
    }
}
