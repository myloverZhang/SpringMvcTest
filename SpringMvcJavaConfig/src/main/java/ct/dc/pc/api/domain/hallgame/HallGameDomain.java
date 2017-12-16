package ct.dc.pc.api.domain.hallgame;

import ct.dc.libinfrastructure.CommonUtils;
import ct.dc.liblogs.ICtDataLogger;
import ct.dc.liblogs.impl.CtDataLoggerImpl;
import ct.dc.pc.api.dao.merge.interfaces.IHallGameByDayDao;
import ct.dc.pc.api.model.domain.merge.MergeLoginByDayDo;
import ct.dc.pc.api.model.domain.merge.MergeLoginDetailByDayDo;
import ct.dc.pc.api.model.po.merge.MergeLoginByDayPo;
import ct.dc.pc.api.model.po.merge.MergeLoginDetailsByDayPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * Created by B41-80 on 2017/4/6.
 */
@Component
public class HallGameDomain {
    private static ICtDataLogger logger = new CtDataLoggerImpl(HallGameDomain.class);
    @Autowired
    private IHallGameByDayDao iHallGameByDayDao;
    /**
     * 大厅游戏二合数据
     * @param beginDate
     * @param endDate
     * @param hallId
     * @return
     */
    public ArrayList<MergeLoginByDayDo> listHallGameInfo(int beginDate,int endDate,int hallId){
        ArrayList<MergeLoginByDayDo> results = new ArrayList<>();
        try {
            for (MergeLoginByDayPo info:iHallGameByDayDao.findByGroup(beginDate, endDate, hallId)){
                results.add(new MergeLoginByDayDo(info.getId(),info.getType(),info.getLoginUnitNum(),info.getTimes()));
            }
        } catch (ExecutionException e) {
            logger.error(String.format("获取大厅游戏二合数据失败{%s}", CommonUtils.getStackErrors(e)));
        } catch (InterruptedException e) {
            logger.error(String.format("获取大厅游戏二合数据失败{%s}", CommonUtils.getStackErrors(e)));
        }
        return results;
    }


    /**
     * 游戏大厅二合数据
     * @param beginDate
     * @param endDate
     * @param game
     * @return
     */
    public ArrayList<MergeLoginByDayDo> listGameHallInfo(int beginDate,int endDate,int game){
        ArrayList<MergeLoginByDayDo> results = new ArrayList<>();
        try {
            for (MergeLoginByDayPo info:iHallGameByDayDao.findByGame(beginDate, endDate, game)){
                results.add(new MergeLoginByDayDo(info.getId(),info.getType(),info.getLoginUnitNum(),info.getTimes()));
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return results;
    }

    /**
     * 大厅二合数据明细
     * @param beginDate
     * @param endDate
     * @param group
     * @param game
     * @return
     */
    public ArrayList<MergeLoginDetailByDayDo> listMergeDetailInfo(int beginDate,int endDate,int group,int game){
        ArrayList<MergeLoginDetailByDayDo> results = new ArrayList<>();
        try {
            for (MergeLoginDetailsByDayPo info:iHallGameByDayDao.findDetail(beginDate, endDate, group, game)){
                results.add(new MergeLoginDetailByDayDo(info.getDate(),info.getType(),info.getLoginUnitNum(),
                        info.getTimes()));
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return results;
    }
}
