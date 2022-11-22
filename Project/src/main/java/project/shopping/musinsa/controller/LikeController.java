package project.shopping.musinsa.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	public void like(Model model, HttpServletRequest request) {
		logger.info("like »£√‚");
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");
		
		List<ProductLikeVO> list = productLikeService.readLike(userId);
		String[] imgList = null;
		for(ProductLikeVO vo : list) {
			imgList = vo.getProductVO().getProductImg().split(" ");
			vo.getProductVO().setProductImg(imgList[0].toString());
		}
		model.addAttribute("list", list);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
