package com.yusj.egret.model.major;

/**
 * @Description
 * @Author kakalgy
 * @Date 2018/11/3 13:32
 **/
public class ErrorMessage {

    private int code;
    private String message;

    public ErrorMessage() {
    }

    public ErrorMessage(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
