package com.erp.response;


import com.erp.constants.Constant;

/**
 * @author xielulin
 * @create 2018-11-18 15:37
 * @desc
 **/
public class Result<T> {
    private T data;

    private int status;

    private String desc;

    public Result() {
    }

    public Result(int status) {
        this.status = status;
    }

    public Result(int status, T data) {
        this.status = status;
        this.data = data;
    }

    public Result(int status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public Result(int status, T data, String desc) {
        this.status = status;
        this.data = data;
        this.desc = desc;
    }

    public static <T> Result<T> ok(T data) {
        return new Result<>(Constant.ResultConstant.SUCCESS, data);
    }

    public static <T> Result<T> ok() {
        return new Result<>(Constant.ResultConstant.SUCCESS, null, null);
    }

    public static <T> Result<T> ok(String message) {
        return new Result<>(Constant.ResultConstant.SUCCESS, null, message);
    }

    public static <T> Result<T> ok(T data, String desc) {
        return new Result<>(Constant.ResultConstant.SUCCESS, data, desc);
    }

    public static Result warn(String desc) {
        return new Result<>(Constant.ResultConstant.FAIL, desc);
    }

    public static <T> Result<T> warn(T data, String desc) {
        return new Result<>(Constant.ResultConstant.FAIL, data, desc);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
