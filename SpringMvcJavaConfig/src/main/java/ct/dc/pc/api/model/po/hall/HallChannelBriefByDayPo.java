package ct.dc.pc.api.model.po.hall;

import java.io.Serializable;

/**
 * Created by CTWLPC on 2017/6/12.
 */
public class HallChannelBriefByDayPo implements Serializable{
    private Long channel;
    private Long group;
    private Integer date;
    private Long userFirstLogin;
    private Long usersLogin;
    private Long userReg;
    private Long hardsLogin;
    private Long hardsReg;
    private Long hardsFirstLogin;

    public HallChannelBriefByDayPo() {
    }

    public Long getUserFirstLogin() {
        return userFirstLogin;
    }

    public void setUserFirstLogin(Long userFirstLogin) {
        this.userFirstLogin = userFirstLogin;
    }

    public Long getHardsFirstLogin() {
        return hardsFirstLogin;
    }

    public void setHardsFirstLogin(Long hardsFirstLogin) {
        this.hardsFirstLogin = hardsFirstLogin;
    }

    public Long getChannel() {
        return channel;
    }

    public void setChannel(Long channel) {
        this.channel = channel;
    }

    public Long getGroup() {
        return group;
    }

    public void setGroup(Long group) {
        this.group = group;
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
        return "HallChannelBriefByDayPo{" +
                "channel=" + channel +
                ", group=" + group +
                ", date=" + date +
                ", userFirstLogin=" + userFirstLogin +
                ", usersLogin=" + usersLogin +
                ", userReg=" + userReg +
                ", hardsLogin=" + hardsLogin +
                ", hardsReg=" + hardsReg +
                ", hardsFirstLogin=" + hardsFirstLogin +
                '}';
    }
}
