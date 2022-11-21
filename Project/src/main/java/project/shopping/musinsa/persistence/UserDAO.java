package project.shopping.musinsa.persistence;

import java.util.List;

import project.shopping.musinsa.domain.UserVO;

public interface UserDAO {

	// 회원 등록
	int insert(UserVO vo);
	
	// 회원 정보 검색
	public UserVO select(String userId) throws Exception;
	
	// 회원 전체 검색
	List<UserVO> select();
	
	// 회원 정보 수정
	int update(UserVO vo);
	
	// 회원 탈퇴
	int delete(String userId);
	
	// 로그인
	UserVO login(UserVO vo);
	
	// 아이디 중복체크
	int idChk(String userId);
	
	// 패스워드 체크
	int passwordChk(UserVO vo);
	
	
} // end UserDAO

