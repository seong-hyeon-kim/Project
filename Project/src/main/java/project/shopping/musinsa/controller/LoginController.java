package project.shopping.musinsa.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import project.shopping.musinsa.domain.UserVO;
import project.shopping.musinsa.persistence.UserDAO;
import project.shopping.musinsa.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class LoginController {
	private static final Logger logger = 
			LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private UserDAO userDao;

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
