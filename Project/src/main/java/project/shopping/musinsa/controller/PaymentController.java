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

import project.shopping.musinsa.domain.PaymentVO;
import project.shopping.musinsa.domain.ProductVO;
import project.shopping.musinsa.service.PaymentService;

@Controller
@RequestMapping(value = "/payment")
public class PaymentController {
	private static final Logger logger = LoggerFactory.getLogger(PaymentController.class);
	
	@Autowired
	private PaymentService paymentService;
	
	@GetMapping
	public void payment(Model model, HttpServletRequest request) {
		logger.info("payment »£√‚");
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");
		List<PaymentVO> list = paymentService.read(userId);
		String[] imgList = null;
		for (PaymentVO vo : list) {
			 imgList = vo.getProductVO().getProductImg().split(" "); 
			 vo.getProductVO().setProductImg((imgList[0].toString()));
		}
		model.addAttribute("list", list);
		
	}
	
	
	
	
}
