package ct.dc.mobile.api.domain.login;

import ct.dc.mobile.api.dao.mobilearea.Interface.*;
import ct.dc.mobile.api.domain.helper.AreaDataUtils;
import ct.dc.mobile.api.enums.StatTypeEnum;
import ct.dc.mobile.api.model.domain.area.AreaLoginByDayDo;
import ct.dc.mobile.api.model.domain.area.AreaLoginByPerDayDo;
import ct.dc.mobile.api.model.domain.report.ReportAreaLoginDo;
import ct.dc.mobile.api.model.po.mobilearea.AreaLoginByDayPo;
import ct.dc.mobile.api.model.po.mobilearea.AreaLoginByPerDayPo;
import ct.dc.mobile.api.model.serialize.CityInfo;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by B41-80 on 2017/1/11.
 */
public class MobileAreaLoginDomain {

    private IAreaNationLoginByDayDao iAreaNationLoginByDayDao;
    private IAreaProvinceLoginByDayDao iAreaProvinceLoginByDayDao;
    private IAreaCityLoginByDayDao iAreaCityLoginByDayDao;
    private IAreaDistrictLoginByDayDao iAreaDistrictLoginByDayDao;
    private IAreaNationLoginByPerDayDao iAreaNationLoginByPerDayDao;
    private IAreaProvinceLoginByPerDayDao iAreaProvinceLoginByPerDayDao;
    private IAreaCityLoginByPerDayDao iAreaCityLoginByPerDayDao;
    private IAreaDistrictLoginByPerDayDao iAreaDistrictLoginByPerDayDao;

    public void setiAreaNationLoginByDayDao(IAreaNationLoginByDayDao iAreaNationLoginByDayDao) {
        this.iAreaNationLoginByDayDao = iAreaNationLoginByDayDao;
    }

    public void setiAreaProvinceLoginByDayDao(IAreaProvinceLoginByDayDao iAreaProvinceLoginByDayDao) {
        this.iAreaProvinceLoginByDayDao = iAreaProvinceLoginByDayDao;
    }

    public void setiAreaCityLoginByDayDao(IAreaCityLoginByDayDao iAreaCityLoginByDayDao) {
        this.iAreaCityLoginByDayDao = iAreaCityLoginByDayDao;
    }

    public void setiAreaDistrictLoginByDayDao(IAreaDistrictLoginByDayDao iAreaDistrictLoginByDayDao) {
        this.iAreaDistrictLoginByDayDao = iAreaDistrictLoginByDayDao;
    }

    public void setiAreaNationLoginByPerDayDao(IAreaNationLoginByPerDayDao iAreaNationLoginByPerDayDao) {
        this.iAreaNationLoginByPerDayDao = iAreaNationLoginByPerDayDao;
    }

    public void setiAreaProvinceLoginByPerDayDao(IAreaProvinceLoginByPerDayDao iAreaProvinceLoginByPerDayDao) {
        this.iAreaProvinceLoginByPerDayDao = iAreaProvinceLoginByPerDayDao;
    }

    public void setiAreaCityLoginByPerDayDao(IAreaCityLoginByPerDayDao iAreaCityLoginByPerDayDao) {
        this.iAreaCityLoginByPerDayDao = iAreaCityLoginByPerDayDao;
    }

    public void setiAreaDistrictLoginByPerDayDao(IAreaDistrictLoginByPerDayDao iAreaDistrictLoginByPerDayDao) {
        this.iAreaDistrictLoginByPerDayDao = iAreaDistrictLoginByPerDayDao;
    }

    /**
     * 转换出需要的do类
     *
     * @param info
     * @return
     */
    private ArrayList<AreaLoginByDayDo> getLoginByPo(AreaLoginByDayPo info) {
        ArrayList<AreaLoginByDayDo> results = new ArrayList<AreaLoginByDayDo>();
        AreaLoginByDayDo hard = new AreaLoginByDayDo();
        AreaLoginByDayDo account = new AreaLoginByDayDo();
        hard.setType(StatTypeEnum.HARD.getValue());
        hard.setDate(info.getDate());
        hard.setTimes(info.getTimes());
        hard.setUsers1D1(info.getHards1D1());
        hard.setUsers3D1(info.getHards3D1());
        hard.setUsers7D1(info.getHards7D1());
        hard.setUsers14D1(info.getHards14D1());
        hard.setUsers30D1(info.getHards30D1());
        account.setType(StatTypeEnum.ACCOUNT.getValue());
        account.setDate(info.getDate());
        account.setTimes(info.getTimes());
        account.setUsers1D1(info.getUsers1D1());
        account.setUsers3D1(info.getUsers3D1());
        account.setUsers7D1(info.getUsers7D1());
        account.setUsers14D1(info.getUsers14D1());
        account.setUsers30D1(info.getUsers30D1());
        results.add(account);
        results.add(hard);
        return results;
    }

    /**
     * 通过po获取单日登录的信息
     * @return
     */
    private AreaLoginByPerDayDo getPerLoginByPo(AreaLoginByPerDayPo info){
        AreaLoginByPerDayDo result = new AreaLoginByPerDayDo();
        result.setTrange(info.getTrange());
        result.setUsers(info.getUsers());
        result.setHards(info.getHards());
        result.setTimes(info.getTimes());
        return result;
    }
    /**
     * 全国多日登录
     * @param begin
     * @param end
     * @return
     */
    public ArrayList<AreaLoginByDayDo> nationUsersByDay(int begin,int end){
        ArrayList<AreaLoginByDayDo> results = new ArrayList<AreaLoginByDayDo>();
        for (AreaLoginByDayPo info: iAreaNationLoginByDayDao.find(begin,end)){
            results.addAll(getLoginByPo(info));
        }
        return results;
    }

    /**
     * 全国单日登录
     * @param date
     * @return
     */
    public ArrayList<AreaLoginByPerDayDo> nationUsersByPerDay(int date){
        ArrayList<AreaLoginByPerDayDo> results = new ArrayList<AreaLoginByPerDayDo>();
        for (AreaLoginByPerDayPo info:iAreaNationLoginByPerDayDao.find(date)){
            results.add(getPerLoginByPo(info));
        }
        return results;
    }

    /**
     * 省份多日登录
     * @param province
     * @param begin
     * @param end
     * @return
     */
    public ArrayList<AreaLoginByDayDo> provinceUsersByDay(String province,int begin,int end){
        ArrayList<AreaLoginByDayDo> results = new ArrayList<AreaLoginByDayDo>();
        for (AreaLoginByDayPo info: iAreaProvinceLoginByDayDao.find(province,begin,end)){
            results.addAll(getLoginByPo(info));
        }
        return results;
    }

    /**
     * 省份单日登录
     * @param province
     * @param date
     * @return
     */
    public ArrayList<AreaLoginByPerDayDo> provinceUserByPerDay(String province,int date){
        ArrayList<AreaLoginByPerDayDo> results = new ArrayList<AreaLoginByPerDayDo>();
        for (AreaLoginByPerDayPo info:iAreaProvinceLoginByPerDayDao.find(province,date)){
            results.add(getPerLoginByPo(info));
        }
        return results;
    }


    /**
     * 地级市多日登录
     * @return
     */
    public ArrayList<AreaLoginByDayDo> cityUsersByDay(String city,int begin,int end){
        ArrayList<AreaLoginByDayDo> results = new ArrayList<AreaLoginByDayDo>();
        for (AreaLoginByDayPo info: iAreaCityLoginByDayDao.find(city,begin,end)){
            results.addAll(getLoginByPo(info));
        }
        return results;
    }

    /**
     * 地级市单日登录
     * @param city
     * @param date
     * @return
     */
    public ArrayList<AreaLoginByPerDayDo> cityUsersByPerDay(String city,int date){
        ArrayList<AreaLoginByPerDayDo> results = new ArrayList<AreaLoginByPerDayDo>();
        for (AreaLoginByPerDayPo info:iAreaCityLoginByPerDayDao.find(city,date)){
            results.add(getPerLoginByPo(info));
        }
        return results;
    }

    /**
     * 地级市多日登录
     * @return
     */
    public ArrayList<AreaLoginByDayDo> districtUsersByDay(String district,int begin,int end){
        ArrayList<AreaLoginByDayDo> results = new ArrayList<AreaLoginByDayDo>();
        for (AreaLoginByDayPo info: iAreaDistrictLoginByDayDao.find(district,begin,end)){
            results.addAll(getLoginByPo(info));
        }
        return results;
    }

    /**
     * 地级市单日登录
     * @param district
     * @param date
     * @return
     */
    public ArrayList<AreaLoginByPerDayDo> districtUsersByPerDay(String district,int date){
        ArrayList<AreaLoginByPerDayDo> results = new ArrayList<AreaLoginByPerDayDo>();
        for (AreaLoginByPerDayPo info:iAreaDistrictLoginByPerDayDao.find(district,date)){
            results.add(getPerLoginByPo(info));
        }
        return results;
    }


    /**
     * 报表地区多日登录接口
     * @return
     */
    public ArrayList<ReportAreaLoginDo> reportAreaLogin(int begin,int end){
        HashMap<String,CityInfo> allCities = AreaDataUtils.allCities();
        HashMap<String,String> allProvinces = AreaDataUtils.allProvinces();
        ArrayList<ReportAreaLoginDo> results = new ArrayList<ReportAreaLoginDo>();
        for (AreaLoginByDayPo info:iAreaCityLoginByDayDao.find(begin,end)){
            if (info.getAreaId().equals("")){
                continue;
            }
            ReportAreaLoginDo result = new ReportAreaLoginDo();
            result.setDate(info.getDate());
            result.setCity(String.valueOf(info.getAreaId()));
            result.setCityName(allCities.containsKey(result.getCity())?allCities.get(result.getCity()).getCityName():"");
            result.setProvince(allCities.containsKey(result.getCity())?allCities.get(result.getCity()).getProvinceCode():"");
            result.setProvinceName(allProvinces.containsKey(result.getProvince())?allProvinces.get(result.getProvince()):"");
            result.setTimes(info.getTimes());
            result.setUsers1D1(info.getUsers1D1());
            result.setUsers3D1(info.getUsers3D1());
            result.setUsers7D1(info.getUsers7D1());
            result.setUsers14D1(info.getUsers14D1());
            result.setUsers30D1(info.getUsers30D1());
            result.setHards1D1(info.getHards1D1());
            result.setHards3D1(info.getHards3D1());
            result.setHards7D1(info.getHards7D1());
            result.setHards14D1(info.getHards14D1());
            result.setHards30D1(info.getHards30D1());
            results.add(result);
        }
        return results;
    }

}
