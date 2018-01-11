package com.fl.auth.authshiro.service;

import com.fl.auth.authshiro.vo.UserVo;

/**
 * 用户服务
 */
public interface IUserService {

    /**
     * 注册
     * @param email
     * @param username
     * @param password
     * @param repassword
     */
    UserVo regist(String email, String username, String password, String repassword);

    /**
     * 登录
     * @param username
     * @param password
     */
    UserVo login(String username,String password);

    /**
     * 根据用户名获取用户信息
     * @param username
     * @return
     */
    UserVo getUser(String username);
}
