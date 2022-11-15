package project.shopping.musinsa.persistence;

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
	public List<QnaVO> select() {
		logger.info("select() 호출");
		return sqlSession.selectList(NAMESPACE + ".select_all");
	} // end select()

	@Override
	public QnaVO select(int productQuestionNumber) {
		logger.info("select() 호출 : productQuestionNumber = " + productQuestionNumber);
		return sqlSession.selectOne(NAMESPACE + ".select_by_question_number", productQuestionNumber);
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
	public List<QnaVO> select(PageCriteria criteria) {
		logger.info("select() 호출");
		logger.info("start = " + criteria.getStart());
		logger.info("end = " + criteria.getEnd());
		return sqlSession.selectList(NAMESPACE + ".paging", criteria);
	} // end select()

	@Override
	public int getTotalCounts() {
		logger.info("getTotalCounts()");
		return sqlSession.selectOne(NAMESPACE + ".total_count");
	} // end getTotalCounts()

} // end QnaDaoImple
