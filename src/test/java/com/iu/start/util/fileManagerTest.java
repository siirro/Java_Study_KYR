package com.iu.start.util;

import static org.junit.Assert.*;

import javax.servlet.ServletContext;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.iu.start.MyAbstractTest;

public class fileManagerTest extends MyAbstractTest{
	
	//@Autowired
	private fileManager fileManager;

	@Test
	public void test(MultipartFile photo, ServletContext servletContext) throws Exception {
		
		
		fileManager.saveFile(servletContext, "resources/upload/test",photo);
		System.out.println("finish---");
	}

}
