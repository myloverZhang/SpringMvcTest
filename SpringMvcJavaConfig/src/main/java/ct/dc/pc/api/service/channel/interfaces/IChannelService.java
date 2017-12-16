package ct.dc.pc.api.service.channel.interfaces;

import ct.dc.pc.api.model.domain.channel.*;

import java.util.ArrayList;

/**
 * Created by CTWLPC on 2017/6/13.
 */
public interface IChannelService {
    /**
     * 根据渠道标签查询概要信息
     * @param channelTag
     * @param beginDate
     * @param endDate
     * @param limitNum
     * @return
     */
    ArrayList<BriefSumDO> listBriefByDayIfs(String channelTag, int beginDate, int endDate, int limitNum);

    /**
     * 根据渠道信息查询多日注册注册数据
     * @param channel
     * @param beginDate
     * @param endDate
     * @param limitNum
     * @return
     */
    ArrayList<RegDetailByDayDo> listRegDetailsByDayIfs(long channel, int beginDate, int endDate, int limitNum);
    /**
     * 根据渠道标签信息查询多日注册注册数据
     * @param channelTag
     * @param beginDate
     * @param endDate
     * @param limitNum
     * @return
     */
    ArrayList<RegDetailByDayDo> listRegDetailsByDayIfs(String channelTag, int beginDate, int endDate, int limitNum);
    /**
     * 根据渠道信息查询多日登录数据
     * @param channel
     * @param beginDate
     * @param endDate
     * @param limitNum
     * @return
     */
    ArrayList<LoginDetailsByDayDo> listLoginDetailsByDayIfs(long channel, int beginDate, int endDate, int limitNum);
    /**
     * 根据渠道信息查询多日登录数据
     * @param channelTag
     * @param beginDate
     * @param endDate
     * @param limitNum
     * @return
     */
    ArrayList<LoginDetailsByDayDo> listLoginDetailsByDayIfs(String channelTag, int beginDate, int endDate, int limitNum);
    /**
     * 根据渠道信息查询多日留存数据
     * @param channel
     * @param beginDate
     * @param endDate
     * @param limitNum
     * @return
     */
    ArrayList<RetainDetailsByDayDo> listRetainDetailsByDayIfs(long channel, int beginDate, int endDate, int limitNum);
    /**
     * 根据渠道信息查询多日留存数据
     * @param channelTag
     * @param beginDate
     * @param endDate
     * @param limitNum
     * @return
     */
    ArrayList<RetainDetailsByDayDo> listRetainDetailsByDayIfs(String channelTag, int beginDate, int endDate, int limitNum);

    /**
     * 注册渠道多日登录
     * @param channel
     * @param beginDate
     * @param endDate
     * @param limitNum
     * @return
     */
    ArrayList<LoginDetailRegChannelDo> listLoginDetailsRegChannelIfs(long channel, int beginDate, int endDate, int limitNum);

    /**
     *注册渠道多日登录 按照标签查询
     * @param channelTag
     * @param beginDate
     * @param endDate
     * @param limitNum
     * @return
     */
    ArrayList<LoginDetailRegChannelDo> listLoginDetailsRegChannelIfs(String channelTag, int beginDate, int endDate, int limitNum);


    /**
     * 周留存查询
     * @param channel
     * @param beginDate
     * @param endDate
     * @param limitNum
     * @return
     */
    ArrayList<RetainDetailsByWeekDo> listRetainDetailsByWeekIfs(long channel, int beginDate, int endDate, int limitNum);

    /**
     * 周留存按照 渠道标签查询
     * @param channelTag
     * @param beginDate
     * @param endDate
     * @param limitNum
     * @return
     */
    ArrayList<RetainDetailsByWeekDo> listRetainDetailsByWeekIfs(String channelTag, int beginDate, int endDate, int limitNum);
}
