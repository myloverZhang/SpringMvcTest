package ct.dc.mobile.api.controller;

import ct.dc.mobile.api.model.dto.input.ReportDaysDto;
import ct.dc.mobile.api.model.dto.output.ReportResultsDto;
import ct.dc.mobile.api.service.IMobileReportAreaService;
import ct.dc.mobile.api.service.IMobileReportGameService;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.ref.ReferenceQueue;

/**
 * Created by B41-80 on 2017/1/17.
 */
@Controller
@ResponseBody
@RequestMapping(value = "/MobileReport")
public class MobileReportController {
    private IMobileReportAreaService iMobileReportAreaService;
    private IMobileReportGameService iMobileReportGameService;

    public void setiMobileReportAreaService(IMobileReportAreaService iMobileReportAreaService) {
        this.iMobileReportAreaService = iMobileReportAreaService;
    }

    public void setiMobileReportGameService(IMobileReportGameService iMobileReportGameService) {
        this.iMobileReportGameService = iMobileReportGameService;
    }

    @RequestMapping(value = "/GameRetain",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "报表游戏留存接口")
    public ReportResultsDto gameRetain(@RequestBody ReportDaysDto params){
        return new ReportResultsDto(true,iMobileReportGameService.getGameRetain(params.getBeginDate(),params.getEndDate()));
    }
    @RequestMapping(value = "/GameLogin",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "报表游戏多日登录")
    public ReportResultsDto gameLogin(@RequestBody ReportDaysDto params){
        return new ReportResultsDto(true,iMobileReportGameService.getGameLogin(params.getBeginDate(),params.getEndDate()));
    }
    @RequestMapping(value = "/GameReg",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "报表游戏注册")
    public ReportResultsDto gameReg(@RequestBody ReportDaysDto params){
        return new ReportResultsDto(true,iMobileReportGameService.getGameReg(params.getBeginDate(),params.getEndDate()));
    }
    @RequestMapping(value = "AreaLogin",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "报表地区登录")
    public ReportResultsDto areaLogin(@RequestBody ReportDaysDto params){
        return new ReportResultsDto(true,iMobileReportAreaService.getAreaLogin(params.getBeginDate(),params.getEndDate()));
    }
    @RequestMapping(value = "AreaReg",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "报表地区注册")
    public ReportResultsDto areaReg(@RequestBody ReportDaysDto params){
        return new ReportResultsDto(true,iMobileReportAreaService.getAreaReg(params.getBeginDate(),params.getEndDate()));
    }
}
