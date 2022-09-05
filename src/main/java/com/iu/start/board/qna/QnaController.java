package com.iu.start.board.qna;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.start.board.impl.BoardDTO;
import com.iu.start.util.Pager;

@Controller
@RequestMapping("/qna/*")
public class QnaController {

	@Autowired
	private QnaService qnaService;
	
	@ModelAttribute("board")
	public String getBoard() {
		return "qna";
	}
	
//	@RequestMapping(value="reply.iu", method=RequestMethod.GET)
	//위에꺼 너무 귀찮아서 겟매핑 새로나옴
	@GetMapping("reply.iu")
	public ModelAndView setReply(QnaDTO qnaDTO, ModelAndView mv) throws Exception{
		mv.addObject("boardDTO", qnaDTO);
		mv.setViewName("board/reply");
		return mv;
	}
	
	@PostMapping("reply.iu")
	public String setReply(QnaDTO qnaDTO)throws Exception{
		int result = qnaService.setReply(qnaDTO);
		
		return "redirect:./list.iu";
	}
	
	@RequestMapping(value="list.iu",method=RequestMethod.GET)
	public String getList(Model model, Pager pager)throws Exception {
		List<BoardDTO> ar = qnaService.getList(pager);
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager);
		return "board/list";
	}
	
	

	
	@RequestMapping(value="detail.iu", method=RequestMethod.GET)
	public ModelAndView getDetail(BoardDTO boardDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		boardDTO = qnaService.getDetail(boardDTO);
		
		mv.addObject("boardDTO", boardDTO);
		mv.setViewName("board/detail");
		return mv;
	}
	
	@RequestMapping(value="add.iu", method=RequestMethod.GET)
	public String setAdd(Model model)throws Exception{

		return "board/add";
	}
	
	
	@RequestMapping(value="add.iu", method=RequestMethod.POST)
	public String setAdd(BoardDTO boardDTO, MultipartFile [] files, HttpSession session)throws Exception{
		int result = qnaService.setAdd(boardDTO, files, session.getServletContext());
		
		return "redirect:./list.iu";
	}
	
	@RequestMapping(value="update.iu", method=RequestMethod.GET)
	public String setUpdate(BoardDTO boardDTO, Model model)throws Exception {
		boardDTO = qnaService.getDetail(boardDTO);
		model.addAttribute("boardDTO", boardDTO);
		return "board/update";
	}
	
	@RequestMapping(value="update.iu", method=RequestMethod.POST)
	public String setUpdate(BoardDTO boardDTO)throws Exception {
		int result = qnaService.setUpdate(boardDTO);
		
		return "redirect:./list.iu";
	}
	
	@RequestMapping(value="delete.iu", method=RequestMethod.GET)
	public String setDelete(BoardDTO boardDTO)throws Exception{
		int result = qnaService.setDelete(boardDTO);
		
		return "redirect:./list.iu";
	}
	
	
}
