package ct.dc.mobile.api.dao.mobilechannel.Interface;

import ct.dc.mobile.api.model.po.mobilechannel.ChannelLoginPo;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/1/18.
 */
public interface IChannelLoginByDayDAO {
    ArrayList<ChannelLoginPo> find(int begin,int end,long app,Long channel);
}
