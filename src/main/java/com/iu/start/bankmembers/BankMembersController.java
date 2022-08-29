package com.iu.start.bankmembers;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.start.bankAccount.BankAccountDAO;
import com.iu.start.bankAccount.BankAccountDTO;
import com.iu.start.bankAccount.BankAccountService;

@Controller
@RequestMapping(value="/member/*")
public class BankMembersController {
	
	@Autowired
	BankMembersService bankMembersService;
	@Autowired
	BankAccountService bankAccountService;
	
	//@RequestMapping(value="mypage.iu", method=RequestMethod.GET)
//	public String myPage(BankMembersDTO bankMembersDTO, BankAccountDTO bankAccountDTO, Model model)throws Exception{
//		bankMembersDTO = bankMembersService.myPage(bankMembersDTO);
//		System.out.println(bankMembersDTO.getEmail());
//		model.addAttribute("mypage77", bankMembersDTO);
//		
//		List<BankAccountDTO> ar = bankMembersService.myPage2(bankAccountDTO);
//		model.addAttribute("mypage2", ar);
//		return "member/mypage";
//		
//	}
	
	@RequestMapping(value="mypage.iu", method=RequestMethod.GET)
	public ModelAndView myPage(HttpSession session)throws Exception{
		ModelAndView mv = new ModelAndView();
		BankMembersDTO bankMembersDTO = (BankMembersDTO)session.getAttribute("member");
		
		//방법1- map사용
//		Map<String, Object> map = bankMembersService.myPage(bankMembersDTO);
//		mv.addObject("mypageMap", map);
		//방법2- 멤버/북+어카운트 조인쿼리 만들기
//		List<BankAccountDTO> ar = bankAccountService.myPage2(bankMembersDTO);
//		mv.addObject("list", ar);
		
		bankMembersDTO = bankMembersService.myPage(bankMembersDTO);
		

		
		mv.addObject("dto", bankMembersDTO);
		
		mv.setViewName("member/mypage");
		return mv;
	}
	
	public void myPage2(HttpSession session)throws Exception{
		BankMembersDTO bankMembersDTO = (BankMembersDTO)session.getAttribute("member");
		List<BankAccountDTO> ar = bankAccountService.myPage2(bankMembersDTO);
		bankAccountService.myPage2(bankMembersDTO);
	}
	
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
	public String join(BankMembersDTO bankMembersDTO, MultipartFile photo, HttpSession session) throws Exception{
		System.out.println("회원가입 post실행");
		System.out.println(photo);
		
		System.out.println("upload 파일명 : "+photo.getOriginalFilename());
		System.out.println("upload 파라미터명 : "+photo.getName());
		System.out.println("upload하는 파일의 크기 : "+photo.getSize());
		
		int result = bankMembersService.setJoin(bankMembersDTO, photo, session.getServletContext());

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
