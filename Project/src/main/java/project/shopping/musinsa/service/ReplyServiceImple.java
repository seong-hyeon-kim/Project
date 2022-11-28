package project.shopping.musinsa.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.shopping.musinsa.domain.ReplyVO;
import project.shopping.musinsa.persistence.ReplyDAO;

@Service
public class ReplyServiceImple implements ReplyService {
	private static final Logger logger =
			LoggerFactory.getLogger(ReplyServiceImple.class);
	
	@Autowired
	private ReplyDAO replyDAO;
	
	@Override
	public int insertReply(Map<String, Object> paramMap) {
		logger.info("-----insertReply() 호출");
		return replyDAO.insertReply(paramMap);
	} // end insertReply()

	@Override
	public List<ReplyVO> read(int reviewNumber) {
		logger.info("read() 호출 : reviewNumber = " + reviewNumber);
		return replyDAO.select(reviewNumber);
	} // end read()

	@Override
	public int update(ReplyVO vo) {
		logger.info("update() 호출 : vo = " + vo.toString());
		return replyDAO.update(vo);
	} // end update()

	@Override
	public int delete(int replyNumber) {
		logger.info("delete() 호출 : replyNumber = " + replyNumber);
		replyDAO.delete(replyNumber);
		logger.info("댓글 삭제 성공");
		return 1;
	} // end delete()


} // end ReplyServiceImple
