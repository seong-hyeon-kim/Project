package project.shopping.musinsa.persistence;

import java.util.List;

import project.shopping.musinsa.domain.BoardVO;
import project.shopping.musinsa.pageutil.PageCriteria;

public interface BoardDAO {

	// �Խù� ���
	int insert(BoardVO vo);
	
	// �Խù� �˻�
	BoardVO select(int boardNumber);
	
	// �Խù� ��ü �˻�
	List<BoardVO> select();
		
	// �Խù� ����
	int update(BoardVO vo);
	
	// �Խù� ����
	int delete(int boardNumber);
	
	// ����¡ ó��
	List<BoardVO> select(PageCriteria criteria);
	
	// �� �Խñ� ��
	int getTotalCounts();
	
	List<BoardVO> select(String boardNumber);
	
	
} // end BoardVO
