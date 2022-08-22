package com.iu.start.bankmembers;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.start.bankAccount.BankAccountDTO;

@Repository
public class BankMembersDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.iu.start.bankmembers.BankMembersDAO.";
	
	public BankMembersDTO myPage(BankMembersDTO bankMembersDTO)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"myPage", bankMembersDTO); 
	}

	public BankMembersDTO getLogin(BankMembersDTO bankMembersDTO)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getLogin", bankMembersDTO);
	}
	
	public int setJoin(BankMembersDTO bankMembersDTO)throws Exception{
		return sqlSession.insert(NAMESPACE+"setJoin", bankMembersDTO);
	}
	
	public List<BankMembersDTO> getSearchByID(String search)throws Exception{
		//return sqlSession.selectList(NAMESPACE+"getSearchByID", search);
		sqlSession.selectList(NAMESPACE+"getSearchByID", search);
		return sqlSession.selectList(NAMESPACE+"getSearchByID", search);
		
	}

	
}
