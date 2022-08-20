package com.iu.start.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/notice/*")
public class NoticeController {
	
	@Autowired
	NoticeService noticeService;
	
	@RequestMapping(value="list.iu", method=RequestMethod.GET)
	public String list(Model model)throws Exception {
		List<NoticeDTO> ar = noticeService.getList();
		model.addAttribute("noticeList", ar);
		
		return "./notice/list";
	}
	
	@RequestMapping(value="detail.iu", method=RequestMethod.GET)
	public String detail(NoticeDTO noticeDTO, Model model)throws Exception {
		noticeDTO = noticeService.getDetail(noticeDTO);
		
		model.addAttribute("noticeDetail", noticeDTO);
		return "./notice/detail";
	}
	
	@RequestMapping(value="add.iu", method=RequestMethod.GET)
	public String add()throws Exception{
		//noticeService.add(noticeDTO);
		
		return "./notice/add";
	}
	
	@RequestMapping(value="add.iu", method=RequestMethod.POST)
	public String add(NoticeDTO noticeDTO)throws Exception{
		noticeService.add(noticeDTO);
		
		return "redirect:./list.iu";
	}
	
	@RequestMapping(value="update.iu", method=RequestMethod.GET)
	public String update(NoticeDTO noticeDTO, Model model)throws Exception{
		
		model.addAttribute("updateinfo", noticeDTO);
		return "./notice/update";
	}
	
	@RequestMapping(value="update.iu", method=RequestMethod.POST)
	public String update(NoticeDTO noticeDTO)throws Exception{
		
		noticeService.update(noticeDTO);
		return "redirect:./list.iu";
	}
	
	
	
	@RequestMapping(value="delete.iu", method=RequestMethod.GET)
	public String delete(NoticeDTO noticeDTO)throws Exception{
		noticeService.delete(noticeDTO);
		
		return "redirect:./list.iu";
	}

}
