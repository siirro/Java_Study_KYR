package com.iu.start.qna;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.start.notice.NoticeDTO;

@Repository
public class QnaDAO implements QnaInterface{
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.iu.start.qna.QnaDAO.";

	@Override
	public List<QnaDTO> getList() throws Exception {
		return sqlSession.selectList(NAMESPACE+"getList");
	}

	@Override
	public QnaDTO getDetail(QnaDTO qnaDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"getDetail", qnaDTO);
	}

	@Override
	public int add(QnaDTO qnaDTO) throws Exception {
		return sqlSession.insert(NAMESPACE+"addQna", qnaDTO);
	}

	@Override
	public int delete(QnaDTO qnaDTO) throws Exception {
		return sqlSession.delete(NAMESPACE+"deleteQna", qnaDTO);
	}

	@Override
	public int update(QnaDTO qnaDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"updateQna", qnaDTO);
	}

}
