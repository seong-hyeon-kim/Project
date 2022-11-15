package project.shopping.musinsa.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import project.shopping.musinsa.domain.PaymentVO;

@Repository
public class PaymentDAOImple implements PaymentDAO{
	private static final Logger logger = LoggerFactory.getLogger(PaymentDAOImple.class);
	private static final String NAMESPACE = "project.shopping.musinsa.PaymentMapper";
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insert(PaymentVO vo) {
		logger.info("insert() 호출 : vo = " + vo.toString());
		
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	}

	@Override
	public List<PaymentVO> select(String userId) {
		logger.info("select 호출 : userId = " + userId);
		return sqlSession.selectList(NAMESPACE + ".select_by_user_id", userId);
	}
	
	
	
	
}
