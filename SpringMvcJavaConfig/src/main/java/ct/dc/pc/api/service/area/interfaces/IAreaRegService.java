package ct.dc.pc.api.service.area.interfaces;

import ct.dc.pc.api.model.domain.area.AreaRegDayDo;
import ct.dc.pc.api.model.domain.area.AreaRegMonthDo;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/4/5.
 */
public interface IAreaRegService {
    /**
     * 地级市多日注册
     * @param city
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<AreaRegDayDo> listCityRegByDayInfo(String city,int beginDate,int endDate);

    /**
     * 地级市多月注册
     * @param city
     * @param beginMonth
     * @param endMonth
     * @return
     */
    AreaRegMonthDo[] listCityRegByMonthInfo(String city,int beginMonth,int endMonth);

    /**
     * 县区多日注册
     * @param district
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<AreaRegDayDo> listDistrictRegByDayInfo(String district,int beginDate,int endDate);

    /**
     * 地级市多月注册
     * @param district
     * @param beginMonth
     * @param endMonth
     * @return
     */
    AreaRegMonthDo[] listDistrictRegByMonthInfo(String district,int beginMonth,int endMonth);

    /**
     * 全国多日注册
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<AreaRegDayDo> listNationRegByDayInfo(int beginDate,int endDate);

    /**
     * 全国多月注册
     * @param beginMonth
     * @param endMonth
     * @return
     */
    AreaRegMonthDo[] listNationRegByMonthInfo(int beginMonth,int endMonth);

    /**
     * 省份多日注册
     * @param province
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<AreaRegDayDo> listProvinceRegByDayInfo(String province,int beginDate,int endDate);

    /**
     * 省份多月注册
     * @param province
     * @param beginMonth
     * @param endMonth
     * @return
     */
    AreaRegMonthDo[] listProvinceRegByMonthInfo(String province,int beginMonth,int endMonth);
}
