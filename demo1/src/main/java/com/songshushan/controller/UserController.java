package com.songshushan.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/user")
@Api("与用户相关")
public class UserController {
    @ApiOperation("获取信息")
    @GetMapping("/get")
    public String get()
    {

        return "hello";
    }

}
