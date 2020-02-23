package com.note.interceptor;

 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class LoginInterceptor implements HandlerInterceptor{

 
	/**
	 * Handlerִ�����֮������������
	 */
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception exc)
			throws Exception {
			//System.out.println("afterCompletion run!");
	}


	/**
	 * Handlerִ��֮��ModelAndView����֮ǰ�����������
	 */

	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler, ModelAndView modelAndView) throws Exception {
			//System.out.println("postHandle run!");
	}

 

	/**
	 * Handlerִ��֮ǰ�����������
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		//System.out.println("preHandle run!");
		return true;
	}
}

