package com.iu.start.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.start.board.impl.BoardDTO;

@Controller
@RequestMapping("/qna/*")
public class QnaController {

	@Autowired
	private QnaService qnaService;
	
	@RequestMapping(value="list.iu",method=RequestMethod.GET)
	public String getList(Model model)throws Exception {
		List<BoardDTO> ar = qnaService.getList();
		model.addAttribute("list", ar);
		
		return "qna/list";
	}
	
	@RequestMapping(value="detail.iu", method=RequestMethod.GET)
	public ModelAndView getDetail(BoardDTO boardDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		boardDTO = qnaService.getDetail(boardDTO);
		
		mv.addObject("detail", boardDTO);
		mv.setViewName("qna/detail");
		return mv;
	}
	
	@RequestMapping(value="add.iu", method=RequestMethod.GET)
	public String setAdd()throws Exception{
		return "qna/add";
	}
	
	
	@RequestMapping(value="add.iu", method=RequestMethod.POST)
	public String setAdd(BoardDTO boardDTO)throws Exception{
		int result = qnaService.setAdd(boardDTO);
		
		return "redirect:./list.iu";
	}
	
	@RequestMapping(value="update.iu", method=RequestMethod.GET)
	public String setUpdate(BoardDTO boardDTO, Model model)throws Exception {
		boardDTO = qnaService.getDetail(boardDTO);
		model.addAttribute("qnaDTO", boardDTO);
		return "qna/update";
	}
	
	@RequestMapping(value="update.iu", method=RequestMethod.POST)
	public String setUpdate(BoardDTO boardDTO)throws Exception {
		int result = qnaService.setUpdate(boardDTO);
		
		return "redirect:./list.iu";
	}
	
	public String setDelete(BoardDTO boardDTO)throws Exception{
		int result = qnaService.setDelete(boardDTO);
		
		return "redirect:./list.iu";
	}
	
}
