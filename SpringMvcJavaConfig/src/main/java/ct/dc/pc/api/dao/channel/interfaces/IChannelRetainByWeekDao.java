package ct.dc.pc.api.dao.channel.interfaces;

import ct.dc.pc.api.model.po.channel.ChannelRetainByWeekPo;

import java.util.ArrayList;

/**
 * Created by CTWLPC on 2017/9/7.
 */
public interface IChannelRetainByWeekDao {
    /**
     * 通过日期查询渠道全局多日登录
     * @param beginDate
     * @param endDate
     * @param limitNum
     * @return
     */
    ArrayList<ChannelRetainByWeekPo> find(int beginDate, int endDate, int limitNum);

    /**
     * 根据日期查询数据
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<ChannelRetainByWeekPo> find(int beginDate,int endDate);
    /**
     * 通过日期和渠道id获取全局多日登录
     * @param channel
     * @param beginDate
     * @param endDate
     * @param limitNum
     * @return
     */
    ArrayList<ChannelRetainByWeekPo> findByChannel(long channel, int beginDate, int endDate, int limitNum);

    /**
     * 通过日期和多个渠道id获取全局多日登录
     * @param channels
     * @param beginDate
     * @param endDate
     * @param limitNum
     * @return
     */
    ArrayList<ChannelRetainByWeekPo> findByChannels(ArrayList<Long> channels, int beginDate, int endDate, int limitNum);
}
