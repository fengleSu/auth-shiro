package com.fl.auth.authshiro.vo;

public class BaseVo {

    /**
     *  结果
     */
    private Result result;
    /**
     * 验证信息
     */
    private ValidateMessage validation;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public ValidateMessage getValidation() {
        return validation;
    }

    public void setValidation(ValidateMessage validation) {
        this.validation = validation;
    }
}
