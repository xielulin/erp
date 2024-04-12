package com.erp.service.Impl;

import com.erp.bean.User;
import com.erp.dao.UserMapper;
import com.erp.exception.BaseException;
import com.erp.exception.EmBussinessError;
import com.erp.service.UserService;
import com.erp.utils.MD5;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author xielulin
 * @create 2024-03-27 21:09
 * @desc 用户service类
 **/
@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;
    @Override
    public User getUserByTelAndPwd(String tel, String pwd) throws BaseException {
        User user = userMapper.selectByTel(tel);
        if(user == null){
            throw new BaseException(EmBussinessError.USER_NOT_EXIT);
        }
        if(user.getIsValid()!= true)
        {
            throw new BaseException(EmBussinessError.USER_NOT_VALID);
        }
        String encryptPwd = MD5.md5(pwd);
        if(!user.getPassword().equals(encryptPwd)){
            throw new BaseException(EmBussinessError.LOGIN_FAIL_ERROR);
        }else {
            return user;
        }

    }
}
