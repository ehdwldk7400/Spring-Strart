package org.jin.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor  extends HandlerInterceptorAdapter {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public void postHandle(HttpServletRequest request, 
							HttpServletResponse response, 
							Object handler,
							ModelAndView modelAndView) throws Exception{
		System.out.println("post handle....");
		
		HttpSession session = request.getSession();
		
		Object userVO = modelAndView.getModel().get("userVO");
		
		if(userVO != null) {
			logger.info("new login success");
			session.setAttribute("login", userVO);
			
//			if(request.getParameter("useCookie") != null) {
				Cookie loginCookie = new Cookie("loginCookie", session.getId());
				loginCookie.setPath("/");
				loginCookie.setMaxAge(60 * 60 * 24 * 7); // 초 * 분 * 초 * 일  = 7일 동안 쿠키 보관
				response.addCookie(loginCookie);
//			}
			response.sendRedirect("/jin");
		}
		
	}
	@Override
	public boolean preHandle(HttpServletRequest request, 
							HttpServletResponse response, 
							Object handler) throws Exception{
		System.out.println("post handle....");
		return true;
	}
}
