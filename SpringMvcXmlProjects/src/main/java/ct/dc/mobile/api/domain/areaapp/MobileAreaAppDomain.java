package ct.dc.mobile.api.domain.areaapp;

import ct.dc.mobile.api.dao.mobilearea.Interface.ICityAppLoginByDayDao;
import ct.dc.mobile.api.dao.mobilearea.Interface.IDistrictAppLoginByDayDao;
import ct.dc.mobile.api.dao.mobilearea.Interface.INationAppLoginByDayDao;
import ct.dc.mobile.api.dao.mobilearea.Interface.IProvinceAppLoginByDayDao;
import ct.dc.mobile.api.domain.helper.AreaAppCacheUtils;
import ct.dc.mobile.api.model.domain.areaApp.AreaAppLoginByDayDo;
import ct.dc.mobile.api.model.domain.areaApp.AreaAppLoginDetailsByDayDo;
import ct.dc.mobile.api.model.po.mobilearea.AreaAppLoginByDayPo;
import ct.dc.mobile.api.model.po.mobilearea.AreaAppLoginDetailsByDayPo;
import ct.dc.mobile.api.utils.ResourceUtils;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * Created by B41-80 on 2017/1/12.
 */
public class MobileAreaAppDomain {
    private IProvinceAppLoginByDayDao iProvinceAppLoginByDayDao;
    private ICityAppLoginByDayDao iCityAppLoginByDayDao;
    private IDistrictAppLoginByDayDao iDistrictAppLoginByDayDao;
    private INationAppLoginByDayDao iNationAppLoginByDayDao;
    private Logger logger = Logger.getLogger(MobileAreaAppDomain.class);

    public void setiProvinceAppLoginByDayDao(IProvinceAppLoginByDayDao iProvinceAppLoginByDayDao) {
        this.iProvinceAppLoginByDayDao = iProvinceAppLoginByDayDao;
    }

    public void setiCityAppLoginByDayDao(ICityAppLoginByDayDao iCityAppLoginByDayDao) {
        this.iCityAppLoginByDayDao = iCityAppLoginByDayDao;
    }

    public void setiDistrictAppLoginByDayDao(IDistrictAppLoginByDayDao iDistrictAppLoginByDayDao) {
        this.iDistrictAppLoginByDayDao = iDistrictAppLoginByDayDao;
    }

    public void setiNationAppLoginByDayDao(INationAppLoginByDayDao iNationAppLoginByDayDao) {
        this.iNationAppLoginByDayDao = iNationAppLoginByDayDao;
    }

    /**
     * 通过po转换do
     * @return
     */
    private AreaAppLoginByDayDo getDomainByPo(AreaAppLoginByDayPo info){
        return new AreaAppLoginByDayDo(info.getId(),info.getLoginUnitNum(),info.getTimes(),info.getType());
    }

    /**
     * 通过po转换do
     * @return
     */
    private AreaAppLoginDetailsByDayDo getDetailDomainByPo(AreaAppLoginDetailsByDayPo info){
        return new AreaAppLoginDetailsByDayDo(info.getDate(),info.getLoginUnitNum(),info.getTimes(),info.getType());
    }
    /**
     * 二合全国一级界面数据
     * @param begin
     * @param end
     * @return
     */
    public ArrayList<AreaAppLoginByDayDo> nationAreaAppLoginByDay(int begin,int end){
        ArrayList<AreaAppLoginByDayDo> results = new ArrayList<AreaAppLoginByDayDo>();
        ArrayList<AreaAppLoginByDayDo> tmp = AreaAppCacheUtils.getParamCache(begin,end, ResourceUtils.NATION_AREA_CODE);
        if (tmp != null){
            return tmp;
        }
        try {
            for (AreaAppLoginByDayPo info:iNationAppLoginByDayDao.findFull(begin,end)){
                results.add(getDomainByPo(info));
            }
        } catch (ExecutionException e) {
            logger.error(e.getMessage());
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
        }
        AreaAppCacheUtils.setParamCache(begin,end,results.toString(),ResourceUtils.NATION_AREA_CODE);
        return results;
    }

    /**
     * 二合全国二级界面数据
     * @param begin
     * @param end
     * @param app
     * @return
     */
    public ArrayList<AreaAppLoginDetailsByDayDo> nationAreaAppLoginDetailsByDay(int begin,int end,long app){
        ArrayList<AreaAppLoginDetailsByDayDo> results = new ArrayList<AreaAppLoginDetailsByDayDo>();
        ArrayList<AreaAppLoginDetailsByDayDo> tmp = AreaAppCacheUtils.getParamCache(begin,end,app,
                ResourceUtils.NATION_AREA_CODE);
        if (tmp != null){
            return tmp;
        }
        try {
            for (AreaAppLoginDetailsByDayPo info:iNationAppLoginByDayDao.findDetails(begin,end,app)){
                results.add(getDetailDomainByPo(info));
            }
        } catch (ExecutionException e) {
            logger.error(e.getMessage());
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
        }
        AreaAppCacheUtils.setParamCache(begin,end,app,results.toString(),ResourceUtils.NATION_AREA_CODE);
        return results;
    }

    /**
     * 省级二合分析一级界面
     * @param province
     * @param begin
     * @param end
     * @return
     */
    public ArrayList<AreaAppLoginByDayDo> provinceAreaAppLoginByDay(String province,int begin,int end){
        ArrayList<AreaAppLoginByDayDo> results = new ArrayList<AreaAppLoginByDayDo>();
        ArrayList<AreaAppLoginByDayDo> tmp = AreaAppCacheUtils.getParamCache(begin,end,province);
        if (tmp!=null){
            return tmp;
        }
        try {
            for (AreaAppLoginByDayPo info:iProvinceAppLoginByDayDao.findFull(begin,end,province)){
                results.add(getDomainByPo(info));
            }
        } catch (ExecutionException e) {
            logger.error(e.getMessage());
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
        }
        AreaAppCacheUtils.setParamCache(begin,end,results.toString(),province);
        return results;
    }

    /**
     * 省级二合分析二级界面
     * @return
     */
    public ArrayList<AreaAppLoginDetailsByDayDo> provinceAreaAppLoginDetailsByDay(String province,int begin,int end,
                                                                                  long app){
        ArrayList<AreaAppLoginDetailsByDayDo> results = new ArrayList<AreaAppLoginDetailsByDayDo>();
        try {
            for (AreaAppLoginDetailsByDayPo info:iProvinceAppLoginByDayDao.findDetails(begin,end,app,province)){
                results.add(getDetailDomainByPo(info));
            }
        } catch (ExecutionException e) {
            logger.error(e.getMessage());
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
        }
        return results;
    }

    /**
     * 市级二合分析一级界面
     * @param city
     * @param begin
     * @param end
     * @return
     */
    public ArrayList<AreaAppLoginByDayDo> cityAreaAppLoginByDay(String city,int begin,int end){
        ArrayList<AreaAppLoginByDayDo> results = new ArrayList<AreaAppLoginByDayDo>();
        try {
            for (AreaAppLoginByDayPo info:iCityAppLoginByDayDao.findFull(begin,end,city)){
                results.add(getDomainByPo(info));
            }
        } catch (ExecutionException e) {
            logger.error(e.getMessage());
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
        }
        return results;
    }

    /**
     * 市级二合分析二级界面
     * @return
     */
    public ArrayList<AreaAppLoginDetailsByDayDo> cityAreaAppLoginDetailsByDay(String city,int begin,int end,long app){
        ArrayList<AreaAppLoginDetailsByDayDo> results = new ArrayList<AreaAppLoginDetailsByDayDo>();
        try {
            for (AreaAppLoginDetailsByDayPo info:iCityAppLoginByDayDao.findDetails(begin,end,app,city)){
                results.add(getDetailDomainByPo(info));
            }
        } catch (ExecutionException e) {
            logger.error(e.getMessage());
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
        }
        return results;
    }
    /**
     * 县区二合分析一级界面
     * @param district
     * @param begin
     * @param end
     * @return
     */
    public ArrayList<AreaAppLoginByDayDo> districtAreaAppLoginByDay(String district,int begin,int end){
        ArrayList<AreaAppLoginByDayDo> results = new ArrayList<AreaAppLoginByDayDo>();
        try {
            for (AreaAppLoginByDayPo info:iDistrictAppLoginByDayDao.findFull(begin,end,district)){
                results.add(getDomainByPo(info));
            }
        } catch (ExecutionException e) {
            logger.error(e.getMessage());
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
        }
        return results;
    }

    /**
     * 县区二合分析二级界面
     * @return
     */
    public ArrayList<AreaAppLoginDetailsByDayDo> districtAreaAppLoginDetailsByDay(String district,int begin,int end,
                                                                                  long app){
        ArrayList<AreaAppLoginDetailsByDayDo> results = new ArrayList<AreaAppLoginDetailsByDayDo>();
        try {
            for (AreaAppLoginDetailsByDayPo info:iDistrictAppLoginByDayDao.findDetails(begin,end,app,district)){
                results.add(getDetailDomainByPo(info));
            }
        } catch (ExecutionException e) {
            logger.error(e.getMessage());
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
        }
        return results;
    }
}
