package ct.dc.pc.api.domain.report;

import ct.dc.pc.api.dao.area.interfaces.ICity2LoginByDayDao;
import ct.dc.pc.api.dao.area.interfaces.ICity2RegByDayDao;
import ct.dc.pc.api.dao.area.interfaces.ICity2RetainByDayDao;
import ct.dc.pc.api.domain.helper.AreaDataUtils;
import ct.dc.pc.api.model.domain.report.ReportCityLoginByDayDo;
import ct.dc.pc.api.model.domain.report.ReportCityRegByDayDo;
import ct.dc.pc.api.model.domain.report.ReportCityRetainByDayDo;
import ct.dc.pc.api.model.po.area.AreaLoginByDayPo;
import ct.dc.pc.api.model.po.area.AreaRegByDayPo;
import ct.dc.pc.api.model.po.area.AreaRetainByDayPo;
import ct.dc.pc.api.model.serialize.CityInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by B41-80 on 2017/4/7.
 */
@Component
public class ReportAreaDomain {
    @Autowired
    private ICity2LoginByDayDao iCity2LoginByDayDao;
    @Autowired
    private ICity2RegByDayDao iCity2RegByDayDao;
    @Autowired
    private ICity2RetainByDayDao iCity2RetainByDayDao;

    /**
     * 报表 地级市多日登录数据
     * @param beginDate
     * @param endDate
     * @return
     */
    public ArrayList<ReportCityLoginByDayDo> listReportAreaLoginInfo(int beginDate, int endDate){
        HashMap<String,CityInfo> allCities = AreaDataUtils.allCities();
        HashMap<String,String> allProvinces = AreaDataUtils.allProvinces();
        ArrayList<ReportCityLoginByDayDo> results = new ArrayList<>();
        for (AreaLoginByDayPo info:iCity2LoginByDayDao.find(beginDate, endDate)){
            if (info.getAreaId().equals(""))
                continue;
            ReportCityLoginByDayDo result = new ReportCityLoginByDayDo();
            result.setDate(info.getDate());
            result.setCity(info.getAreaId());
            result.setCityName(allCities.containsKey(info.getAreaId())?allCities.get(info.getAreaId()).getCityName():"");
            result.setProvince(allCities.containsKey(info.getAreaId())?
                    allCities.get(result.getCity()).getProvinceCode():"");
            result.setProvinceName(allProvinces.containsKey(result.getProvince())?
                    allProvinces.get(result.getProvince()):"");
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


    /**
     * 报表 地级市多日留存数据
     * @param beginDate
     * @param endDate
     * @return
     */
    public ArrayList<ReportCityRetainByDayDo> listReportAreaRetainInfo(int beginDate,int endDate){
        HashMap<String,CityInfo> allCities = AreaDataUtils.allCities();
        HashMap<String,String> allProvinces = AreaDataUtils.allProvinces();
        ArrayList<ReportCityRetainByDayDo> results = new ArrayList<>();
        for (AreaRetainByDayPo info:iCity2RetainByDayDao.find(beginDate, endDate)){
            if (info.getArea().equals(""))
                continue;
            ReportCityRetainByDayDo result = new ReportCityRetainByDayDo();
            result.setDate(info.getDate());
            result.setCity(info.getArea());
            result.setCityName(allCities.containsKey(info.getArea())?allCities.get(info.getArea()).getCityName():"");
            result.setProvince(allCities.containsKey(info.getArea())?
                    allCities.get(result.getCity()).getProvinceCode():"");
            result.setProvinceName(allProvinces.containsKey(result.getProvince())?
                    allProvinces.get(result.getProvince()):"");
            result.setUsersNew(info.getUsersNew());
            result.setUsersD1(info.getUsersD1());
            result.setUsersD3(info.getUsersD3());
            result.setUsersD7(info.getUsersD7());
            result.setUsersD14(info.getUsersD14());
            result.setUsersD30(info.getUsersD30());
            result.setHardsNew(info.getHardsNew());
            result.setHardsD1(info.getHardsD1());
            result.setHardsD3(info.getHardsD3());
            result.setHardsD7(info.getHardsD7());
            result.setHardsD14(info.getHardsD14());
            result.setHardsD30(info.getHardsD30());
            results.add(result);
        }
        return results;
    }


    /**
     * 报表 地级市多日注册
     * @param beginDate
     * @param endDate
     * @return
     */
    public ArrayList<ReportCityRegByDayDo> listReportAreaRegInfo(int beginDate,int endDate){
        HashMap<String,CityInfo> allCities = AreaDataUtils.allCities();
        HashMap<String,String> allProvinces = AreaDataUtils.allProvinces();
        ArrayList<ReportCityRegByDayDo> results = new ArrayList<>();
        for (AreaRegByDayPo info:iCity2RegByDayDao.find(beginDate, endDate)){
            if (info.getAreaId().equals(""))
                continue;
            ReportCityRegByDayDo result = new ReportCityRegByDayDo();
            result.setDate(info.getDate());
            result.setCity(info.getAreaId());
            result.setCityName(allCities.containsKey(info.getAreaId())?allCities.get(info.getAreaId()).getCityName():"");
            result.setProvince(allCities.containsKey(info.getAreaId())?
                    allCities.get(result.getCity()).getProvinceCode():"");
            result.setProvinceName(allProvinces.containsKey(result.getProvince())?
                    allProvinces.get(result.getProvince()):"");
            result.setUsers(info.getUsers());
            result.setHards(info.getHards());
            results.add(result);
        }
        return results;
    }
}
