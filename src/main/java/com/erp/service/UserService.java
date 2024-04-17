package com.erp.service;

import com.erp.bean.User;
import com.erp.dto.LoginDto;
import com.erp.dto.UserDto;
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

    /**
     * @description 登录
     * @author xielulin
     * @date 2024/4/15
     * @param tel
     * @param password
     * @return com.erp.bean.User
     */
    LoginDto login(String tel, String password) throws BaseException;

    /**
     * @description 通过id获取用户
     * @author xielulin
     * @date 2024/4/15
     * @param id
     * @return com.erp.bean.User
     */
    User getUserById(Integer id);

    UserDto getUserDetailById(int id);
}
