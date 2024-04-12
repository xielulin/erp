package com.erp.exception;

/**
 * @author xielulin
 * @create 2020-10-28 22:58
 * @desc 异常
 **/
public interface CommonError {
    public int getErrCode();
    public String getErrMsg();
    public CommonError setErrMsg(String msg);
}
