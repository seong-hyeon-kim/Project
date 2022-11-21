package project.shopping.musinsa.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.shopping.musinsa.domain.BoardVO;
import project.shopping.musinsa.domain.UserVO;
import project.shopping.musinsa.pageutil.PageCriteria;
import project.shopping.musinsa.pageutil.PageMaker;
import project.shopping.musinsa.service.BoardService;
import project.shopping.musinsa.service.UserService;

@RestController
@RequestMapping(value="/user")
public class LoginRESTController {
	private static final Logger logger =
			LoggerFactory.getLogger(LoginRESTController.class);
	
	
	@Autowired
	private UserService userService;
	
	// 아이디 중복체크
	// LoginRESTController -> UserServiceImple -> UserDAOImple -> LoginRESTController
 
	@PostMapping("join/userIdChk")
	public ResponseEntity<Integer> userIdChk(@RequestBody UserVO vo){
		logger.info("userIdChk() 호출 userId =" + vo.getUserId());
		
		int result = 0;
		
		try {
			result = userService.idChk(vo.getUserId());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(result == 1) { 
			logger.info("이미있는아이디");
			
		} else {
			logger.info("사용가능한아이디");
		}
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	} // end userIdChk
	
	
	
	
	
	
	
} //  LoginRESTController
