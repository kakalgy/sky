package com.yusj.egret.model.major;

/**
 * @Description
 * @Author kakalgy
 * @Date 2018/11/3 13:26
 **/
public class ReturnObject<T> {

    private boolean success;
    private T result;
    private ErrorMessage message;

    public ReturnObject() {
    }

    public ReturnObject(boolean success, T result) {
        this.success = success;
        this.result = result;
    }

    public ReturnObject(boolean success, ErrorMessage message) {
        this.success = success;
        this.message = message;
    }

    public ReturnObject(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public ErrorMessage getMessage() {
        return message;
    }

    public void setMessage(ErrorMessage message) {
        this.message = message;
    }
}
