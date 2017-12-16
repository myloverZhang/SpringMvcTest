package ct.dc.pc.api.dao.hall.interfaces;

import ct.dc.pc.api.model.po.hall.HallChannelBriefByDayPo;

import java.util.ArrayList;

/**
 * Created by CTWLPC on 2017/6/13.
 */
public interface IChannelBriefByDayDao {

    /**
     * 通过日期查询所有渠道概要信息
     * @param group
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<HallChannelBriefByDayPo> find(long group,int beginDate, int endDate);
    /**
     * 通过渠道和大厅获取渠道概要信息
     * @param channel
     * @param group
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<HallChannelBriefByDayPo> findByChannel(long channel, long group, int beginDate, int endDate);

    /**
     * 根据多个渠道和大厅信息获取概要信息
     * @param channel
     * @param group
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<HallChannelBriefByDayPo> findByChannels(ArrayList<Long> channel, long group, int beginDate, int endDate);
}
