package ct.dc.pc.api.service.area.interfaces;

import ct.dc.pc.api.model.domain.area.AreaLoginByDayDo;
import ct.dc.pc.api.model.domain.area.AreaLoginPerDayDo;
import ct.dc.pc.api.model.po.area.AreaLoginPerDayPo;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/4/5.
 */
public interface IAreaLoginService {
    /**
     * 根据日期获取全国多日登录信息
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<AreaLoginByDayDo> listNationLoginByDayInfo(int beginDate,int endDate);

    /**
     * 根据日期获取全国单日登录信息
     * @param date
     * @return
     */
    ArrayList<AreaLoginPerDayDo> listNationLoginPerDayInfo(int date);

    /**
     * 根据省份日期获取多日登录信息
     * @param beginDate
     * @param endDate
     * @param province
     * @return
     */
    ArrayList<AreaLoginByDayDo> listProvinceLoginByDayInfo(int beginDate,int endDate,String province);

    /**
     * 根据省份日期获取单日登录信息
     * @param date
     * @param province
     * @return
     */
    ArrayList<AreaLoginPerDayDo> listProvinceLoginPerDayInfo(int date,String province);

    /**
     * 根据地级市、日期获取多日登录信息
     * @param beginDate
     * @param endDate
     * @param city
     * @return
     */
    ArrayList<AreaLoginByDayDo> listCityLoginByDayInfo(int beginDate,int endDate,String city);

    /**
     * 根据地级市、日期获取单日登录信息
     * @param date
     * @param city
     * @return
     */
    ArrayList<AreaLoginPerDayDo> listCityLoginPerDayInfo(int date,String city);

    /**
     * 根据县区、日期获取多日登录信息
     * @param beginDate
     * @param endDate
     * @param district
     * @return
     */
    ArrayList<AreaLoginByDayDo> listDistrictLoginByDayInfo(int beginDate,int endDate,String district);

    /**
     * 根据县区日期获取单日登录信息
     * @param date
     * @param district
     * @return
     */
    ArrayList<AreaLoginPerDayDo> listDistrictLoginPerDayInfo(int date,String district);
}
