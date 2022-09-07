package com.iu.start.bankBook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.start.util.CommentPager;

@Service
public class BankBookService {
	

	//--------------------COMMENT------------------------
	@Autowired
	private BankBookCommentDAO bankBookCommentDAO;
	
	public int setUpdateComment(BankBookCommentDTO bankBookCommentDTO)throws Exception{
		return bankBookCommentDAO.setUpdateComment(bankBookCommentDTO);
	}
	
	public int setDeleteComment(BankBookCommentDTO bankBookCommentDTO)throws Exception{
		return bankBookCommentDAO.setDeleteComment(bankBookCommentDTO);
	}
	
	public List<BankBookCommentDTO> getCommentList(CommentPager commentPager)throws Exception{
		commentPager.getRowNum();
		Long totalCount = bankBookCommentDAO.getCommentListTotalCount(commentPager);
		commentPager.makePage(totalCount);
		return bankBookCommentDAO.getCommentList(commentPager);
	}
	
	public int setAddComment(BankBookCommentDTO bankBookCommentDTO)throws Exception{
		return bankBookCommentDAO.setAddComment(bankBookCommentDTO);
	}
	
	//---------------------------------------------------
	@Autowired
	private BankBookDAO bankBookDAO;
	
	public int setBankBook(BankBookDTO bankBookDTO) throws Exception{
		return bankBookDAO.setBankbook(bankBookDTO);
	}
	
	public List<BankBookDTO> getList() throws Exception{
		return bankBookDAO.getList();
	}
	
	public int setChangeSale(BankBookDTO bankBookDTO) throws Exception{
		return bankBookDAO.setChangeSale(bankBookDTO);
	}
	
	public BankBookDTO getDetail(BankBookDTO bankBookDTO) throws Exception{
		return bankBookDAO.getDetail(bankBookDTO);
	}
	
	public int setUpdate(BankBookDTO bankBookDTO) throws Exception {
	     return bankBookDAO.setUpdate(bankBookDTO);
	}
	
	public int setDelete(BankBookDTO bankBookDTO) throws Exception {
		return bankBookDAO.setDelete(bankBookDTO);
	}
	
	}


