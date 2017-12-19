package ct.dc.mobile.api.dao.mobilechannel.Interface;

import ct.dc.mobile.api.model.po.mobilechannel.ChannelBriefPo;

import java.nio.channels.Channel;
import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/1/18.
 */
public interface IChannelBriefByDayDAO {
    ArrayList<ChannelBriefPo> find(int begin, int end, long app, Long channel);

    ArrayList<ChannelBriefPo> find(int begin, int end, long app, ArrayList<Long> channels);

    ArrayList<ChannelBriefPo> find(int begin, int end, long app);
}
