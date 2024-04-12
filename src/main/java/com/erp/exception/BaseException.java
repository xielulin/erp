package com.erp.exception;

/**
 * @author xielulin
 * @create 2018-12-12 11:09
 * @desc
 **/
public class BaseException extends Exception implements CommonError{
    private CommonError commonError;

    public BaseException(CommonError commonError){
        super();
        this.commonError = commonError;
    }

    public BaseException(CommonError commonError,String errMsg){
        super();
        this.commonError = commonError;
        this.commonError.setErrMsg(errMsg);
    }

    @Override
    public int getErrCode() {
        return this.commonError.getErrCode();
    }

    @Override
    public String getErrMsg() {
        return this.commonError.getErrMsg();
    }

    @Override
    public CommonError setErrMsg(String msg) {
        return this.commonError.setErrMsg(msg);
    }
}
