package com.erp.controller;

import com.erp.exception.BaseException;
import com.erp.exception.EmBussinessError;
import com.erp.response.Result;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xielulin
 * @create 2020-10-28 23:32
 * @desc BaseController
 **/
public class BaseController {
    public static final String CONTENT_TYPE_FORMED = "application/x-www-form-urlencoded";

    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Result handleException(HttpServletRequest request, Exception ex){
        Result result = Result.ok();
        Map<String,Object> map = new HashMap<>();
        if(ex instanceof BaseException){
            BaseException exception = (BaseException) ex;
            result.setStatus(exception.getErrCode());
            result.setDesc(exception.getErrMsg());
        }else if (ex instanceof MissingServletRequestParameterException){
            MissingServletRequestParameterException parameterException = (MissingServletRequestParameterException) ex;
            String parameterName = parameterException.getParameterName();
            result.setStatus(EmBussinessError.PARAMEER_VALIDATION_ERROR.getErrCode());
            result.setDesc("参数错误：缺少"+parameterName+"参数");
        }else{
            ex.printStackTrace();
            result.setStatus(EmBussinessError.UNKNOW_ERROR.getErrCode());
            result.setDesc(EmBussinessError.UNKNOW_ERROR.getErrMsg());
        }
        return result;

    }
}
