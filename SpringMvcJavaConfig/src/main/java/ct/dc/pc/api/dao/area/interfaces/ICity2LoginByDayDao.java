package ct.dc.pc.api.dao.area.interfaces;

import ct.dc.pc.api.model.po.area.AreaLoginByDayPo;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/3/31.
 */
public interface ICity2LoginByDayDao {
    /**
     * 根据地级市和日期查找多日登录数据
     * @param city
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<AreaLoginByDayPo> findByCity(String city, int beginDate, int endDate);

    /**
     * 根据日期查询多日登录数据
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<AreaLoginByDayPo> find(int beginDate,int endDate);
}
