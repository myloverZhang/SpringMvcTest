package ct.dc.pc.api.dao.channel.interfaces;

import ct.dc.pc.api.model.po.channel.ChannelBriefByDayPo;

import java.util.ArrayList;

/**
 * Created by CTWLPC on 2017/6/12.
 */
public interface IChannelBriefByDayDao {

    /**
     * 通过日期查询渠道信息
     * @param beginDate
     * @param endDate
     * @param limitNum
     * @return
     */
    ArrayList<ChannelBriefByDayPo> find(int beginDate, int endDate, int limitNum);

    /**
     * 通过日期查询数据
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<ChannelBriefByDayPo> find(int beginDate,int endDate);
    /**
     * 通过日期查询全局渠道概要信息
     *
     * @param channel
     * @param beginDate
     * @param endDate
     * @param limitNum
     * @return
     */
    ArrayList<ChannelBriefByDayPo> findByChannel(long channel, int beginDate, int endDate, int limitNum);

    /**
     * 通过日期查询全局多个渠道的信息
     * @param channels
     * @param beginDate
     * @param endDate
     * @param limitNum
     * @return
     */
    ArrayList<ChannelBriefByDayPo> findByChannels(ArrayList<Long> channels, int beginDate, int endDate, int limitNum);
}
