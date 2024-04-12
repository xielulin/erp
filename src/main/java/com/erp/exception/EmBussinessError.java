package com.erp.exception;

public enum EmBussinessError implements CommonError {
    //10000 通用错误码
    PARAMEER_VALIDATION_ERROR(10001,"参数不合法"),
    UNKNOW_ERROR(10002, "未知错误"),

    //20000开头为用户信息相关错误码
    USER_NOT_EXIT(20001,"用户不存在"),
    USER_NOT_VALID(20004,"账号已失效，请联系管理员"),

    LOGIN_FAIL_ERROR(20002, "手机号码或密码不正确"),
    USER_NOT_LOGIN(20003,"用户未登陆" ),

    PULL_COMPANY_ERROR(30001,"公司信息拉取接口调用失败"),

    //30000 订单错误码
    STOCK_NOT_ENOUGH(30001, "商品库存不足"), ;


    private int errCode;
    private String errMsg;
    private EmBussinessError(int errCode,String errMsg){
        this.errCode = errCode;
        this.errMsg = errMsg;
    }


    @Override
    public int getErrCode() {
        return this.errCode;
    }

    @Override
    public String getErrMsg() {
        return this.errMsg;
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
         this.errMsg = errMsg;
         return this;
    }
}
