package ct.dc.mobile.api.service.channel;

import ct.dc.mobile.api.domain.channel.MobileChannelBriefDomain;
import ct.dc.mobile.api.model.domain.channel.BriefSumDO;
import ct.dc.mobile.api.model.domain.channel.RegDetailDO;
import ct.dc.mobile.api.service.IMobileChannelBriefService;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/1/18.
 */
public class ChannelBriefServiceImpl implements IMobileChannelBriefService {
    private MobileChannelBriefDomain mobileChannelBriefDomain;

    public void setMobileChannelBriefDomain(MobileChannelBriefDomain mobileChannelBriefDomain) {
        this.mobileChannelBriefDomain = mobileChannelBriefDomain;
    }

    /**
     * 一级界面数据
     * @param begin
     * @param end
     * @param app
     * @param tag
     * @return
     */
    @Override
    public ArrayList<BriefSumDO> briefInfoByDays(int begin, int end, long app, String tag) {
        return mobileChannelBriefDomain.briefInfos(begin,end,app,tag);
    }

    /**
     * 二级界面详情
     * @param begin
     * @param end
     * @param app
     * @param channel
     * @return
     */
    @Override
    public ArrayList<RegDetailDO> regInfoByDays(int begin, int end, long app, Long channel) {
        return mobileChannelBriefDomain.regInfosByDays(begin,end,app,channel);
    }
}
