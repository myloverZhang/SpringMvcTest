package ct.dc.pc.api.controller;

import ct.dc.pc.api.model.dto.input.*;
import ct.dc.pc.api.model.dto.output.ResultDto;
import ct.dc.pc.api.service.area.interfaces.IAreaLoginService;
import ct.dc.pc.api.service.area.interfaces.IAreaRegService;
import ct.dc.pc.api.service.area.interfaces.IAreaRetainService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.invoke.util.VerifyAccess;

/**
 * Created by B41-80 on 2017/4/5.
 */
@Controller
@ResponseBody
@RequestMapping(value = "/Area")
public class AreaController {
    @Autowired
    private IAreaLoginService iAreaLoginService;
    @Autowired
    private IAreaRegService iAreaRegService;
    @Autowired
    private IAreaRetainService iAreaRetainService;

    @ResponseBody
    @RequestMapping(value = "/NationLoginUsersPerDay",method = RequestMethod.POST)
    @ApiOperation(value = "根据日期获取全国单日登录信息")
    public ResultDto nationLoginUsersPerDay(@RequestBody DayDto param){
        return new ResultDto(
                true,
                iAreaLoginService.listNationLoginPerDayInfo(param.getDate()),
                ""
        );
    }

    @RequestMapping(value = "/NationLoginUsersByDay",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "根据日期获取全国多日登录信息")
    public ResultDto nationLoginUsersByDay(@RequestBody DaysDto param){
        return new ResultDto(
                true,
                iAreaLoginService.listNationLoginByDayInfo(param.getBeginDate(),param.getEndDate()),
                ""
        );
    }

    @RequestMapping(value = "/ProvinceLoginUsersByDay",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "根据日期获取省份多日登录信息")
    public ResultDto provinceLoginUsersByDay(@RequestBody AreaDaysDto params){
        if (params.getAreaId().length()!=2){
            return new ResultDto(false,null,"省份ID格式不正确！！");
        }
        return new ResultDto(
                true,
                iAreaLoginService.listProvinceLoginByDayInfo(params.getBeginDate(),params.getEndDate(),
                        params.getAreaId()),
                ""
        );
    }

    @RequestMapping(value = "/ProvinceLoginUsersPerDay",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "根据日期获取全国单日登录信息")
    public ResultDto provinceLoginUsersPerDay(@RequestBody AreaDayDto params){
        if (params.getAreaId().length()!=2){
            return new ResultDto(false,null,"省份ID格式不正确！！");
        }
        return new ResultDto(
                true,
                iAreaLoginService.listProvinceLoginPerDayInfo(params.getDate(),params.getAreaId()),
                ""
        );
    }

    @RequestMapping(value = "/CityLoginUsersByDay",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "根据日期获取地级市(包含县区)多日登录信息")
    public ResultDto cityLoginUsersByDay(@RequestBody AreaDaysDto params){
        if (params.getAreaId().length()!=4){
            return new ResultDto(false,null,"地级市ID格式不正确！！");
        }
        return new ResultDto(
                true,
                iAreaLoginService.listCityLoginByDayInfo(params.getBeginDate(), params.getEndDate(), params.getAreaId()),
                ""
        );
    }

    @RequestMapping(value = "/CityLoginUsersPerDay",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "根据日期获取地级市(包含县区)单日登录信息")
    public ResultDto cityLoginUsersPerDay(@RequestBody AreaDayDto params){
        if (params.getAreaId().length()!=4){
            return new ResultDto(false,null,"地级市ID格式不正确！！");
        }
        return new ResultDto(
                true,
                iAreaLoginService.listCityLoginPerDayInfo(params.getDate(),params.getAreaId()),
                ""
        );
    }
    @RequestMapping(value = "/DistrictLoginUsersByDay",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "根据日期获取县区多日登录信息")
    public ResultDto districtLoginUsersByDay(@RequestBody AreaDaysDto params){
        if (params.getAreaId().length()!=6){
            return new ResultDto(false,null,"县区ID格式不正确！！");
        }
        return new ResultDto(
                true,
                iAreaLoginService.listDistrictLoginByDayInfo(params.getBeginDate(),params.getEndDate(),params.getAreaId()),
                ""
        );
    }
    @RequestMapping(value = "/DistrictLoginUsersPerDay",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "根据日期获取县区单日登录信息")
    public ResultDto districtLoginUsersPerDay(@RequestBody AreaDayDto params){
        if (params.getAreaId().length()!=6){
            return new ResultDto(false,null,"县区ID格式不正确！！");
        }
        return new ResultDto(
                true,
                iAreaLoginService.listDistrictLoginPerDayInfo(params.getDate(),params.getAreaId()),
                ""
        );
    }


    @RequestMapping(value = "/NationRegUsersByDay",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "根据日期获取全国多日注册信息")
    public ResultDto nationRegUsersByDay(@RequestBody DaysDto params){
        return new ResultDto(
                true,
                iAreaRegService.listNationRegByDayInfo(params.getBeginDate(),params.getEndDate()),
                ""
        );
    }
    @RequestMapping(value = "/NationRegUsersByMonth",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "根据日期获取全国多月注册信息")
    public ResultDto nationRegUsersByMonth(@RequestBody MonthsDay params){
        return new ResultDto(
                true,
                iAreaRegService.listNationRegByMonthInfo(params.getBeginMonth(),params.getEndMonth()),
                ""
        );
    }

    @RequestMapping(value = "/ProvinceRegUsersByDay",method = RequestMethod.POST)
    @ApiOperation(value = " 根据日期获取省份多日注册信息")
    @ResponseBody
    public ResultDto provinceRegUsersByDay(@RequestBody AreaDaysDto params){
        if (params.getAreaId().length()!=2){
            return new ResultDto(false,null,"省份ID格式不正确！！");
        }
        return new ResultDto(
                true,
                iAreaRegService.listProvinceRegByDayInfo(params.getAreaId(),params.getBeginDate(),params.getEndDate()),
                ""
        );
    }

    @RequestMapping(value = "/ProvinceRegUsersByMonth",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "根据日期获取省份多月注册信息")
    public ResultDto provinceRegUsersByMonth(@RequestBody AreaMonthsDay params){
        if (params.getAreaId().length()!=2){
            return new ResultDto(false,null,"省份ID格式不正确！！");
        }
        return new ResultDto(
                true,
                iAreaRegService.listProvinceRegByMonthInfo(params.getAreaId(),params.getBeginMonth(),params.getEndMonth()),
                ""
        );
    }

    @RequestMapping(value = "/CityRegUsersByDay",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "根据日期获取地级市（包含县区）多日注册信息")
    public ResultDto cityRegUsersByDay(@RequestBody AreaDaysDto params){
        if (params.getAreaId().length()!=4){
            return new ResultDto(false,null,"地级市ID格式不正确！！");
        }
        return new ResultDto(
                true,
                iAreaRegService.listCityRegByDayInfo(params.getAreaId(),params.getBeginDate(),params.getEndDate()),
                ""
        );
    }
    @RequestMapping(value = "/CityRegUsersByMonth",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "根据日期获取地级市（包含县区）多月注册信息")
    public ResultDto cityRegUsersByMonth(@RequestBody AreaMonthsDay params){
        if (params.getAreaId().length()!=4){
            return new ResultDto(false,null,"地级市ID格式不正确！！");
        }
        return new ResultDto(
                true,
                iAreaRegService.listCityRegByMonthInfo(params.getAreaId(),params.getBeginMonth(),params.getEndMonth()),
                ""
        );
    }
    @RequestMapping(value = "/DistrictRegUsersByDay",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "根据日期获取县区多日注册信息")
    public ResultDto districtRegUsersByDay(@RequestBody AreaDaysDto params){
        if (params.getAreaId().length()!=6){
            return new ResultDto(false,null,"地级市ID格式不正确！！");
        }
        return new ResultDto(
                true,
                iAreaRegService.listDistrictRegByDayInfo(params.getAreaId(),params.getBeginDate(),params.getEndDate()),
                ""
        );
    }

    @RequestMapping(value = "/DistrictRegUsersByMonth",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "根据日期获取县区多月注册信息")
    public ResultDto districtRegUsersByMonth(@RequestBody AreaMonthsDay params){
        if (params.getAreaId().length()!=6){
            return new ResultDto(false,null,"地级市ID格式不正确！！");
        }
        return new ResultDto(
                true,
                iAreaRegService.listDistrictRegByMonthInfo(params.getAreaId(),params.getBeginMonth(),params.getEndMonth()),
                ""
        );
    }

    @ResponseBody
    @RequestMapping(value = "/NationRetainByDay", method = RequestMethod.POST)
    @ApiOperation(value = "全国范围pc用户留存")
    public ResultDto nationRetainByDay(@RequestBody DaysDto params){
        return new ResultDto(
                true,
                iAreaRetainService.listNationRetainByDayIfs(params.getBeginDate(), params.getEndDate()),
                ""
        );
    }

    @ResponseBody
    @RequestMapping(value = "/ProvinceRetainByDay", method = RequestMethod.POST)
    @ApiOperation(value = "省级多日留存")
    public ResultDto provinceRetainByDay(@RequestBody AreaDaysDto params){
        if (params.getAreaId().length()!=2){
            return new ResultDto(false,null,"省份ID格式不正确！！");
        }
        return new ResultDto(
                true,
                iAreaRetainService.listProvinceRetainByDayIfs(params.getAreaId(),params.getBeginDate(),params.getEndDate()),
                ""
        );
    }
    @RequestMapping(value = "/CityRetainByDay",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "地级市多日留存")
    public ResultDto cityRetainByDay(@RequestBody AreaDaysDto params){
        if (params.getAreaId().length()!=4){
            return new ResultDto(false,null,"地级市ID格式不正确！！");
        }
        return new ResultDto(
                true,
                iAreaRetainService.listCityRetainByDayIfs(params.getAreaId(),params.getBeginDate(),params.getEndDate()),
                ""
        );
    }
    @RequestMapping(value = "/DistrictRetainByDay",method = RequestMethod.POST)
    @ApiOperation(value = "县区多日留存")
    @ResponseBody
    public ResultDto districtRetainByDay(@RequestBody AreaDaysDto params){
        if (params.getAreaId().length()!=6){
            return new ResultDto(false,null,"地级市ID格式不正确！！");
        }
        return new ResultDto(
                true,
                iAreaRetainService.listDistrictRetainByDayIfs(params.getAreaId(),params.getBeginDate(),params.getEndDate()),
                ""
        );
    }

}
