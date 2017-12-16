package ct.dc.pc.api.dao.area.interfaces;

import ct.dc.pc.api.model.po.area.AreaRetainByDayPo;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/3/31.
 */
public interface INationRetainByDayDao {
    /**
     * 根据日期获取全国留存
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<AreaRetainByDayPo> find(int beginDate,int endDate);
}
