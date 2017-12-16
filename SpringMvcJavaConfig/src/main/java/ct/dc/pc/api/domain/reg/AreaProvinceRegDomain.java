package ct.dc.pc.api.domain.reg;

import ct.dc.pc.api.dao.area.interfaces.IProvinceRegByDayDao;
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
public class AreaProvinceRegDomain {
    @Autowired
    private IProvinceRegByDayDao iProvinceRegByDayDao;

    /**
     * 地级市多日注册信息
     * @param province
     * @param beginDate
     * @param endDate
     * @return
     */
    public ArrayList<AreaRegDayDo> listAreaRegByDayInfo(String province, int beginDate, int endDate){
        ArrayList<AreaRegDayDo> results = new ArrayList<AreaRegDayDo>();
        for (AreaRegByDayPo info:iProvinceRegByDayDao.findByProvince(province, beginDate, endDate)){
            results.add(AreaRegInfoHelper.getRegByDayInfoByPo(info));
        }
        return results;
    }

    /**
     * 地级市多月注册
     * @param province
     * @param beginMonth
     * @param endMonth
     * @return
     */
    public AreaRegMonthDo[] listAreaRegByMonthInfo(String province, int beginMonth, int endMonth){
        AreaRegMonthDo[] results = new AreaRegMonthDo[]{};
        HashMap<Integer,AreaRegMonthDo> details = new HashMap<Integer, AreaRegMonthDo>();
        for (AreaRegByDayPo info:iProvinceRegByDayDao.findByProvince(province,beginMonth*100+1,endMonth*100+31)){
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
