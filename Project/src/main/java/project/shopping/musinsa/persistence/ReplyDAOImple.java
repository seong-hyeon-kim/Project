package project.shopping.musinsa.persistence;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import project.shopping.musinsa.domain.ReplyVO;

@Repository
public class ReplyDAOImple implements ReplyDAO {
	private static final Logger logger =
			LoggerFactory.getLogger(ReplyDAOImple.class);
	private static final String NAMESPACE =
			"project.shopping.musinsa.ReplyMapper";
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insertReply(Map<String, Object> paramMap) {
		logger.info("insertReply() ȣ��");
		return sqlSession.insert(NAMESPACE + ".insertReply", paramMap);
	} // end insertReply()

	@Override
	public List<ReplyVO> select(int reviewNumber) {
		logger.info("select() ȣ�� : reviewNumber = " + reviewNumber);
		return sqlSession.selectList(NAMESPACE + ".selectReplyList", reviewNumber);
	} // end select()

	@Override
	public int update(ReplyVO vo) {
		logger.info("update() ȣ�� : vo = " + vo.toString());
		return sqlSession.update(NAMESPACE + ".update", vo);
	} // end update()

	@Override
	public int delete(int replyNumber) {
		logger.info("delete() ȣ�� : replyNumber = " + replyNumber);
		return sqlSession.delete(NAMESPACE + ".delete", replyNumber);
	} // end delete()

} // end ReplyDAOImple
