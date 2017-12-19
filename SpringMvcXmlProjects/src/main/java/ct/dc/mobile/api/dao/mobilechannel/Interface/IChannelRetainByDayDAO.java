package ct.dc.mobile.api.dao.mobilechannel.Interface;

import ct.dc.mobile.api.model.po.mobilechannel.ChannelRetainPo;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/1/18.
 */
public interface IChannelRetainByDayDAO {
    ArrayList<ChannelRetainPo> find(int begin,int end,long app,Long channel);
}
