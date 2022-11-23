package project.shopping.musinsa.controller;

import java.time.LocalTime;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import project.shopping.musinsa.domain.NonUserVO;
import project.shopping.musinsa.domain.PaymentVO;
import project.shopping.musinsa.domain.UserVO;
import project.shopping.musinsa.persistence.UserDAO;
import project.shopping.musinsa.service.NonUserService;
import project.shopping.musinsa.service.PaymentService;
import project.shopping.musinsa.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class LoginController {
	private static final Logger logger = 
			LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private UserService userService;
	
	@Autowired
	private NonUserService nonUserService;

	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private PaymentService paymentService;
	
	@GetMapping("/nonUserPayment")
	public void nonUserPayment() {
		
	}
	
	// 비회원
	@GetMapping("/simpleJoin")
	public void simpleJoinGet() {
		
	}
	
	@PostMapping("/simpleJoin") 
		public String simpleJoinPOST(NonUserVO vo, PaymentVO Pvo, HttpServletRequest request) {
		int leftLimit = 48; // numeral '0'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 10;
		Random random = new Random();

		String generatedString = random.ints(leftLimit,rightLimit + 1)
		  .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
		  .limit(targetStringLength)
		  .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
		  .toString();
		
		
		LocalTime time = LocalTime.now();
		String timeA = time.toString();
		String timeAA = timeA.substring(9);
		String nonUserId = generatedString+timeAA;
		vo.setUserId(nonUserId);
		String ad1 = request.getParameter("nonUserAddressNum");
		String ad2 = request.getParameter("nonUserAddress1");
		String ad3 = request.getParameter("nonUserAddress2");
		String ad4 = request.getParameter("nonUserAddress3");
		String add = ad1 + " " + ad2 + " " + ad3 + " " + ad4;
		vo.setNonUserAddress(add);
		vo.setNonUserEmail(request.getParameter("nonUserEmail"));
		vo.setNonUserPhone(request.getParameter("nonUserPhone"));
		logger.info(vo.toString());
		
		int result = nonUserService.create(vo);
		if(result == 1) {
			Pvo.setUserId(nonUserId);
			Pvo.setProductNumber(Integer.parseInt(request.getParameter("productNumber")));
			Pvo.setPaymentPrice(Integer.parseInt(request.getParameter("paymentPrice")));
			Pvo.setPaymentAmount(Integer.parseInt(request.getParameter("paymentAmount")));
			Pvo.setPaymentProductSize(request.getParameter("paymentProductSize"));
			int resultPayment = paymentService.create(Pvo);
			if(resultPayment == 1 ) {
				logger.info("비회원 구매 성공");
				return "redirect:nonUserPayment";
			} else {
				logger.info("비회원 구매 실패");
				return "redirect:/";
			}
		} else {
			logger.info("계정 생성 실패");
			return "redirect:/";
		}
		}
	

	// 회원가입
	@GetMapping("/join")
	public void joinGET() {
		logger.info("joinGET() 호출");
	} // end joinGet

	@PostMapping("/join")
	public String joinPOST(UserVO vo, RedirectAttributes reAttr) {
		logger.info(vo.toString());
		logger.info("joinPOST() 호출");
		int result = userService.create(vo);
		logger.info(result + "행 삽입");
		if (result == 1) {
			reAttr.addFlashAttribute("insert_result", "success");
			return "redirect:/";
		} else {
			return "redirect:/user/join";
		}
	}// end joinPOST

	// 로그인 페이지
	@GetMapping("/login")
	public String loginGET() {
		logger.info("loginGET() 호출");
		return "user/login";
	} // end loginGET

	// 로그인
	@PostMapping("/login")
	public String loginPOST(Model model, String userId, String userPassword, HttpServletRequest request)
			throws Exception {
		logger.info("loginPOST() 호출");
		UserVO vo = userDao.select(userId);

		if (userPassword.equals(vo.getUserPassword())) {
			logger.info("로그인 성공");
			HttpSession session = request.getSession();
			session.setAttribute("userId", userId);
			session.setAttribute("loginChk", "Chk");
			session.setAttribute("UserVO", vo);

			// 세션에서 targetURL 가져오기
			String targetURL = (String) session.getAttribute("targetURL");
			logger.info("targetURL : " + targetURL);
			if (targetURL != null) {
				session.removeAttribute("targetURL");
				session.setMaxInactiveInterval(600);
				return "redirect:" + targetURL;
			} else {
				return "redirect:/";
			}
		} else {
			logger.info("로그인 실패");
			return "redirect:/user/login";
		}
	} // end loginPOST

	// 로그아웃
	@GetMapping("/logout")
	public String logoutPOST(HttpSession session) {
		logger.info("logoutPOST() 호출");
		session.removeAttribute("userId");
		logger.info("로그아웃 성공");
		return "redirect:/";
	} // logoutPOST

	// 회원 정보 결과
	
	@GetMapping("/userResult")
	public String userResult(Model model, HttpServletRequest res, String userId) throws Exception {
		logger.info("userResult() 호출");
		// session.getAttribute("userId");
		HttpSession session = res.getSession();
		userId = (String )session.getAttribute("userId");
		UserVO vo = userService.read(userId);
		model.addAttribute("vo", vo);

		return "/user/userResult";
	}// end userResult
	

	// 회원 정보 수정
	@GetMapping("/update")
	public void updateGET(Model model, String userId) throws Exception {
		logger.info("updateGET() 호출 : userId = " + userId);
		UserVO vo = userService.read(userId);
		model.addAttribute("vo", vo);
	} // end updateGET

	@PostMapping("/update")
	public String updatePOST(UserVO vo) {
		logger.info("updatePOST() 호출  : vo = " + vo.toString());
		int result = userService.update(vo);
		if (result == 1) {
			return "redirect:/user/userResult?userId=" + vo.getUserId();

		} else {
			return "redirect:/user/update?userId=" + vo.getUserId();

		}
	} // end updatePOST

	// 회원 탈퇴
	@GetMapping("/deleteId")
	public String deleteGET(HttpSession session, HttpServletRequest request) {
		logger.info("deleteGET() 호출 : userId = " + request.getParameter("userId"));
		int result = userService.delete(request.getParameter("userId"));
		logger.info("너는 누구니");
		if (result == 1) {
			session.removeAttribute("userId");
			logger.info("여기 왔니?");
			return "redirect:/";
		} else {
			return "redirect:/user/userResult?userId=";
		}

	}// end deleteGET
	
	// 관리자 
	@GetMapping("/verify")
	public void verifyGET() {
		logger.info("verifyGET() 호출");
	} // end verifyGET

	

} // end loginController
