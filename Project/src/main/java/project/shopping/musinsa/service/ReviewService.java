package project.shopping.musinsa.service;

import java.util.List;

import project.shopping.musinsa.domain.ReviewVO;

public interface ReviewService {
	int create(ReviewVO rvo);
	
	List<ReviewVO> read(int productNumber);
	
	int update(ReviewVO vo);
	
	int delete(int reviewNumber);
	
} // end ReviewService
