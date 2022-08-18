package com.iu.start.bankmembers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/member/*")
public class BankMembersController {
	
	@Autowired
	BankMembersService bankMembersService;
	
	@RequestMapping(value="login.iu", method=RequestMethod.GET)
	public void login() throws Exception{
	}
	
	@RequestMapping(value="login.iu", method=RequestMethod.POST)
	public String login(HttpServletRequest request, BankMembersDTO bankMembersDTO) throws Exception{
		System.out.println("로그인 post실행");
		bankMembersService.getLogin(bankMembersDTO);
		HttpSession session = request.getSession();
		session.setAttribute("member", bankMembersDTO);
		
		return "redirect:../";
	}
	
	@RequestMapping(value="logout.iu", method=RequestMethod.GET)
	public String logout(HttpSession session)throws Exception{
		session.invalidate();
		
		return "redirect:../";
	}
	
	@RequestMapping(value="join.iu", method=RequestMethod.GET)
	public void join() throws Exception{
	}
	
	@RequestMapping(value="join.iu", method=RequestMethod.POST)
	public String join(BankMembersDTO bankMembersDTO) throws Exception{
		System.out.println("회원가입 post실행");
		bankMembersService.setJoin(bankMembersDTO);
		
		return "redirect:./login.iu";
	}
	
	@RequestMapping(value="search.iu", method=RequestMethod.GET)
	public void search() throws Exception{
	}
	
	@RequestMapping(value="search.iu", method=RequestMethod.POST)
	public String  search(String search, Model model) throws Exception{
		System.out.println("search post실행");
		System.out.println(search);
		List<BankMembersDTO> ar = bankMembersService.getSearchByID(search);
		model.addAttribute("list", ar);
		return "member/list";
		
	}

}
