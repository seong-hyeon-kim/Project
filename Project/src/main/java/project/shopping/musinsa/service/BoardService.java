package project.shopping.musinsa.service;

import java.util.List;

import project.shopping.musinsa.domain.BoardVO;
import project.shopping.musinsa.pageutil.PageCriteria;

//CRUD (Create, Read, Update, Delete)
public interface BoardService {
	
		// 등록
		int create(BoardVO vo);
		
		// 검색
		BoardVO read(int boardNumber);
		
		// 전체검색
		List<BoardVO> read(PageCriteria criteria);
		
		// 수정
		int update(BoardVO vo);
		
		// 삭제
		int delete(int boardNumber);
		
		// 총 게시물 수
		int getTotalCounts();
		
		

} // end BoardService
