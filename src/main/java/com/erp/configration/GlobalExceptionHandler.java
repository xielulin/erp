package com.erp.configration;

import com.erp.exception.BaseException;
import com.erp.response.Result;
import lombok.extern.slf4j.Slf4j;
import org.omg.CORBA.SystemException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;

/**
 * SpringMVC统一异常处理
 *
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理Validated校验异常
     * <p>
     * 注: 常见的ConstraintViolationException异常&#xff0c; 也属于ValidationException异常
     *
     * @param e
     *         捕获到的异常
     * @return 返回给前端的data
     */
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {BindException.class, ValidationException.class, MethodArgumentNotValidException.class})
    public Result<Object> handleParameterVerificationException(Exception e) {
        log.error(" handleParameterVerificationException has been invoked", e);
        String msg = null;
        /// BindException
        if (e instanceof BindException) {
            // getFieldError获取的是第一个不合法的参数(P.S.如果有多个参数不合法的话)
            FieldError fieldError = ((BindException) e).getFieldError();
            if (fieldError != null) {
                msg = fieldError.getField()+":"+fieldError.getDefaultMessage();
            }
            /// MethodArgumentNotValidException
        } else if (e instanceof MethodArgumentNotValidException) {
            BindingResult bindingResult = ((MethodArgumentNotValidException) e).getBindingResult();
            // getFieldError获取的是第一个不合法的参数(P.S.如果有多个参数不合法的话)
            FieldError fieldError = bindingResult.getFieldError();
            if (fieldError != null) {
                msg = fieldError.getField()+":"+fieldError.getDefaultMessage();
            }
            /// ValidationException 的子类异常ConstraintViolationException
        } else if (e instanceof ConstraintViolationException) {
            /*
             * ConstraintViolationException的e.getMessage()形如
             *     {方法名}.{参数名}: {message}
             *  这里只需要取后面的message即可
             */
            msg = e.getMessage();
            if (msg != null) {
                int lastIndex = msg.lastIndexOf('.');
                if (lastIndex >= 0) {
                    msg = msg.substring(lastIndex + 1).trim();
                }
            }
        } else {
            msg = "处理参数时异常";
        }
        return Result.warn(msg);
    }

    /**
     * 全局异常捕获处理,保证所有接口返回正常的结果值
     *
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Result exceptionHandler(Exception e) {
        log.error("系统异常：{}", e);
        return  Result.warn("系统异常:" + e.getMessage());
    }

    /**
     * 全局异常捕获处理,保证所有接口返回正常的结果值
     *
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = BaseException.class)
    public Result baseExceptionHandler(BaseException e) {
        log.error("系统异常：{}", e);
        return  Result.warn("系统异常:" + e.getErrMsg());
    }

    @ExceptionHandler({HttpMessageNotReadableException.class})
    @ResponseBody
    public Result requestNotReadable(HttpMessageNotReadableException e) {
        log.error("请求参数不合法：{}", e);
        return  Result.warn("请求参数不合法:" + e.getMessage());
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    public Result nullPointerExceptionHandler(NullPointerException e) {
        log.error("空指针异常：{}", e);
        return Result.warn("空指针异常:" + e.getMessage());
    }

    @ExceptionHandler(value = { SystemException.class })
    @ResponseBody
    public Result resourceNotFoundExceptionHandle(Exception e) {
        log.error("Resource not found! Message：{}", e);
        return Result.warn("Resource not found! Message:" + e.getMessage());
    }

}