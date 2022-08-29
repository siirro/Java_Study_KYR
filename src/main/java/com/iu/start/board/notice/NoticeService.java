package com.iu.start.board.notice;

import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.start.board.impl.BoardDTO;
import com.iu.start.board.impl.BoardFileDTO;
import com.iu.start.board.impl.BoardService;
import com.iu.start.util.Pager;
import com.iu.start.util.fileManager;

@Service
public class NoticeService implements BoardService{

	@Autowired
	private NoticeDAO noticeDAO;

	@Autowired
	private fileManager fileManager;
	
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		Long totalCount = noticeDAO.getCount(pager);
		pager.getNum(totalCount);
		pager.getRowNum();
		
		
		
		
		// TODO Auto-generated method stub
//		System.out.println("service page"+page);
//		Long perPage = 10L; //한페이지에 출력할 목록의 개수
//		// page			startRow		lastRow
//		// 1			1				10
//		// 2			11				20
//		// 3			21				30
//		Long startRow = (page-1)*perPage+1;
//		Long lastRow = page*perPage;
//		
//		System.out.println("startRow : "+startRow);
//		System.out.println("lastRow : "+lastRow);
//		Map<String, Long> map = new HashMap<String, Long>();
//		map.put("startRow", startRow);
//		map.put("lastRow", lastRow);
//		
//		/************************
//		 
//		 * JSP에 페이지번호를 출력 1 - ?
//		 * 1. 글의 총 갯수
//		 * 2. 총 페이지 수 구하기
//		 * 3. totalBlock 갯수 구하기
//		 * Block	: 
//		 * perBlock : 한페이지에 출력할 번호의 수
//		 * 4. page로 현재 Block 번호 찾기
//		 * page				curBlock
//		 * 1				1
//		 * 2				1
//		 * 3				1
//		 * 4				1
//		 * 5				1
//		 * 6				2
//		 * 10				2
//		 * 11				3
//		 * 
//		 * 5. curBlcok으로 시작번호와 끝번호 알아오기
//		 * Block
//		 * curBlock		startNum	lastNum
//		 * 1			1			5
//		 * 2			6			10
//		 * 3			11 			15
//		 */
//		
//		
//		//1
//		Long totalCount = noticeDAO.getCount();
//		
//		//2
//		Long totalPage = totalCount/perPage;
//		if(totalCount%perPage!=0) {
//			totalPage += 1;
//		}
//		
//		System.out.println("totalCount"+totalCount);
//		System.out.println("totalPage"+totalPage);
//		
//		//3
//		Long perBlock=5L;
//		Long totalBlock = totalPage/perBlock;
//		if(totalPage%perBlock!=0) {
//			totalBlock += 1;
//		}
//		
//		System.out.println("전체페이지블럭"+totalBlock);
//		
//		//4
//		Long curBlock = page/perBlock;
//		if(page%perBlock!=0) {
//			curBlock +=1;
//		}
//		
//		System.out.println("현재페이지블럭"+curBlock);
//		
//		//5
//		Long startNum = curBlock*perBlock-(perBlock-1) ;
//		Long lastNum = curBlock*perBlock;
//		
//		
		return noticeDAO.getList(pager);
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.getDetail(boardDTO);
	}

	@Override
	public int setAdd(BoardDTO boardDTO, MultipartFile [] files, ServletContext servletContext) throws Exception {
		int result = noticeDAO.setAdd(boardDTO);
		String path="resources/upload/notice";
		
		for(MultipartFile f : files) {
			if(f.isEmpty()) {
				continue;
			}
			
			String fileName = fileManager.saveFile(servletContext, path, f);
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			boardFileDTO.setFileName(fileName);
			boardFileDTO.setOriName(f.getOriginalFilename());
			boardFileDTO.setNum(boardDTO.getNum());
			noticeDAO.setAddFile(boardFileDTO);
		}
		
		//다중파일버전
//		String realPath = servletContext.getRealPath("resources/upload/notice");
//		
//		File file = new File(realPath);
//
//		if(!file.exists()) {
//			file.mkdirs();
//		}

//		for(MultipartFile f : files) {
//			
//			if(f.isEmpty()) {
//				continue;
//			}
//			
//			//정석 방법 1번@@
//			//File file = new File(realPath);
//
//			
//			String fileName = UUID.randomUUID().toString();
//			fileName = fileName+"_"+f.getOriginalFilename();
//			System.out.println(fileName);
//
//			//이거는 에러방법!!!
//			//file = new File(file, fileName) 폴더, 파일명
//			//f.transferTo(file); //일케하면 파일명 중첩되서 에러뜸
//			
//			
//			//정석 방법2번!
////			File dest = new File(file, fileName); 
////			f.transferTo(dest); //
//			
//			
//			f.transferTo(new File(file, fileName));
//			
//			BoardFileDTO boardFileDTO = new BoardFileDTO();
//			boardFileDTO.setFileName(fileName);
//			boardFileDTO.setOriName(f.getOriginalFilename());
//			boardFileDTO.setNum(boardDTO.getNum());
//			System.out.println(boardDTO.getNum());
//			noticeDAO.setAddFile(boardFileDTO);
//
//		}
//		
		return result;
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.setUpdate(boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.setDelete(boardDTO);
	}

}
