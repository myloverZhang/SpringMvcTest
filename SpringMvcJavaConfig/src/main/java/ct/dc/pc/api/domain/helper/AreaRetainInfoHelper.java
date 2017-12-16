package ct.dc.pc.api.domain.helper;

import ct.dc.pc.api.enums.StatTypeEnum;
import ct.dc.pc.api.model.domain.area.AreaRetainByDayDo;
import ct.dc.pc.api.model.po.area.AreaRetainByDayPo;

import java.util.ArrayList;

/**
 * Created by CTWLPC on 2017/6/14.
 */
public class AreaRetainInfoHelper {
    /**
     * 通过po实体类 获取do实体类
     * @return
     */
    public static ArrayList<AreaRetainByDayDo> listTheRetainDoByPo(AreaRetainByDayPo info){
        ArrayList<AreaRetainByDayDo> results = new ArrayList<>();
        AreaRetainByDayDo account = new AreaRetainByDayDo();
        account.setDate(info.getDate());
        account.setType(StatTypeEnum.ACCOUNT.getValue());
        account.setNewCount(info.getUsersNew());
        account.setUsers1Day(info.getUsersD1());
        account.setUsers3Day(info.getUsersD3());
        account.setUsers7Day(info.getUsersD7());
        account.setUsers14Day(info.getUsersD14());
        account.setUsers30Day(info.getUsersD30());
        results.add(account);

        AreaRetainByDayDo hard = new AreaRetainByDayDo();
        hard.setDate(info.getDate());
        hard.setType(StatTypeEnum.HARD.getValue());
        hard.setNewCount(info.getHardsNew());
        hard.setUsers1Day(info.getHardsD1());
        hard.setUsers3Day(info.getHardsD3());
        hard.setUsers7Day(info.getHardsD7());
        hard.setUsers14Day(info.getHardsD14());
        hard.setUsers30Day(info.getHardsD30());
        results.add(hard);
        return results;
    }
}
