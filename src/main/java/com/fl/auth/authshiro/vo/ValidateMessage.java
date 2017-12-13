package com.fl.auth.authshiro.vo;

/**
 * 验证信息
 */
public enum ValidateMessage {
    EMAIL_EMPTY(101,"邮箱为空"),
    EMAIL_REGEX_WRONG(102,"邮箱格式错误"),
    EMAIL_TOO_LONG(103,"邮箱超长"),
    USERNAME_EMPTY(104,"用户名为空"),
    USERNAME_REGEX_WRONG(105,"用户名格式错误"),
    USERNAME_TOO_LONG(106,"用户名过长"),
    PASSWORD_EMPTY(107,"密码为空"),
    PASSWORD_REGEX_WRONG(108,"密码格式错误"),
    PASSWORD_TOO_LONG(109,"密码过长"),
    REPASSWORD_EMPTY(110,"重复密码为空"),
    REPASSWORD_REGEX_WRONG(111,"重复密码格式错误"),
    REPASSWORD_TOO_LONG(112,"重复密码过长"),

    PASSWORD_INCONSISTENT(201,"两次输入密码不一致"),
    USER_NOT_EXIST(202,"用户不存在");

    private int code;

    private String message;

    private ValidateMessage(int code,String message){
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
