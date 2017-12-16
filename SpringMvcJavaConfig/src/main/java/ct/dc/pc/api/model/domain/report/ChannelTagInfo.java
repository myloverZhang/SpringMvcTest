package ct.dc.pc.api.model.domain.report;

import java.io.Serializable;

/**
 * Created by CTWLPC on 2017/9/15.
 */
public class ChannelTagInfo implements Serializable{
    /**
     * 渠道标签id
     */
    private Integer channelTagId;
    /**
     * 渠道标签名称
     */
    private String channelTagName;

    public Integer getChannelTagId() {
        return channelTagId;
    }

    public void setChannelTagId(Integer channelTagId) {
        this.channelTagId = channelTagId;
    }

    public String getChannelTagName() {
        return channelTagName;
    }

    public void setChannelTagName(String channelTagName) {
        this.channelTagName = channelTagName;
    }
}
