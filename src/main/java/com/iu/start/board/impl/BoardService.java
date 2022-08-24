package com.iu.start.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.iu.start.util.Pager;

public interface BoardService {
	
	public List<BoardDTO> getList(Pager pager)throws Exception;
	
	public BoardDTO getDetail(BoardDTO boardDTO)throws Exception;
	
	public int setAdd(BoardDTO boardDTO)throws Exception;
	
	public int setUpdate(BoardDTO boardDTO)throws Exception;
	
	public int setDelete(BoardDTO boardDTO)throws Exception;

}
