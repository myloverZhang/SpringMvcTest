package ct.dc.pc.api.service.hall;

import ct.dc.pc.api.domain.retain.HallRetainDomain;
import ct.dc.pc.api.model.domain.hall.HallRetainByDayDo;
import ct.dc.pc.api.service.hall.interfaces.IHallRetainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/4/6.
 */
@Service
public class HallRetainServiceImpl implements IHallRetainService{

    @Autowired
    private HallRetainDomain hallRetainDomain;

    /**
     * 大厅留存
     *
     * @param group
     * @param beginDate
     * @param endDate
     * @param retainType
     * @return
     */
    @Override
    public ArrayList<HallRetainByDayDo> listHallRetainByDayInfo(int group, int beginDate, int endDate, int retainType) {
        return hallRetainDomain.listHallRetainByDayInfo(retainType, group, beginDate, endDate);
    }
}
