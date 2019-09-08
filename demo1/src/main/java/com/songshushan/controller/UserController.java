package com.songshushan.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.songshushan.domain.UserVO;
import com.songshushan.mapper.userMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@Api("与用户相关")
public class UserController {
    //@Autowired
    //private loginMapper loginMapper;
    @Autowired
    private userMapper userMapper;
    @ApiOperation("获取信息")
    @GetMapping("/get")
    public String get()
    {

        return "hello";
    }
    /*@ApiOperation("登录")
    @PostMapping("/login")
    public UserVO login(UserVO user)
    {
        UserVO userVO = loginMapper.selectOne(user);
        if(userVO!=null)
        {
            String token = JWTUtil.createToken(user.getUsername());
            System.out.println(token);
            System.out.println("登陆成功");
            return user;
        }

            return  null;
    }*/
    @ApiOperation("列表")
    @PostMapping("/list")
    public PageInfo<UserVO> getUsers(Integer pageNum){
        PageHelper.startPage(pageNum, 2);
        List<UserVO> users= userMapper.getAll();
        PageInfo<UserVO> pageInfo = new PageInfo<>(users);
        return pageInfo;
    }
}
