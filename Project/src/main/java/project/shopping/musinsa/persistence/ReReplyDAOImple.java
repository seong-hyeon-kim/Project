package project.shopping.musinsa.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import project.shopping.musinsa.domain.ReReplyVO;

@Repository
public class ReReplyDAOImple implements ReReplyDAO {
	private static final Logger logger = 
			LoggerFactory.getLogger(ReReplyDAOImple.class);
	private static final String NAMESPACE =
			"project.shopping.musinsa.ReReplyMapper";
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insert(ReReplyVO vo) {
		logger.info("********insert() 호출 : vo = " + vo.toString());
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	} // end insert()

	@Override
	public List<ReReplyVO> select(int replyNumber) {
		logger.info("*********select() 호출 : replyNumber = " + replyNumber);
		return sqlSession.selectList(NAMESPACE + ".select_all_by_reply_number", replyNumber);
	} // end select()

	@Override
	public int delete(int reReplyNumber) {
		logger.info("*********delete() 호출 : reReplyNumber = "  + reReplyNumber);
		return sqlSession.delete(NAMESPACE + ".delete", reReplyNumber);
	} // end delete()

} // end ReReplyDAOImple()
