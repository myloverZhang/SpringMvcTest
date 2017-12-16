package ct.dc.pc.api.model.po.merge;

import java.io.Serializable;

/**
 * Created by B41-80 on 2017/4/1.
 */
public class MergeLoginByDayPo implements Serializable{
    private Integer id;
    private Integer type;
    private Integer loginUnitNum;
    private Integer times;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        return "MergeLoginByDayPo{" +
                "id=" + id +
                ", type=" + type +
                ", loginUnitNum=" + loginUnitNum +
                ", times=" + times +
                '}';
    }
}
