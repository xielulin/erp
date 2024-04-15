package com.erp.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.erp.bean.User;
import lombok.extern.slf4j.Slf4j;

/**
 * @author xielulin
 * @create 2024-04-15 10:37
 * @desc token工具类
 **/
@Slf4j
public class JwtUtil {
    /**
     * 使用固定的解密秘钥
     */
    private static final String SECRET = "nfkjawleiaasdjf";

    /**
     * @version: V1.0
     * @description: 生成token并验证token并解密token中的信息
     * @param:  userInfo 用户手机号和用户Id
     * @return: java.lang.String 返回token
     **/
    public static String getToken(User userInfo) {
        try{
            //用秘钥生成签名
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            //默认头部+载荷（手机号/id）+签名=jwt
            String jwtToken= JWT.create()
                    .withClaim("userTel", userInfo.getTel())
                    .withClaim("userId", userInfo.getId())
                    .sign(algorithm);
            log.info("用户{}的token生成成功：{}",userInfo.getId(),jwtToken);
            return jwtToken;
        }catch (Exception e){
            log.error("用户{}的token生成异常：{}",userInfo.getId(),e);
            return null;
        }
    }

    /**
     * @version: V1.0
     * @description: 校验token是否正确
     * @param:  token
     * @param: userPhone
     * @return: UserInfoEntity token中的用户信息(姓名/id)
     **/
    public static User verify(String token) {
        try {
            // 根据用户信息userInfo生成JWT效验器
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            JWTVerifier verifier = JWT.require(algorithm)
                    .build();
            // 效验TOKEN
            verifier.verify(token);
            log.info("token：{}校验成功成功",token);
            //返回token内容
            return getTokenInfo(token);
        } catch (Exception exception) {
            log.error("token校验异常：{}",exception);
            return null;
        }
    }

    /**
     * @version: V1.0
     * @Title: getUsername
     * @description: 从Token中解密获得Token中的用户信息
     * @param:  token
     * @return: UserInfoEntity token中的用户信息(姓名/id)
     **/
    private static User getTokenInfo(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            User userInfo=new User();
            userInfo.setTel(jwt.getClaim("userTel").asString());
            userInfo.setId(jwt.getClaim("userId").asInt());
            log.info("用户{}从token获取用户信息成功",userInfo);
            return userInfo;
        } catch (JWTDecodeException e) {
            log.error("从token：{}获取用户信息异常：{}",token,e);
            return null;
        }
    }
}