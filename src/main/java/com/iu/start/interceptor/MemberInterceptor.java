package com.iu.start.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.iu.start.bankmembers.BankMembersDAO;

public class MemberInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	private BankMembersDAO bankMembersDAO;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("member");
		
		System.out.println(bankMembersDAO);
		if(obj != null) {
			System.out.println("로그인 했음");
			return true;
		}else {
			System.out.println("로그인 안함");
			response.sendRedirect("../../../../../../../member/login.iu");
			return false;
		}
		
		
	}
	
	

}
