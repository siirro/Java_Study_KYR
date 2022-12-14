package com.iu.start.board.impl;

import java.util.List;
import java.util.Map;

import com.iu.start.board.qna.QnaDTO;
import com.iu.start.util.Pager;

public interface BoardDAO {
	
	//인터페이스 - public abstract 생략 가능
	
	public BoardFileDTO getFileDetail(BoardFileDTO boardFileDTO)throws Exception;
	
	public int setFileDelete(BoardFileDTO boardFileDTO)throws Exception;
	
	public int setAddFile(BoardFileDTO boardFileDTO)throws Exception;
	
	//글목록
	public List<BoardDTO> getList(Pager pager)throws Exception;
	
	//글상세보기
	public BoardDTO getDetail(BoardDTO boardDTO)throws Exception;
	
	//글쓰기
	public int setAdd(BoardDTO boardDTO)throws Exception;
	
	//글수정
	public int setUpdate(BoardDTO boardDTO)throws Exception;
	
	//글삭제
	public int setDelete(BoardDTO boardDTO)throws Exception;
	
	//카운트
	public Long getCount(Pager pager)throws Exception;
	
	
	
	
}
