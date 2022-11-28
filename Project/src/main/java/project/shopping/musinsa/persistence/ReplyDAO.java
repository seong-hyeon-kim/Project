package project.shopping.musinsa.persistence;

import java.util.List;
import java.util.Map;

import project.shopping.musinsa.domain.ReplyVO;

public interface ReplyDAO {
	// ´ñ±Û µî·Ï
	int insertReply(Map<String, Object> paramMap);
	
	List<ReplyVO> select(int reviewNumber);
	
	int update(ReplyVO vo);
	
	int delete(int replyNumber);
	
} // end ReplyDAO
