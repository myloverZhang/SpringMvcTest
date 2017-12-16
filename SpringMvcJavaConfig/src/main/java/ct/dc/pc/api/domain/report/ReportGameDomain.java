package ct.dc.pc.api.domain.report;

import ct.dc.pc.api.dao.game.interfaces.IGameLoginByDayDao;
import ct.dc.pc.api.dao.game.interfaces.IGameRetainByDayDao;
import ct.dc.pc.api.domain.helper.AppDataUtils;
import ct.dc.pc.api.model.domain.report.ReportGameRetainByDayDo;
import ct.dc.pc.api.model.po.game.GameRetainByDayPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by B41-80 on 2017/4/7.
 */
@Component
public class ReportGameDomain {
    @Autowired
    private IGameLoginByDayDao iGameLoginByDayDao;
    @Autowired
    private IGameRetainByDayDao iGameRetainByDayDao;
    /**
     * 游戏留存报表数据
     * @param beginDate
     * @param endDate
     * @return
     */
    public ArrayList<ReportGameRetainByDayDo> listGameRetainByDayInfo(int beginDate,int endDate){
        ArrayList<ReportGameRetainByDayDo> results = new ArrayList<>();
        HashMap<String,String> allGame = AppDataUtils.allGame();
        for (GameRetainByDayPo info:iGameRetainByDayDao.find(beginDate,endDate)){
            ReportGameRetainByDayDo result = new ReportGameRetainByDayDo();

        }
        return results;
    }
}
