package com.iu.start.board.qna;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.start.MyAbstractTest;
import com.iu.start.board.impl.BoardDTO;

public class QnaTest extends MyAbstractTest{

	@Autowired
	private QnaDAO qnaDAO;
	
	@Test
	public void getListTest() throws Exception {
		BoardDTO boardDTO = new BoardDTO();
		List<BoardDTO> ar = qnaDAO.getList();
		
		assertEquals(3, ar.size());
	}
	
	@Test
	public void getDetail()throws Exception{
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setNum(2L);
		boardDTO = qnaDAO.getDetail(boardDTO);
		
		assertNotNull(boardDTO.getContents());
	}

	//setAdd 테스트성공
//	@Test
//	public void setAdd()throws Exception{
//		BoardDTO boardDTO = new BoardDTO();
//		boardDTO.setTitle("test중제목d");
//		boardDTO.setWriter("test중작성d자");
//		boardDTO.setContents("test중내d용");
//		int result = qnaDAO.setAdd(boardDTO);
//		
//		assertEquals(1, result);
//	}
	
	//setUpdate 테스트성공
//	@Test
//	public void setUpdate()throws Exception{
//		BoardDTO boardDTO = new BoardDTO();
//		boardDTO.setNum(2L);
//		boardDTO.setTitle("고치기테스트");
//		boardDTO.setContents("고치기테스트내용");
//		int result = qnaDAO.setUpdate(boardDTO);
//		assertEquals(1, result);
//	}
	
	//setDelete 테스트성공 끗
	@Test
	public void setDelete()throws Exception{
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setNum(42L);
		
		int result = qnaDAO.setDelete(boardDTO);
		assertEquals(1, result);
	}
}
