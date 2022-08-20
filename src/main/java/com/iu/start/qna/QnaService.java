package com.iu.start.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QnaService {
	
	@Autowired
	QnaDAO qnaDAO;
	
	
	public List<QnaDTO> getList()throws Exception {
		return qnaDAO.getList();
	}

	public QnaDTO getDetail(QnaDTO qnaDTO)throws Exception {
		return qnaDAO.getDetail(qnaDTO);
	}

	public int add(QnaDTO qnaDTO)throws Exception {
		return qnaDAO.add(qnaDTO);
	}

	public int delete(QnaDTO qnaDTO)throws Exception {
		return qnaDAO.delete(qnaDTO);
	}

	public int update(QnaDTO qnaDTO)throws Exception {
		return qnaDAO.update(qnaDTO);
	}

}
