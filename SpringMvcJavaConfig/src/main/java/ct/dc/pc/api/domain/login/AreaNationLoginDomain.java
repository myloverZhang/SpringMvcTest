package ct.dc.pc.api.domain.login;

import ct.dc.pc.api.dao.area.interfaces.INationLoginByDayDao;
import ct.dc.pc.api.dao.area.interfaces.INationLoginPerDayDao;
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
public class AreaNationLoginDomain {
    @Autowired
    private INationLoginPerDayDao iNationLoginPerDayDao;
    @Autowired
    private INationLoginByDayDao iNationLoginByDayDao;

    /**
     * 全国多日登录信息
     * @param beginDate
     * @param endDate
     * @return
     */
    public ArrayList<AreaLoginByDayDo> listAreaLoginByDayInfo(int beginDate, int endDate){
        ArrayList<AreaLoginByDayDo> results = new ArrayList<AreaLoginByDayDo>();
        for (AreaLoginByDayPo info:iNationLoginByDayDao.find(beginDate, endDate)){
            results.addAll(AreaLoginInfoHelper.listAreaLoginInfoByPo(info));
        }
        return results;
    }

    /**
     * 全国单日登录
     * @param date
     * @return
     */
    public ArrayList<AreaLoginPerDayDo> listAreaLoginPerDayInfo(int date){
        ArrayList<AreaLoginPerDayDo> results = new ArrayList<AreaLoginPerDayDo>();
        for (AreaLoginPerDayPo info:iNationLoginPerDayDao.find(date)){
            results.add(AreaLoginInfoHelper.getAreaLoginPerDayByPo(info));
        }
        return results;
    }
}
