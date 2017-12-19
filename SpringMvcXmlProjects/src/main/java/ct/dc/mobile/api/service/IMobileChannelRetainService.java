package ct.dc.mobile.api.service;

import ct.dc.mobile.api.model.domain.channel.RetainDetailDO;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/1/18.
 */
public interface IMobileChannelRetainService {
    ArrayList<RetainDetailDO> retainInfoByDays(int begin,int end,long app,Long channel);
}
