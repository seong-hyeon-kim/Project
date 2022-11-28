package project.shopping.musinsa.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import project.shopping.musinsa.domain.ProductVO;
import project.shopping.musinsa.domain.QnaVO;
import project.shopping.musinsa.domain.ReviewVO;
import project.shopping.musinsa.pageutil.PageCriteria;
import project.shopping.musinsa.pageutil.PageMaker;
import project.shopping.musinsa.service.ProductService;
import project.shopping.musinsa.service.QnaService;
import project.shopping.musinsa.service.ReviewService;

@Controller
@RequestMapping(value = "/detail")
public class GoodsController {
	private static final Logger logger = LoggerFactory.getLogger(GoodsController.class);
	
	@Autowired
	private ProductService productService;
	@Autowired
	private QnaService qnaService;
	@Autowired
	private ReviewService reviewService;
	
	@GetMapping
	public void detail(Model model, Integer productNumber, Integer productQuestionNumber, Integer page, Integer numsPerPage) {
		logger.info("detail() 호출 : productNumber = " + productNumber);
		logger.info("page 번호 : " + page);
		logger.info("numsPerPage : " + numsPerPage);
		
		PageCriteria criteria= new PageCriteria();
		if(page != null) {
			criteria.setPage(page);
		}
		if(numsPerPage != null) {
			criteria.setNumsPerPage(numsPerPage);
		}
		
		ProductVO vo = productService.read(productNumber);
		
		List<QnaVO> list = qnaService.read(criteria, productNumber);
		List<ReviewVO> reviewList = reviewService.read(productNumber);
		for(QnaVO Qvo : list) {
			logger.info(Qvo.toString());
		}
		
		ArrayList<Integer> reviewListNumber = new ArrayList<Integer>();
	
		
		for(ReviewVO rvo : reviewList) {
			logger.info(rvo.toString());
			reviewListNumber.add(rvo.getReviewNumber());
		}
		
		
		String[] imgList = vo.getProductImg().split(" ");
		vo.setProductImg(imgList[0].toString());
		
		List<String> Llist = new ArrayList<String>(Arrays.asList(imgList));
		Llist.remove(0);
		imgList = Llist.toArray(new String[0]);
		
		model.addAttribute("imgList", imgList);
		model.addAttribute("vo", vo);
		model.addAttribute("list", list);
		model.addAttribute("productNumber", productNumber);
		model.addAttribute("reviewList", reviewList);
		model.addAttribute("reviewListNumber", reviewListNumber);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);;
		pageMaker.setTotalCount(qnaService.getTotalCounts(productNumber));
		pageMaker.setPageData();
		model.addAttribute("pageMaker", pageMaker);
		System.out.println(vo.getProductSize());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
