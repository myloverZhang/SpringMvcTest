package ct.dc.pc.api.service.area;

import ct.dc.pc.api.domain.reg.AreaCityRegDomain;
import ct.dc.pc.api.domain.reg.AreaDistrictRegDomain;
import ct.dc.pc.api.domain.reg.AreaNationRegDomain;
import ct.dc.pc.api.domain.reg.AreaProvinceRegDomain;
import ct.dc.pc.api.model.domain.area.AreaRegDayDo;
import ct.dc.pc.api.model.domain.area.AreaRegMonthDo;
import ct.dc.pc.api.service.area.interfaces.IAreaRegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/4/5.
 */
@Service
public class AreaRegServiceImpl implements IAreaRegService{
    @Autowired
    private AreaCityRegDomain areaCityRegDomain;
    @Autowired
    private AreaDistrictRegDomain areaDistrictRegDomain;
    @Autowired
    private AreaProvinceRegDomain areaProvinceRegDomain;
    @Autowired
    private AreaNationRegDomain areaNationRegDomain;

    /**
     * 地级市多日注册
     *
     * @param city
     * @param beginDate
     * @param endDate
     * @return
     */
    public ArrayList<AreaRegDayDo> listCityRegByDayInfo(String city, int beginDate, int endDate) {
        return areaCityRegDomain.listAreaRegByDayInfo(city, beginDate, endDate);
    }

    /**
     * 地级市多月注册
     *
     * @param city
     * @param beginMonth
     * @param endMonth
     * @return
     */
    public AreaRegMonthDo[] listCityRegByMonthInfo(String city, int beginMonth, int endMonth) {
        return areaCityRegDomain.listAreaRegByMonthInfo(city,beginMonth,endMonth);
    }

    /**
     * 县区多日注册
     *
     * @param district
     * @param beginDate
     * @param endDate
     * @return
     */
    public ArrayList<AreaRegDayDo> listDistrictRegByDayInfo(String district, int beginDate, int endDate) {
        return areaDistrictRegDomain.listAreaRegByDayInfo(district, beginDate, endDate);
    }

    /**
     * 地级市多月注册
     *
     * @param district
     * @param beginMonth
     * @param endMonth
     * @return
     */
    public AreaRegMonthDo[] listDistrictRegByMonthInfo(String district, int beginMonth, int endMonth) {
        return areaDistrictRegDomain.listAreaRegByMonthInfo(district, beginMonth, endMonth);
    }

    /**
     * 全国多日注册
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    public ArrayList<AreaRegDayDo> listNationRegByDayInfo(int beginDate, int endDate) {
        return areaNationRegDomain.listAreaRegByDayInfo(beginDate, endDate);
    }

    /**
     * 全国多月注册
     *
     * @param beginMonth
     * @param endMonth
     * @return
     */
    public AreaRegMonthDo[] listNationRegByMonthInfo(int beginMonth, int endMonth) {
        return areaNationRegDomain.listAreaRegByMonthInfo(beginMonth, endMonth);
    }

    /**
     * 省份多日注册
     *
     * @param province
     * @param beginDate
     * @param endDate
     * @return
     */
    public ArrayList<AreaRegDayDo> listProvinceRegByDayInfo(String province, int beginDate, int endDate) {
        return areaProvinceRegDomain.listAreaRegByDayInfo(province, beginDate, endDate);
    }

    /**
     * 省份多月注册
     *
     * @param province
     * @param beginMonth
     * @param endMonth
     * @return
     */
    public AreaRegMonthDo[] listProvinceRegByMonthInfo(String province, int beginMonth, int endMonth) {
        return areaProvinceRegDomain.listAreaRegByMonthInfo(province, beginMonth, endMonth);
    }
}
