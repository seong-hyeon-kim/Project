package project.shopping.musinsa.persistence;

import java.util.List;

import project.shopping.musinsa.domain.ReviewVO;

public interface ReviewDAO {
	// 리뷰 등록
	int insert(ReviewVO rvo);
	
	// 리뷰 글 전부 가져오기
	List<ReviewVO> select(int productNumber);
	
	// 리뷰 수정
	int update(ReviewVO rvo);
	
	// 리뷰 삭제
	int delete(int reviewNumber);
	
} // end ReviewDAO
