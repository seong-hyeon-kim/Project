package project.shopping.musinsa.service;

import java.util.List;

import project.shopping.musinsa.domain.ReReplyVO;

public interface ReReplyService {
	int create(ReReplyVO vo);
	
	List<ReReplyVO> read(int replyNumber);
	
	int delete(int reReplyNumber);

} // end ReReplyService
