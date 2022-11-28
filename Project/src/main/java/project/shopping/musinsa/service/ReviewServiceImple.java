package project.shopping.musinsa.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.shopping.musinsa.domain.ReviewVO;
import project.shopping.musinsa.persistence.ReviewDAO;

@Service
public class ReviewServiceImple implements ReviewService {
	private static final Logger logger = 
			LoggerFactory.getLogger(ReviewServiceImple.class);
	
	@Autowired
	private ReviewDAO reviewDao;

	@Override
	public int create(ReviewVO rvo) {
		logger.info("create() 호출 : rvo = " + rvo.toString());
		return reviewDao.insert(rvo);
	} // end create()

	@Override
	public List<ReviewVO> read(int productNumber) {
		logger.info("read() 호출");
		return reviewDao.select(productNumber);
	} // end read()

	@Override
	public int update(ReviewVO rvo) {
		logger.info("update() 호출 : rvo = " + rvo.toString());
		return reviewDao.update(rvo);
	} // end update()

	@Override
	public int delete(int reviewNumber) {
		logger.info("delete() 호출  : 리뷰 글 번호 = " + reviewNumber);
		return reviewDao.delete(reviewNumber);
	} // end delete()

} // end ReviewServiceImple
