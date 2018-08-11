package com.tuobuxie.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @author: lishaofeng
 **/
@RestController
@RequestMapping("/hello")
@Api(value="VIP视频播放",tags="hello接口")

public class HelloController {

    @GetMapping("/")
    @ApiOperation("")

    public String hello(@ApiParam(name = "name",value = "姓名",required = true) @RequestParam String name) {
        return "Hello, " + name + " " + new Date();
    }

}
