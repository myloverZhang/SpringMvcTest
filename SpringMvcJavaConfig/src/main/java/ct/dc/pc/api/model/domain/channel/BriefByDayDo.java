package ct.dc.pc.api.model.domain.channel;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by CTWLPC on 2017/6/13.
 */
public class BriefByDayDo implements Serializable{
    private Long channel;
    private Integer type;
    private Long reg;
    private Long login;
    private Integer date;

    public BriefByDayDo() {
        channel = 0L;
        reg = 0L;
        login = 0L;
        date = 0;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Long getChannel() {
        return channel;
    }

    public void setChannel(Long channel) {
        this.channel = channel;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getReg() {
        return reg;
    }

    public void setReg(Long reg) {
        this.reg = reg;
    }

    public Long getLogin() {
        return login;
    }

    public void setLogin(Long login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "BriefByDayDo{" +
                "channel=" + channel +
                ", type=" + type +
                ", reg=" + reg +
                ", login=" + login +
                ", date=" + date +
                '}';
    }
}
