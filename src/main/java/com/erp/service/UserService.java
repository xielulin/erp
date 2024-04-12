package com.erp.service;

import com.erp.bean.User;
import com.erp.exception.BaseException;

/**
 * @author xielulin
 * @create 2024-03-27 21:10
 * @desc
 **/
public interface UserService {
    /**
     * @description 根据电话号码和密码获取用户
     * @author xielulin
     * @date 2024/3/27
     * @param tel
     * @param pwd
     * @return com.erp.bean.User
     */
    User getUserByTelAndPwd(String tel, String pwd) throws BaseException;


}
