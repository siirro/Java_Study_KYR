package com.iu.start.bankAccount;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.start.bankBook.BankBookDTO;
import com.iu.start.bankmembers.BankMembersDTO;

@Controller
@RequestMapping(value = "/bankAccount/*")
public class BankAccountController {
	
	@Autowired
	private BankAccountService bankAccountService;
	

	
	@RequestMapping(value = "add.iu", method = RequestMethod.GET)
	public String add(Model model, BankBookDTO bankBookDTO) {
		model.addAttribute("addinfo", bankBookDTO);
		return "bankAccount/add";
	
	}
	
	@RequestMapping(value = "add.iu", method = RequestMethod.POST)
	public String add(BankBookDTO bankBookDTO, BankAccountDTO bankAccountDTO, HttpSession Session) throws Exception {
		
		BankMembersDTO bankMembersDTO = (BankMembersDTO)Session.getAttribute("member");
		

		
		bankAccountDTO.setUserName(bankMembersDTO.getUserName());
		bankAccountDTO.setBookNum(bankBookDTO.getBookNum());
		
		
		bankAccountService.add(bankAccountDTO);
		return "redirect:../bankbook/list.iu";
	}
}