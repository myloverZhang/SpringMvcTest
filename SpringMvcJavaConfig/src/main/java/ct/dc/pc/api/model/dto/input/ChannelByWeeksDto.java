package ct.dc.pc.api.model.dto.input;

import java.io.Serializable;

/**
 * Created by CTWLPC on 2017/9/5.
 */
public class ChannelByWeeksDto implements Serializable{
    private Integer beginWeek;
    private Integer endWeek;
    private Long channelId;
    private Integer limitNum;


    public ChannelByWeeksDto() {
    }


    public ChannelByWeeksDto(Integer beginWeek, Integer endWeek, Long channelId, Integer limitNum) {
        this.beginWeek = beginWeek;
        this.endWeek = endWeek;
        this.channelId = channelId;
        this.limitNum = limitNum;
    }

    public Integer getLimitNum() {
        return limitNum;
    }

    public void setLimitNum(Integer limitNum) {
        this.limitNum = limitNum;
    }

    public Integer getBeginWeek() {
        return beginWeek;
    }

    public void setBeginWeek(Integer beginWeek) {
        this.beginWeek = beginWeek;
    }

    public Integer getEndWeek() {
        return endWeek;
    }

    public void setEndWeek(Integer endWeek) {
        this.endWeek = endWeek;
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    @Override
    public String toString() {
        return "ChannelByWeeksDto{" +
                "beginWeek=" + beginWeek +
                ", endWeek=" + endWeek +
                ", channelId=" + channelId +
                '}';
    }
}
