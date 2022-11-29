package project.shopping.musinsa.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.shopping.musinsa.domain.ReviewVO;
import project.shopping.musinsa.service.ReviewService;

@RestController
@RequestMapping(value = "reviews")
public class ReviewRESTController {
	private static final Logger logger = LoggerFactory.getLogger(ReviewRESTController.class);

	@Autowired
	private ReviewService reviewService;

	@PostMapping
	public ResponseEntity<Integer> createReview(@RequestBody ReviewVO rvo) {
		logger.info("createReview() 호출 : rvo = " + rvo.toString());
		int result = reviewService.create(rvo);
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	} // end createReview()

	@GetMapping("/all/{productNumber}")
	public ResponseEntity<List<ReviewVO>> readReviews(@PathVariable("productNumber") int productNumber) {
		List<ReviewVO> list = reviewService.read(productNumber);
		return new ResponseEntity<List<ReviewVO>>(list, HttpStatus.OK);
	} // end readReviews

	@DeleteMapping("/{reviewNumber}")
	public ResponseEntity<Integer> deleteReview(@PathVariable("reviewNumber") int reviewNumber,
			@RequestBody ReviewVO rvo) {
		logger.info("deleteReview() 호출 : 리뷰 번호 = " + reviewNumber);
		int result = reviewService.delete(reviewNumber);
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	} // end deleteReview()
} // end ReviewRESTController
