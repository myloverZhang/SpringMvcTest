package ct.dc.pc.api.dao.channel.interfaces;

import ct.dc.pc.api.model.po.channel.ChannelRetainByDayPo;

import java.util.ArrayList;

/**
 * Created by CTWLPC on 2017/6/12.
 */
public interface IChannelRetainByDayDao {
    /**
     * 根据日期查询留存
     * @param beginDate
     * @param endDate
     * @param limitNum
     * @return
     */
    ArrayList<ChannelRetainByDayPo> find(int beginDate, int endDate, int limitNum);

    /**
     * 根据日期查询数据
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<ChannelRetainByDayPo> find(int beginDate,int endDate);

    /**
     * 根据渠道信息查询留存
     * @param channel
     * @param beginDate
     * @param endDate
     * @param limitNum
     * @return
     */
    ArrayList<ChannelRetainByDayPo> findByChannel(long channel, int beginDate, int endDate, int limitNum);
    /**
     * 根据渠道信息查询留存
     * @param channels
     * @param beginDate
     * @param endDate
     * @param limitNum
     * @return
     */
    ArrayList<ChannelRetainByDayPo> findByChannels(ArrayList<Long> channels, int beginDate, int endDate, int limitNum);
}
