package ct.dc.pc.api.domain.retain;

import com.sun.org.apache.regexp.internal.RESyntaxException;
import com.sun.scenario.effect.impl.prism.PrImage;
import ct.dc.pc.api.dao.hall.interfaces.IHallRetainHallByDayDao;
import ct.dc.pc.api.dao.hall.interfaces.IHallRetainPcByDayDao;
import ct.dc.pc.api.enums.HallRetainTypeEnum;
import ct.dc.pc.api.enums.StatTypeEnum;
import ct.dc.pc.api.model.domain.hall.HallRetainByDayDo;
import ct.dc.pc.api.model.po.hall.HallRetainHallByDayPo;
import ct.dc.pc.api.model.po.hall.HallRetainPcByDayPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/4/6.
 */
@Component
public class HallRetainDomain {
    @Autowired
    private IHallRetainHallByDayDao iHallRetainHallByDayDao;
    @Autowired
    private IHallRetainPcByDayDao iHallRetainPcByDayDao;

    /**
     * hall
     * @param group
     * @param beginDate
     * @param endDate
     * @return
     */

    private ArrayList<HallRetainByDayDo> listHallRetainHallInfo(int group,int beginDate,int endDate){
        ArrayList<HallRetainByDayDo> results = new ArrayList<>();
        for (HallRetainHallByDayPo info:iHallRetainHallByDayDao.findByGroup(group, beginDate, endDate)){
            HallRetainByDayDo account = new HallRetainByDayDo();
            HallRetainByDayDo hard = new HallRetainByDayDo();

            account.setType(StatTypeEnum.ACCOUNT.getValue());
            account.setDate(info.getDate());
            account.setNewCount(info.getUsersNew());
            account.setUsers1Day(info.getUsersD1());
            account.setUsers3Day(info.getUsersD3());
            account.setUsers7Day(info.getUsersD7());
            account.setUsers14Day(info.getUsersD14());
            account.setUsers30Day(info.getUsersD30());

            hard.setType(StatTypeEnum.HARD.getValue());
            hard.setDate(info.getDate());
            hard.setNewCount(info.getHardsNew());
            hard.setUsers1Day(info.getHardsD1());
            hard.setUsers3Day(info.getHardsD3());
            hard.setUsers7Day(info.getHardsD7());
            hard.setUsers14Day(info.getHardsD14());
            hard.setUsers30Day(info.getHardsD30());

            results.add(account);
            results.add(hard);
        }
        return results;
    }

    /**
     * 大厅留存
     * @param group
     * @param beginDate
     * @param endDate
     * @return
     */
    private ArrayList<HallRetainByDayDo> listHallRetainPcInfo(int group,int beginDate,int endDate){
        ArrayList<HallRetainByDayDo> results = new ArrayList<>();
        for (HallRetainPcByDayPo info:iHallRetainPcByDayDao.findByGroup(group, beginDate, endDate)){
            HallRetainByDayDo account = new HallRetainByDayDo();
            HallRetainByDayDo hard = new HallRetainByDayDo();

            account.setType(StatTypeEnum.ACCOUNT.getValue());
            account.setDate(info.getDate());
            account.setNewCount(info.getUsersNew());
            account.setUsers1Day(info.getUsersD1());
            account.setUsers3Day(info.getUsersD3());
            account.setUsers7Day(info.getUsersD7());
            account.setUsers14Day(info.getUsersD14());
            account.setUsers30Day(info.getUsersD30());

            hard.setType(StatTypeEnum.HARD.getValue());
            hard.setDate(info.getDate());
            hard.setNewCount(info.getHardsNew());
            hard.setUsers1Day(info.getHardsD1());
            hard.setUsers3Day(info.getHardsD3());
            hard.setUsers7Day(info.getHardsD7());
            hard.setUsers14Day(info.getHardsD14());
            hard.setUsers30Day(info.getHardsD30());

            results.add(account);
            results.add(hard);
        }
        return results;
    }
    /**
     * 大厅多日留存
     * @param retainType
     * @param group
     * @param beginDate
     * @param endDate
     * @return
     */
    public ArrayList<HallRetainByDayDo> listHallRetainByDayInfo(int retainType,int group,int beginDate,int endDate){
        ArrayList<HallRetainByDayDo> results = new ArrayList<>();
        switch (HallRetainTypeEnum.valueOf(retainType)){
            case HALL:
                return listHallRetainHallInfo(group, beginDate, endDate);
            case PC:
                return listHallRetainPcInfo(group, beginDate, endDate);
            default:
                return results;
        }
    }
}
