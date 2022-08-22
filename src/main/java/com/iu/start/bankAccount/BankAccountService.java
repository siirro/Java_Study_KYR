package com.iu.start.bankAccount;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.start.bankmembers.BankMembersDTO;

@Service
public class BankAccountService {
	
	@Autowired 
	BankAccountDAO bankAccountDAO;
	
	public int add(BankAccountDTO bankAccountDTO) throws Exception{
		return bankAccountDAO.add(bankAccountDTO);
	}
	
	public List<BankAccountDTO> myPage2(BankMembersDTO bankMembersDTO) throws Exception{
		return bankAccountDAO.myPage2(bankMembersDTO);
	}

}
