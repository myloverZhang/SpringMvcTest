package ct.dc.pc.api.domain.login;

import ct.dc.pc.api.dao.area.interfaces.IProvinceLoginByDayDao;
import ct.dc.pc.api.dao.area.interfaces.IProvinceLoginPerDayDao;
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
public class AreaProvinceDomain {
    @Autowired
    private IProvinceLoginByDayDao iProvinceLoginByDayDao;
    @Autowired
    private IProvinceLoginPerDayDao iProvinceLoginPerDayDao;

    /**
     * 省份多日登录信息
     * @param province
     * @param beginDate
     * @param endDate
     * @return
     */
    public ArrayList<AreaLoginByDayDo> listAreaLoginByDayInfo(String province,int beginDate,int endDate){
        ArrayList<AreaLoginByDayDo> results = new ArrayList<AreaLoginByDayDo>();
        for (AreaLoginByDayPo info:iProvinceLoginByDayDao.findByProvince(province, beginDate, endDate)){
            results.addAll(AreaLoginInfoHelper.listAreaLoginInfoByPo(info));
        }
        return results;
    }

    /**
     * 省份单日登录
     * @param province
     * @param date
     * @return
     */
    public ArrayList<AreaLoginPerDayDo> listAreaLoginPerDayInfo(String province,int date){
        ArrayList<AreaLoginPerDayDo> results = new ArrayList<AreaLoginPerDayDo>();
        for (AreaLoginPerDayPo info:iProvinceLoginPerDayDao.findByProvince(province, date)){
            results.add(AreaLoginInfoHelper.getAreaLoginPerDayByPo(info));
        }
        return results;
    }
}
