package ct.dc.mobile.api.model.domain.channel;

import java.io.Serializable;

/**
 * Created by B41-80 on 2017/1/18.
 */
public class BriefSumDO implements Serializable{
    private Long channel;
    private Integer type;
    private Long reg;
    private Long login;
    private Long firstLogin;

    public BriefSumDO() {
    }

    public BriefSumDO(Long channel, Integer type, Long reg, Long login, Long firstLogin) {
        this.channel = channel;
        this.type = type;
        this.reg = reg;
        this.login = login;
        this.firstLogin = firstLogin;
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

    @Override
    public String toString() {
        return "BriefSumDO{" +
                "channel=" + channel +
                ", type=" + type +
                ", reg=" + reg +
                ", login=" + login +
                ", firstLogin=" + firstLogin +
                '}';
    }
}
