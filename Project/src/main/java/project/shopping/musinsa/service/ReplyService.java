package project.shopping.musinsa.service;

import java.util.List;
import java.util.Map;

import project.shopping.musinsa.domain.ReplyVO;

public interface ReplyService {

	int insertReply(Map<String, Object> paramMap);
	
	List<ReplyVO> read(int reviewNumber);
	
	int update(ReplyVO vo);
	
	int delete(int replyNumber);
	
} // end ReplyService
