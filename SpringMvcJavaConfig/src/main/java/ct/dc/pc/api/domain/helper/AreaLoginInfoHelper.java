package ct.dc.pc.api.domain.helper;

import ct.dc.pc.api.enums.StatTypeEnum;
import ct.dc.pc.api.model.domain.area.AreaLoginByDayDo;
import ct.dc.pc.api.model.domain.area.AreaLoginPerDayDo;
import ct.dc.pc.api.model.po.area.AreaLoginByDayPo;
import ct.dc.pc.api.model.po.area.AreaLoginPerDayPo;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/3/6.
 */

public class AreaLoginInfoHelper {

    /**
     * 地区信息多日登录转换
     * @param info
     * @return
     */
    public static ArrayList<AreaLoginByDayDo> listAreaLoginInfoByPo(AreaLoginByDayPo info){
        AreaLoginByDayDo account = new AreaLoginByDayDo();
        account.setDate(info.getDate());
        account.setTimes(info.getTimes());
        account.setType(StatTypeEnum.ACCOUNT.getValue());
        account.setUsers1D1(info.getUsers1D1());
        account.setUsers3D1(info.getUsers3D1());
        account.setUsers7D1(info.getUsers7D1());
        account.setUsers14D1(info.getUsers14D1());
        account.setUsers30D1(info.getUsers30D1());

        AreaLoginByDayDo hard = new AreaLoginByDayDo();
        hard.setDate(info.getDate());
        hard.setTimes(info.getTimes());
        hard.setType(StatTypeEnum.HARD.getValue());
        hard.setUsers1D1(info.getHards1D1());
        hard.setUsers3D1(info.getHards3D1());
        hard.setUsers7D1(info.getHards7D1());
        hard.setUsers14D1(info.getHards14D1());
        hard.setUsers30D1(info.getHards30D1());

        ArrayList<AreaLoginByDayDo> results = new ArrayList<AreaLoginByDayDo>();
        results.add(account);
        results.add(hard);
        return results;
    }

    /**
     * 单日登录转换
     * @param info
     * @return
     */
    public static AreaLoginPerDayDo getAreaLoginPerDayByPo(AreaLoginPerDayPo info){
        AreaLoginPerDayDo result =new AreaLoginPerDayDo();
        result.setTrange(info.getTrange());
        result.setUsers(info.getUsers());
        result.setHards(info.getHards());
        result.setTimes(info.getTimes());
        return result;
    }
}
