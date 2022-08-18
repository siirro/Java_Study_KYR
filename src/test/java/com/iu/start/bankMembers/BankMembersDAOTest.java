package com.iu.start.bankMembers;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.start.MyAbstractTest;
import com.iu.start.bankBook.BankBookDTO;
import com.iu.start.bankmembers.BankMembersDAO;
import com.iu.start.bankmembers.BankMembersDTO;

public class BankMembersDAOTest extends MyAbstractTest{
	
	@Autowired
	private BankMembersDAO bankMembersDAO;
	
//	@Autowired
//	private BankMembersDTO bankMembersDTO;

	@Test
	public void setJoinTest()throws Exception {
		BankMembersDTO bankMembersDTO = new BankMembersDTO();
		bankMembersDTO.setUserName("i54345d");
		bankMembersDTO.setPassword("iddd");
		bankMembersDTO.setName("iddd");
		bankMembersDTO.setEmail("iddd");
		bankMembersDTO.setPhone("iddd");

		int result = bankMembersDAO.setJoin(bankMembersDTO);
		assertEquals(1, result);
		
		Calendar car = Calendar.getInstance();
		System.out.println(car.getTime());
	}
//	
//	@Test
//	public void getLoginTest()throws Exception {
//		BankMembersDTO bankMembersDTO = new BankMembersDTO();
//		bankMembersDTO.setUserName("iddd");
//		bankMembersDTO.setPassword("iddd");
//		bankMembersDTO.setName("iddd");
//		bankMembersDTO.setEmail("iddd");
//		bankMembersDTO.setPhone("iddd");
//		Object obj = bankMembersDAO.getLogin(bankMembersDTO);
//		assertNotNull(obj);
//	}

}
