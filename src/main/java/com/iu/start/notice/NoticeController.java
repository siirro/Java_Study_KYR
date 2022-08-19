package com.iu.start.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/notice/*")
public class NoticeController {
	
	@Autowired
	NoticeDAO noticeDAO;
	
	@RequestMapping(value="list.iu", method=RequestMethod.GET)
	public String list(Model model)throws Exception {
		List<NoticeDTO> ar = noticeDAO.getlist();
		model.addAttribute("list", ar);
		
		return "./notice/list";
	}

}
