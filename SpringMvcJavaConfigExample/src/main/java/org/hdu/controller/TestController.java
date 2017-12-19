package org.hdu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhang on 2017/12/18.
 */
@RestController
@RequestMapping(value = "/api")
public class TestController {
    @GetMapping(value = "/test")
    public String test(){
        return "hello world";
    }
}
