package com.fl.auth.authshiro.vo;

public enum Result {
    SUCCESS(1,"成功"),
    INVALID(2,"验证错误"),
    FAILED(3,"失败");

    private int state;
    private String message;

    private Result(int state,String message){
        this.state = state;
        this.message = message;
    }

    public int getState() {
        return state;
    }

    public String getMessage() {
        return message;
    }
}
