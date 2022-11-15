package project.shopping.musinsa.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import project.shopping.musinsa.domain.ProductLikeVO;
import project.shopping.musinsa.service.ProductLikeService;

@Controller
@RequestMapping(value = "/like")
public class LikeController {
	private static final Logger logger = LoggerFactory.getLogger(LikeController.class);
	
	@Autowired
	private ProductLikeService productLikeService;
	
	@GetMapping
	public void like(Model model) {
		logger.info("like »£√‚");
		String userId = "1";
		
		List<ProductLikeVO> list = productLikeService.readLike(userId);
		for(ProductLikeVO a : list) {
			logger.info(a.toString());
		}
		model.addAttribute("list", list);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
