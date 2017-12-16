package ct.dc.pc.api.controller;

import ct.dc.pc.api.model.dto.input.GameDaysDto;
import ct.dc.pc.api.model.dto.input.HallDaysDto;
import ct.dc.pc.api.model.dto.input.HallGameDaysDto;
import ct.dc.pc.api.model.dto.output.ResultDto;
import ct.dc.pc.api.service.merge.interfaces.IHallGameService;
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
 * Created by B41-80 on 2017/4/7.
 */
@Controller
@RequestMapping(value = "/HallGame")
@ResponseBody
public class HallGameController {

    @Autowired
    private IHallGameService iHallGameService;

    @RequestMapping(value = "/HallGameLoginByDaysFull",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "大厅统计游戏分布一级界面查询接口")
    public ResultDto hallGameLoginByDaysFull(@RequestBody HallDaysDto params){
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
        if (params.getHallId()<=0){
            return new ResultDto(
                    false,
                    null,
                    "大厅id不能为0"
            );
        }
        int yestoday = DateUtils.addDay(DateUtils.DateToInt(new Date()),-1);
        if (params.getEndDate()>yestoday)
            params.setEndDate(yestoday);
        return new ResultDto(
                true,
                iHallGameService.listHallGameInfo(params.getBeginDate(),params.getEndDate(),params.getHallId()),
                ""
        );
    }

    @RequestMapping(value = "/HallGameLoginByDayDetail",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "大厅统计游戏分布二级界面查询接口")
    public ResultDto hallGameLoginByDayDetail(@RequestBody HallGameDaysDto params){
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
        if (params.getHallId()<=0){
            return new ResultDto(
                    false,
                    null,
                    "大厅id不能为0"
            );
        }
        int yestoday = DateUtils.addDay(DateUtils.DateToInt(new Date()),-1);
        if (params.getEndDate()>yestoday)
            params.setEndDate(yestoday);

        return new ResultDto(
                true,
                iHallGameService.listMergeDetailInfo(params.getBeginDate(),params.getEndDate(),params.getHallId(),
                        params.getGameId()),
                ""
        );
    }
    @RequestMapping(value = "/GameHallLoginByDaysFull",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "游戏统计大厅分布一级界面查询接口")
    public ResultDto gameHallLoginByDaysFull(@RequestBody GameDaysDto params){
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
        if (params.getGameId()<=0){
            return new ResultDto(
                    false,
                    null,
                    "游戏id不能为0"
            );
        }
        int yestoday = DateUtils.addDay(DateUtils.DateToInt(new Date()),-1);
        if (params.getEndDate()>yestoday)
            params.setEndDate(yestoday);

        return new ResultDto(
                true,
                iHallGameService.listGameHallInfo(params.getBeginDate(),params.getEndDate(),params.getGameId()),
                ""
        );

    }
    @RequestMapping(value = "/GameHallLoginByDayDetail",method = RequestMethod.POST)
    @ApiOperation(value = "游戏统计大厅二级界面查询接口")
    @ResponseBody
    public ResultDto gameHallLoginByDayDetail(@RequestBody HallGameDaysDto params){
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
        if (params.getGameId()<=0){
            return new ResultDto(
                    false,
                    null,
                    "游戏id不能为0"
            );
        }
        int yestoday = DateUtils.addDay(DateUtils.DateToInt(new Date()),-1);
        if (params.getEndDate()>yestoday)
            params.setEndDate(yestoday);

        return new ResultDto(
                true,
                iHallGameService.listMergeDetailInfo(params.getBeginDate(),params.getEndDate(),params.getHallId(),
                        params.getGameId()),
                ""
        );
    }
}

