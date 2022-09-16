package com.iu.start.util;

import java.io.File;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.iu.start.file.FileDTO;

@Component
public class fileManager {
	
//	@Autowired
//	private ServletContext servletContext;
	
	//서블릿컨텍스트 끌어오는법
	//1. 위에 오토와이어드로 걸어놓기
	//2. 메서드의 매개변수로 선언해주기
	
	//delete
	public boolean deleteFile(ServletContext servletContext, String path, FileDTO fileDTO)throws Exception{
		String realPath = servletContext.getRealPath(path);
		System.out.println("realpath : "+realPath);
		File file = new File(realPath, fileDTO.getFileName());
		
		return file.delete();
	}
	
	
	//save
	public String saveFile(ServletContext servletContext, String path, MultipartFile multipartFile)throws Exception{
		//1. 저장할 폴더의 실제경로를 반환합니다.
		String realPath = servletContext.getRealPath(path);
		System.out.println("realpath : "+realPath);
		
		//2. 폴더(directory) 체크
		File file = new File(realPath);
		if(!file.exists()) {
			file.mkdirs();
		}
		
		//3. 저장할 파일명 생성
		String fileName = UUID.randomUUID().toString();
		fileName = fileName+"_"+multipartFile.getOriginalFilename();
		
		//4. HDD에 저장
		file = new File(file, fileName);
		multipartFile.transferTo(file);
		
		return fileName;
	}

}
