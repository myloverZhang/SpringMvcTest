package ct.dc.pc.api.domain.reg;

import ct.dc.pc.api.dao.area.interfaces.INationRegByDayDao;
import ct.dc.pc.api.domain.helper.AreaRegInfoHelper;
import ct.dc.pc.api.model.domain.area.AreaRegDayDo;
import ct.dc.pc.api.model.domain.area.AreaRegMonthDo;
import ct.dc.pc.api.model.po.area.AreaRegByDayPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by B41-80 on 2017/4/5.
 */
@Component
public class AreaNationRegDomain {

    @Autowired
    private INationRegByDayDao iNationRegByDayDao;
    /**
     * 全国多日注册信息
     * @param beginDate
     * @param endDate
     * @return
     */
    public ArrayList<AreaRegDayDo> listAreaRegByDayInfo(int beginDate, int endDate){
        ArrayList<AreaRegDayDo> results = new ArrayList<AreaRegDayDo>();
        for (AreaRegByDayPo info:iNationRegByDayDao.find(beginDate, endDate)){
            results.add(AreaRegInfoHelper.getRegByDayInfoByPo(info));
        }
        return results;
    }

    /**
     * 地级市多月注册
     * @param beginMonth
     * @param endMonth
     * @return
     */
    public AreaRegMonthDo[] listAreaRegByMonthInfo(int beginMonth, int endMonth){
        AreaRegMonthDo[] results = new AreaRegMonthDo[]{};
        HashMap<Integer,AreaRegMonthDo> details = new HashMap<Integer, AreaRegMonthDo>();
        for (AreaRegByDayPo info:iNationRegByDayDao.find(beginMonth*100+1,endMonth*100+31)){
            int month = info.getDate()/100;
            if (!details.containsKey(month))
                details.put(month,new AreaRegMonthDo(month,0,0));
            AreaRegMonthDo value = details.get(month);
            value.setUsers(value.getUsers()+info.getUsers());
            value.setHards(value.getHards()+info.getHards());
        }
        return details.values().toArray(results);
    }
}
