package ct.dc.pc.api.dao.hall.interfaces;

import ct.dc.pc.api.model.po.hall.HallChannelRetainByDayPo;

import java.util.ArrayList;

/**
 * Created by CTWLPC on 2017/6/13.
 */
public interface IChannelRetainByDayDao {
    /**
     * 通过渠道和大厅信息获取渠道留存
     * @param channel
     * @param group
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<HallChannelRetainByDayPo> find(long channel,long group,int beginDate,int endDate);
}
