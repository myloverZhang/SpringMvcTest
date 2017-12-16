package ct.dc.pc.api.service.area;

import ct.dc.pc.api.domain.retain.AreaRetainDomain;
import ct.dc.pc.api.model.domain.area.AreaRetainByDayDo;
import ct.dc.pc.api.service.area.interfaces.IAreaRetainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by CTWLPC on 2017/6/14.
 */
@Service
public class AreaRetainServiceImpl implements IAreaRetainService{
    @Autowired
    private AreaRetainDomain areaRetainDomain;

    /**
     * 获取全国留存信息
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    @Override
    public ArrayList<AreaRetainByDayDo> listNationRetainByDayIfs(int beginDate, int endDate) {
        return areaRetainDomain.listNationRetainByDayIfs(beginDate, endDate);
    }

    /**
     * 获取省级多日留存数据
     *
     * @param province
     * @param beginDate
     * @param endDate
     * @return
     */
    @Override
    public ArrayList<AreaRetainByDayDo> listProvinceRetainByDayIfs(String province, int beginDate, int endDate) {
        return areaRetainDomain.listProvinceRetainByDayIfs(province, beginDate, endDate);
    }

    /**
     * 获取全国地级市多日留存数据
     *
     * @param city
     * @param beginDate
     * @param endDate
     * @return
     */
    @Override
    public ArrayList<AreaRetainByDayDo> listCityRetainByDayIfs(String city, int beginDate, int endDate) {
        return areaRetainDomain.listCityRetainByDayIfs(city, beginDate, endDate);
    }

    /**
     * 获取先去多日留存数据
     *
     * @param district
     * @param beginDate
     * @param endDate
     * @return
     */
    @Override
    public ArrayList<AreaRetainByDayDo> listDistrictRetainByDayIfs(String district, int beginDate, int endDate) {
        return areaRetainDomain.listDistrictRetainByDayIfs(district, beginDate, endDate);
    }
}
