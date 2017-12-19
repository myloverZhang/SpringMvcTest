package ct.dc.mobile.api.domain.apparea;

import ct.dc.mobile.api.dao.mobilearea.Interface.ICityAppLoginByDayDao;
import ct.dc.mobile.api.domain.IAppAreaDomain;
import ct.dc.mobile.api.model.domain.areaApp.AppAreaLoginByDayDo;
import ct.dc.mobile.api.model.domain.areaApp.AppAreaLoginDetailsByDayDo;
import ct.dc.mobile.api.model.po.mobileapp.AppAreaLoginByDayPo;
import ct.dc.mobile.api.model.po.mobileapp.AppAreaLoginDetailByDayPo;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * Created by B41-80 on 2017/1/10.
 */
public class MobileAppAreaDomain implements IAppAreaDomain{
    private ICityAppLoginByDayDao iCityAppLoginByDayDao;
    private Logger logger = Logger.getLogger(MobileAppAreaDomain.class);

    public void setiCityAppLoginByDayDao(ICityAppLoginByDayDao iCityAppLoginByDayDao) {
        this.iCityAppLoginByDayDao = iCityAppLoginByDayDao;
    }

    public MobileAppAreaDomain(ICityAppLoginByDayDao iCityAppLoginByDayDao) {
        this.iCityAppLoginByDayDao = iCityAppLoginByDayDao;
    }

    public MobileAppAreaDomain() {

    }

    @Override
    public ArrayList<AppAreaLoginByDayDo> appAreaByDay(long app, int begin, int end) {
        try {
            ArrayList<AppAreaLoginByDayDo> results = new ArrayList<AppAreaLoginByDayDo>();
             for (AppAreaLoginByDayPo info:iCityAppLoginByDayDao.findFull(app,begin,end)){
                 AppAreaLoginByDayDo result = new AppAreaLoginByDayDo();
                 result.setId(info.getId());
                 result.setTimes(info.getTimes());
                 result.setLoginUnitNum(info.getLoginUnitNum());
                 result.setType(info.getType());
                 results.add(result);
            }
            return results;
        } catch (ExecutionException e) {
            logger.error(e.getMessage());
            return null;
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
            return null;
        }
    }

    @Override
    public ArrayList<AppAreaLoginDetailsByDayDo> appAreaDetailsByDay(long app, int begin, int end, String city) {
        try {
            ArrayList<AppAreaLoginDetailsByDayDo> results = new ArrayList<AppAreaLoginDetailsByDayDo>();
            for (AppAreaLoginDetailByDayPo info:iCityAppLoginByDayDao.findDetail(app,city,begin,end)){
                AppAreaLoginDetailsByDayDo result = new AppAreaLoginDetailsByDayDo();
                result.setDate(info.getDate());
                result.setTimes(info.getTimes());
                result.setType(info.getType());
                result.setLoginUnitNum(info.getLoginUnitNum());
                results.add(result);
            }
            return results;
        } catch (ExecutionException e) {
            logger.error(e.getMessage());
            return null;
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
            return null;
        }
    }
}
