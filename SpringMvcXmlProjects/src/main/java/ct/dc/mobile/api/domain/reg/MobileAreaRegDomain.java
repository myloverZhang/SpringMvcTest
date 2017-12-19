package ct.dc.mobile.api.domain.reg;

import ct.dc.mobile.api.dao.mobilearea.Interface.IAreaCityRegByDayDao;
import ct.dc.mobile.api.dao.mobilearea.Interface.IAreaDistrictRegByDayDao;
import ct.dc.mobile.api.dao.mobilearea.Interface.IAreaNationRegByDayDao;
import ct.dc.mobile.api.dao.mobilearea.Interface.IAreaProvinceRegByDayDao;
import ct.dc.mobile.api.domain.helper.AreaDataUtils;
import ct.dc.mobile.api.model.domain.area.AreaRegDayDo;
import ct.dc.mobile.api.model.domain.area.AreaRegMonthDo;
import ct.dc.mobile.api.model.domain.report.ReportAreaRegDo;
import ct.dc.mobile.api.model.po.mobilearea.AreaRegByDayPo;
import ct.dc.mobile.api.model.serialize.CityInfo;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by B41-80 on 2017/1/11.
 */
public class MobileAreaRegDomain {
    private IAreaCityRegByDayDao iAreaCityRegByDayDao;
    private IAreaDistrictRegByDayDao iAreaDistrictRegByDayDao;
    private IAreaNationRegByDayDao iAreaNationRegByDayDao;
    private IAreaProvinceRegByDayDao iAreaProvinceRegByDayDao;

    public void setiAreaCityRegByDayDao(IAreaCityRegByDayDao iAreaCityRegByDayDao) {
        this.iAreaCityRegByDayDao = iAreaCityRegByDayDao;
    }

    public void setiAreaDistrictRegByDayDao(IAreaDistrictRegByDayDao iAreaDistrictRegByDayDao) {
        this.iAreaDistrictRegByDayDao = iAreaDistrictRegByDayDao;
    }

    public void setiAreaNationRegByDayDao(IAreaNationRegByDayDao iAreaNationRegByDayDao) {
        this.iAreaNationRegByDayDao = iAreaNationRegByDayDao;
    }

    public void setiAreaProvinceRegByDayDao(IAreaProvinceRegByDayDao iAreaProvinceRegByDayDao) {
        this.iAreaProvinceRegByDayDao = iAreaProvinceRegByDayDao;
    }

    /**
     * 通过
     * @return
     */
    private AreaRegDayDo getRegInfoByPo(AreaRegByDayPo info){
        AreaRegDayDo result = new AreaRegDayDo();
        result.setHards(info.getHards());
        result.setUsers(info.getUsers());
        result.setDate(info.getDate());
        return result;
    }

    /**
     * 转换成月份维度的注册明细
     */
    private void getMouthRegInfoByPo(HashMap<Integer,AreaRegMonthDo> results,AreaRegByDayPo info){
        int month = info.getDate()/100;
        if (!results.containsKey(month)){
            results.put(month,new AreaRegMonthDo(month,0,0));
        }
        AreaRegMonthDo value = results.get(month);
        value.setUsers(value.getUsers()+info.getUsers());
        value.setHards(value.getHards()+info.getHards());
    }
    /**
     * 全国按日注册信息
     * @return
     */
    public ArrayList<AreaRegDayDo> nationRegUsersByDay(int begin,int end){
        ArrayList<AreaRegDayDo> results = new ArrayList<AreaRegDayDo>();
        for (AreaRegByDayPo info:iAreaNationRegByDayDao.find(begin,end)){
            results.add(getRegInfoByPo(info));
        }
        return results;
    }

    /**
     * 全国按月注册信息
     * @return
     */
    public AreaRegMonthDo[] nationRegUsersByMonth(int begin,int end){
        HashMap<Integer,AreaRegMonthDo> mapResults = new HashMap<Integer,AreaRegMonthDo>();
        for (AreaRegByDayPo info:iAreaNationRegByDayDao.find(begin*100+1,end*100+31)){
            getMouthRegInfoByPo(mapResults,info);
        }
        AreaRegMonthDo[] results = new AreaRegMonthDo[]{};
        return mapResults.values().toArray(results);
    }

    /**
     * 省份按日注册信息
     * @return
     */
    public ArrayList<AreaRegDayDo> provinceRegUsersByDay(int begin,int end,String province){
        ArrayList<AreaRegDayDo> results = new ArrayList<AreaRegDayDo>();
        for (AreaRegByDayPo info:iAreaProvinceRegByDayDao.find(begin,end,province)){
            results.add(getRegInfoByPo(info));
        }
        return results;
    }

    /**
     * 省份按月注册信息
     * @param begin
     * @param end
     * @param province
     * @return
     */
    public AreaRegMonthDo[] provinceRegUsersByMonth(int begin,int end,String province){
        HashMap<Integer,AreaRegMonthDo> mapResults = new HashMap<Integer,AreaRegMonthDo>();
        for (AreaRegByDayPo info:iAreaProvinceRegByDayDao.find(begin*100+1,end*100+31,province)){
            getMouthRegInfoByPo(mapResults,info);
        }
        AreaRegMonthDo[] results = new AreaRegMonthDo[]{};
        return mapResults.values().toArray(results);
    }

    /**
     * 地级市按日的注册信息
     * @return
     */
    public ArrayList<AreaRegDayDo> cityRegUsersByDay(int begin,int end,String city){
        ArrayList<AreaRegDayDo> results = new ArrayList<AreaRegDayDo>();
        for (AreaRegByDayPo info:iAreaCityRegByDayDao.find(begin,end,city)){
            results.add(getRegInfoByPo(info));
        }
        return results;
    }

    /**
     * 地级市按月的注册信息
     * @param begin
     * @param end
     * @param city
     * @return
     */
    public AreaRegMonthDo[] cityRegUsersByMonth(int begin,int end,String city){
        HashMap<Integer,AreaRegMonthDo> mapResults = new HashMap<Integer,AreaRegMonthDo>();
        for (AreaRegByDayPo info:iAreaCityRegByDayDao.find(begin*100+1,end*100+31,city)){
            getMouthRegInfoByPo(mapResults,info);
        }
        AreaRegMonthDo[] results = new AreaRegMonthDo[]{};
        return mapResults.values().toArray(results);
    }

    /**
     * 县区按日的注册信息
     * @param begin
     * @param end
     * @param district
     * @return
     */
    public ArrayList<AreaRegDayDo> districtRegUsersByDay(int begin,int end,String district){
        ArrayList<AreaRegDayDo> results = new ArrayList<AreaRegDayDo>();
        for (AreaRegByDayPo info:iAreaDistrictRegByDayDao.find(begin,end,district)){
            results.add(getRegInfoByPo(info));
        }
        return results;
    }

    /**
     * 县区的按月的注册信息
     * @return
     */
    public AreaRegMonthDo[] districtRegUsersByMonth(int begin,int end,String district){
        HashMap<Integer,AreaRegMonthDo> mapResults = new HashMap<Integer,AreaRegMonthDo>();
        for (AreaRegByDayPo info:iAreaDistrictRegByDayDao.find(begin*100+1,end*100+31,district)){
            getMouthRegInfoByPo(mapResults,info);
        }
        AreaRegMonthDo[] results = new AreaRegMonthDo[]{};
        return mapResults.values().toArray(results);
    }

    /**
     * 报表地区注册信息
     * @param begin
     * @param end
     * @return
     */
    public ArrayList<ReportAreaRegDo> reportCityRegByDays(int begin,int end){
        ArrayList<ReportAreaRegDo> results = new ArrayList<ReportAreaRegDo>();
        HashMap<String,CityInfo> allCities = AreaDataUtils.allCities();
        HashMap<String,String> allProvinces = AreaDataUtils.allProvinces();
        for (AreaRegByDayPo info:iAreaCityRegByDayDao.find(begin,end)){
            if (info.getAreaId().equals("")){
                continue;
            }
            ReportAreaRegDo result = new ReportAreaRegDo();
            result.setCity(String.valueOf(info.getAreaId()));
            result.setCityName(allCities.containsKey(result.getCity())?allCities.get(result.getCity()).getCityName():"");
            result.setProvince(allCities.containsKey(result.getCity())?allCities.get(result.getCity()).getProvinceCode():"");
            result.setProvinceName(allProvinces.containsKey(result.getProvince())?allProvinces.get(result.getProvince()):"");
            result.setDate(info.getDate());
            result.setUsers(info.getUsers());
            result.setHards(info.getHards());
            results.add(result);
        }
        return results;
    }
}
