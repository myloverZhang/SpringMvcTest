package ct.dc.pc.api.domain.areagame;

import ct.dc.pc.api.dao.merge.interfaces.ICityGameByDayDao;
import ct.dc.pc.api.dao.merge.interfaces.IDistrictGameByDayDao;
import ct.dc.pc.api.dao.merge.interfaces.INationGameByDayDao;
import ct.dc.pc.api.dao.merge.interfaces.IProvinceGameByDayDao;
import ct.dc.pc.api.domain.helper.AreaGameCacheUtils;
import ct.dc.pc.api.model.domain.merge.MergeLoginByDayDo;
import ct.dc.pc.api.model.domain.merge.MergeLoginDetailByDayDo;
import ct.dc.pc.api.model.po.merge.MergeLoginByDayPo;
import ct.dc.pc.api.model.po.merge.MergeLoginDetailsByDayPo;
import ct.dc.pc.api.util.ResourceClass;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by B41-80 on 2017/4/6.
 */
@Component
public class AreaGameDomain {
    @Autowired
    private ICityGameByDayDao iCityGameByDayDao;
    @Autowired
    private IProvinceGameByDayDao iProvinceGameByDayDao;
    @Autowired
    private IDistrictGameByDayDao iDistrictGameByDayDao;
    @Autowired
    private INationGameByDayDao iNationGameByDayDao;
    private Logger logger = Logger.getLogger(AreaGameDomain.class);



    /**
     * 全国游戏二合  一级界面
     * @param beginDate
     * @param endDate
     * @return
     */
    public ArrayList<MergeLoginByDayDo> listNationGameLoginByDayInfo(int beginDate,int endDate){
        ArrayList<MergeLoginByDayDo> results = new ArrayList<>();
        ArrayList<MergeLoginByDayDo> tmp = AreaGameCacheUtils.getParamCache(beginDate,endDate,
                ResourceClass.NATION_AREA_CODE);
        if (tmp!=null){
            return tmp;
        }
        try {
            for (MergeLoginByDayPo info:iNationGameByDayDao.find(beginDate, endDate)){
                results.add(new MergeLoginByDayDo(info.getId(),info.getType(),info.getLoginUnitNum(),info.getTimes()));
            }
        }catch (ExecutionException e){
            logger.error(e.getMessage());
        }catch (InterruptedException e){
            logger.error(e.getMessage());
        }
        if (results.size()>0)
            AreaGameCacheUtils.setParamCache(beginDate,endDate,results.toString(),ResourceClass.NATION_AREA_CODE);
        return results;
    }

    /**
     * 全国统计游戏分布二级界面查询
     * @param beginDate
     * @param endDate
     * @param game
     * @return
     */
    public ArrayList<MergeLoginDetailByDayDo> listNationGameLoginDetailByDayInfo(int beginDate,int endDate,int game){
        ArrayList<MergeLoginDetailByDayDo> results = new ArrayList<>();
        try {
            for (MergeLoginDetailsByDayPo info:iNationGameByDayDao.findDetails(beginDate,endDate,game)){
                results.add(new MergeLoginDetailByDayDo(info.getDate(),info.getType(),info.getLoginUnitNum(),
                        info.getTimes()));
            }
        }catch (ExecutionException e){
            logger.error(e.getMessage());
        }catch (InterruptedException e){
            logger.error(e.getMessage());
        }
        return results;
    }

    /**
     * 省份二合数据 一级界面
     * @param beginDate
     * @param endDate
     * @param province
     * @return
     */
    public ArrayList<MergeLoginByDayDo> listProvinceGameLoginByDayInfo(int beginDate,int endDate,String province){
        ArrayList<MergeLoginByDayDo> results = new ArrayList<>();
        ArrayList<MergeLoginByDayDo> tmp = AreaGameCacheUtils.getParamCache(beginDate,endDate,province);
        if (tmp!=null){
            return tmp;
        }
        try {
            for (MergeLoginByDayPo info:iProvinceGameByDayDao.find(province, beginDate, endDate)){
                results.add(new MergeLoginByDayDo(info.getId(),info.getType(),info.getLoginUnitNum(),info.getTimes()));
            }
        }catch (ExecutionException e){
            logger.error(e.getMessage());
        }catch (InterruptedException e){
            logger.error(e.getMessage());
        }
        if (results.size()>0)
            AreaGameCacheUtils.setParamCache(beginDate,endDate,results.toString(),province);
        return results;
    }

    /**
     * 省份二合数据 二级界面
     * @param beginDate
     * @param endDate
     * @param province
     * @param game
     * @return
     */
    public ArrayList<MergeLoginDetailByDayDo> listProvinceGameLoginDetailByDayInfo(int beginDate,int endDate,
                                                                                   String province,int game){
        ArrayList<MergeLoginDetailByDayDo> results = new ArrayList<>();
        try {
            for (MergeLoginDetailsByDayPo info:iProvinceGameByDayDao.findDetails(province, beginDate, endDate, game)){
                results.add(new MergeLoginDetailByDayDo(info.getDate(),info.getType(),info.getLoginUnitNum(),
                        info.getTimes()));
            }
        } catch (ExecutionException e) {
            logger.error(e.getMessage());
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
        }
        return results;
    }

    /**
     * 地级市二合数据 一级界面
     * @param beginDate
     * @param endDate
     * @param city
     * @return
     */
    public ArrayList<MergeLoginByDayDo> listCityGameLoginByDayInfo(int beginDate,int endDate,String city){
        ArrayList<MergeLoginByDayDo> results = new ArrayList<>();
        try {
            for (MergeLoginByDayPo info:iCityGameByDayDao.find(city, beginDate, endDate)){
                results.add(new MergeLoginByDayDo(info.getId(),info.getType(),info.getLoginUnitNum(),info.getTimes()));
            }
        } catch (ExecutionException e) {
            logger.error(e.getMessage());
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
        }
        return results;
    }

    /**
     * 地级市二合数据
     * @param beginDate
     * @param endDate
     * @param city
     * @param game
     * @return
     */
    public ArrayList<MergeLoginDetailByDayDo> listCityGameLoginDetailByDayInfo(int beginDate,int endDate,String city,
                                                                               int game){
        ArrayList<MergeLoginDetailByDayDo> results = new ArrayList<>();
        try {
            for (MergeLoginDetailsByDayPo info:iCityGameByDayDao.findDetails(city, beginDate, endDate, game)){
                results.add(new MergeLoginDetailByDayDo(info.getDate(),info.getType(),info.getLoginUnitNum(),
                        info.getTimes()));
            }
        } catch (ExecutionException e) {
            logger.error(e.getMessage());
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
        }
        return results;
    }

    /**
     * 县区二合数据
     * @param beginDate
     * @param endDate
     * @param district
     * @return
     */
    public ArrayList<MergeLoginByDayDo> listDistrictGameLoginByDayInfo(int beginDate,int endDate,String district){
        ArrayList<MergeLoginByDayDo> results = new ArrayList<>();
        try {
            for (MergeLoginByDayPo info:iDistrictGameByDayDao.find(district, beginDate, endDate)){
                results.add(new MergeLoginByDayDo(info.getId(),info.getType(),info.getLoginUnitNum(),info.getTimes()));
            }
        } catch (ExecutionException e) {
            logger.error(e.getMessage());
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
        }
        return results;
    }

    /**
     * 县区二合数据
     * @param beginDate
     * @param endDate
     * @param game
     * @param district
     * @return
     */
    public ArrayList<MergeLoginDetailByDayDo> listDistrictGameLoginDetailByDayInfo(int beginDate,int endDate,
                                                                                   int game,String district){
        ArrayList<MergeLoginDetailByDayDo> results =  new ArrayList<>();
        try {
            for (MergeLoginDetailsByDayPo info:iDistrictGameByDayDao.findDetails(district, beginDate, endDate, game)){
                results.add(new MergeLoginDetailByDayDo(info.getDate(),info.getType(),info.getLoginUnitNum(),
                        info.getTimes()));
            }
        } catch (ExecutionException e) {
            logger.error(e.getMessage());
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
        }
        return results;
    }
}
