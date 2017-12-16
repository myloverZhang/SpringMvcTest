package ct.dc.pc.api.service.channel;

import ct.dc.libinfrastructure.CommonUtils;
import ct.dc.liblogs.ICtDataLogger;
import ct.dc.liblogs.impl.CtDataLoggerImpl;
import ct.dc.pc.api.domain.channel.HallChannelDomain;
import ct.dc.pc.api.model.domain.channel.*;
import ct.dc.pc.api.service.channel.interfaces.IHallChannelService;
import ct.dc.pc.api.util.PromoteUtils;
import ct.dc.pc.api.util.ResourceClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by CTWLPC on 2017/6/13.
 */
@Service
public class HallChannelServiceImpl implements IHallChannelService{
    private static ICtDataLogger logger = new CtDataLoggerImpl(HallChannelServiceImpl.class);
    @Autowired
    private HallChannelDomain hallChannelDomain;

    /**
     * 根据渠道标签查询概要信息
     *
     * @param channelTag
     * @param group
     * @param beginDate
     * @param endDate    @return
     */
    @Override
    public ArrayList<HallBriefSumDo> listBriefByDayIfs(String channelTag, long group, int beginDate, int endDate) {
        ArrayList<HallBriefSumDo> results = new ArrayList<>();
        if (channelTag == null || channelTag.equals("")||channelTag.equals(ResourceClass.ALL_CHANNEL))
            return hallChannelDomain.listBriefByDayIfs(new ArrayList<Long>(),group,beginDate,endDate);
        try {
            int tag = Integer.parseInt(channelTag);
            ArrayList<Long> channels = PromoteUtils.getChannelsByTag(tag);
            if (channels.size() == 0)
                return results;
            results = hallChannelDomain.listBriefByDayIfs(channels,group,beginDate,endDate);
        }catch (Exception ex){
            logger.error(String.format("获取全局渠道概要信息失败：【%s】", CommonUtils.getStackErrors(ex)));
            return results;
        }
        return results;
    }

    /**
     * 根据渠道信息查询多日注册注册数据
     *
     * @param channel
     * @param group
     * @param beginDate
     * @param endDate   @return
     */
    @Override
    public ArrayList<HallRegDetailsByDayDo> listRegDetailsByDayIfs(long channel, long group, int beginDate, int endDate) {
        return hallChannelDomain.listRegDetailsByDayIfs(channel, group, beginDate, endDate);
    }

    /**
     * 根据渠道信息查询多日登录数据
     *
     * @param channel
     * @param group
     * @param beginDate
     * @param endDate   @return
     */
    @Override
    public ArrayList<HallLoginDetailsByDayDo> listLoginDetailsByDayIfs(long channel, long group, int beginDate, int endDate) {
        return hallChannelDomain.listLoginDetailsByDayIfs(channel, group, beginDate, endDate);
    }

    /**
     * 根据渠道信息查询多日留存数据
     *
     * @param channel
     * @param group
     * @param beginDate
     * @param endDate   @return
     */
    @Override
    public ArrayList<HallRetainDetailsByDayDo> listRetainDetailsByDayIfs(long channel, long group, int beginDate, int endDate) {
        return hallChannelDomain.listRetainDetailsByDayIfs(channel, group, beginDate, endDate);
    }
}
