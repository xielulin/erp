package com.erp.configration;

import com.erp.exception.BaseException;
import com.erp.response.Result;
import org.omg.CORBA.SystemException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class HandleException {
    private static final Logger logger = LoggerFactory.getLogger(HandleException.class);

    @InitBinder
    public void initBinder(WebDataBinder binder) {

    }

    /**
     * 全局异常捕获处理,保证所有接口返回正常的结果值
     *
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = BaseException.class)
    public Result exceptionHandler(BaseException e) {
        logger.error("系统异常1：{}", e);
        return  Result.warn("2", "系统异常:" + e.getMessage());
    }

    @ExceptionHandler({HttpMessageNotReadableException.class})
    @ResponseBody
    public Result requestNotReadable(HttpMessageNotReadableException e) {
        logger.error("请求参数不合法：{}", e);
        return Result.warn("2", "请求参数不合法:" + e.getMessage());
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public Result nullPointerExceptionHandler(NullPointerException e) {
        logger.error("空指针异常：{}", e);
        return Result.warn("2", "空指针异常:" + e.getMessage());
    }

    @ExceptionHandler(value = { SystemException.class })
    @ResponseBody
    public Result resourceNotFoundExceptionHandle(Exception e) {
        logger.error("Resource not found! Message：{}", e);
        return Result.warn("2", "Resource not found! Message:" + e.getMessage());
    }
}
