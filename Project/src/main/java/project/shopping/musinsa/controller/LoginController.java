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
