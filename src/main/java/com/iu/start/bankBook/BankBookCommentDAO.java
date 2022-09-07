package com.iu.start.bankBook;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.start.util.CommentPager;

@Repository
public class BankBookCommentDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.iu.start.bankBook.BankBookCommentDAO.";
	
	public int setUpdateComment(BankBookCommentDTO bankBookCommentDTO)throws Exception{
		return sqlSession.update(NAMESPACE+"setUpdateComment", bankBookCommentDTO);
	}
	
	public int setDeleteComment(BankBookCommentDTO bankBookCommentDTO)throws Exception{
		return sqlSession.delete(NAMESPACE+"setDeleteComment", bankBookCommentDTO);
	}
	
	public Long getCommentListTotalCount(CommentPager commentPager)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getCommentListTotalCount", commentPager);
	}
	
	public int setAddComment(BankBookCommentDTO bankBookCommentDTO)throws Exception{
		return sqlSession.insert(NAMESPACE+"setAddComment", bankBookCommentDTO);
	}
	
	public List<BankBookCommentDTO> getCommentList(CommentPager commentPager)throws Exception{
		return sqlSession.selectList(NAMESPACE+"getCommentList", commentPager);
	}

}
