package com.erp.service;

import com.erp.exception.BaseException;
import com.erp.response.Result;

/**
 * @author xielulin
 * @create 2024-04-24 22:55
 * @desc
 **/
public interface SendMessageService {
    /**
     * @description 发送验证码
     * @author xielulin
     * @date 2024/4/24
     * @param tel
     * @return com.erp.response.Result
     */
    Result sendVerificationCode(String tel) throws BaseException;

    /**
     * @description 校验验证码
     * @author xielulin
     * @date 2024/4/24
     * @param tel
     * @param verificationCode
     * @return com.erp.response.Result
     */
    Result checkVerificationCode(String tel, String verificationCode);
}
