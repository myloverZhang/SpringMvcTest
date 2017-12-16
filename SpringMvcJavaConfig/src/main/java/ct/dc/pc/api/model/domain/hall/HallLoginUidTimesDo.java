package ct.dc.pc.api.model.domain.hall;

import java.io.Serializable;

/**
 * Created by B41-80 on 2017/4/6.
 */
public class HallLoginUidTimesDo implements Serializable{
    private Integer uid;
    private Integer times;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    @Override
    public String toString() {
        return "HallLoginUidTimesDo{" +
                "uid=" + uid +
                ", times=" + times +
                '}';
    }
}
