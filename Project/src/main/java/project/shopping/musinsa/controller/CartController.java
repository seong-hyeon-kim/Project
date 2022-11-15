package project.shopping.musinsa.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import project.shopping.musinsa.domain.CartVO;
import project.shopping.musinsa.service.CartService;

@Controller
@RequestMapping(value = "/cart")
public class CartController {
	private static final Logger logger = LoggerFactory.getLogger(CartController.class);

	@Autowired
	private CartService cartService;

	@GetMapping
	public void cart(Model model) {
		logger.info("cart호출");
		String userId = "1";

		List<CartVO> list = cartService.read(userId);
		model.addAttribute("list", list);
	}

	@PostMapping("/register")
	public String registerPOST(Model model, CartVO vo, HttpServletRequest request, RedirectAttributes reAttr) {
		logger.info("register 호출");
		vo.setUserId("1");
		List<String> resultCartVoList = cartService.readC(vo.getUserId());
		
		if (resultCartVoList.size() == 0) {
			vo.setProductNumber(Integer.parseInt(request.getParameter("productNumber")));
			vo.setCartSize(request.getParameter("size"));
			vo.setCartAmount(Integer.parseInt(request.getParameter("cartAmount")));
			int result = cartService.create(vo);
			logger.info("카트 " + result + " 추가");
			if (result == 1) {
				reAttr.addFlashAttribute("cartVO", vo);
				return "redirect:/cart";
			}
		} else {
			if (resultCartVoList.contains(Integer.toString(vo.getProductNumber()))) {
				return "redirect:/cart";
			} else {
				vo.setProductNumber(Integer.parseInt(request.getParameter("productNumber")));
				vo.setCartSize(request.getParameter("size"));
				vo.setCartAmount(Integer.parseInt(request.getParameter("cartAmount")));
				int result = cartService.create(vo);
				if (result == 1) {
					reAttr.addFlashAttribute("cartVO", vo);
					return "redirect:/cart";
				}
			}
		}
		return "redirect:/cart";
	} // end registerPOST()
}
