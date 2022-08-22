package com.iu.start.bankmembers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.start.bankAccount.BankAccountDAO;
import com.iu.start.bankAccount.BankAccountDTO;

@Service
public class BankMembersService {
	
	@Autowired
	BankMembersDAO bankMembersDAO;
//	@Autowired
//	BankAccountDAO bankAccountDAO;
	
//	public Map<String, Object> myPage(BankMembersDTO bankMembersDTO)throws Exception{
//		Map<String, Object> map = new HashMap<String, Object>();
//		List<BankAccountDTO> ar = bankAccountDAO.myPage2(bankMembersDTO);
//		bankMembersDTO = bankMembersDAO.myPage(bankMembersDTO);
//		map.put("list", ar);
//		map.put("dto", bankMembersDTO);
//		
//		return map;
//	}

	public BankMembersDTO myPage(BankMembersDTO bankMembersDTO) throws Exception{
		return bankMembersDAO.myPage(bankMembersDTO);
	}

	public BankMembersDTO getLogin(BankMembersDTO bankMembersDTO)throws Exception{
		return bankMembersDAO.getLogin(bankMembersDTO);
	}
	
	public int setJoin(BankMembersDTO bankMembersDTO)throws Exception{
		return bankMembersDAO.setJoin(bankMembersDTO);
	}
	
	public List<BankMembersDTO> getSearchByID(String Search)throws Exception{
		return bankMembersDAO.getSearchByID(Search);
	}

}
