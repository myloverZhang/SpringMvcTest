package ct.dc.mobile.api.controller;

import ct.dc.mobile.api.model.dto.input.*;
import ct.dc.mobile.api.model.dto.output.ResultDto;
import ct.dc.mobile.api.service.IMobileAreaAppLoginService;
import ct.dc.mobile.api.service.IMobileAreaLoginService;
import ct.dc.mobile.api.service.IMobileAreaRegService;
import ct.dc.mobile.api.utils.date.DateUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * 移动地区接口控制器
 * Created by B41-80 on 2017/1/10.
 */
@Controller
@RequestMapping(value = "MobileArea")
@ResponseBody
public class MobileAreaController {
    private final String NATION_AREA_CODE = "";//全国地区的地区code
    private IMobileAreaLoginService iMobileAreaLoginService;
    private IMobileAreaRegService iMobileAreaRegService;
    private IMobileAreaAppLoginService iMobileAreaAppLoginService;
    public void setiMobileAreaLoginService(IMobileAreaLoginService iMobileAreaLoginService) {
        this.iMobileAreaLoginService = iMobileAreaLoginService;
    }

    public void setiMobileAreaRegService(IMobileAreaRegService iMobileAreaRegService) {
        this.iMobileAreaRegService = iMobileAreaRegService;
    }

    public void setiMobileAreaAppLoginService(IMobileAreaAppLoginService iMobileAreaAppLoginService) {
        this.iMobileAreaAppLoginService = iMobileAreaAppLoginService;
    }

    /**
     * 全国单日登录
     * @param params
     * @return
     */
    @RequestMapping(value = "/NationLoginUsersPerDay",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "全国单日登录")
    public ResultDto nationLoginUsersPerDay(@RequestBody DayDto params){
        return new ResultDto(true,iMobileAreaLoginService.loginUsersByPerDay(NATION_AREA_CODE,params.getDate()),"");
    }

    /**
     * 全国多日登录
     * @param params
     * @return
     */
    @RequestMapping(value = "/NationLoginUserByDay",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "全国多日登录")
    public ResultDto natonLoginUsersByDay(@RequestBody DaysDto params){
        return new ResultDto(true,iMobileAreaLoginService.loginUsersByDay(NATION_AREA_CODE,params.getBeginDate(),params.getEndDate()),"");
    }

    /**
     * 省份多日登录
     * @param params
     * @return
     */
    @RequestMapping(value = "/ProvinceLoginUsersByDay",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "省份多日登录")
    public ResultDto provinceLoginUsersByDay(@RequestBody AreaDaysDto params){
        if (params.getAreaId().length()!=2){
            return new ResultDto(false,null,"省份信息错误");
        }
        return new ResultDto(true,iMobileAreaLoginService.loginUsersByDay(params.getAreaId(),params.getBeginDate(),params.getEndDate()),"");
    }

    /**
     * 省份单日登录
     * @param params
     * @return
     */
    @RequestMapping(value = "/ProvinceLoginUserPerDay",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "省份单日登录")
    public ResultDto provinceLoginUsersPerDay(@RequestBody AreaDayDto params){
        if (params.getAreaId().length()!=2){
            return new ResultDto(false,null,"省份信息错误");
        }
        return new ResultDto(true,iMobileAreaLoginService.loginUsersByPerDay(params.getAreaId(),params.getDate()),"");
    }

    /**
     * 地级市多日登录
     * @param params
     * @return
     */
    @RequestMapping(value = "/CityLoginUsersByDay",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "地级市多日登录")
    public ResultDto cityLoginUsersByDay(@RequestBody AreaDaysDto params){
        if (params.getAreaId().length()!=4){
            return new ResultDto(false,null,"地级市信息错误");
        }
        return new ResultDto(true,iMobileAreaLoginService.loginUsersByDay(params.getAreaId(),params.getBeginDate(),params.getEndDate()),"");
    }

    /**
     * 地级市单日登录
     * @param params
     * @return
     */
    @RequestMapping(value = "/CityLoginUsersPerDay",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "地级市单日登录")
    public ResultDto cityLoginUsersPerDay(@RequestBody AreaDayDto params){
        if (params.getAreaId().length()!=4){
            return new ResultDto(false,null,"地级市信息错误");
        }
        return new ResultDto(true,iMobileAreaLoginService.loginUsersByPerDay(params.getAreaId(),params.getDate()),"");
    }
    @RequestMapping(value = "/DistrictLoginUsersByDay",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "县区多日登录")
    public ResultDto districtLoginUsersByDay(@RequestBody AreaDaysDto params){
        if (params.getAreaId().length()!=6){
            return new ResultDto(false,null,"县区信息错误");
        }
        return new ResultDto(true,iMobileAreaLoginService.loginUsersByDay(params.getAreaId(),params.getBeginDate(),params.getEndDate()),"");
    }
    @RequestMapping(value = "/DistrictLoginUsersPerDay",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "县区单日登录")
    public ResultDto districtLoginUsersPerDay(@RequestBody AreaDayDto params){
        if (params.getAreaId().length()!=6){
            return new ResultDto(false,null,"县区信息错误");
        }
        return new ResultDto(true,iMobileAreaLoginService.loginUsersByPerDay(params.getAreaId(),params.getDate()),"");
    }

    /**
     * 全国多月注册信息
     * @return
     */
    @RequestMapping(value = "/NationRegUsersByMonth",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "全国多月注册")
    public ResultDto nationRegUsersByMonth(@RequestBody MonthsDto params){
        if (!DateUtils.isDate(params.getBeginMonth()*100+1)||!DateUtils.isDate(params.getEndMonth()*100+1)){
            return new ResultDto(false,null,"月份信息错误");
        }
        return new ResultDto(true,iMobileAreaRegService.regInfoByMonth(params.getBeginMonth(),params.getEndMonth(),NATION_AREA_CODE),"");
    }

    /**
     * 全国多日注册信息
     * @param params
     * @return
     */
    @RequestMapping(value = "/NationRegUsersByDay",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "全国多日注册")
    public ResultDto nationRegUsersByDay(@RequestBody DaysDto params){
        return new ResultDto(true,iMobileAreaRegService.regInfoByDay(params.getBeginDate(),params.getEndDate(),NATION_AREA_CODE),"");
    }

    /**
     * 省份多日注册信息
     * @param params
     * @return
     */
    @RequestMapping(value = "/ProvinceRegUsersByDay",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "省份多日注册")
    public ResultDto provinceRegUsersByDay(@RequestBody AreaDaysDto params){
        if (params.getAreaId().length()!=2){
            return new ResultDto(false,null,"省份信息错误");
        }
        return new ResultDto(true,iMobileAreaRegService.regInfoByDay(params.getBeginDate(),params.getEndDate(),params.getAreaId()),"");
    }

    /**
     * 省份多月注册信息
     * @param params
     * @return
     */
    @RequestMapping(value = "/ProvinceRegUsersByMonth",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "省份多月注册信息")
    public ResultDto provinceRegUsersByMonth(@RequestBody AreaMonthsDto params){
        if (params.getAreaId().length()!=2){
            return new ResultDto(false,null,"省份信息错误");
        }
        return new ResultDto(true,iMobileAreaRegService.regInfoByMonth(params.getBeginMonth(),params.getEndMonth(),params.getAreaId()),"");
    }

    /**
     * 地级市多日注册信息
     * @param params
     * @return
     */
    @RequestMapping(value = "/CityRegUsersByDay",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "地级市多日注册信息")
    public ResultDto cityRegUsersByDay(@RequestBody AreaDaysDto params){
        if (params.getAreaId().length()!=4){
            return new ResultDto(false,null,"地级市信息错误");
        }
        return new ResultDto(true,iMobileAreaRegService.regInfoByDay(params.getBeginDate(),params.getEndDate(),params.getAreaId()),"");

    }

    /**
     * 地级市多月注册信息
     * @param params
     * @return
     */
    @RequestMapping(value = "/CityRegUsersByMonth",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "地级市多月注册信息")
    public ResultDto cityRegUsersByMonth(@RequestBody AreaMonthsDto params){
        if (params.getAreaId().length()!=4){
            return new ResultDto(false,null,"地级市信息错误");
        }
        return new ResultDto(true,iMobileAreaRegService.regInfoByMonth(params.getBeginMonth(),params.getEndMonth(),params.getAreaId()),"");
    }

    /**
     * 县区多日注册信息
     * @param params
     * @return
     */
    @RequestMapping(value = "/DistrictRegUsersByDay",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "县区多日注册信息")
    public ResultDto districtRegUsersByDay(@RequestBody AreaDaysDto params){
        if (params.getAreaId().length()!=6){
            return new ResultDto(false,null,"县区信息错误");
        }
        return new ResultDto(true,iMobileAreaRegService.regInfoByDay(params.getBeginDate(),params.getEndDate(),params.getAreaId()),"");
    }

    /**
     * 县区多月注册
     * @param params
     * @return
     */
    @RequestMapping(value = "/DistrictRegUsersByMonth",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "县区多月注册信息")
    public ResultDto districtRegUsersByMonth(@RequestBody AreaMonthsDto params){
        if (params.getAreaId().length()!=6){
            return new ResultDto(false,null,"县区信息错误");
        }
        return new ResultDto(true,iMobileAreaRegService.regInfoByMonth(params.getBeginMonth(),params.getEndMonth(),params.getAreaId()),"");
    }

    /**
     * 二合一级界面
     * @param params
     * @return
     */
    @RequestMapping(value = "/NationAreaGameLoginByDays",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "全国地区游戏二合分析之一级界面")
    public ResultDto nationAreaGameLoginByDay(@RequestBody DaysDto params){
        if (!DateUtils.isDate(params.getBeginDate())||!DateUtils.isDate(params.getEndDate())){
            return new ResultDto(false,null,"日期格式错误");
        }
        if (DateUtils.addDay(DateUtils.DateToInt(new Date()),-30)>params.getBeginDate()){
            return new ResultDto(false,null,"日期范围错误");
        }
        if (params.getBeginDate()>params.getEndDate()){
            return new ResultDto(false,null,"开始时间不能大于结束时间");
        }
        int yesToday = DateUtils.addDay(DateUtils.DateToInt(new Date()),-1);
        if (params.getEndDate()>yesToday){
            params.setEndDate(yesToday);
        }
        return new ResultDto(true,iMobileAreaAppLoginService.areaAppLoginByDay(NATION_AREA_CODE,params.getBeginDate(),params.getEndDate()),"");
    }

    /**
     * 二合二级界面
     * @param params
     * @return
     */
    @RequestMapping(value = "/NationAreaGameLoginDetailsByDays",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "全国地区游戏二合分析之二级界面")
    public ResultDto nationAreaGameLoginDetailsByDay(@RequestBody AppDaysDto params){
        if (!DateUtils.isDate(params.getBeginDate())||!DateUtils.isDate(params.getEndDate())){
            return new ResultDto(false,null,"日期格式错误");
        }
        if (DateUtils.addDay(DateUtils.DateToInt(new Date()),-30)>params.getBeginDate()){
            return new ResultDto(false,null,"日期范围错误");
        }
        if (params.getBeginDate()>params.getEndDate()){
            return new ResultDto(false,null,"开始时间不能大于结束时间");
        }
        int yesToday = DateUtils.addDay(DateUtils.DateToInt(new Date()),-1);
        if (params.getEndDate()>yesToday){
            params.setEndDate(yesToday);
        }
        if (params.getAppId()<0){
            return new ResultDto(false,null,"app信息错误");
        }
        return new ResultDto(true,iMobileAreaAppLoginService.areaAppLoginDetailsByDay(NATION_AREA_CODE,params.getBeginDate(),params.getEndDate(),params.getAppId()),"");
    }

    /**
     * 二合一级界面 省份
     * @param params
     * @return
     */
    @RequestMapping(value = "/ProvinceAreaGameLoginByDays",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "省级地区游戏二合分析之一级界面")
    public ResultDto provinceAreaGameLoginByDay(@RequestBody AreaDaysDto params){
        if (!DateUtils.isDate(params.getBeginDate())||!DateUtils.isDate(params.getEndDate())){
            return new ResultDto(false,null,"日期格式错误");
        }
        if (DateUtils.addDay(DateUtils.DateToInt(new Date()),-30)>params.getBeginDate()){
            return new ResultDto(false,null,"日期范围错误");
        }
        if (params.getBeginDate()>params.getEndDate()){
            return new ResultDto(false,null,"开始时间不能大于结束时间");
        }
        if (params.getAreaId().length() != 2){
            return new ResultDto(false,null,"地区信息错误");
        }
        int yesToday = DateUtils.addDay(DateUtils.DateToInt(new Date()),-1);
        if (params.getEndDate()>yesToday){
            params.setEndDate(yesToday);
        }
        return new ResultDto(true,iMobileAreaAppLoginService.areaAppLoginByDay(params.getAreaId(),params.getBeginDate(),params.getEndDate()),"");
    }

    /**
     * 二合二级界面 省份
     * @param params
     * @return
     */
    @RequestMapping(value = "/ProvinceAreaGameLoginDetailsByDays",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "省级地区游戏二合分析之二级界面")
    public ResultDto provinceAreaGameLoginDetailsByDay(@RequestBody AppAreaDetailDto params){
        if (!DateUtils.isDate(params.getBeginDate())||!DateUtils.isDate(params.getEndDate())){
            return new ResultDto(false,null,"日期格式错误");
        }
        if (DateUtils.addDay(DateUtils.DateToInt(new Date()),-30)>params.getBeginDate()){
            return new ResultDto(false,null,"日期范围错误");
        }
        if (params.getBeginDate()>params.getEndDate()){
            return new ResultDto(false,null,"开始时间不能大于结束时间");
        }
        if (params.getAreaId().length() != 2){
            return new ResultDto(false,null,"地区信息错误");
        }
        int yesToday = DateUtils.addDay(DateUtils.DateToInt(new Date()),-1);
        if (params.getEndDate()>yesToday){
            params.setEndDate(yesToday);
        }
        if (params.getAppId()<0){
            return new ResultDto(false,null,"app信息错误");
        }
        return new ResultDto(true,iMobileAreaAppLoginService.areaAppLoginDetailsByDay(params.getAreaId(),params.getBeginDate(),params.getEndDate(),params.getAppId()),"");
    }

    /**
     * 二合一级界面 地级市
     * @param params
     * @return
     */
    @RequestMapping(value = "/CityAreaGameLoginByDays",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "市级地区游戏二合分析之一级界面")
    public ResultDto cityAreaGameLoginByDay(@RequestBody AreaDaysDto params){
        if (!DateUtils.isDate(params.getBeginDate())||!DateUtils.isDate(params.getEndDate())){
            return new ResultDto(false,null,"日期格式错误");
        }
        if (DateUtils.addDay(DateUtils.DateToInt(new Date()),-30)>params.getBeginDate()){
            return new ResultDto(false,null,"日期范围错误");
        }
        if (params.getBeginDate()>params.getEndDate()){
            return new ResultDto(false,null,"开始时间不能大于结束时间");
        }
        if (params.getAreaId().length() != 4){
            return new ResultDto(false,null,"地区信息错误");
        }
        int yesToday = DateUtils.addDay(DateUtils.DateToInt(new Date()),-1);
        if (params.getEndDate()>yesToday){
            params.setEndDate(yesToday);
        }
        return new ResultDto(true,iMobileAreaAppLoginService.areaAppLoginByDay(params.getAreaId(),params.getBeginDate(),params.getEndDate()),"");
    }

    /**
     * 二合二级界面 地级市
     * @param params
     * @return
     */
    @RequestMapping(value = "/CityAreaGameLoginDetailsByDays",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "市级地区游戏二合分析之二级界面")
    public ResultDto cityAreaGameLoginDetailsByDay(@RequestBody AppAreaDetailDto params){
        if (!DateUtils.isDate(params.getBeginDate())||!DateUtils.isDate(params.getEndDate())){
            return new ResultDto(false,null,"日期格式错误");
        }
        if (DateUtils.addDay(DateUtils.DateToInt(new Date()),-30)>params.getBeginDate()){
            return new ResultDto(false,null,"日期范围错误");
        }
        if (params.getBeginDate()>params.getEndDate()){
            return new ResultDto(false,null,"开始时间不能大于结束时间");
        }
        if (params.getAreaId().length() != 4){
            return new ResultDto(false,null,"地区信息错误");
        }
        int yesToday = DateUtils.addDay(DateUtils.DateToInt(new Date()),-1);
        if (params.getEndDate()>yesToday){
            params.setEndDate(yesToday);
        }
        if (params.getAppId() < 0){
            return new ResultDto(false,null,"app信息错误");
        }
        return new ResultDto(true,iMobileAreaAppLoginService.areaAppLoginDetailsByDay(params.getAreaId(),params.getBeginDate(),params.getEndDate(),params.getAppId()),"");
    }

    /**
     * 二合一级界面  县区
     * @param params
     * @return
     */
    @RequestMapping(value = "/DistrictAreaGameLoginByDays",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "县级地区游戏二合分析之一级界面")
    public ResultDto districtAreaGameLoginByDay(@RequestBody AreaDaysDto params){
        if (!DateUtils.isDate(params.getBeginDate())||!DateUtils.isDate(params.getEndDate())){
            return new ResultDto(false,null,"日期格式错误");
        }
        if (DateUtils.addDay(DateUtils.DateToInt(new Date()),-30)>params.getBeginDate()){
            return new ResultDto(false,null,"日期范围错误");
        }
        if (params.getBeginDate()>params.getEndDate()){
            return new ResultDto(false,null,"开始时间不能大于结束时间");
        }
        if (params.getAreaId().length() != 6){
            return new ResultDto(false,null,"地区信息错误");
        }
        int yesToday = DateUtils.addDay(DateUtils.DateToInt(new Date()),-1);
        if (params.getEndDate()>yesToday){
            params.setEndDate(yesToday);
        }
        return new ResultDto(true,iMobileAreaAppLoginService.areaAppLoginByDay(params.getAreaId(),params.getBeginDate(),params.getEndDate()),"");
    }

    /**
     * 二合二级界面  县区
     * @param params
     * @return
     */
    @RequestMapping(value = "/DistrictAreaGameLoginDetailsByDays",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "县级地区游戏二合分析之二级界面")
    public ResultDto districtAreaGameLoginDetailsByDay(@RequestBody AppAreaDetailDto params){
        if (!DateUtils.isDate(params.getBeginDate())||!DateUtils.isDate(params.getEndDate())){
            return new ResultDto(false,null,"日期格式错误");
        }
        if (DateUtils.addDay(DateUtils.DateToInt(new Date()),-30)>params.getBeginDate()){
            return new ResultDto(false,null,"日期范围错误");
        }
        if (params.getBeginDate()>params.getEndDate()){
            return new ResultDto(false,null,"开始时间不能大于结束时间");
        }
        if (params.getAreaId().length() != 6){
            return new ResultDto(false,null,"地区信息错误");
        }
        int yesToday = DateUtils.addDay(DateUtils.DateToInt(new Date()),-1);
        if (params.getEndDate()>yesToday){
            params.setEndDate(yesToday);
        }
        if (params.getAppId()<0){
            return new ResultDto(false,null,"app信息错误");
        }
        return new ResultDto(true,iMobileAreaAppLoginService.areaAppLoginDetailsByDay(params.getAreaId(),params.getBeginDate(),params.getEndDate(),params.getAppId()),"");
    }
}
