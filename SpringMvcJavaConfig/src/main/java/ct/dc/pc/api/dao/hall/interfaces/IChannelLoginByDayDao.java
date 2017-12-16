package ct.dc.pc.api.dao.hall.interfaces;

import ct.dc.pc.api.model.po.hall.HallChannelLoginByDayPo;

import java.util.ArrayList;

/**
 * Created by CTWLPC on 2017/6/13.
 */
public interface IChannelLoginByDayDao {
    /**
     * 通过渠道和大厅信息获取多日登录信息
     * @param channel
     * @param group
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<HallChannelLoginByDayPo> find(long channel, long group, int beginDate, int endDate);
}
