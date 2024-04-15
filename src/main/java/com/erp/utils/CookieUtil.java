package com.qbzz.bot.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {

    private static final Logger logger = LoggerFactory.getLogger(CookieUtil.class);

	/**
	 * Cookie删除
	 * 
	 * @param request 请求头
	 * @param reponse 响应头
	 * @param key	需要删除的key
	 * @return
	 */
	public static boolean rmCookie(HttpServletRequest request , 
			HttpServletResponse reponse , String key) {
		Cookie ck = null;
		//当key或者request为空时，直接返回false
		if("".equals(key) && key == null
				&& request == null) {
			return false;
		}
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if(key.equals(cookie.getName())) {
				ck = cookie;
			}
		}
		
		if(ck != null) {
			//将获取到的Cookie设置时间为0，并加入响应头
			ck.setMaxAge(0);
			reponse.addCookie(ck);
		}
		return true;
	}
	
	/**
	 * 根据Cookie的Key获取值
	 * 
	 * @param request 请求头
	 * @param key  	  需要查询Cookie的Key
	 * @return		 返回Cookie的Value
	 */
	public static String getValue(HttpServletRequest request , String key) {
		
		String obj = null;
		//当key或request为null时，直接返回null;
		if("".equals(key) || key == null
				|| request == null) {
			return null;
		}
		Cookie[] cookies = request.getCookies();
		if(cookies == null) {
			return null;
		}
		for (Cookie cookie : cookies) {
			if(key.equals(cookie.getName())) {
				obj = cookie.getValue();
			}
		}
		return obj;
	}
	
	
	public static <T> T getUserInfo(HttpServletRequest request, Class<T> responseType){
		Object value = getValue(request,"Authentication");
        logger.info("Authentication值为，value:{}", value);
		@SuppressWarnings("unchecked")
		T  obj = (T)RedisUtil.get(value);
		return obj;
	}
}
