package com.iu.start.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value="/qna/*")

public class QnaController {
	
	@Autowired
	QnaService qnaService;
	
	@RequestMapping(value="list.iu", method=RequestMethod.GET)
	public String list(Model model)throws Exception {
		List<QnaDTO> ar = qnaService.getList();
		model.addAttribute("qnaList", ar);
		
		return "./qna/list";
	}
	
	@RequestMapping(value="detail.iu", method=RequestMethod.GET)
	public String detail(QnaDTO qnaDTO, Model model)throws Exception {
		qnaDTO = qnaService.getDetail(qnaDTO);
		
		model.addAttribute("qnaDetail", qnaDTO);
		return "./qna/detail";
	}
	
	@RequestMapping(value="add.iu", method=RequestMethod.GET)
	public String add()throws Exception{
		
		return "./qna/add";
	}
	
	@RequestMapping(value="add.iu", method=RequestMethod.POST)
	public String add(QnaDTO qnaDTO)throws Exception{
		qnaService.add(qnaDTO);
		
		return "redirect:./list.iu";
	}
	
	@RequestMapping(value="update.iu", method=RequestMethod.GET)
	public String update(QnaDTO qnaDTO, Model model)throws Exception{
		
		model.addAttribute("updateinfo", qnaDTO);
		return "./qna/update";
	}
	
	@RequestMapping(value="update.iu", method=RequestMethod.POST)
	public String update(QnaDTO qnaDTO)throws Exception{
		
		qnaService.update(qnaDTO);
		return "redirect:./list.iu";
	}
	
	
	
	@RequestMapping(value="delete.iu", method=RequestMethod.GET)
	public String delete(QnaDTO qnaDTO)throws Exception{
		qnaService.delete(qnaDTO);
		
		return "redirect:./list.iu";
	}

}
