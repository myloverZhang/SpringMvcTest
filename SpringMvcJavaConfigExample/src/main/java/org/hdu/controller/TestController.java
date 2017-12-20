package org.hdu.controller;

import com.sun.org.apache.bcel.internal.generic.RET;
import org.hdu.model.SchoolPo;
import org.hdu.model.StudentsPo;
import org.hdu.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhang on 2017/12/18.
 */
@RestController
@RequestMapping(value = "/api")
public class TestController {
    @Autowired
    private ITestService testService;

    @GetMapping(value = "/test")
    public String test(){
        return "hello world";
    }

    @GetMapping(value = "/studentById")
    public StudentsPo getStudentById(@RequestParam Integer id){
        return testService.getStudentInfo(id);
    }

    @GetMapping(value = "/schoolById")
    public SchoolPo getSchoolById(@RequestParam Integer id){
        return  testService.getSchoolInfo(id);
    }
}
