package ct.dc.pc.api.domain.login;

import ct.dc.pc.api.dao.area.interfaces.IDistrictLoginByDay;
import ct.dc.pc.api.dao.area.interfaces.IDistrictLoginPerDay;
import ct.dc.pc.api.domain.helper.AreaLoginInfoHelper;
import ct.dc.pc.api.model.domain.area.AreaLoginByDayDo;
import ct.dc.pc.api.model.domain.area.AreaLoginPerDayDo;
import ct.dc.pc.api.model.po.area.AreaLoginByDayPo;
import ct.dc.pc.api.model.po.area.AreaLoginPerDayPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/4/5.
 */
@Component
public class AreaDistrictLoginDomain {
    @Autowired
    private IDistrictLoginPerDay iDistrictLoginPerDay;
    @Autowired
    private IDistrictLoginByDay iDistrictLoginByDay;

    /**
     * 县区多日登录信息
     * @param district
     * @param beginDate
     * @param endDate
     * @return
     */
    public ArrayList<AreaLoginByDayDo> listAreaLoginByDayInfo(String district,int beginDate,int endDate){
        ArrayList<AreaLoginByDayDo> results = new ArrayList<AreaLoginByDayDo>();
        for (AreaLoginByDayPo info:iDistrictLoginByDay.findByDistrict(district, beginDate, endDate)){
            results.addAll(AreaLoginInfoHelper.listAreaLoginInfoByPo(info));
        }
        return results;
    }

    /**
     * 县区单日登录信息
     * @param district
     * @param date
     * @return
     */
    public ArrayList<AreaLoginPerDayDo> listAreaLoginPerDayInfo(String district,int date){
        ArrayList<AreaLoginPerDayDo> results = new ArrayList<AreaLoginPerDayDo>();
        for (AreaLoginPerDayPo info:iDistrictLoginPerDay.findByDistrict(district,date)){
            results.add(AreaLoginInfoHelper.getAreaLoginPerDayByPo(info));
        }
        return results;
    }
}
