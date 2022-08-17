package com.iu.start.bankmembers;

import java.util.List;

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
		System.out.println("로그인 get실행");
	}
	
	@RequestMapping(value="login.iu", method=RequestMethod.POST)
	public String login(BankMembersDTO bankMembersDTO) throws Exception{
		System.out.println("로그인 post실행");
		bankMembersService.getLogin(bankMembersDTO);
		
		return "redirect:../";
	}
	
	@RequestMapping(value="join.iu", method=RequestMethod.GET)
	public void join() throws Exception{
		System.out.println("회원가입 get실행");
	}
	
	@RequestMapping(value="join.iu", method=RequestMethod.POST)
	public void join(BankMembersDTO bankMembersDTO) throws Exception{
		System.out.println("회원가입 post실행");
	}
	
	@RequestMapping(value="search.iu", method=RequestMethod.GET)
	public void search() throws Exception{
	}
	
	@RequestMapping(value="search.iu", method=RequestMethod.POST)
	public String  search(String search, Model model) throws Exception{
		System.out.println("search post실행");
		
		List<BankMembersDTO> ar = bankMembersService.getSearchByID(search);
		model.addAttribute("list", ar);
		return "list";
		
	}

}
