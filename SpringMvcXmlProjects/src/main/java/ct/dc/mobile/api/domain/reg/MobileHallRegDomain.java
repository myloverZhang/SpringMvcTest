package ct.dc.mobile.api.domain.reg;

import com.sun.org.apache.bcel.internal.generic.MONITORENTER;
import ct.dc.mobile.api.dao.mobileHall.Interface.IHallRegByDayDao;
import ct.dc.mobile.api.model.domain.hall.HallRegByDayDo;
import ct.dc.mobile.api.model.domain.hall.HallRegByMonthDo;
import ct.dc.mobile.api.model.po.mobilehall.HallRegByDayPo;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by B41-80 on 2017/1/13.
 */
public class MobileHallRegDomain {

    private IHallRegByDayDao iHallRegByDayDao;

    public void setiHallRegByDayDao(IHallRegByDayDao iHallRegByDayDao) {
        this.iHallRegByDayDao = iHallRegByDayDao;
    }

    /**
     * 大厅多日注册
     * @param begin
     * @param end
     * @param hallId
     * @return
     */
    public ArrayList<HallRegByDayDo> regUsersByDay(int begin,int end,int hallId){
        ArrayList<HallRegByDayDo> results = new ArrayList<HallRegByDayDo>();
        for (HallRegByDayPo info:iHallRegByDayDao.find(begin,end,hallId)){
            HallRegByDayDo result = new HallRegByDayDo();
            result.setUsers(info.getUsers());
            result.setHards(info.getHards());
            result.setDate(info.getDate());
            results.add(result);
        }
        return results;
    }

    /**
     * 大厅多月注册信息
     * @param begin
     * @param end
     * @param hallId
     * @return
     */
    public HallRegByMonthDo[] regUsersByMonth(int begin,int end,int hallId){
        HashMap<Integer,HallRegByMonthDo> mapResults = new HashMap<Integer,HallRegByMonthDo>();
        for (HallRegByDayPo info:iHallRegByDayDao.find(begin*100+1,end*100+31,hallId)){
            int month = info.getDate()/100;
            if (!mapResults.containsKey(month)){
                mapResults.put(month,new HallRegByMonthDo(month,0 ,0));
            }
            HallRegByMonthDo value = mapResults.get(month);
            value.setUsers(value.getUsers()+info.getUsers());
            value.setHards(value.getHards()+info.getHards());
        }
        HallRegByMonthDo[] results = new HallRegByMonthDo[]{};
        return mapResults.values().toArray(results);
    }
}
