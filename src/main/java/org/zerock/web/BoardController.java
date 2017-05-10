package org.zerock.web;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PagerMaker;
import org.zerock.service.BoardService;


@Controller
@RequestMapping("/board/*")
public class BoardController {

	
	private static Logger logger= org.slf4j.LoggerFactory.getLogger(BoardController.class);
	
	
	@Inject
	private BoardService service;
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public void registerGET(BoardVO board,Model model)throws Exception{
		
		logger.info(board.toString());
		logger.info("register get");
	}

	
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String registPOST(BoardVO board,RedirectAttributes rttr)throws Exception{
		
		logger.info("regist post...");
		logger.info(board.toString());
		
		service.regist(board);
	
		rttr.addFlashAttribute("msg","success");
		
		//return "/board/success";
		return "redirect:/board/listAll";
	}
	
	
	@RequestMapping(value="/listAll",method=RequestMethod.GET)
	public void listall(Criteria cri,Model model)throws Exception{
		
		
		logger.info("show all list....");
		model.addAttribute("list",service.listAll(cri));
		
		PagerMaker pm = new PagerMaker(130,cri);
		
		logger.info(pm.toString());
		model.addAttribute("pagerMaker",pm);
		
	}
	
	@RequestMapping(value="/read",method=RequestMethod.GET)
	public void detailview(Integer bno,BoardVO vo, Model model)throws Exception{
		
		vo=service.read(bno);

		logger.info("read get.......");
		
		model.addAttribute("bno", bno);
		model.addAttribute("vo",vo);
		
	}

	
	
	
	
	
}
