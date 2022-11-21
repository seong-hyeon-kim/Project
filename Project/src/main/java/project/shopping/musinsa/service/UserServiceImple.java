package project.shopping.musinsa.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.shopping.musinsa.domain.UserVO;
import project.shopping.musinsa.persistence.UserDAO;

@Service
public class UserServiceImple implements UserService {
	
	private static final Logger logger =
			LoggerFactory.getLogger(UserServiceImple.class);

	@Autowired
	private UserDAO dao;
	
	
	@Override
	public int create(UserVO vo) {
		logger.info("create() 호출 : vo = " + vo.toString());
		return dao.insert(vo);
	}

	// 회원 조회
	@Override
	public UserVO read(String userId) throws Exception {
		logger.info("read() 호출 : userId = " + userId);
		return dao.select(userId);
	}
	
	@Override
	public List<UserVO> read(UserVO vo) {
		logger.info("List<UserVO>read() 호출 : vo = " + vo);
		return dao.select();
	}

	@Override
	public int update(UserVO vo) {
		logger.info("update() 호출 : vo = " + vo.toString());
		return dao.update(vo);
	}

	@Override
	public int delete(String userId) {
		logger.info("delete() 호출 : userId = " + userId);
		return dao.delete(userId);
	}

	@Override
	public UserVO Login(UserVO vo) {
		logger.info("login() 호출 : vo = " + vo.toString());
		return dao.login(vo);
	}

	@Override
	public int idChk(String userId) {
		logger.info("idChk() 호출 : userId = " + userId);
		return dao.idChk(userId); // daoimple에서 id체크 후 있는 아이디면 1로 돌려주기
	}

	@Override
	public int passwordChk(UserVO vo) {
		logger.info("passChk() 호출 : vo = " + vo.toString());
		return dao.passwordChk(vo);
	}



} // end UserServiceImple
