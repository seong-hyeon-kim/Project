package project.shopping.musinsa.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import project.shopping.musinsa.domain.ProductVO;
import project.shopping.musinsa.pageutil.PageCriteria;
import project.shopping.musinsa.pageutil.PageMaker;
import project.shopping.musinsa.service.ProductService;

@Controller
public class MainController {
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/main")
	public void main(Model model, Integer page, Integer numsPerPage) {
		numsPerPage = 10;
		logger.info("main() 호출");
		logger.info("page = " + page + ", numsPerPage = " + numsPerPage);
		
		PageCriteria criteria = new PageCriteria();
		if(page != null) {
			criteria.setPage(page);
		}
		
		if(numsPerPage != null) {
			criteria.setNumsPerPage(numsPerPage);
		}
		
		List<ProductVO> list = productService.read(criteria);
		String[] imgList = null;
		logger.info("list = "+list.toString());
		for (ProductVO vo : list) {
			 imgList = vo.getProductImg().split(" "); 
			 vo.setProductImg(imgList[0].toString());
			 logger.info("이미지 리스트 = " + imgList[0].toString());

		}
		
		
		model.addAttribute("list", list);
		model.addAttribute("imgList", imgList);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);
		pageMaker.setTotalCount(productService.getTotalCounts());
		pageMaker.setPageData();
		model.addAttribute("pageMaker", pageMaker);
		
	}
	
}
























