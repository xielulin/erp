package com.qbzz.bot.intercepors;

import com.alibaba.fastjson.JSON;
import com.qbzz.bot.exceptions.BusinessException;
import com.qbzz.bot.model.User;
import com.qbzz.bot.service.CommonService;
import com.qbzz.bot.utils.CookieUtil;
import com.qbzz.bot.utils.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@Component
public class LoginInterceptor implements HandlerInterceptor{

    private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    @Autowired
    private CommonService commonService;

    //这个方法是在访问接口之前执行的，用户调用指定接口之前验证登陆状态
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

//        User user = null;
        String requestUri = request.getRequestURI();
        String token = (String) CookieUtil.getValue(request, "Authentication");
        logger.info("获取到的token, token:{}", token);
//        user = (User) RedisUtil.get(token);
//        String s = String.valueOf(RedisUtil.get(token));
//        logger.info("获取到用户缓存信息， s:{}", s);
//        if(Objects.isNull(RedisUtil.get(token))){
//            user = null;
//        }else {
//
//            logger.info("登录信息，s:{}", s);
//            boolean valid = JSON.isValid(s);
//            if(valid){
//                user = JSON.parseObject(s, User.class);
//            }else {
//                user = (User)RedisUtil.get(token);
//            }
//        }
        if (StringUtils.isBlank(token)){
            response.setStatus(302);
            logger.warn("用户登录失效，请重新登录");
            return false;
        }
        HttpHeaders headers = new HttpHeaders();
//        headers.add("Authentication", token);
//        headers.setBearerAuth(token);
        User user = commonService.userbySession(headers, token);
        logger.info("当前用户信息， user:{}", user);
        if(user == null) {
            logger.warn("未获取到用户信息");
            response.setStatus(302);
            return false;
//            throw new BusinessException("登录信息过期，请重新登录");
        }
        return true;
    }
}
