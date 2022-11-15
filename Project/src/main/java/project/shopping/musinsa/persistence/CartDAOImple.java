package project.shopping.musinsa.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import project.shopping.musinsa.domain.CartVO;

@Repository
public class CartDAOImple implements CartDAO{
	private static final Logger logger = LoggerFactory.getLogger(CartDAOImple.class);
	private static final String NAMESPACE = "project.shopping.musinsa.CartMapper";
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insert(CartVO vo) {
		logger.info("insert() 호출");
		logger.info(vo.toString());
		
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	}

	@Override
	public List<CartVO> select(String userId) {
		logger.info("select() 호출 userId = " + userId);
		
		return sqlSession.selectList(NAMESPACE + ".select_by_user_id", userId);
	}

	@Override
	public int update(CartVO vo) {
		logger.info("update() 호출 vo = " + vo.toString());
		return sqlSession.update(NAMESPACE + ".update", vo);
	}

	@Override
	public int delete(int cartNumber) {
		logger.info("delete 호출 : cartNumber = " + cartNumber);
		return sqlSession.delete(NAMESPACE + ".delete", cartNumber);
	}

	@Override
	public List<String> select2(String userId) {
		logger.info("select2(userId로 cart에 담긴 상품 불러오기)");
		return sqlSession.selectList(NAMESPACE + ".select_userId_from_cart", userId);
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
