package ct.dc.pc.api.model.domain.channel;

/**
 * Created by CTWLPC on 2017/6/13.
 */
public class RetainDetailsByDayDo {
    private Integer date;
    private Long channelId;
    private Integer type;
    private Long newCount;
    private Long users1Day;
    private Long users3Day;
    private Long users7Day;
    private Long users14Day;
    private Long users30Day;

    public RetainDetailsByDayDo() {
        this.date = 0;
        this.channelId = 0L;
        this.newCount = 0L;
        this.users1Day = 0L;
        this.users3Day = 0L;
        this.users7Day = 0L;
        this.users14Day = 0L;
        this.users30Day = 0L;
    }



    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getNewCount() {
        return newCount;
    }

    public void setNewCount(Long newCount) {
        this.newCount = newCount;
    }

    public Long getUsers1Day() {
        return users1Day;
    }

    public void setUsers1Day(Long users1Day) {
        this.users1Day = users1Day;
    }

    public Long getUsers3Day() {
        return users3Day;
    }

    public void setUsers3Day(Long users3Day) {
        this.users3Day = users3Day;
    }

    public Long getUsers7Day() {
        return users7Day;
    }

    public void setUsers7Day(Long users7Day) {
        this.users7Day = users7Day;
    }

    public Long getUsers14Day() {
        return users14Day;
    }

    public void setUsers14Day(Long users14Day) {
        this.users14Day = users14Day;
    }

    public Long getUsers30Day() {
        return users30Day;
    }

    public void setUsers30Day(Long users30Day) {
        this.users30Day = users30Day;
    }

    @Override
    public String toString() {
        return "RetainDetailsByDayDo{" +
                "date=" + date +
                ", channelId=" + channelId +
                ", type=" + type +
                ", newCount=" + newCount +
                ", users1Day=" + users1Day +
                ", users3Day=" + users3Day +
                ", users7Day=" + users7Day +
                ", users14Day=" + users14Day +
                ", users30Day=" + users30Day +
                '}';
    }
}
