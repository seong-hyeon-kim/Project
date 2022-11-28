package project.shopping.musinsa.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.shopping.musinsa.domain.ReReplyVO;
import project.shopping.musinsa.persistence.ReReplyDAO;

@Service
public class ReReplyServiceImple implements ReReplyService {
	private static final Logger logger =
			LoggerFactory.getLogger(ReReplyServiceImple.class);
	
	@Autowired
	private ReReplyDAO reDAO;

	@Override
	public int create(ReReplyVO vo) {
		logger.info("create() 호출 : vo = " + vo.toString());
		int result = reDAO.insert(vo);
		logger.info("대댓글 입력 성공");
		return result;
	} // end create()

	@Override
	public List<ReReplyVO> read(int replyNumber) {
		logger.info("read() 호출 : replyNumber = " + replyNumber);
		return reDAO.select(replyNumber);
	} // end read()

	@Override
	public int delete(int reReplyNumber) {
		logger.info("delete() 호출 : reReplyNumber = " + reReplyNumber);
		return reDAO.delete(reReplyNumber);
	} // end delete()

} // end ReReplyServiceImple
