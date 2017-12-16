package ct.dc.pc.api.model.domain.channel;

import java.io.Serializable;

/**
 * Created by CTWLPC on 2017/6/13.
 */
public class HallBriefByDayDo implements Serializable{
    private Long channel;
    private Integer type;
    private Long reg;
    private Long login;
    private Long firstLogin;
    private Integer date;

    public HallBriefByDayDo() {
    }

    public HallBriefByDayDo(Long channel, Integer type, Long reg, Long login, Long firstLogin, Integer date) {
        this.channel = channel;
        this.type = type;
        this.reg = reg;
        this.login = login;
        this.firstLogin = firstLogin;
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

    public Long getFirstLogin() {
        return firstLogin;
    }

    public void setFirstLogin(Long firstLogin) {
        this.firstLogin = firstLogin;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "HallBriefByDayDo{" +
                "channel=" + channel +
                ", type=" + type +
                ", reg=" + reg +
                ", login=" + login +
                ", firstLogin=" + firstLogin +
                ", date=" + date +
                '}';
    }
}
