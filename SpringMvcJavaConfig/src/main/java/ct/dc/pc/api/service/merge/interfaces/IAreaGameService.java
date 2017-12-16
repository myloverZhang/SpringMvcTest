package ct.dc.pc.api.service.merge.interfaces;

import ct.dc.pc.api.model.domain.merge.MergeLoginByDayDo;
import ct.dc.pc.api.model.domain.merge.MergeLoginDetailByDayDo;

import java.util.ArrayList;

/**
 * Created by B41-80 on 2017/4/6.
 */
public interface IAreaGameService {
    /**
     * 全国二合一级界面
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<MergeLoginByDayDo> listNationGameInfo(int beginDate,int endDate);

    /**
     * 全国二合二级界面
     * @param beginDate
     * @param endDate
     * @param game
     * @return
     */
    ArrayList<MergeLoginDetailByDayDo> listNationGameDetailInfo(int beginDate,int endDate,int game);

    /**
     * 省份二合 一级界面
     * @param province
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<MergeLoginByDayDo> listProvinceGameInfo(String province,int beginDate,int endDate);

    /**
     * 省份二合 二级界面
     * @param province
     * @param beginDate
     * @param endDate
     * @param game
     * @return
     */
    ArrayList<MergeLoginDetailByDayDo> listProvinceGameDetailInfo(String province,int beginDate,int endDate,int game);


    /**
     * 地级市二合 一级界面
     * @param city
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<MergeLoginByDayDo> listCityGameInfo(String city,int beginDate,int endDate);

    /**
     * 地级市二合 二级界面
     * @param city
     * @param beginDate
     * @param endDate
     * @param game
     * @return
     */
    ArrayList<MergeLoginDetailByDayDo> listCityGameDetailInfo(String city,int beginDate,int endDate,int game);


    /**
     * 县区二合 一级界面
     * @param district
     * @param beginDate
     * @param endDate
     * @return
     */
    ArrayList<MergeLoginByDayDo> listDistrictGameInfo(String district,int beginDate,int endDate);

    /**
     * 县区二合 二级界面
     * @param district
     * @param beginDate
     * @param endDate
     * @param game
     * @return
     */
    ArrayList<MergeLoginDetailByDayDo> listDistrictGameDetailInfo(String district,int beginDate,int endDate,int game);
}
