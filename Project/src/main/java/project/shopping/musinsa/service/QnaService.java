package project.shopping.musinsa.service;

import java.util.List;

import project.shopping.musinsa.domain.QnaVO;
import project.shopping.musinsa.pageutil.PageCriteria;

public interface QnaService {
	int create(QnaVO vo);
	
	List<QnaVO> read(PageCriteria criteria, int productNumber);
	
	QnaVO read(int productQuestionNumber);
	
	int update(QnaVO vo);
	
	int delete(int productQuestionNumber);
	
	int getTotalCounts(int productNumber);

} // end QnaService
