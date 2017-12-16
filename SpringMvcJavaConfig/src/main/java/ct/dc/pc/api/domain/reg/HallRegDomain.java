package ct.dc.pc.api.domain.reg;

import ct.dc.pc.api.dao.hall.interfaces.IHallRegByDayDao;
import ct.dc.pc.api.model.domain.hall.HallRegByDayDo;
import ct.dc.pc.api.model.domain.hall.HallRegByMonthDo;
import ct.dc.pc.api.model.po.hall.HallRegByDayPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by B41-80 on 2017/4/6.
 */
@Component
public class HallRegDomain {
    @Autowired
    private IHallRegByDayDao iHallRegByDayDao;

    /**
     * 大厅多日注册
     * @param group
     * @param beginDate
     * @param endDate
     * @return
     */
    public ArrayList<HallRegByDayDo> listHallRegByDayInfo(int group,int beginDate,int endDate){
        ArrayList<HallRegByDayDo> results = new ArrayList<>();
        for (HallRegByDayPo info:iHallRegByDayDao.findByGroup(group, beginDate, endDate)){
            HallRegByDayDo result = new HallRegByDayDo();
            result.setDate(info.getDate());
            result.setUsers(info.getUsers());
            result.setHards(info.getHards());
            results.add(result);
        }
        return results;
    }


    /**
     * 大厅多月注册信息
     * @param group
     * @param beginMonth
     * @param endMonth
     * @return
     */
    public HallRegByMonthDo[] listRegByMonthInfo(int group,int beginMonth,int endMonth){
        HallRegByMonthDo[] results = new HallRegByMonthDo[]{};
        HashMap<Integer, HallRegByMonthDo> details = new HashMap<>();
        for (HallRegByDayPo info:iHallRegByDayDao.findByGroup(group,beginMonth*100+1, endMonth*100+31)){
            int month = info.getDate()/100;
            if (!details.containsKey(month))
                details.put(month, new HallRegByMonthDo(month, 0, 0));
            HallRegByMonthDo value = details.get(month);
            value.setUsers(value.getUsers()+info.getUsers());
            value.setHards(value.getHards()+info.getHards());
        }
        return details.values().toArray(results);
    }
}
