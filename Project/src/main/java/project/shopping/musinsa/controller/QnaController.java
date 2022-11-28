package project.shopping.musinsa.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import project.shopping.musinsa.domain.ProductVO;
import project.shopping.musinsa.domain.QnaVO;
import project.shopping.musinsa.service.QnaService;

@Controller
@RequestMapping(value = "/")
public class QnaController {
	private static final Logger logger = LoggerFactory.getLogger(QnaController.class);

	@Autowired
	private QnaService qnaService;

	/*
	 * @GetMapping("/Q&A") 
	 * public void qna(Model model, Integer page, Integer numsPerPage) { 
	 * 		logger.info("qna() 호출"); 
	 * 		logger.info("page = " + page + ", numsPerPage = " + numsPerPage);
	 * paging 처리
	 *  PageCriteria criteria = new PageCriteria(); 
	 *  	if (page != null) {
	 * 			criteria.setPage(page); 
	 * 		}
	 * 		if (numsPerPage != null) { 
	 * 			criteria.setNumsPerPage(numsPerPage); 
	 * 		}
	 * 
	 * 	List<QnaVO> list = qnaService.read(criteria); 
	 * 	// for(QnaVO vo : list) { 
	 * 	//  	logger.info(vo.toString()); 
	 * 	// } 
	 * 
	 * 	model.addAttribute("list", list);
	 * 
	 * 
	 * PageMaker pageMaker = new PageMaker(); 
	 * pageMaker.setCriteria(criteria);
	 * pageMaker.setTotalCount(qnaService.getTotalCounts());
	 * pageMaker.setPageData(); 
	 * model.addAttribute("pageMaker", pageMaker);
	 * 
	 * } // end qna()
	 */

	@GetMapping("/qaregister")
	public void qaregisterGET(Model model, int productNumber) {
		logger.info("qaregisterGET() 호출");
		logger.info("productNumber = " + productNumber);
		model.addAttribute("productNumber", productNumber);

	} // end registerGET()

	@GetMapping("/qaUpdate")
	public void qaUpdateGET(Model model, Integer productQuestionNumber, Integer productNumber, ProductVO vo) {
		logger.info("qaUpdateGET() 호출 , 문의글 번호 : " + productQuestionNumber + ", 상품번호 : " + productNumber);
		QnaVO Qvo = qnaService.read(productQuestionNumber);
		logger.info("Qvo : " + Qvo.toString());
		model.addAttribute("vo", vo);
		model.addAttribute("Qvo", Qvo);
		model.addAttribute("productNumber", productNumber);
	} // end qaUpdateGET()

	@PostMapping("/qaUpdate")
	public String qaUpdatePOST(QnaVO vo, Integer page) {
		logger.info("qaUpdatePOST() 호출 : vo = " + vo.toString());
		logger.info("page = " + page);
		int result = qnaService.update(vo);
		if (result == 1) {
			return "redirect:/productQna/Q&A";
		} else {
			return "redirect:/productQna/qaUpdate?userId=" + vo.getUserId();
		}
	} // end qaUpdatePOST()

	@GetMapping("/qaDelete")
	public String qaDeleteGET(Integer productQuestionNumber) {
		logger.info("qaDeleteGET() 호출 : 문의글 번호 = " + productQuestionNumber);
		int result = qnaService.delete(productQuestionNumber);
		if (result == 1) {
			return "redirect:/productQna/Q&A";
		} else {
			return "redirect:/productQna/Q&A";
		}
	} // end qaDeleteGET()

	@GetMapping("/review")
	public void reviewGET() {
		logger.info("reviewGET() 호출");
	} // end reviewGET()

} // end qnaController
