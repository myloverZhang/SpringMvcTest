package ct.dc.pc.api.service.channel;

import ct.dc.libinfrastructure.CommonUtils;
import ct.dc.liblogs.ICtDataLogger;
import ct.dc.liblogs.impl.CtDataLoggerImpl;
import ct.dc.pc.api.domain.channel.ChannelDomain;
import ct.dc.pc.api.model.domain.channel.*;
import ct.dc.pc.api.service.channel.interfaces.IChannelService;
import ct.dc.pc.api.util.PromoteUtils;
import ct.dc.pc.api.util.ResourceClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by CTWLPC on 2017/6/13.
 */
@Service
public class ChannelServiceImpl implements IChannelService{
    private static ICtDataLogger logger = new CtDataLoggerImpl(ChannelServiceImpl.class);
    @Autowired
    private ChannelDomain channelDomain;

    public void setChannelDomain(ChannelDomain channelDomain) {
        this.channelDomain = channelDomain;
    }

    /**
     * 根据渠道标签查询概要信息
     *
     * @param channelTag
     * @param beginDate
     * @param endDate
     * @param limitNum
     * @return
     */
    @Override
    public ArrayList<BriefSumDO> listBriefByDayIfs(String channelTag, int beginDate, int endDate, int limitNum) {
        ArrayList<BriefSumDO> results = new ArrayList<>();
        if (channelTag == null || channelTag.equals("")||channelTag.equals(ResourceClass.ALL_CHANNEL))
            return channelDomain.listBriefByDayIfs(new ArrayList<Long>(),beginDate,endDate, limitNum);
        try {
            int tag = Integer.parseInt(channelTag);
            ArrayList<Long> channels = PromoteUtils.getChannelsByTag(tag);
            if (channels.size()==0)
                return results;
            results = channelDomain.listBriefByDayIfs(channels, beginDate, endDate, limitNum);
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
     * @param beginDate
     * @param endDate
     * @param limitNum
     * @return
     */
    @Override
    public ArrayList<RegDetailByDayDo> listRegDetailsByDayIfs(long channel, int beginDate, int endDate, int limitNum) {
        return channelDomain.listRegDetailsByDayIfs(channel, beginDate, endDate);
    }
    /**
     * 根据渠道标签信息查询多日注册注册数据
     *
     * @param channelTag
     * @param beginDate
     * @param endDate
     * @param limitNum
     * @return
     */
    @Override
    public ArrayList<RegDetailByDayDo> listRegDetailsByDayIfs(String channelTag, int beginDate, int endDate, int limitNum) {
        ArrayList<RegDetailByDayDo> results = new ArrayList<>();
        if (channelTag == null || channelTag.equals("")||channelTag.equals(ResourceClass.ALL_CHANNEL))
            return channelDomain.listRegDetailsByDayIfs(new ArrayList<Long>(),beginDate,endDate, limitNum);
        try {
            int tag = Integer.parseInt(channelTag);
            ArrayList<Long> channels = PromoteUtils.getChannelsByTag(tag);
            if (channels.size()==0)
                return results;
            results = channelDomain.listRegDetailsByDayIfs(channels, beginDate, endDate, limitNum);
        }catch (Exception ex){
            logger.error(String.format("获取全局渠道概要信息失败：【%s】", CommonUtils.getStackErrors(ex)));
            return results;
        }
        return results;
    }
    /**
     * 根据渠道信息查询多日登录数据
     *
     * @param channel
     * @param beginDate
     * @param endDate
     * @param limitNum
     * @return
     */
    @Override
    public ArrayList<LoginDetailsByDayDo> listLoginDetailsByDayIfs(long channel, int beginDate, int endDate, int limitNum) {
        return channelDomain.listLoginDetailsByDayIfs(channel,beginDate, endDate);
    }
    /**
     * 根据渠道标签信息查询多日登录数据
     *
     * @param channelTag
     * @param beginDate
     * @param endDate
     * @param limitNum
     * @return
     */
    @Override
    public ArrayList<LoginDetailsByDayDo> listLoginDetailsByDayIfs(String channelTag, int beginDate, int endDate, int limitNum) {
        ArrayList<LoginDetailsByDayDo> results = new ArrayList<>();
        if (channelTag == null || channelTag.equals("")||channelTag.equals(ResourceClass.ALL_CHANNEL))
            return channelDomain.listLoginDetailsByDayIfs(new ArrayList<Long>(),beginDate,endDate, limitNum);
        try {
            int tag = Integer.parseInt(channelTag);
            ArrayList<Long> channels = PromoteUtils.getChannelsByTag(tag);
            if (channels.size()==0)
                return results;
            results = channelDomain.listLoginDetailsByDayIfs(channels, beginDate, endDate, limitNum);
        }catch (Exception ex){
            logger.error(String.format("获取全局渠道概要信息失败：【%s】", CommonUtils.getStackErrors(ex)));
            return results;
        }
        return results;
    }
    /**
     * 根据渠道信息查询多日留存数据
     *
     * @param channel
     * @param beginDate
     * @param endDate
     * @param limitNum
     * @return
     */
    @Override
    public ArrayList<RetainDetailsByDayDo> listRetainDetailsByDayIfs(long channel, int beginDate, int endDate, int limitNum) {
        return channelDomain.listRetainDetailsByDayIfs(channel, beginDate, endDate);
    }





    /**
     * 根据渠道标签信息查询多日留存数据
     *
     * @param channelTag
     * @param beginDate
     * @param endDate
     * @param limitNum
     * @return
     */
    @Override
    public ArrayList<RetainDetailsByDayDo> listRetainDetailsByDayIfs(String channelTag, int beginDate, int endDate, int limitNum) {
        ArrayList<RetainDetailsByDayDo> results = new ArrayList<>();
        if (channelTag == null || channelTag.equals("")||channelTag.equals(ResourceClass.ALL_CHANNEL))
            return channelDomain.listRetainDetailsByDayIfs(new ArrayList<Long>(),beginDate,endDate, limitNum);
        try {
            int tag = Integer.parseInt(channelTag);
            ArrayList<Long> channels = PromoteUtils.getChannelsByTag(tag);
            if (channels.size()==0)
                return results;
            results = channelDomain.listRetainDetailsByDayIfs(channels, beginDate, endDate, limitNum);
        }catch (Exception ex){
            logger.error(String.format("获取全局渠道概要信息失败：【%s】", CommonUtils.getStackErrors(ex)));
            return results;
        }
        return results;
    }

    /**
     * 注册渠道多日登录
     *
     * @param channel
     * @param beginDate
     * @param endDate
     * @param limitNum
     * @return
     */
    @Override
    public ArrayList<LoginDetailRegChannelDo> listLoginDetailsRegChannelIfs(long channel, int beginDate, int endDate, int limitNum) {
        return channelDomain.listLoginDetailsWithRegChannelIfs(channel, beginDate, endDate);
    }

    /**
     * 注册渠道多日登录 按照标签查询
     *
     * @param channelTag
     * @param beginDate
     * @param endDate
     * @param limitNum
     * @return
     */
    @Override
    public ArrayList<LoginDetailRegChannelDo> listLoginDetailsRegChannelIfs(String channelTag, int beginDate, int endDate, int limitNum) {
        ArrayList<LoginDetailRegChannelDo> results = new ArrayList<>();
        if (channelTag == null || channelTag.equals("")||channelTag.equals(ResourceClass.ALL_CHANNEL))
            return channelDomain.listLoginDetailsWithRegChannelIfs(new ArrayList<Long>(),beginDate,endDate, limitNum);
        try {
            int tag = Integer.parseInt(channelTag);
            ArrayList<Long> channels = PromoteUtils.getChannelsByTag(tag);
            if (channels.size()==0)
                return results;
            results = channelDomain.listLoginDetailsWithRegChannelIfs(channels, beginDate, endDate, limitNum);
        }catch (Exception ex){
            logger.error(String.format("获取全局注册渠道多日登录信息失败：【%s】", CommonUtils.getStackErrors(ex)));
            return results;
        }
        return results;
    }

    /**
     * 周留存查询
     *
     * @param channel
     * @param beginDate
     * @param endDate
     * @param limitNum
     * @return
     */
    @Override
    public ArrayList<RetainDetailsByWeekDo> listRetainDetailsByWeekIfs(long channel, int beginDate, int endDate, int limitNum) {
        return channelDomain.listRetainDetailsByWeekIfs(channel, beginDate, endDate);
    }

    /**
     * 周留存按照 渠道标签查询
     *
     * @param channelTag
     * @param beginDate
     * @param endDate
     * @param limitNum
     * @return
     */
    @Override
    public ArrayList<RetainDetailsByWeekDo> listRetainDetailsByWeekIfs(String channelTag, int beginDate, int endDate, int limitNum) {
        ArrayList<RetainDetailsByWeekDo> results = new ArrayList<>();
        if (channelTag == null || channelTag.equals("")||channelTag.equals(ResourceClass.ALL_CHANNEL))
            return channelDomain.listRetainDetailsByWeekIfs(new ArrayList<Long>(),beginDate,endDate, limitNum);
        try {
            int tag = Integer.parseInt(channelTag);
            ArrayList<Long> channels = PromoteUtils.getChannelsByTag(tag);
            if (channels.size()==0)
                return results;
            results = channelDomain.listRetainDetailsByWeekIfs(channels, beginDate, endDate, limitNum);
        }catch (Exception ex){
            logger.error(String.format("获取全局注册渠道周维度留存信息失败：【%s】", CommonUtils.getStackErrors(ex)));
            return results;
        }
        return results;
    }
}
