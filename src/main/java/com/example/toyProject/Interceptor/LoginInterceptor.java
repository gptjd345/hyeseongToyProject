package com.example.toyProject.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		//로그인 여부 확인 
		//로그인 성공시 이름을 세션에 저장했기 때문에 이름 확인한다.  
		if(session.getAttribute("name") != null)
		{
			System.out.println("Intercep: "+session.getAttribute("name"));
			return true; //메인 액션 실행가능
		}
		else {
			// 로그인 페이지 요청을 수행한다. 
			response.sendRedirect(request.getContextPath() + "/member/login.do");
			return false; //메인 액션 실행 불가능
		}
		
	}
		
	
}
