package org.zerock.web;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.zerock.domain.BoardVO;
import org.zerock.domain.PagerMaker;
import org.zerock.domain.SearchCriteria;
import org.zerock.service.BoardService;

@Controller
@RequestMapping("/sboard/*")
public class SearchBoardController {

	private static final Logger logger =Logger.getLogger(SearchBoardController.class);
	
	
	@Inject
	BoardService service;
	
	@RequestMapping(value="/listAll",method=RequestMethod.GET)
	public void listPage(@ModelAttribute("cri") SearchCriteria cri,
			Model model)throws Exception{
		logger.info("get............");
		logger.info(cri.toString());
	
		model.addAttribute("list", service.listAll(cri));
		PagerMaker pagerMaker=new PagerMaker(service.totalCounter(),cri);
		model.addAttribute("pagerMaker",pagerMaker);
		
		
	}
	
	@RequestMapping(value="/read",method=RequestMethod.GET)
	public void detailview(Integer bno,BoardVO vo, Model model)throws Exception{
		
		vo=service.read(bno);

		logger.info("read get.......");
		
		model.addAttribute("bno", bno);
		model.addAttribute("vo",vo);
		
	}
	
	
}
