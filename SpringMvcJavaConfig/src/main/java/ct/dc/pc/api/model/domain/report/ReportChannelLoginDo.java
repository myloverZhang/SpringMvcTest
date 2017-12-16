package ct.dc.pc.api.model.domain.report;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by CTWLPC on 2017/9/15.
 */
public class ReportChannelLoginDo implements Serializable{
    private Integer date;
    private Long channelId;
    private String channelName;
    private ArrayList<ChannelTagInfo> tags;
    private Long times;
    private Long users1D1;
    private Long users3D1;
    private Long users7D1;
    private Long users14D1;
    private Long users30D1;
    private Long hards1D1;
    private Long hards3D1;
    private Long hards7D1;
    private Long hards14D1;
    private Long hards30D1;

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

    public Long getTimes() {
        return times;
    }

    public void setTimes(Long times) {
        this.times = times;
    }

    public Long getUsers1D1() {
        return users1D1;
    }

    public void setUsers1D1(Long users1D1) {
        this.users1D1 = users1D1;
    }

    public Long getUsers3D1() {
        return users3D1;
    }

    public void setUsers3D1(Long users3D1) {
        this.users3D1 = users3D1;
    }

    public Long getUsers7D1() {
        return users7D1;
    }

    public void setUsers7D1(Long users7D1) {
        this.users7D1 = users7D1;
    }

    public Long getUsers14D1() {
        return users14D1;
    }

    public void setUsers14D1(Long users14D1) {
        this.users14D1 = users14D1;
    }

    public Long getUsers30D1() {
        return users30D1;
    }

    public void setUsers30D1(Long users30D1) {
        this.users30D1 = users30D1;
    }

    public Long getHards1D1() {
        return hards1D1;
    }

    public void setHards1D1(Long hards1D1) {
        this.hards1D1 = hards1D1;
    }

    public Long getHards3D1() {
        return hards3D1;
    }

    public void setHards3D1(Long hards3D1) {
        this.hards3D1 = hards3D1;
    }

    public Long getHards7D1() {
        return hards7D1;
    }

    public void setHards7D1(Long hards7D1) {
        this.hards7D1 = hards7D1;
    }

    public Long getHards14D1() {
        return hards14D1;
    }

    public void setHards14D1(Long hards14D1) {
        this.hards14D1 = hards14D1;
    }

    public Long getHards30D1() {
        return hards30D1;
    }

    public void setHards30D1(Long hards30D1) {
        this.hards30D1 = hards30D1;
    }

    @Override
    public String toString() {
        return "ReportChannelLoginDo{" +
                "date=" + date +
                ", channelId=" + channelId +
                ", channelName='" + channelName + '\'' +
                ", tags=" + tags +
                ", times=" + times +
                ", users1D1=" + users1D1 +
                ", users3D1=" + users3D1 +
                ", users7D1=" + users7D1 +
                ", users14D1=" + users14D1 +
                ", users30D1=" + users30D1 +
                ", hards1D1=" + hards1D1 +
                ", hards3D1=" + hards3D1 +
                ", hards7D1=" + hards7D1 +
                ", hards14D1=" + hards14D1 +
                ", hards30D1=" + hards30D1 +
                '}';
    }
}
