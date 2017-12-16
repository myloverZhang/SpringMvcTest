package ct.dc.pc.api.model.domain.channel;

import java.io.Serializable;

/**
 * Created by CTWLPC on 2017/6/13.
 */
public class HallRetainDetailsByDayDo implements Serializable{
    private Integer date;
    private Long channelId;
    private Integer type;
    private Long newCount;
    private Long users1Day;
    private Long users3Day;
    private Long users7Day;
    private Long users14Day;
    private Long users30Day;

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
        return "HallRetainDetailsByDayDo{" +
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
