package com.fl.auth.authshiro.controller;

import com.fl.auth.authshiro.service.IUserService;
import com.fl.auth.authshiro.vo.RegistVo;
import com.fl.auth.authshiro.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 注册
     * @return
     */
    @RequestMapping("/regist")
    public UserVo regist(@RequestBody RegistVo registInfo){
        UserVo userVo = userService.regist(registInfo.getEmail(),registInfo.getUsername(),registInfo.getPassword(),registInfo.getRepassword());
        return userVo;
    }

    /**
     * 登录
     * @return
     */
    @RequestMapping("/login")
    public UserVo login(){
        UserVo userVo = new  UserVo();
        return userVo;
    }
}
