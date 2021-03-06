package ct.dc.pc.api.model.po.channel;

import java.io.Serializable;

/**
 * Created by CTWLPC on 2017/9/7.
 */
public class ChannelRetainByWeekPo implements Serializable{
    private Long channel;
    private Integer date;
    private Long usersNew;
    private Long usersW1;
    private Long usersW2;
    private Long usersW3;
    private Long usersW4;
    private Long hardsNew;
    private Long hardsW1;
    private Long hardsW2;
    private Long hardsW3;
    private Long hardsW4;

    public ChannelRetainByWeekPo() {
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

    public Long getUsersNew() {
        return usersNew;
    }

    public void setUsersNew(Long usersNew) {
        this.usersNew = usersNew;
    }

    public Long getUsersW1() {
        return usersW1;
    }

    public void setUsersW1(Long usersW1) {
        this.usersW1 = usersW1;
    }

    public Long getUsersW2() {
        return usersW2;
    }

    public void setUsersW2(Long usersW2) {
        this.usersW2 = usersW2;
    }

    public Long getUsersW3() {
        return usersW3;
    }

    public void setUsersW3(Long usersW3) {
        this.usersW3 = usersW3;
    }

    public Long getUsersW4() {
        return usersW4;
    }

    public void setUsersW4(Long usersW4) {
        this.usersW4 = usersW4;
    }

    public Long getHardsNew() {
        return hardsNew;
    }

    public void setHardsNew(Long hardsNew) {
        this.hardsNew = hardsNew;
    }

    public Long getHardsW1() {
        return hardsW1;
    }

    public void setHardsW1(Long hardsW1) {
        this.hardsW1 = hardsW1;
    }

    public Long getHardsW2() {
        return hardsW2;
    }

    public void setHardsW2(Long hardsW2) {
        this.hardsW2 = hardsW2;
    }

    public Long getHardsW3() {
        return hardsW3;
    }

    public void setHardsW3(Long hardsW3) {
        this.hardsW3 = hardsW3;
    }

    public Long getHardsW4() {
        return hardsW4;
    }

    public void setHardsW4(Long hardsW4) {
        this.hardsW4 = hardsW4;
    }

    @Override
    public String toString() {
        return "ChannelRetainByWeekPo{" +
                "channel=" + channel +
                ", date=" + date +
                ", usersNew=" + usersNew +
                ", usersW1=" + usersW1 +
                ", usersW2=" + usersW2 +
                ", usersW3=" + usersW3 +
                ", usersW4=" + usersW4 +
                ", hardsNew=" + hardsNew +
                ", hardsW1=" + hardsW1 +
                ", hardsW2=" + hardsW2 +
                ", hardsW3=" + hardsW3 +
                ", hardsW4=" + hardsW4 +
                '}';
    }
}
