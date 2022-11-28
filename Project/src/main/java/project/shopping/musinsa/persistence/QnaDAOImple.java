package project.shopping.musinsa.persistence;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import project.shopping.musinsa.domain.QnaVO;
import project.shopping.musinsa.pageutil.PageCriteria;

@Repository
public class QnaDAOImple implements QnaDAO {
	private static final Logger logger =
			LoggerFactory.getLogger(QnaDAOImple.class);
	private static final String NAMESPACE =
			"project.shopping.musinsa.QnaMapper";
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insert(QnaVO vo) {
		logger.info("insert() 호출 : vo = " + vo.toString());
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	} // end insert()

	@Override
	public List<QnaVO> select(int productNumber) {
		logger.info("select() 호출 : " + productNumber);
		return sqlSession.selectList(NAMESPACE + ".select_all", productNumber);
	} // end select()

	
	@Override 
	public QnaVO select1(int productQuestionNumber) {
		logger.info("select() 호출 : productNumber = " + productQuestionNumber); 
		return sqlSession.selectOne(NAMESPACE + ".select_by_product_number", productQuestionNumber);
	} // end select()
	 
	@Override
	public int update(QnaVO vo) {
		logger.info("update() 호출 : vo = " + vo.toString());
		return sqlSession.update(NAMESPACE + ".update", vo);
	} // end update()

	@Override
	public int delete(int productQuestionNumber) {
		logger.info("delete() 호출  : productQuestionNumber = " + productQuestionNumber);
		return sqlSession.delete(NAMESPACE + ".delete", productQuestionNumber);
	} // end delete()

	@Override
	public List<QnaVO> select(PageCriteria criteria, int productNumber) {
		logger.info("================select() 호출");
		logger.info("productNumber = " + productNumber);
		logger.info("start = " + criteria.getStart());
		logger.info("end = " + criteria.getEnd());
		HashMap map = new HashMap();
		map.put("start", criteria.getStart());
		map.put("end", criteria.getEnd());
		map.put("productNumber", productNumber);
		return sqlSession.selectList(NAMESPACE + ".paging", map);
	} // end select()

	@Override
	public int getTotalCounts(int productNumber) {
		logger.info("getTotalCounts() 제품 번호 = " + productNumber);
		return sqlSession.selectOne(NAMESPACE + ".total_count", productNumber);
	} // end getTotalCounts()

} // end QnaDaoImple
