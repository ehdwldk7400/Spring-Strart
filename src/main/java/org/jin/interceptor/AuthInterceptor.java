package org.jin.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter{
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler) throws Exception{
		
		// Session을 설정하고,
		HttpSession session = request.getSession();
		
		// session에 로그읜 정보가 없으면
		if(session.getAttribute("login") == null) {
			// 글쓰기 권한이 없으므로 로그인을 할 수 ㅇ 있는 펭지로 이동.
			response.sendRedirect("/member/lgoin");
			return false;
		}
		
		return true;
	}
}
