package project.shopping.musinsa.persistence;

import java.util.List;

import project.shopping.musinsa.domain.ReReplyVO;

public interface ReReplyDAO {
	// 대댓글 등록
	int insert(ReReplyVO vo);
	
	// 대댓글 전체 검색 
	List<ReReplyVO> select(int replyNumber);
	
	// 대댓글 삭제
	int delete(int reReplyNumber);

} // end ReReplyDAO
