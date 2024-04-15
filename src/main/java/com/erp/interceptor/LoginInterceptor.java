package com.erp.interceptor;

import com.erp.bean.User;
import com.erp.constants.Constant;
import com.erp.service.UserService;
import com.erp.utils.CookieUtil;
import com.erp.utils.JwtUtil;
import com.erp.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Resource
    private UserService userService;

    //这个方法是在访问接口之前执行的，用户调用指定接口之前验证登陆状态
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String token = (String) CookieUtil.getValue(request, "Authentication");
        log.info("获取到的token, token:{}", token);
        if(token ==null){
            response.setStatus(302);
            log.warn("用户登录失效，请重新登录");
            return false;
        }
        User verify = JwtUtil.verify(token);
        if(verify == null){
            log.warn("未获取到用户信息");
            response.setStatus(302);
            return false;
        }
        if(Objects.isNull(RedisUtil.redisUtil.get(Constant.RedisConstant.TOKEN_KEY + verify.getId()))){
            response.setStatus(302);
            log.warn("用户登录失效，请重新登录");
            return false;
        }
        HttpHeaders headers = new HttpHeaders();
        User user = userService.getUserById(verify.getId());
        log.info("当前用户信息， user:{}", user);
        if(user == null) {
            log.warn("未获取到用户信息");
            response.setStatus(302);
            return false;
        }
        //token续期60min
        RedisUtil.redisUtil.expire(Constant.RedisConstant.TOKEN_KEY +user.getId(),60, TimeUnit.MINUTES);
        return true;
    }
}
