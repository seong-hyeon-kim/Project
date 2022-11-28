package project.shopping.musinsa.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.shopping.musinsa.domain.NonUserVO;
import project.shopping.musinsa.domain.PaymentVO;
import project.shopping.musinsa.service.NonUserService;
import project.shopping.musinsa.service.PaymentService;

@RestController
@RequestMapping(value = "/nonUserPayment")
public class NonUserPaymentRESTController {
	private static final Logger logger = LoggerFactory.getLogger(NonUserPaymentRESTController.class);
	
	@Autowired
	private NonUserService nonUserService;
	
	@Autowired
	private PaymentService paymentService;
	
	
	@PostMapping
	public ResponseEntity<Integer> createNonUser(@RequestBody Map<String, Object> paramMap, NonUserVO NUvo, PaymentVO Pvo) {
		
		NUvo.setNonUserAddress((String)paramMap.get("nonUserAddress"));
		NUvo.setNonUserEmail((String)paramMap.get("nonUserEmail"));
		NUvo.setNonUserPhone((String)paramMap.get("nonUserPhone"));
		NUvo.setUserId((String)paramMap.get("userId"));
		logger.info(NUvo.toString());
		
		
		Pvo.setUserId((String)paramMap.get("userId"));
		Pvo.setProductNumber(Integer.parseInt((String) paramMap.get("productNumber")));
		Pvo.setPaymentPrice(Integer.parseInt((String) paramMap.get("paymentPrice")));
		Pvo.setPaymentAmount(Integer.parseInt((String) paramMap.get("paymentAmount")));
		Pvo.setPaymentProductSize((String) paramMap.get("paymentProductSize"));
		logger.info(Pvo.toString());
		
		int result = nonUserService.create(NUvo);
		if(result == 1) { // 비회원가입 성공
			int paymentResult = paymentService.create(Pvo);
			if(paymentResult == 1) { // 비회원가입 후 결제 성공
				return new ResponseEntity<Integer>(paymentResult, HttpStatus.OK);
			} else { // 비회원가입 후 결제 실패
				return new ResponseEntity<Integer>(paymentResult, HttpStatus.OK);
			}
		} else { // 비회원가입 실패
			return new ResponseEntity<Integer>(result, HttpStatus.OK);
		}
		
		
		
		
	}
	
	@GetMapping("/{nonUserId}")
	public ResponseEntity<List<PaymentVO>> readPayment (
			@PathVariable("nonUserId") String userId) {
		List<PaymentVO> list = paymentService.read(userId);
		String[] imgList = null;
		for(PaymentVO vo : list) {
			imgList = vo.getProductVO().getProductImg().split(" ");
			vo.getProductVO().setProductImg(imgList[0].toString());
		}
		
		
		return new ResponseEntity<List<PaymentVO>>(list, HttpStatus.OK);
		
	}
	
	
	
}