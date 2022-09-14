package com.iu.start.board.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.start.bankmembers.BankMembersDTO;
import com.iu.start.board.impl.BoardDTO;
import com.iu.start.util.Pager;

@Controller
@RequestMapping(value="/notice/*")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@ModelAttribute("board")
	public String getBoard() {
		return "notice";
	}
	
	@RequestMapping(value="list.iu", method=RequestMethod.GET)
	public ModelAndView getList(Pager pager)throws Exception{
		ModelAndView mv = new ModelAndView();
		
		List<BoardDTO> ar = noticeService.getList(pager);
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.setViewName("board/list");
		//System.out.println(pager.getKind());
		//System.out.println(pager.getSearch());
		
		if(ar.size() !=0) {
			throw new Exception();
		}
		return mv;
	}
	
	@RequestMapping(value="detail.iu", method=RequestMethod.GET)
	public String getDetail(BoardDTO boardDTO, Model model)throws Exception{
		boardDTO = noticeService.getDetail(boardDTO);
		model.addAttribute("boardDTO", boardDTO);
		return "board/detail";
	}
	
	@RequestMapping(value="add.iu", method=RequestMethod.GET)
	public String setAdd(HttpSession session)throws Exception{
		BankMembersDTO bankMembersDTO = (BankMembersDTO)session.getAttribute("member");
		
		if(bankMembersDTO!=null) {
			return "board/add";
			
		}else {
			return "redirect:../member/login.iu";
		}
		
	}
	
	@RequestMapping(value="add.iu", method=RequestMethod.POST)
	public ModelAndView setAdd(BoardDTO boardDTO, MultipartFile [] files, HttpSession session)throws Exception{
		int result = noticeService.setAdd(boardDTO, files, session.getServletContext());
		ModelAndView mv = new ModelAndView();
		
		
		String message = "등록 실패";
		if(result!=0) {
			message = "등록 성공";
			
		}
		
		mv.addObject("url", "./list.iu");
		mv.addObject("message", message);
		mv.addObject("result", result);
		
		mv.setViewName("common/result"); 
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
	
	@ExceptionHandler(NullPointerException.class)
	public ModelAndView exceptionTest() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("errors/error_404");
		return mv;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView exceptionTest2() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("errors/error_404");
		return mv;
	}
	
}
