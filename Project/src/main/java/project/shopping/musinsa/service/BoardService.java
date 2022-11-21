package project.shopping.musinsa.service;

import java.util.List;

import project.shopping.musinsa.domain.BoardVO;
import project.shopping.musinsa.pageutil.PageCriteria;

//CRUD (Create, Read, Update, Delete)
public interface BoardService {
	
		// ���
		int create(BoardVO vo);
		
		// �˻�
		BoardVO read(int boardNumber);
		
		// ��ü�˻�
		List<BoardVO> read(PageCriteria criteria);
		
		// ����
		int update(BoardVO vo);
		
		// ����
		int delete(int boardNumber);
		
		// �� �Խù� ��
		int getTotalCounts();
		
		

} // end BoardService
