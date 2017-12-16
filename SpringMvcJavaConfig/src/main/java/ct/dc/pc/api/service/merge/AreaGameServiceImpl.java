package ct.dc.pc.api.service.merge;

import ct.dc.pc.api.domain.areagame.AreaGameDomain;
import ct.dc.pc.api.model.domain.merge.MergeLoginByDayDo;
import ct.dc.pc.api.model.domain.merge.MergeLoginDetailByDayDo;
import ct.dc.pc.api.service.merge.interfaces.IAreaGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/4/6.
 */
@Service
public class AreaGameServiceImpl implements IAreaGameService{
    @Autowired
    private AreaGameDomain areaGameDomain;
    /**
     * 全国二合一级界面
     *
     * @param beginDate
     * @param endDate
     * @return
     */
    @Override
    public ArrayList<MergeLoginByDayDo> listNationGameInfo(int beginDate, int endDate) {
        return areaGameDomain.listNationGameLoginByDayInfo(beginDate, endDate);
    }

    /**
     * 全国二合二级界面
     *
     * @param beginDate
     * @param endDate
     * @param game
     * @return
     */
    @Override
    public ArrayList<MergeLoginDetailByDayDo> listNationGameDetailInfo(int beginDate, int endDate, int game) {
        return areaGameDomain.listNationGameLoginDetailByDayInfo(beginDate, endDate, game);
    }

    /**
     * 省份二合 一级界面
     *
     * @param province
     * @param beginDate
     * @param endDate
     * @return
     */
    @Override
    public ArrayList<MergeLoginByDayDo> listProvinceGameInfo(String province, int beginDate, int endDate) {
        return areaGameDomain.listProvinceGameLoginByDayInfo(beginDate, endDate, province);
    }

    /**
     * 省份二合 二级界面
     *
     * @param province
     * @param beginDate
     * @param endDate
     * @param game
     * @return
     */
    @Override
    public ArrayList<MergeLoginDetailByDayDo> listProvinceGameDetailInfo(String province, int beginDate, int endDate, int game) {
        return areaGameDomain.listProvinceGameLoginDetailByDayInfo(beginDate, endDate, province, game);
    }

    /**
     * 地级市二合 一级界面
     *
     * @param city
     * @param beginDate
     * @param endDate
     * @return
     */
    @Override
    public ArrayList<MergeLoginByDayDo> listCityGameInfo(String city, int beginDate, int endDate) {
        return areaGameDomain.listCityGameLoginByDayInfo(beginDate,endDate,city);
    }

    /**
     * 地级市二合 二级界面
     *
     * @param city
     * @param beginDate
     * @param endDate
     * @param game
     * @return
     */
    @Override
    public ArrayList<MergeLoginDetailByDayDo> listCityGameDetailInfo(String city, int beginDate, int endDate, int game) {
        return areaGameDomain.listCityGameLoginDetailByDayInfo(beginDate, endDate, city, game);
    }

    /**
     * 县区二合 一级界面
     *
     * @param district
     * @param beginDate
     * @param endDate
     * @return
     */
    @Override
    public ArrayList<MergeLoginByDayDo> listDistrictGameInfo(String district, int beginDate, int endDate) {
        return areaGameDomain.listDistrictGameLoginByDayInfo(beginDate, endDate, district);
    }

    /**
     * 县区二合 二级界面
     *
     * @param district
     * @param beginDate
     * @param endDate
     * @param game
     * @return
     */
    @Override
    public ArrayList<MergeLoginDetailByDayDo> listDistrictGameDetailInfo(String district, int beginDate, int endDate, int game) {
        return areaGameDomain.listDistrictGameLoginDetailByDayInfo(beginDate, endDate, game, district);
    }
}
