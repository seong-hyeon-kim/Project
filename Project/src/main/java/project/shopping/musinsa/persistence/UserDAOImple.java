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

	// ȸ�� ���
	@Override
	public int insert(UserVO vo) {
		logger.info("insert() ȣ�� : vo = " + vo.toString());
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	}

	// ȸ�� �˻�
	@Override 
	public UserVO select(String userId) throws Exception {
	logger.info("select() ȣ�� : userId = " + userId); 
	return sqlSession.selectOne(NAMESPACE + ".select_by_user_id", userId); 
	}
	 

	// ȸ�� ��ü �˻�
	@Override
	public List<UserVO> select() {
		logger.info("select() ȣ��");
		return sqlSession.selectList(NAMESPACE + ".select_all");
	}


	// ȸ�� ���� ����
	@Override
	public int update(UserVO vo) {
		logger.info("update() ȣ�� = " + vo.toString());
		return sqlSession.update(NAMESPACE + ".update", vo);
	}

	// ȸ�� Ż��
	@Override
	public int delete(String userId) {
		logger.info("delete() ȣ�� : userId = " + userId);
		return sqlSession.delete(NAMESPACE + ".delete", userId);
	}

	// �α���
	@Override
	public UserVO login(UserVO vo) {
		logger.info("login() ȣ��  = " + vo);
		return sqlSession.selectOne(NAMESPACE + ".login", vo);
	}

	// ���̵� �ߺ�üũ
	@Override
	public int idChk(String userId) {
		logger.info("idChk() ȣ�� : userId = " + userId);
		return sqlSession.selectOne(NAMESPACE + ".idChk", userId);
	} // UserMapper���� ���̵� �ߺ��˻� ���� ���� ��->
		// LoginRESTController�� userId �� �����ֱ�

	// �н����� üũ
	@Override
	public int passwordChk(UserVO vo) {
		logger.info("passwordChk() ȣ��  = " + vo);
		return sqlSession.selectOne(NAMESPACE + ".passChk", vo);
	}

	

} // end UserDAOImple
