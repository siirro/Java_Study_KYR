package com.iu.start.bankBook;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.start.MyAbstractTest;
import com.iu.start.util.CommentPager;

public class BankBookCommentDAOTest extends MyAbstractTest{
	
	@Autowired
	private BankBookCommentDAO bankBookCommentDAO;

//	@Test
//	public void setAddTest() throws Exception {
//		BankBookCommentDTO bankBookCommentDTO = new BankBookCommentDTO();
//		bankBookCommentDTO.setBookNum(12L);
//		bankBookCommentDTO.setContents("dfdf");
//		bankBookCommentDTO.setWriter("NAME1");
//		
//		int result = bankBookCommentDAO.setAddComment(bankBookCommentDTO);
//		assertEquals(1, result);
//	}
	
	@Test
	public void getCommentListTest()throws Exception{
		CommentPager commentPager = new CommentPager();
		commentPager.setBookNum(12L);
		commentPager.setPage(1L);
		commentPager.getRowNum();
		List<BankBookCommentDTO> ar = bankBookCommentDAO.getCommentList(commentPager);
		assertEquals(5, ar.size());
		
		//assertNotNull(ar);
	}

}
