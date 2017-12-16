package ct.dc.pc.api.domain.helper;

import ct.dc.pc.api.model.domain.area.AreaRegDayDo;
import ct.dc.pc.api.model.po.area.AreaRegByDayPo;

/**
 * Created by B41-80 on 2017/3/7.
 */
public class AreaRegInfoHelper {
    /**
     *多日注册信息转换
     * @param info
     * @return
     */
    public static AreaRegDayDo getRegByDayInfoByPo(AreaRegByDayPo info){
        AreaRegDayDo result = new AreaRegDayDo();
        result.setDate(info.getDate());
        result.setUsers(info.getUsers());
        result.setHards(info.getHards());
        return result;
    }
}
