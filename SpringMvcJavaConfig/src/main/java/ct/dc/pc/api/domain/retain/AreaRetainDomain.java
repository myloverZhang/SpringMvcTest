package ct.dc.pc.api.domain.retain;

import ct.dc.pc.api.dao.area.interfaces.ICity2RetainByDayDao;
import ct.dc.pc.api.dao.area.interfaces.IDistrictRetainByDayDao;
import ct.dc.pc.api.dao.area.interfaces.INationRetainByDayDao;
import ct.dc.pc.api.dao.area.interfaces.IProvinceRetainByDayDao;
import ct.dc.pc.api.domain.helper.AreaRetainInfoHelper;
import ct.dc.pc.api.model.domain.area.AreaRetainByDayDo;
import ct.dc.pc.api.model.po.area.AreaRetainByDayPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Created by CTWLPC on 2017/6/14.
 */
@Component
public class AreaRetainDomain {
    @Autowired
    private INationRetainByDayDao iNationRetainByDayDao;
    @Autowired
    private IProvinceRetainByDayDao iProvinceRetainByDayDao;
    @Autowired
    private ICity2RetainByDayDao iCity2RetainByDayDao;
    @Autowired
    private IDistrictRetainByDayDao iDistrictRetainByDayDao;

    /**
     * 获取地级市多日留存
     */
    public ArrayList<AreaRetainByDayDo> listCityRetainByDayIfs(String city,int beginDate,int endDate){
        ArrayList<AreaRetainByDayDo> results = new ArrayList<>();
        for (AreaRetainByDayPo info:iCity2RetainByDayDao.findByCity(city, beginDate, endDate)){
            results.addAll(AreaRetainInfoHelper.listTheRetainDoByPo(info));
        }
        return results;
    }

    /**
     * 获取县区多日留存
     * @param district
     * @param beginDate
     * @param endDate
     * @return
     */
    public ArrayList<AreaRetainByDayDo> listDistrictRetainByDayIfs(String district, int beginDate,int endDate){
        ArrayList<AreaRetainByDayDo> results = new ArrayList<>();
        for (AreaRetainByDayPo info:iDistrictRetainByDayDao.findByDistrict(district, beginDate, endDate)){
            results.addAll(AreaRetainInfoHelper.listTheRetainDoByPo(info));
        }
        return results;
    }

    /**
     * 获取省份多日留存数据
     * @param province
     * @param beginDate
     * @param endDate
     * @return
     */
    public ArrayList<AreaRetainByDayDo> listProvinceRetainByDayIfs(String province,int beginDate,int endDate){
        ArrayList<AreaRetainByDayDo> results = new ArrayList<>();
        for (AreaRetainByDayPo info:iProvinceRetainByDayDao.findByProvince(province, beginDate, endDate)){
            results.addAll(AreaRetainInfoHelper.listTheRetainDoByPo(info));
        }
        return results;
    }

    /**
     * 根据日期获取全国多日留存信息
     * @param beginDate
     * @param endDate
     * @return
     */
    public ArrayList<AreaRetainByDayDo> listNationRetainByDayIfs(int beginDate,int endDate){
        ArrayList<AreaRetainByDayDo> results = new ArrayList<>();
        for (AreaRetainByDayPo info:iNationRetainByDayDao.find(beginDate , endDate)){
            results.addAll(AreaRetainInfoHelper.listTheRetainDoByPo(info));
        }
        return results;
    }

}
