package project.shopping.musinsa.persistence;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import project.shopping.musinsa.domain.NonUserVO;

@Repository
public class NonUserDAOImple implements NonUserDAO{
	private static final Logger logger = LoggerFactory.getLogger(NonUserDAOImple.class);
	private static final String NAMESPACE = "project.shopping.musinsa.NonUserMapper";

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insert(NonUserVO vo) {
		logger.info("insert »£√‚ : vo = " + vo.toString());
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	}
	
}
