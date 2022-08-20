package com.iu.start.qna;

import java.util.List;

public interface QnaInterface {
	
	public List<QnaDTO> getList()throws Exception;

	public QnaDTO getDetail(QnaDTO qnaDTO)throws Exception;

	public int add(QnaDTO qnaDTO)throws Exception;

	public int delete(QnaDTO qnaDTO)throws Exception;

	public int update(QnaDTO qnaDTO)throws Exception;


}
