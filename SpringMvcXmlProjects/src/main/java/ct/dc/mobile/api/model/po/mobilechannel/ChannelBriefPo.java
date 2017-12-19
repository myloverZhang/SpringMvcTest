package ct.dc.mobile.api.model.po.mobilechannel;

import java.io.Serializable;

/**
 * Created by B41-80 on 2017/1/18.
 */
public class ChannelBriefPo implements Serializable{
    private Long channel;
    private Long app;
    private Integer date;
    private Integer usersFirstLogin;
    private Integer usersLogin;
    private Integer usersReg;
    private Integer hardsFirstLogin;
    private Integer hardsLogin;
    private Integer hardsReg;

    public ChannelBriefPo() {
    }

    public ChannelBriefPo(Long channel, Long app, Integer date, Integer usersFirstLogin, Integer usersLogin,
                          Integer usersReg, Integer hardsFirstLogin, Integer hardsLogin, Integer hardsReg) {
        this.channel = channel;
        this.app = app;
        this.date = date;
        this.usersFirstLogin = usersFirstLogin;
        this.usersLogin = usersLogin;
        this.usersReg = usersReg;
        this.hardsFirstLogin = hardsFirstLogin;
        this.hardsLogin = hardsLogin;
        this.hardsReg = hardsReg;
    }

    public Long getChannel() {
        return channel;
    }

    public void setChannel(Long channel) {
        this.channel = channel;
    }

    public Long getApp() {
        return app;
    }

    public void setApp(Long app) {
        this.app = app;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Integer getUsersFirstLogin() {
        return usersFirstLogin;
    }

    public void setUsersFirstLogin(Integer usersFirstLogin) {
        this.usersFirstLogin = usersFirstLogin;
    }

    public Integer getUsersLogin() {
        return usersLogin;
    }

    public void setUsersLogin(Integer usersLogin) {
        this.usersLogin = usersLogin;
    }

    public Integer getUsersReg() {
        return usersReg;
    }

    public void setUsersReg(Integer usersReg) {
        this.usersReg = usersReg;
    }

    public Integer getHardsFirstLogin() {
        return hardsFirstLogin;
    }

    public void setHardsFirstLogin(Integer hardsFirstLogin) {
        this.hardsFirstLogin = hardsFirstLogin;
    }

    public Integer getHardsLogin() {
        return hardsLogin;
    }

    public void setHardsLogin(Integer hardsLogin) {
        this.hardsLogin = hardsLogin;
    }

    public Integer getHardsReg() {
        return hardsReg;
    }

    public void setHardsReg(Integer hardsReg) {
        this.hardsReg = hardsReg;
    }

    @Override
    public String toString() {
        return "ChannelBriefPo{" +
                "channel=" + channel +
                ", app=" + app +
                ", date=" + date +
                ", usersFirstLogin=" + usersFirstLogin +
                ", usersLogin=" + usersLogin +
                ", usersReg=" + usersReg +
                ", hardsFirstLogin=" + hardsFirstLogin +
                ", hardsLogin=" + hardsLogin +
                ", hardsReg=" + hardsReg +
                '}';
    }
}
