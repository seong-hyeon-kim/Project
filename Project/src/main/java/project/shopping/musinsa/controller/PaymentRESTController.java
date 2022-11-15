package project.shopping.musinsa.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.shopping.musinsa.domain.PaymentVO;
import project.shopping.musinsa.service.PaymentService;

@RestController
@RequestMapping(value = "/payment")
public class PaymentRESTController {
	private static final Logger logger = LoggerFactory.getLogger(PaymentRESTController.class);
	
	@Autowired
	private PaymentService paymentService;
	
	@PostMapping("/register")
	public ResponseEntity<Integer> createPayment(@RequestBody PaymentVO vo) {
		logger.info("register »£√‚ vo = " + vo.toString());
		int result = paymentService.create(vo);
		
		
		return new ResponseEntity<Integer>(result, HttpStatus.OK) ;
		
	}
	
	
}
