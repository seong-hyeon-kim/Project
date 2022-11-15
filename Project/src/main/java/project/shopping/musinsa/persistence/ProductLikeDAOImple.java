package project.shopping.musinsa.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import project.shopping.musinsa.domain.ProductLikeVO;
import project.shopping.musinsa.domain.ProductVO;

@Repository
public class ProductLikeDAOImple implements ProductLikeDAO{
	private static final Logger logger = LoggerFactory.getLogger(ProductLikeDAOImple.class);
	private static final String NAMESPACE = "project.shopping.musinsa.ProductLikeMapper";

	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insert(ProductLikeVO vo) {
		logger.info("DAOImple.insert() 호출");
		logger.info(vo.toString());
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	}

	@Override
	public List<ProductVO> select(int productNumber) {
		logger.info("productLikeDAOImple.select() 호출 : productNumber = " + productNumber);
		return sqlSession.selectList(NAMESPACE + ".select_all_by_product_number", productNumber);
	}

	@Override
	public int selectLikeCnt(ProductLikeVO vo) {
		logger.info("productLikeDAOImple.selectLikeCnt() 호출");
		
		return sqlSession.selectOne(NAMESPACE + ".findLike", vo);
	}

	@Override
	public int delete(ProductLikeVO vo) {
		logger.info("좋아요 delete() 호출 : vo = " + vo.toString());
		
		return sqlSession.delete(NAMESPACE + ".delete", vo);
	}

	@Override
	public List<ProductLikeVO> selectLike(String userId) {
		
		return sqlSession.selectList(NAMESPACE + ".select", userId);
	}


	
	















}
