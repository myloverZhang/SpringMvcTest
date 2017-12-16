package ct.dc.pc.api.service.hall.interfaces;

import ct.dc.pc.api.model.domain.hall.HallRetainByDayDo;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/4/6.
 */
public interface IHallRetainService {

    /**
     * 大厅留存
     * @param group
     * @param beginDate
     * @param endDate
     * @param retainType
     * @return
     */
    ArrayList<HallRetainByDayDo> listHallRetainByDayInfo(int group,int beginDate,int endDate,int retainType);

}
