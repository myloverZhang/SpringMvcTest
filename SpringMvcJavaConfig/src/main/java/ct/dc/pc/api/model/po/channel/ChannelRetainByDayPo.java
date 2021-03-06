package ct.dc.pc.api.model.po.channel;

/**
 * Created by CTWLPC on 2017/6/12.
 */
public class ChannelRetainByDayPo {
    private Long channel;
    private Integer date;
    private Long usersNew;
    private Long usersD1;
    private Long usersD3;
    private Long usersD7;
    private Long usersD14;
    private Long usersD30;
    private Long hardsNew;
    private Long hardsD1;
    private Long hardsD3;
    private Long hardsD7;
    private Long hardsD14;
    private Long hardsD30;

    public ChannelRetainByDayPo() {
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

    public Long getUsersD1() {
        return usersD1;
    }

    public void setUsersD1(Long usersD1) {
        this.usersD1 = usersD1;
    }

    public Long getUsersD3() {
        return usersD3;
    }

    public void setUsersD3(Long usersD3) {
        this.usersD3 = usersD3;
    }

    public Long getUsersD7() {
        return usersD7;
    }

    public void setUsersD7(Long usersD7) {
        this.usersD7 = usersD7;
    }

    public Long getUsersD14() {
        return usersD14;
    }

    public void setUsersD14(Long usersD14) {
        this.usersD14 = usersD14;
    }

    public Long getUsersD30() {
        return usersD30;
    }

    public void setUsersD30(Long usersD30) {
        this.usersD30 = usersD30;
    }

    public Long getHardsNew() {
        return hardsNew;
    }

    public void setHardsNew(Long hardsNew) {
        this.hardsNew = hardsNew;
    }

    public Long getHardsD1() {
        return hardsD1;
    }

    public void setHardsD1(Long hardsD1) {
        this.hardsD1 = hardsD1;
    }

    public Long getHardsD3() {
        return hardsD3;
    }

    public void setHardsD3(Long hardsD3) {
        this.hardsD3 = hardsD3;
    }

    public Long getHardsD7() {
        return hardsD7;
    }

    public void setHardsD7(Long hardsD7) {
        this.hardsD7 = hardsD7;
    }

    public Long getHardsD14() {
        return hardsD14;
    }

    public void setHardsD14(Long hardsD14) {
        this.hardsD14 = hardsD14;
    }

    public Long getHardsD30() {
        return hardsD30;
    }

    public void setHardsD30(Long hardsD30) {
        this.hardsD30 = hardsD30;
    }

    @Override
    public String toString() {
        return "ChannelRetainByDayPo{" +
                "channel=" + channel +
                ", date=" + date +
                ", usersNew=" + usersNew +
                ", usersD1=" + usersD1 +
                ", usersD3=" + usersD3 +
                ", usersD7=" + usersD7 +
                ", usersD14=" + usersD14 +
                ", usersD30=" + usersD30 +
                ", hardsNew=" + hardsNew +
                ", hardsD1=" + hardsD1 +
                ", hardsD3=" + hardsD3 +
                ", hardsD7=" + hardsD7 +
                ", hardsD14=" + hardsD14 +
                ", hardsD30=" + hardsD30 +
                '}';
    }
}
