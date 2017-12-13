package com.fl.auth.authshiro.vo;

/**
 * 用户信息
 * @author fengle
 */
public class UserVo  extends BaseVo{

    /**
     *  用户名
     */
    private String username;

    /**
     * token
     */
    private String token;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
