package com.iu.start.bankmembers;

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

import com.iu.start.bankAccount.BankAccountDAO;
import com.iu.start.bankAccount.BankAccountDTO;
import com.iu.start.util.fileManager;

@Service
public class BankMembersService {
	
	@Autowired
	private BankMembersDAO bankMembersDAO;
	
	@Autowired
	private fileManager fileManager;
	
//	@Autowired
//	private ServletContext servletContext;
	
//	@Autowired
//	BankAccountDAO bankAccountDAO;
	
//	public Map<String, Object> myPage(BankMembersDTO bankMembersDTO)throws Exception{
//		Map<String, Object> map = new HashMap<String, Object>();
//		List<BankAccountDTO> ar = bankAccountDAO.myPage2(bankMembersDTO);
//		bankMembersDTO = bankMembersDAO.myPage(bankMembersDTO);
//		map.put("list", ar);
//		map.put("dto", bankMembersDTO);
//		
//		return map;
//	}

	public BankMembersDTO myPage(BankMembersDTO bankMembersDTO) throws Exception{
		return bankMembersDAO.myPage(bankMembersDTO);
	}

	public BankMembersDTO getLogin(BankMembersDTO bankMembersDTO)throws Exception{
		return bankMembersDAO.getLogin(bankMembersDTO);
	}
	
	public int setJoin(BankMembersDTO bankMembersDTO, MultipartFile photo, ServletContext servletContext)throws Exception{
		
			int result = bankMembersDAO.setJoin(bankMembersDTO);
			String path = "resources/upload/member";
			
			String fileName = fileManager.saveFile(servletContext, path, photo);
			BankMembersFileDTO bankMembersFileDTO = new BankMembersFileDTO();
			bankMembersFileDTO.setFileName(fileName);
			bankMembersFileDTO.setOriName(photo.getOriginalFilename());
			bankMembersFileDTO.setUserName(bankMembersDTO.getUserName());
			bankMembersDAO.setAddFile(bankMembersFileDTO);
			
			
//		//1. HDD에 파일을 저장
//		// 파일저장시에 경로는 Tomcat 기준이 아니라 OS의 기준으로 설정
//			//1) 파일저장 위치 (/는 C:이다)
//			//	/resources/upload/member
//			//2) 저장된 폴더의 실제경로 반환(OS 기준)
//			String realPath = servletContext.getRealPath("resources/upload/member");
//			System.out.println("realpath : "+realPath);
//			
//			//3) 저장할 폴더의 정보를 가지는 자바 객체 생성
//			File file = new File(realPath);
//			
//			//*** 파일첨부가 없을때 구분
//			//if(photo.getSize()!=0) {}
//			if(!photo.isEmpty()) {
//			
//			System.out.println();
//			System.out.println(file.isDirectory());
//			System.out.println(file.exists());
//			if(!file.exists()) {
//				file.mkdirs();
//			}
//			
//			//4) 파일명 중복 방지 - 시간, 자바api
//			//java api(랜덤문자열만들어주는api) 버전
//			String fileName = UUID.randomUUID().toString();
//			System.out.println(fileName);
//			//시간(밀리세컨즈) 활용 버전
//			Calendar ca = Calendar.getInstance();
//			Long time = ca.getTimeInMillis();
//			System.out.println(time);
//			
//			fileName = fileName+"_"+photo.getOriginalFilename();
//			System.out.println(fileName);
//			
//			//5) HDD에 파일 저장
//			// 어느 폴더에 어떤 이름을 저장할 파일 객체 생성
//			file = new File(file, fileName);
//			
//			// 1} Multipartfile 클래스의 transferTo 메서드 사용
//			photo.transferTo(file);
//			
//			// 2} FilecopyUtils 클래스의 copy 메서드 사용
//			
//			
//			//2. 저장된 파일정보를 DB에 저장
//			BankMembersFileDTO bankMembersFileDTO = new BankMembersFileDTO();
//			bankMembersFileDTO.setFileName(fileName);
//			bankMembersFileDTO.setOriName(photo.getOriginalFilename());
//			bankMembersFileDTO.setUserName(bankMembersDTO.getUserName());
//			bankMembersDAO.setAddFile(bankMembersFileDTO);
//			
//			} //파일첨부가 비었나 (isempty) if절의 끝

		
		return result;
	}
	
	public List<BankMembersDTO> getSearchByID(String Search)throws Exception{
		return bankMembersDAO.getSearchByID(Search);
	}

}
