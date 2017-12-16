package ct.dc.pc.api.model.po.channel;

import java.io.Serializable;

/**
 * Created by CTWLPC on 2017/6/12.
 */
public class ChannelBriefByDayPo implements Serializable{
    private Long channel;
    private Integer date;
    private Long usersLogin;
    private Long userReg;
    private Long hardsLogin;
    private Long hardsReg;

    public ChannelBriefByDayPo() {
    }

    public ChannelBriefByDayPo(Long channel, Integer date, Long usersLogin, Long userReg, Long hardsLogin, Long hardsReg) {
        this.channel = channel;
        this.date = date;
        this.usersLogin = usersLogin;
        this.userReg = userReg;
        this.hardsLogin = hardsLogin;
        this.hardsReg = hardsReg;
    }

    public Long getChannel() {
        return channel;
    }

    public void setChannel(Long channel) {
        this.channel = channel;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Long getUsersLogin() {
        return usersLogin;
    }

    public void setUsersLogin(Long usersLogin) {
        this.usersLogin = usersLogin;
    }

    public Long getUserReg() {
        return userReg;
    }

    public void setUserReg(Long userReg) {
        this.userReg = userReg;
    }

    public Long getHardsLogin() {
        return hardsLogin;
    }

    public void setHardsLogin(Long hardsLogin) {
        this.hardsLogin = hardsLogin;
    }

    public Long getHardsReg() {
        return hardsReg;
    }

    public void setHardsReg(Long hardsReg) {
        this.hardsReg = hardsReg;
    }

    @Override
    public String toString() {
        return "ChannelBriefByDayPo{" +
                "channel=" + channel +
                ", date=" + date +
                ", usersLogin=" + usersLogin +
                ", userReg=" + userReg +
                ", hardsLogin=" + hardsLogin +
                ", hardsReg=" + hardsReg +
                '}';
    }
}
