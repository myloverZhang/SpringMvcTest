package ct.dc.pc.api.domain.login;

import ct.dc.pc.api.dao.area.interfaces.ICity2LoginByDayDao;
import ct.dc.pc.api.dao.area.interfaces.ICity2LoginPerDayDao;
import ct.dc.pc.api.domain.helper.AreaLoginInfoHelper;
import ct.dc.pc.api.model.domain.area.AreaLoginByDayDo;
import ct.dc.pc.api.model.domain.area.AreaLoginPerDayDo;
import ct.dc.pc.api.model.domain.report.ReportCityLoginByDayDo;
import ct.dc.pc.api.model.po.area.AreaLoginByDayPo;
import ct.dc.pc.api.model.po.area.AreaLoginPerDayPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/4/5.
 */
@Component
public class AreaCityLoginDomain {
    @Autowired
    private ICity2LoginByDayDao iCity2LoginByDayDao;
    @Autowired
    private ICity2LoginPerDayDao iCity2LoginPerDayDao;



    /**
     * 获取地级市多日登录信息
     * @param beginDate
     * @param endDate
     * @param city
     * @return
     */
    public ArrayList<AreaLoginByDayDo> listAreaLoginByDayInfo(int beginDate,int endDate,String city){
        ArrayList<AreaLoginByDayDo> results = new ArrayList<AreaLoginByDayDo>();
        for (AreaLoginByDayPo info:iCity2LoginByDayDao.findByCity(city,beginDate,endDate)){
            results.addAll(AreaLoginInfoHelper.listAreaLoginInfoByPo(info));
        }
        return results;
    }

    /**
     * 获取地级市单日登录信息
     * @param date
     * @param city
     * @return
     */
    public ArrayList<AreaLoginPerDayDo> listCityLoginPerDayInfo(int date,String city){
        ArrayList<AreaLoginPerDayDo> results = new ArrayList<AreaLoginPerDayDo>();
        for (AreaLoginPerDayPo info:iCity2LoginPerDayDao.findByCity(city,date)){
            results.add(AreaLoginInfoHelper.getAreaLoginPerDayByPo(info));
        }
        return results;
    }
}
