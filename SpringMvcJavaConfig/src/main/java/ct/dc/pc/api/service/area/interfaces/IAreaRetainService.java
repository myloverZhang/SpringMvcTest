package ct.dc.pc.api.service.area.interfaces;

import ct.dc.pc.api.model.domain.area.AreaRetainByDayDo;

import java.util.ArrayList;

/**
 * Created by CTWLPC on 2017/6/14.
 */
public interface IAreaRetainService {
    /**
     * 获取全国留存信息
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<AreaRetainByDayDo> listNationRetainByDayIfs(int beginDate, int endDate);

    /**
     * 获取省级多日留存数据
     * @param province
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<AreaRetainByDayDo> listProvinceRetainByDayIfs(String province, int beginDate, int endDate);

    /**
     * 获取全国地级市多日留存数据
     * @param city
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<AreaRetainByDayDo> listCityRetainByDayIfs(String city, int beginDate,int endDate);

    /**
     * 获取先去多日留存数据
     * @param district
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<AreaRetainByDayDo> listDistrictRetainByDayIfs(String district, int beginDate, int endDate);
}
