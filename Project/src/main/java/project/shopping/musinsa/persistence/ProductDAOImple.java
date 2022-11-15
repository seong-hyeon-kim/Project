package project.shopping.musinsa.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import project.shopping.musinsa.domain.ProductVO;
import project.shopping.musinsa.pageutil.PageCriteria;

@Repository
public class ProductDAOImple implements ProductDAO {
	private static final Logger logger = LoggerFactory.getLogger(ProductDAOImple.class);
	private static final String NAMESPACE = "project.shopping.musinsa.ProductMapper";
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insert(ProductVO vo) {
		logger.info("DAOImple.insert() 호출");
		logger.info(vo.toString());
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	} // end insert

	@Override
	public List<ProductVO> select() {
		logger.info("DAOImple.select() 호출");
		return sqlSession.selectList(NAMESPACE + ".select_all");
	} // end select()

	@Override
	public List<ProductVO> select(PageCriteria criteria) {
		logger.info("DAOImple.select() 호출");
		logger.info("start + " + criteria.getStart());
		logger.info("end = " + criteria.getEnd());
		return sqlSession.selectList(NAMESPACE + ".paging", criteria);
	}

	@Override
	public int getTotalCounts() {
		logger.info("DAOImple.getTotalCounts() 호출");
		
		return sqlSession.selectOne(NAMESPACE + ".total_count");
	}

	@Override
	public ProductVO select(int productNumber) {
		logger.info("DAOImple.select() 호출 : productNumber = " + productNumber);
		
		return sqlSession.selectOne(NAMESPACE + ".select_by_product_number", productNumber);
	}

	@Override
	public int update(ProductVO vo) {
		logger.info("DAOImple.update() 호출 : vo = " + vo.toString());
		
		return sqlSession.update(NAMESPACE + ".update", vo);
	}

	@Override
	public int delete(int productNumber) {
		logger.info("DAOImple.delete() 호출 : productNumber = " + productNumber);
		
		return sqlSession.delete(NAMESPACE + ".delete", productNumber);
	}

	@Override
	public int updateProductGood(int amount, int productNumber) {
		logger.info("productDAOImple.updateProductGood() : productNumber = " + productNumber);
		Map<String, Integer> args = new HashMap<String, Integer>();
		args.put("amount", amount);
		args.put("productNumber", productNumber);
		return sqlSession.update(NAMESPACE + ".update_product_good", args);
	}


	
	
}
