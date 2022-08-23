package com.iu.start.board.notice;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.start.MyAbstractTest;
import com.iu.start.board.impl.BoardDAO;
import com.iu.start.board.impl.BoardDTO;

public class NoticeTest extends MyAbstractTest{
	
	@Autowired
	private NoticeDAO noticeDAO;

	//getList테스트 성공
	@Test
	public void test() throws Exception {
		List<BoardDTO> ar = noticeDAO.getList();
		assertNotEquals(0, ar.size());
		
	}
	
	//getDetail테스트 실패..그리고 해결법(실제 디비에 있는 넘을 넣어야함) 이제 성공
//	@Test
//	public void detailTest()throws Exception{
//		BoardDTO boardDTO = new BoardDTO();
//		boardDTO.setNum(1L);
//
//		
//		boardDTO = noticeDAO.getDetail(boardDTO);
//		
//		assertNotNull(boardDTO.getTitle());
//	}
	
	//setAdd테스트
//	@Test
//	public void setAddTest() throws Exception {
//		BoardDTO boardDTO = new BoardDTO();
//		boardDTO.setWriter("sdsf");
//		boardDTO.setTitle("gd");
//		boardDTO.setContents("sdfsdf");
//		int result = noticeDAO.setAdd(boardDTO);
//		assertEquals(1, result);
//	}
	
	//setUpdate테스트
//	@Test
//	public void updateTest()throws Exception{
//		BoardDTO boardDTO = new BoardDTO();
//		boardDTO.setNum(1L);
//		boardDTO.setTitle("하이루");
//		boardDTO.setContents("하이루로바꿨어요");
//		
//		int result = noticeDAO.setUpdate(boardDTO);
//		assertEquals(1, result);
//	}
	
	
	
	
//	public void deleteTest()throws Exception{
//		BoardDTO boardDTO = new BoardDTO();
//		boardDTO.setNum(23L);
//		
//		int result = noticeDAO.setDelete(boardDTO);
//		assertEquals(1, result);
//	}

}
