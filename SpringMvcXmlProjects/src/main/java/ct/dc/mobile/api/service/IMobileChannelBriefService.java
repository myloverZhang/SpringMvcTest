package ct.dc.mobile.api.service;

import ct.dc.mobile.api.model.domain.channel.BriefSumDO;
import ct.dc.mobile.api.model.domain.channel.RegDetailDO;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/1/18.
 */
public interface IMobileChannelBriefService {
    ArrayList<BriefSumDO> briefInfoByDays(int begin,int end,long app,String tag);
    ArrayList<RegDetailDO> regInfoByDays(int begin, int end, long app, Long channel);
}
