package ct.dc.pc.api.service.channel.interfaces;

import ct.dc.pc.api.model.domain.channel.*;

import java.util.ArrayList;

/**
 * Created by CTWLPC on 2017/6/13.
 */
public interface IHallChannelService {
    /**
     * 根据渠道标签查询概要信息
     * @param channelTag
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<HallBriefSumDo> listBriefByDayIfs(String channelTag, long group, int beginDate, int endDate);

    /**
     * 根据渠道信息查询多日注册注册数据
     * @param channel
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<HallRegDetailsByDayDo> listRegDetailsByDayIfs(long channel, long group, int beginDate, int endDate);
    /**
     * 根据渠道信息查询多日登录数据
     * @param channel
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<HallLoginDetailsByDayDo> listLoginDetailsByDayIfs(long channel, long group, int beginDate, int endDate);

    /**
     * 根据渠道信息查询多日留存数据
     * @param channel
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<HallRetainDetailsByDayDo> listRetainDetailsByDayIfs(long channel, long group, int beginDate, int endDate);
}
