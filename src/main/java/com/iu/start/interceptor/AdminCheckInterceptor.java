package com.iu.start.interceptor;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.iu.start.bankmembers.BankMembersDTO;
import com.iu.start.bankmembers.RoleDTO;

public class AdminCheckInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		//1. 반복문돌려서 rolename 프린트
		BankMembersDTO bankMembersDTO = (BankMembersDTO)request.getSession().getAttribute("member");
		
		boolean check=false;
		
		for(RoleDTO roleDTO:bankMembersDTO.getRoleDTOs()) {
			System.out.println(roleDTO.getRoleName());
			if(roleDTO.getRoleName().equals("admin")) {
				check = true;
				break;
			}
		}
		
		if(!check) {
			request.setAttribute("message", "권한이 없습니다");
			request.setAttribute("url", "../../../../../");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp");
			view.forward(request, response);
			
		}
		
		return check;
		
		
	}

}
