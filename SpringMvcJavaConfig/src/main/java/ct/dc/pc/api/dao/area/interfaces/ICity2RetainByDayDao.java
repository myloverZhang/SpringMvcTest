package ct.dc.pc.api.dao.area.interfaces;

import ct.dc.pc.api.model.po.area.AreaRetainByDayPo;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/3/31.
 */
public interface ICity2RetainByDayDao {
    /**
     * 根据地级市和日期查询留存数据
     * @param city
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<AreaRetainByDayPo> findByCity(String city,int beginDate,int endDate);

    /**
     * 根据日期查询地级市留存数据
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<AreaRetainByDayPo> find(int beginDate,int endDate);
}
