package ct.dc.pc.api.domain.reg;

import ct.dc.pc.api.dao.area.interfaces.ICity2RegByDayDao;
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
public class AreaCityRegDomain {
    @Autowired
    private ICity2RegByDayDao iCity2RegByDayDao;
    /**
     * 地级市多日注册信息
     * @param city
     * @param beginDate
     * @param endDate
     * @return
     */
    public ArrayList<AreaRegDayDo> listAreaRegByDayInfo(String city,int beginDate,int endDate){
        ArrayList<AreaRegDayDo> results = new ArrayList<AreaRegDayDo>();
        for (AreaRegByDayPo info:iCity2RegByDayDao.findByCity(city, beginDate, endDate)){
            results.add(AreaRegInfoHelper.getRegByDayInfoByPo(info));
        }
        return results;
    }

    /**
     * 地级市多月注册
     * @param city
     * @param beginMonth
     * @param endMonth
     * @return
     */
    public AreaRegMonthDo[] listAreaRegByMonthInfo(String city,int beginMonth,int endMonth){
        AreaRegMonthDo[] results = new AreaRegMonthDo[]{};
        HashMap<Integer,AreaRegMonthDo> details = new HashMap<Integer, AreaRegMonthDo>();
            for (AreaRegByDayPo info:iCity2RegByDayDao.findByCity(city,beginMonth*100+1,endMonth*100+31)){
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
