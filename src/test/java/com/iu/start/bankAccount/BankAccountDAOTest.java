package com.iu.start.bankAccount;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.start.MyAbstractTest;
import com.iu.start.bankmembers.BankMembersDTO;

public class BankAccountDAOTest extends MyAbstractTest{
	@Autowired
	BankAccountDAO bankAccountDAO;

	@Test
	public void myPage2()throws Exception {
		BankMembersDTO bankMembersDTO = new BankMembersDTO();
		bankMembersDTO.setUserName("NAME1");
		List<BankAccountDTO> ar = bankAccountDAO.myPage2(bankMembersDTO);
		assertNotEquals(0, ar.size());
	}

}
