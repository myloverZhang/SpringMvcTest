package ct.dc.pc.api.model.domain.report;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by CTWLPC on 2017/9/15.
 */
public class ReportChannelRegDo implements Serializable{
    private Integer date;
    private Long channelId;
    private String channelName;
    private ArrayList<ChannelTagInfo> tags;
    private Long users;
    private Long hards;

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

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public ArrayList<ChannelTagInfo> getTags() {
        return tags;
    }

    public void setTags(ArrayList<ChannelTagInfo> tags) {
        this.tags = tags;
    }

    public Long getUsers() {
        return users;
    }

    public void setUsers(Long users) {
        this.users = users;
    }

    public Long getHards() {
        return hards;
    }

    public void setHards(Long hards) {
        this.hards = hards;
    }

    @Override
    public String toString() {
        return "ReportChannelRegDo{" +
                "date=" + date +
                ", channelId=" + channelId +
                ", channelName='" + channelName + '\'' +
                ", tags=" + tags +
                ", users=" + users +
                ", hards=" + hards +
                '}';
    }
}
