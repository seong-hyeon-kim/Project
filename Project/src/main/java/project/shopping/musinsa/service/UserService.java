package project.shopping.musinsa.service;

import java.util.List;

import project.shopping.musinsa.domain.UserVO;

// CRUD (Create, Read, Update, Delete)
public interface UserService {

	// 등록
	int create(UserVO vo);
	
	// 검색
	 UserVO read(String userId) throws Exception;
	
	// 전체검색
	List<UserVO> read(UserVO vo);
	
	// 수정
	int update(UserVO vo);
	
	// 탈퇴
	int delete(String userId);

	// 로그인 
	UserVO Login(UserVO vo); 
	
	// 아이디 중복체크
	int idChk(String userId) throws Exception;
	
	// 패스워드 체크
	int passwordChk(UserVO vo);
	
} // end userService
