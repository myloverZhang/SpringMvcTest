package ct.dc.mobile.api.service.channel;

import ct.dc.mobile.api.domain.channel.MobileChannelRetainDomain;
import ct.dc.mobile.api.model.domain.channel.RetainDetailDO;
import ct.dc.mobile.api.service.IMobileChannelRetainService;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/1/18.
 */
public class ChannelRetainServiceImpl implements IMobileChannelRetainService{
    private MobileChannelRetainDomain mobileChannelRetainDomain;

    public void setMobileChannelRetainDomain(MobileChannelRetainDomain mobileChannelRetainDomain) {
        this.mobileChannelRetainDomain = mobileChannelRetainDomain;
    }

    @Override
    public ArrayList<RetainDetailDO> retainInfoByDays(int begin, int end, long app, Long channel) {
        return mobileChannelRetainDomain.retainInfos(begin,end,app,channel);
    }
}
