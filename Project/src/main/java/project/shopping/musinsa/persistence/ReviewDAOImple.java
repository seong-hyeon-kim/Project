package project.shopping.musinsa.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import project.shopping.musinsa.domain.ReviewVO;

@Repository
public class ReviewDAOImple implements ReviewDAO {
	private static final Logger logger = 
			LoggerFactory.getLogger(ReviewDAOImple.class);
	private static final String NAMESPACE =
			"project.shopping.musinsa.ReviewMapper";
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insert(ReviewVO rvo) {
		logger.info("insert() ȣ�� : rvo = " + rvo.toString());
		return sqlSession.insert(NAMESPACE + ".insert", rvo);
	} // end insert()

	@Override
	public List<ReviewVO> select(int productNumber) {
		logger.info("select() ȣ�� : ��ǰ��ȣ : " + productNumber);
		return sqlSession.selectList(NAMESPACE + ".select_by_product_number", productNumber);
	} // end select()

	@Override
	public int update(ReviewVO rvo) {
		logger.info("update() ȣ�� : rvo = " + rvo.toString());
		return sqlSession.update(NAMESPACE + ".update", rvo);
	} // end update()

	@Override
	public int delete(int reviewNumber) {
		logger.info("delete() ȣ�� : ����� ��ȣ : " + reviewNumber);
		return sqlSession.delete(NAMESPACE + ".delete", reviewNumber);
	} // end delete()

} // end ReviewDAOImple
