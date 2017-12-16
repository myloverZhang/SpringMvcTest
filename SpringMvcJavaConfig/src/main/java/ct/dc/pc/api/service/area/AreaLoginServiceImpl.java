package ct.dc.pc.api.service.area;

import ct.dc.pc.api.domain.login.AreaCityLoginDomain;
import ct.dc.pc.api.domain.login.AreaDistrictLoginDomain;
import ct.dc.pc.api.domain.login.AreaNationLoginDomain;
import ct.dc.pc.api.domain.login.AreaProvinceDomain;
import ct.dc.pc.api.model.domain.area.AreaLoginByDayDo;
import ct.dc.pc.api.model.domain.area.AreaLoginPerDayDo;
import ct.dc.pc.api.service.area.interfaces.IAreaLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/4/5.
 */
@Service
public class AreaLoginServiceImpl implements IAreaLoginService{
    @Autowired
    private AreaCityLoginDomain areaCityLoginDomain;
    @Autowired
    private AreaProvinceDomain areaProvinceDomain;
    @Autowired
    private AreaDistrictLoginDomain areaDistrictLoginDomain;
    @Autowired
    private AreaNationLoginDomain areaNationLoginDomain;

    /**
     * 根据日期获取全国多日登录信息
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    public ArrayList<AreaLoginByDayDo> listNationLoginByDayInfo(int beginDate, int endDate) {
        return areaNationLoginDomain.listAreaLoginByDayInfo(beginDate,endDate);
    }

    /**
     * 根据日期获取全国单日登录信息
     *
     * @param date
     * @return
     */
    public ArrayList<AreaLoginPerDayDo> listNationLoginPerDayInfo(int date) {
        return areaNationLoginDomain.listAreaLoginPerDayInfo(date);
    }

    /**
     * 根据省份日期获取多日登录信息
     *
     * @param beginDate
     * @param endDate
     * @param province
     * @return
     */
    public ArrayList<AreaLoginByDayDo> listProvinceLoginByDayInfo(int beginDate, int endDate, String province) {
        return areaProvinceDomain.listAreaLoginByDayInfo(province, beginDate, endDate);
    }

    /**
     * 根据省份日期获取单日登录信息
     *
     * @param date
     * @param province
     * @return
     */
    public ArrayList<AreaLoginPerDayDo> listProvinceLoginPerDayInfo(int date, String province) {
        return areaProvinceDomain.listAreaLoginPerDayInfo(province, date);
    }

    /**
     * 根据地级市、日期获取多日登录信息
     *
     * @param beginDate
     * @param endDate
     * @param city
     * @return
     */
    public ArrayList<AreaLoginByDayDo> listCityLoginByDayInfo(int beginDate, int endDate, String city) {
        return areaCityLoginDomain.listAreaLoginByDayInfo(beginDate, endDate, city);
    }

    /**
     * 根据地级市、日期获取单日登录信息
     *
     * @param date
     * @param city
     * @return
     */
    public ArrayList<AreaLoginPerDayDo> listCityLoginPerDayInfo(int date, String city) {
        return areaCityLoginDomain.listCityLoginPerDayInfo(date, city);
    }

    /**
     * 根据县区、日期获取多日登录信息
     *
     * @param beginDate
     * @param endDate
     * @param district
     * @return
     */
    public ArrayList<AreaLoginByDayDo> listDistrictLoginByDayInfo(int beginDate, int endDate, String district) {
        return areaDistrictLoginDomain.listAreaLoginByDayInfo(district, beginDate, endDate);
    }

    /**
     * 根据县区日期获取单日登录信息
     *
     * @param date
     * @param district
     * @return
     */
    public ArrayList<AreaLoginPerDayDo> listDistrictLoginPerDayInfo(int date, String district) {
        return areaDistrictLoginDomain.listAreaLoginPerDayInfo(district, date);
    }
}
