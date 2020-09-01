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
		
		// Session�� �����ϰ�,
		HttpSession session = request.getSession();
		
		// session�� �α��� ������ ������
		if(session.getAttribute("login") == null) {
			// �۾��� ������ �����Ƿ� �α����� �� �� �� �ִ� ������ �̵�.
			response.sendRedirect("/member/lgoin");
			return false;
		}
		
		return true;
	}
}
