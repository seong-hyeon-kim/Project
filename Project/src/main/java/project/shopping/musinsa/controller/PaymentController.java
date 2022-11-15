package project.shopping.musinsa.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import project.shopping.musinsa.domain.PaymentVO;
import project.shopping.musinsa.service.PaymentService;

@Controller
@RequestMapping(value = "/payment")
public class PaymentController {
	private static final Logger logger = LoggerFactory.getLogger(PaymentController.class);
	
	@Autowired
	private PaymentService paymentService;
	
	@GetMapping
	public void payment(Model model) {
		logger.info("payment »£√‚");
		String userId = "1";
		List<PaymentVO> list = paymentService.read(userId);
		for(PaymentVO a : list) {
			logger.info(a.toString());
		}
		model.addAttribute("list", list);
		
	}
	
	
	
	
}
