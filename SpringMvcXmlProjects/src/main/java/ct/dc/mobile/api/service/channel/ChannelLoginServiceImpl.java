package ct.dc.mobile.api.service.channel;

import ct.dc.mobile.api.domain.channel.MobileChannelLoginDomain;
import ct.dc.mobile.api.model.domain.channel.LoginDetailDO;
import ct.dc.mobile.api.service.IMobileChannelLoginService;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/1/18.
 */
public class ChannelLoginServiceImpl implements IMobileChannelLoginService{
    private MobileChannelLoginDomain mobileChannelLoginDomain;

    public void setMobileChannelLoginDomain(MobileChannelLoginDomain mobileChannelLoginDomain) {
        this.mobileChannelLoginDomain = mobileChannelLoginDomain;
    }

    @Override
    public ArrayList<LoginDetailDO> loginInfoByDays(int begin, int end, long app, Long channel) {
        return mobileChannelLoginDomain.loginInfos(begin,end,app,channel);
    }
}
