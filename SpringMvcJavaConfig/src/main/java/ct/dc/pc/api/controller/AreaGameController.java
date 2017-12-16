package ct.dc.pc.api.controller;

import ct.dc.pc.api.model.dto.input.AreaDaysDto;
import ct.dc.pc.api.model.dto.input.AreaGameDaysDto;
import ct.dc.pc.api.model.dto.input.DaysDto;
import ct.dc.pc.api.model.dto.input.GameDaysDto;
import ct.dc.pc.api.model.dto.output.ResultDto;
import ct.dc.pc.api.service.merge.interfaces.IAreaGameService;
import ct.dc.pc.api.util.date.DateUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Created by B41-80 on 2017/4/6.
 */
@Controller
@RequestMapping(value = "/AreaGame")
@ResponseBody
public class AreaGameController {

    @Autowired
    private IAreaGameService iAreaGameService;

    @RequestMapping(value = "/NationGameLoginByDaysFull",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = " 全国统计游戏分布一级界面查询接口")
    public ResultDto nationGameLoginByDaysFull(@RequestBody DaysDto params){
        if (!DateUtils.isDate(params.getBeginDate())||!DateUtils.isDate(params.getEndDate()))
            return new ResultDto(
                    false,
                    null,
                    "日期格式错误"
            );
        if (DateUtils.addDay(DateUtils.DateToInt(new Date()),-30)>params.getBeginDate())
            return new ResultDto(
                    false,
                    null,
                    "日期范围错误"
            );
        if (params.getBeginDate()>params.getEndDate())
            return new ResultDto(
                    false,
                    null,
                    "开始时间不能大于结束时间"
            );
        int yestoday = DateUtils.addDay(DateUtils.DateToInt(new Date()),-1);
        if (params.getEndDate()>yestoday)
            params.setEndDate(yestoday);
        return new ResultDto(
                true,
                iAreaGameService.listNationGameInfo(params.getBeginDate(),params.getEndDate()),
                ""
        );
    }


    @RequestMapping(value = "/NationGameLoginByDayDetail",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "全国统计游戏分布二级界面查询接口")
    public ResultDto nationGameLoginByDayDetail(@RequestBody GameDaysDto params){
        if (!DateUtils.isDate(params.getBeginDate())||!DateUtils.isDate(params.getEndDate()))
            return new ResultDto(
                    false,
                    null,
                    "日期格式错误"
            );
        if (DateUtils.addDay(DateUtils.DateToInt(new Date()),-30)>params.getBeginDate())
            return new ResultDto(
                    false,
                    null,
                    "日期范围错误"
            );
        if (params.getBeginDate()>params.getEndDate())
            return new ResultDto(
                    false,
                    null,
                    "开始时间不能大于结束时间"
            );
        int yestoday = DateUtils.addDay(DateUtils.DateToInt(new Date()),-1);
        if (params.getEndDate()>yestoday)
            params.setEndDate(yestoday);
        return new ResultDto(
                true,
                iAreaGameService.listNationGameDetailInfo(params.getBeginDate(),params.getEndDate(),params.getGameId()),
                ""
        );
    }

    @RequestMapping(value = "/ProvinceGameLoginByDaysFull",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = " 省级统计游戏分布一级界面查询接口")
    public ResultDto provinceGameLoginByDaysFull(@RequestBody AreaDaysDto params){
        if (!DateUtils.isDate(params.getBeginDate())||!DateUtils.isDate(params.getEndDate()))
            return new ResultDto(
                    false,
                    null,
                    "日期格式错误"
            );
        if (DateUtils.addDay(DateUtils.DateToInt(new Date()),-30)>params.getBeginDate())
            return new ResultDto(
                    false,
                    null,
                    "日期范围错误"
            );
        if (params.getBeginDate()>params.getEndDate())
            return new ResultDto(
                    false,
                    null,
                    "开始时间不能大于结束时间"
            );
        if (params.getAreaId().length()!=2){
            return new ResultDto(
                    false,
                    null,
                    "地区id非法"
            );
        }
        int yestoday = DateUtils.addDay(DateUtils.DateToInt(new Date()),-1);
        if (params.getEndDate()>yestoday)
            params.setEndDate(yestoday);
        return new ResultDto(
                true,
                iAreaGameService.listProvinceGameInfo(params.getAreaId(),params.getBeginDate(),params.getEndDate()),
                ""
        );
    }

    @RequestMapping(value = "/ProvinceGameLoginByDayDetail",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "省级统计游戏分布二级界面查询接口")
    public ResultDto provinceGameLoginByDayDetail(@RequestBody AreaGameDaysDto params){
        if (!DateUtils.isDate(params.getBeginDate())||!DateUtils.isDate(params.getEndDate()))
            return new ResultDto(
                    false,
                    null,
                    "日期格式错误"
            );
        if (DateUtils.addDay(DateUtils.DateToInt(new Date()),-30)>params.getBeginDate())
            return new ResultDto(
                    false,
                    null,
                    "日期范围错误"
            );
        if (params.getBeginDate()>params.getEndDate())
            return new ResultDto(
                    false,
                    null,
                    "开始时间不能大于结束时间"
            );
        if (params.getAreaId().length()!=2){
            return new ResultDto(
                    false,
                    null,
                    "地区id非法"
            );
        }
        int yestoday = DateUtils.addDay(DateUtils.DateToInt(new Date()),-1);
        if (params.getEndDate()>yestoday)
            params.setEndDate(yestoday);

        return new ResultDto(
                true,
                iAreaGameService.listProvinceGameDetailInfo(params.getAreaId(),params.getBeginDate(),
                        params.getEndDate(),params.getGameId()),
                ""
        );
    }

    @RequestMapping(value = "/CityGameLoginByDaysFull",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "市级统计游戏分布一级界面查询接口")
    public ResultDto cityGameLoginByDaysFull(@RequestBody AreaDaysDto params){
        if (!DateUtils.isDate(params.getBeginDate())||!DateUtils.isDate(params.getEndDate()))
            return new ResultDto(
                    false,
                    null,
                    "日期格式错误"
            );
        if (DateUtils.addDay(DateUtils.DateToInt(new Date()),-30)>params.getBeginDate())
            return new ResultDto(
                    false,
                    null,
                    "日期范围错误"
            );
        if (params.getBeginDate()>params.getEndDate())
            return new ResultDto(
                    false,
                    null,
                    "开始时间不能大于结束时间"
            );
        if (params.getAreaId().length()!=4){
            return new ResultDto(
                    false,
                    null,
                    "地区id非法"
            );
        }
        int yestoday = DateUtils.addDay(DateUtils.DateToInt(new Date()),-1);
        if (params.getEndDate()>yestoday)
            params.setEndDate(yestoday);

        return new ResultDto(
                true,
                iAreaGameService.listCityGameInfo(params.getAreaId(),params.getBeginDate(),params.getEndDate()),
                ""
        );
    }

    @RequestMapping(value = "/CityGameLoginByDayDetail",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "市级统计游戏分布二级界面查询接口")
    public ResultDto cityGameLoginByDayDetail(@RequestBody AreaGameDaysDto params){
        if (!DateUtils.isDate(params.getBeginDate())||!DateUtils.isDate(params.getEndDate()))
            return new ResultDto(
                    false,
                    null,
                    "日期格式错误"
            );
        if (DateUtils.addDay(DateUtils.DateToInt(new Date()),-30)>params.getBeginDate())
            return new ResultDto(
                    false,
                    null,
                    "日期范围错误"
            );
        if (params.getBeginDate()>params.getEndDate())
            return new ResultDto(
                    false,
                    null,
                    "开始时间不能大于结束时间"
            );
        if (params.getAreaId().length()!=4){
            return new ResultDto(
                    false,
                    null,
                    "地区id非法"
            );
        }
        int yestoday = DateUtils.addDay(DateUtils.DateToInt(new Date()),-1);
        if (params.getEndDate()>yestoday)
            params.setEndDate(yestoday);
        return new ResultDto(
                true,
                iAreaGameService.listCityGameDetailInfo(params.getAreaId(),params.getBeginDate(),params.getEndDate(),
                        params.getGameId()),
                ""
        );
    }


    @RequestMapping(value = "/DistrictGameLoginByDaysFull",method = RequestMethod.POST)
    @ApiOperation(value = "县区统计游戏分布一级界面查询接口")
    @ResponseBody
    public ResultDto DistrictGameLoginByDaysFull(@RequestBody AreaDaysDto params){
        if (!DateUtils.isDate(params.getBeginDate())||!DateUtils.isDate(params.getEndDate()))
            return new ResultDto(
                    false,
                    null,
                    "日期格式错误"
            );
        if (DateUtils.addDay(DateUtils.DateToInt(new Date()),-30)>params.getBeginDate())
            return new ResultDto(
                    false,
                    null,
                    "日期范围错误"
            );
        if (params.getBeginDate()>params.getEndDate())
            return new ResultDto(
                    false,
                    null,
                    "开始时间不能大于结束时间"
            );
        if (params.getAreaId().length()!=6){
            return new ResultDto(
                    false,
                    null,
                    "地区id非法"
            );
        }
        int yestoday = DateUtils.addDay(DateUtils.DateToInt(new Date()),-1);
        if (params.getEndDate()>yestoday)
            params.setEndDate(yestoday);

        return new ResultDto(
                true,
                iAreaGameService.listDistrictGameInfo(params.getAreaId(),params.getBeginDate(),params.getEndDate()),
                ""
        );
    }
    @RequestMapping(value = "/DistrictGameLoginByDayDetail",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "县区统计游戏分布二级界面查询接口")
    public ResultDto districtGameLoginByDayDetail(@RequestBody AreaGameDaysDto params){
        if (!DateUtils.isDate(params.getBeginDate())||!DateUtils.isDate(params.getEndDate()))
            return new ResultDto(
                    false,
                    null,
                    "日期格式错误"
            );
        if (DateUtils.addDay(DateUtils.DateToInt(new Date()),-30)>params.getBeginDate())
            return new ResultDto(
                    false,
                    null,
                    "日期范围错误"
            );
        if (params.getBeginDate()>params.getEndDate())
            return new ResultDto(
                    false,
                    null,
                    "开始时间不能大于结束时间"
            );
        if (params.getAreaId().length()!=6){
            return new ResultDto(
                    false,
                    null,
                    "地区id非法"
            );
        }
        int yestoday = DateUtils.addDay(DateUtils.DateToInt(new Date()),-1);
        if (params.getEndDate()>yestoday)
            params.setEndDate(yestoday);

        return new ResultDto(
                true,
                iAreaGameService.listDistrictGameDetailInfo(params.getAreaId(),params.getBeginDate(),
                        params.getEndDate(),params.getGameId()),
                ""
        );
    }
}
