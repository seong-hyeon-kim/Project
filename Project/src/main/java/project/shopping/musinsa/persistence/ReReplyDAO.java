package project.shopping.musinsa.persistence;

import java.util.List;

import project.shopping.musinsa.domain.ReReplyVO;

public interface ReReplyDAO {
	// ���� ���
	int insert(ReReplyVO vo);
	
	// ���� ��ü �˻� 
	List<ReReplyVO> select(int replyNumber);
	
	// ���� ����
	int delete(int reReplyNumber);

} // end ReReplyDAO
