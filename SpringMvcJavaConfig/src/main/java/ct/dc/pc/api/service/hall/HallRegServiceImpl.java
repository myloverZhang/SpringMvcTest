package ct.dc.pc.api.service.hall;

import ct.dc.pc.api.domain.reg.HallRegDomain;
import ct.dc.pc.api.model.domain.hall.HallRegByDayDo;
import ct.dc.pc.api.model.domain.hall.HallRegByMonthDo;
import ct.dc.pc.api.service.hall.interfaces.IHallRegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/4/6.
 */
@Service
public class HallRegServiceImpl implements IHallRegService{
    @Autowired
    private HallRegDomain hallRegDomain;

    /**
     * 大厅多日注册
     *
     * @param group
     * @param beginDate
     * @param endDate
     * @return
     */
    @Override
    public ArrayList<HallRegByDayDo> listHallRegByDayInfo(int group, int beginDate, int endDate) {
        return hallRegDomain.listHallRegByDayInfo(group, beginDate, endDate);
    }

    /**
     * 大厅多月注册
     *
     * @param group
     * @param beginMonth
     * @param endMonth
     * @return
     */
    @Override
    public HallRegByMonthDo[] listHallRegByMonthInfo(int group, int beginMonth, int endMonth) {
        return hallRegDomain.listRegByMonthInfo(group, beginMonth, endMonth);
    }
}
