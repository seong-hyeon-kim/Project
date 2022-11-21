package project.shopping.musinsa.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import project.shopping.musinsa.domain.UserVO;

@Repository
public class UserDAOImple implements UserDAO {

	private static final Logger logger = LoggerFactory.getLogger(UserDAOImple.class);
	private static final String NAMESPACE = "project.shopping.musinsa.UserMapper";

	@Autowired
	private SqlSession sqlSession;

	// 회원 등록
	@Override
	public int insert(UserVO vo) {
		logger.info("insert() 호출 : vo = " + vo.toString());
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	}

	// 회원 검색
	@Override 
	public UserVO select(String userId) throws Exception {
	logger.info("select() 호출 : userId = " + userId); 
	return sqlSession.selectOne(NAMESPACE + ".select_by_user_id", userId); 
	}
	 

	// 회원 전체 검색
	@Override
	public List<UserVO> select() {
		logger.info("select() 호출");
		return sqlSession.selectList(NAMESPACE + ".select_all");
	}


	// 회원 정보 수정
	@Override
	public int update(UserVO vo) {
		logger.info("update() 호출 = " + vo.toString());
		return sqlSession.update(NAMESPACE + ".update", vo);
	}

	// 회원 탈퇴
	@Override
	public int delete(String userId) {
		logger.info("delete() 호출 : userId = " + userId);
		return sqlSession.delete(NAMESPACE + ".delete", userId);
	}

	// 로그인
	@Override
	public UserVO login(UserVO vo) {
		logger.info("login() 호출  = " + vo);
		return sqlSession.selectOne(NAMESPACE + ".login", vo);
	}

	// 아이디 중복체크
	@Override
	public int idChk(String userId) {
		logger.info("idChk() 호출 : userId = " + userId);
		return sqlSession.selectOne(NAMESPACE + ".idChk", userId);
	} // UserMapper에서 아이디 중복검사 쿼리 수행 후->
		// LoginRESTController에 userId 값 돌려주기

	// 패스워드 체크
	@Override
	public int passwordChk(UserVO vo) {
		logger.info("passwordChk() 호출  = " + vo);
		return sqlSession.selectOne(NAMESPACE + ".passChk", vo);
	}

	

} // end UserDAOImple
