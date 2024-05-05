package com.erp.service.Impl;

import com.erp.bean.Company;
import com.erp.bean.User;
import com.erp.constants.Constant;
import com.erp.dao.CompanyMapper;
import com.erp.dao.UserMapper;
import com.erp.dto.LoginDto;
import com.erp.dto.UserDto;
import com.erp.exception.BaseException;
import com.erp.exception.EmBussinessError;
import com.erp.param.EditUserParam;
import com.erp.service.UserService;
import com.erp.utils.JwtUtil;
import com.erp.utils.MD5;
import com.erp.utils.RedisUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author xielulin
 * @create 2024-03-27 21:09
 * @desc 用户service类
 **/
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private CompanyMapper companyMapper;
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

    @Override
    public LoginDto login(String tel, String password) throws BaseException {
        User user = getUserByTelAndPwd(tel, password);
        String token = JwtUtil.getToken(user);
        RedisUtil.redisUtil.set(Constant.RedisConstant.TOKEN_KEY +user.getId(),token);
        RedisUtil.redisUtil.expire(Constant.RedisConstant.TOKEN_KEY +user.getId(),60, TimeUnit.MINUTES);
        LoginDto loginDto = new LoginDto();
        loginDto.setToken(token);
        loginDto.setUserId(user.getId());
        loginDto.setUserName(user.getName());
        return loginDto;
    }

    @Override
    public User getUserById(Integer id) throws BaseException {
        User user = userMapper.selectByPrimaryKey(id);
        if(user == null){
            throw new BaseException(EmBussinessError.USER_NOT_EXIT);
        }
        return user;
    }

    @Override
    public UserDto getUserDetailById(int id) throws BaseException {
        User user = getUserById(id);
        if(user == null){
            return null;
        }
        UserDto userDto = new UserDto();
        Company company = companyMapper.selectByPrimaryKey(user.getComId());
        if(company != null){
            userDto.setComName(company.getComName());
        }
        BeanUtils.copyProperties(user,userDto);
        return userDto;
    }

    @Override
    public UserDto editUserDetail(EditUserParam param) {
        User user = new User();
        BeanUtils.copyProperties(param,user);
        userMapper.updateByPrimaryKeySelective(user);
        Company company = companyMapper.selectByPrimaryKey(user.getId());
        company.setComName(param.getComName());
        companyMapper.updateByPrimaryKey(company);
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(param,userDto);
        return userDto;
    }

}
