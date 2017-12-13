package com.fl.auth.authshiro.service;

import com.fl.auth.authshiro.vo.UserVo;

public interface IUserService {

    /**
     * 注册
     * @param email
     * @param username
     * @param password
     * @param repassword
     */
    UserVo regist(String email, String username, String password, String repassword, Integer userId);

    /**
     * 登录
     * @param username
     * @param password
     */
    UserVo login(String username,String password);
}
