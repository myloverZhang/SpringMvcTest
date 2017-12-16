package ct.dc.pc.api.model.dto.input;

import java.io.Serializable;

/**
 * Created by CTWLPC on 2017/9/5.
 */
public class ChannelTagByWeeksDto implements Serializable {
    private String channelTag;
    private Integer beginWeek;
    private Integer endWeek;
    private Integer limitNum;

    public ChannelTagByWeeksDto() {
    }

    public ChannelTagByWeeksDto(String channelTag, Integer beginWeek, Integer endWeek, Integer limitNum) {
        this.channelTag = channelTag;
        this.beginWeek = beginWeek;
        this.endWeek = endWeek;
        this.limitNum = limitNum;
    }

    public Integer getLimitNum() {
        return limitNum;
    }

    public void setLimitNum(Integer
                                    limitNum) {
        this.limitNum = limitNum;
    }

    public String getChannelTag() {
        return channelTag;
    }

    public void setChannelTag(String channelTag) {
        this.channelTag = channelTag;
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

    @Override
    public String toString() {
        return "ChannelTagByWeeksDto{" +
                "channelTag='" + channelTag + '\'' +
                ", beginWeek=" + beginWeek +
                ", endWeek=" + endWeek +
                '}';
    }
}
