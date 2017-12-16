package ct.dc.pc.api.controller;

import ct.dc.pc.api.model.dto.input.GameDayDto;
import ct.dc.pc.api.model.dto.input.GameDaysDto;
import ct.dc.pc.api.model.dto.output.ResultDto;
import ct.dc.pc.api.service.game.interfaces.IGameLoginService;
import ct.dc.pc.api.service.game.interfaces.IGameRetainService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by B41-80 on 2017/4/6.
 */
@Controller
@ResponseBody
@RequestMapping(value = "/Game")
public class GameController {
    @Autowired
    private IGameLoginService iGameLoginService;

    @Autowired
    private IGameRetainService iGameRetainService;


    @RequestMapping(value = "/LoginUsersPerDay",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "根据日期获取PC游戏单日登录信息")
    public ResultDto loginUsersPerDay(@RequestBody GameDayDto params){
        return new ResultDto(
                true,
                iGameLoginService.listGameLoginPerDayInfo(params.getGameId(),params.getDate()),
                ""
        );
    }

    @RequestMapping(value = "/LoginUsersByDay",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "根据日期获取PC游戏多日登录信息")
    public ResultDto loginUsersByDay(@RequestBody GameDaysDto params){
        return new ResultDto(
                true,
                iGameLoginService.listGameLoginByDayInfo(params.getGameId(),params.getBeginDate(),params.getEndDate()),
                ""
        );
    }

    @RequestMapping(value = "/RetainByDay",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "按日统计PC游戏留存率")
    public ResultDto retainByDay(@RequestBody GameDaysDto params){
        return new ResultDto(
                true,
                iGameRetainService.listGameRetainByDayInfo(params.getGameId(),params.getBeginDate(),params.getEndDate()),
                ""
        );
    }
}
