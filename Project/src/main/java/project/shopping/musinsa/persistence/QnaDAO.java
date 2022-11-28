package project.shopping.musinsa.persistence;

import java.util.List;

import project.shopping.musinsa.domain.QnaVO;
import project.shopping.musinsa.pageutil.PageCriteria;

public interface QnaDAO {
	// 등록
	int insert(QnaVO vo);
	
	// 전체검색
	List<QnaVO> select(int productNumber);
	
	// 상세검색(하나만)
	QnaVO select1(int productQuestionNumber);
	
	// 수정
	int update(QnaVO vo);
	
	// 삭제
	int delete(int productQuestionNumber);
	
	// 페이징 처리
	List<QnaVO> select(PageCriteria criteria, int productNumber);
	
	// 총 게시글 수
	int getTotalCounts(int productNumber);
	
	

} // end QnaDAO
