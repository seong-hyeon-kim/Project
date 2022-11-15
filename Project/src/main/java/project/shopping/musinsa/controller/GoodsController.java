package project.shopping.musinsa.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import project.shopping.musinsa.domain.ProductVO;
import project.shopping.musinsa.domain.QnaVO;
import project.shopping.musinsa.service.ProductService;
import project.shopping.musinsa.service.QnaService;

@Controller
@RequestMapping(value = "/detail")
public class GoodsController {
	private static final Logger logger = LoggerFactory.getLogger(GoodsController.class);
	
	@Autowired
	private ProductService productService;
	@Autowired
	private QnaService qnaService;
	
	@GetMapping
	public void detail(Model model, Integer productNumber, Integer productQuestionNumber) {
		logger.info("detail() »£√‚ : productNumber = " + productNumber);
		ProductVO vo = productService.read(productNumber);
		
		model.addAttribute("vo", vo);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
