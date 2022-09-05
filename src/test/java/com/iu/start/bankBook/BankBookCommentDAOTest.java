package com.iu.start.bankBook;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.start.MyAbstractTest;

public class BankBookCommentDAOTest extends MyAbstractTest{
	
	@Autowired
	private BankBookCommentDAO bankBookCommentDAO;

	@Test
	public void setAddTest() throws Exception {
		BankBookCommentDTO bankBookCommentDTO = new BankBookCommentDTO();
		bankBookCommentDTO.setBookNum(12L);
		bankBookCommentDTO.setContents("dsf");
		bankBookCommentDTO.setWriter("NAME1");
		
		int result = bankBookCommentDAO.setAddComment(bankBookCommentDTO);
		assertEquals(1, result);
	}

}
