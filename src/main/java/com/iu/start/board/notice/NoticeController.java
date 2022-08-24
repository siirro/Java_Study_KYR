package com.iu.start.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.iu.start.board.impl.BoardDTO;

@Controller
@RequestMapping(value="/notice/*")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@ModelAttribute("board")
	public String getBoard() {
		return "공지사항";
	}
	
	@RequestMapping(value="list.iu", method=RequestMethod.GET)
	public ModelAndView getList(@RequestParam(defaultValue = "1") Long page)throws Exception{
		ModelAndView mv = new ModelAndView();
		
		System.out.println("page : "+page);
		List<BoardDTO> ar = noticeService.getList(page);
		mv.addObject("list", ar);
		mv.setViewName("board/list");
		
		return mv;
	}
	
	@RequestMapping(value="detail.iu", method=RequestMethod.GET)
	public String getDetail(BoardDTO boardDTO, Model model)throws Exception{
		boardDTO = noticeService.getDetail(boardDTO);
		model.addAttribute("boardDTO", boardDTO);
		return "board/detail";
	}
	
	@RequestMapping(value="add.iu", method=RequestMethod.GET)
	public String setAdd(Model model)throws Exception{
		return "board/add";
	}
	
	@RequestMapping(value="add.iu", method=RequestMethod.POST)
	public ModelAndView setAdd(BoardDTO boardDTO)throws Exception{
		int result = noticeService.setAdd(boardDTO);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:./list.iu"); 
		return mv;
	}
	
	@RequestMapping(value="update.iu", method=RequestMethod.GET)
	public ModelAndView setUpdate(BoardDTO boardDTO, ModelAndView mv)throws Exception{
		boardDTO = noticeService.getDetail(boardDTO);
		mv.addObject("boardDTO", boardDTO);

		mv.setViewName("board/update");
		return mv;
	}
	
	@RequestMapping(value="update.iu", method=RequestMethod.POST)
	public String setUpdate(BoardDTO boardDTO)throws Exception{
		
		int result = noticeService.setUpdate(boardDTO);
		
		return "redirect:./detail.iu?num="+boardDTO.getNum();
	}
	
	@RequestMapping(value="delete.iu", method=RequestMethod.GET)
	public String setDelete(BoardDTO boardDTO)throws Exception{
		int result = noticeService.setDelete(boardDTO);
		
		return "redirect:./list.iu";
	}
	
}
