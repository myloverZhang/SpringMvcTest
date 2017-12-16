package ct.dc.pc.api.model.domain.channel;

import java.io.Serializable;

/**
 * Created by CTWLPC on 2017/9/7.
 */
public class RetainDetailsByWeekDo implements Serializable{
    private Long channelId;
    private Integer date;
    private Long newCount;
    private Integer type;
    private Long Users1Week;
    private Long Users2Week;
    private Long Users3Week;
    private Long Users4Week;

    public RetainDetailsByWeekDo() {
        this.date = 0;
        this.channelId = 0L;
        this.newCount = 0L;
        this.Users1Week = 0L;
        this.Users2Week = 0L;
        this.Users3Week = 0L;
        this.Users4Week = 0L;
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Long getNewCount() {
        return newCount;
    }

    public void setNewCount(Long newCount) {
        this.newCount = newCount;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getUsers1Week() {
        return Users1Week;
    }

    public void setUsers1Week(Long users1Week) {
        Users1Week = users1Week;
    }

    public Long getUsers2Week() {
        return Users2Week;
    }

    public void setUsers2Week(Long users2Week) {
        Users2Week = users2Week;
    }

    public Long getUsers3Week() {
        return Users3Week;
    }

    public void setUsers3Week(Long users3Week) {
        Users3Week = users3Week;
    }

    public Long getUsers4Week() {
        return Users4Week;
    }

    public void setUsers4Week(Long users4Week) {
        Users4Week = users4Week;
    }
}
