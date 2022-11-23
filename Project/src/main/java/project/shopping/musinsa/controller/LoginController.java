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
	
	// ��ȸ��
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
				logger.info("��ȸ�� ���� ����");
				return "redirect:nonUserPayment";
			} else {
				logger.info("��ȸ�� ���� ����");
				return "redirect:/";
			}
		} else {
			logger.info("���� ���� ����");
			return "redirect:/";
		}
		}
	

	// ȸ������
	@GetMapping("/join")
	public void joinGET() {
		logger.info("joinGET() ȣ��");
	} // end joinGet

	@PostMapping("/join")
	public String joinPOST(UserVO vo, RedirectAttributes reAttr) {
		logger.info(vo.toString());
		logger.info("joinPOST() ȣ��");
		int result = userService.create(vo);
		logger.info(result + "�� ����");
		if (result == 1) {
			reAttr.addFlashAttribute("insert_result", "success");
			return "redirect:/";
		} else {
			return "redirect:/user/join";
		}
	}// end joinPOST

	// �α��� ������
	@GetMapping("/login")
	public String loginGET() {
		logger.info("loginGET() ȣ��");
		return "user/login";
	} // end loginGET

	// �α���
	@PostMapping("/login")
	public String loginPOST(Model model, String userId, String userPassword, HttpServletRequest request)
			throws Exception {
		logger.info("loginPOST() ȣ��");
		UserVO vo = userDao.select(userId);

		if (userPassword.equals(vo.getUserPassword())) {
			logger.info("�α��� ����");
			HttpSession session = request.getSession();
			session.setAttribute("userId", userId);
			session.setAttribute("loginChk", "Chk");
			session.setAttribute("UserVO", vo);

			// ���ǿ��� targetURL ��������
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
			logger.info("�α��� ����");
			return "redirect:/user/login";
		}
	} // end loginPOST

	// �α׾ƿ�
	@GetMapping("/logout")
	public String logoutPOST(HttpSession session) {
		logger.info("logoutPOST() ȣ��");
		session.removeAttribute("userId");
		logger.info("�α׾ƿ� ����");
		return "redirect:/";
	} // logoutPOST

	// ȸ�� ���� ���
	
	@GetMapping("/userResult")
	public String userResult(Model model, HttpServletRequest res, String userId) throws Exception {
		logger.info("userResult() ȣ��");
		// session.getAttribute("userId");
		HttpSession session = res.getSession();
		userId = (String )session.getAttribute("userId");
		UserVO vo = userService.read(userId);
		model.addAttribute("vo", vo);

		return "/user/userResult";
	}// end userResult
	

	// ȸ�� ���� ����
	@GetMapping("/update")
	public void updateGET(Model model, String userId) throws Exception {
		logger.info("updateGET() ȣ�� : userId = " + userId);
		UserVO vo = userService.read(userId);
		model.addAttribute("vo", vo);
	} // end updateGET

	@PostMapping("/update")
	public String updatePOST(UserVO vo) {
		logger.info("updatePOST() ȣ��  : vo = " + vo.toString());
		int result = userService.update(vo);
		if (result == 1) {
			return "redirect:/user/userResult?userId=" + vo.getUserId();

		} else {
			return "redirect:/user/update?userId=" + vo.getUserId();

		}
	} // end updatePOST

	// ȸ�� Ż��
	@GetMapping("/deleteId")
	public String deleteGET(HttpSession session, HttpServletRequest request) {
		logger.info("deleteGET() ȣ�� : userId = " + request.getParameter("userId"));
		int result = userService.delete(request.getParameter("userId"));
		logger.info("�ʴ� ������");
		if (result == 1) {
			session.removeAttribute("userId");
			logger.info("���� �Դ�?");
			return "redirect:/";
		} else {
			return "redirect:/user/userResult?userId=";
		}

	}// end deleteGET
	
	// ������ 
	@GetMapping("/verify")
	public void verifyGET() {
		logger.info("verifyGET() ȣ��");
	} // end verifyGET

	

} // end loginController
