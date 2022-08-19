package com.iu.start.notice;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeDAO implements NoticeInterface{
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.iu.start.notice.NoticeDAO.";

	@Override
	public List<NoticeDTO> getlist() throws Exception {
		return sqlSession.selectList(NAMESPACE+"getList");
	}

	@Override
	public NoticeDTO getDetail(NoticeDTO noticeDTO) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int add(NoticeDTO noticeDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(NoticeDTO noticeDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(NoticeDTO noticeDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
