package org.zerock.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.domain.ProductVO;



@Controller
public class SamlpleController {

	private static final Logger logger= LoggerFactory.getLogger(SamlpleController.class);
	
	@RequestMapping("doA")
	public void doA(){
		logger.info("doA call............");
	}
	
	@RequestMapping("doB")
	public void doB(){
		logger.info("doB call............");
	}

	
	@RequestMapping("doC")
	public String doC(@ModelAttribute("msg") String msg){
		
		logger.info("doC call............");
	
		return "result";
	}
	
	@RequestMapping("doD") 
		public String doD(Model model,@ModelAttribute("name") String name, double price){
		
		logger.info("doD call............");
		
		ProductVO product = new ProductVO(name, price);
		
		model.addAttribute("product",product);
		
		return "productDetail";
		
	}
	
	
	
}
