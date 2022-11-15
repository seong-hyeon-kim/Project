package project.shopping.musinsa.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.shopping.musinsa.domain.QnaVO;
import project.shopping.musinsa.pageutil.PageCriteria;
import project.shopping.musinsa.service.QnaService;

@RestController
@RequestMapping(value="/qa")
public class QnaRESTController {
	private static final Logger logger =
			LoggerFactory.getLogger(QnaRESTController.class);
	
	@Autowired
	private QnaService qnaService;
	
	@PostMapping("/qaREST")
	public ResponseEntity<Integer> createQna(@RequestBody QnaVO vo, PageCriteria page) {
		logger.info("createQna() 호출 : vo = " + vo.toString());
		logger.info("page = " + page);
		int result = qnaService.create(vo);
		logger.info("=========================result = " + result);
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	} // end createQna()
	
	@PutMapping("/{productQuestionNumber}")
	public ResponseEntity<Integer> updateQna(
			@PathVariable("productQuestionNumber") int productQuestionNumber,
			@RequestBody QnaVO vo) {
		logger.info("updateQna() 호출");
		vo.setProductQuestionNumber(productQuestionNumber);
		int result = qnaService.update(vo);
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	} // end updateQna()

	@DeleteMapping("/{productQuestionNumber}")
	public ResponseEntity<Integer> deleteQna(@PathVariable("productQuestionNumber") int productQuestionNumber) {
		logger.info("문의 번호 : " + productQuestionNumber);
		int result = qnaService.delete(productQuestionNumber);
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	} // end deleteQna()
	
} // end QnaRESTController
