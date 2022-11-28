package project.shopping.musinsa.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.shopping.musinsa.domain.QnaVO;
import project.shopping.musinsa.pageutil.PageCriteria;
import project.shopping.musinsa.persistence.QnaDAO;

@Service
public class QnaServiceImple implements QnaService {
	private static final Logger logger = 
			LoggerFactory.getLogger(QnaServiceImple.class);
	
	@Autowired
	private QnaDAO dao;

	@Override
	public int create(QnaVO vo) {
		logger.info("create() ȣ�� : vo = " + vo.toString());
		return dao.insert(vo);
	} // end create()

	@Override
	public List<QnaVO> read(PageCriteria criteria, int productNumber) {
		logger.info("read() ȣ�� ");
		logger.info("start = " + criteria.getStart());
		logger.info("end = " + criteria.getEnd());
		return dao.select(criteria, productNumber);
	} // end read()

	
	@Override 
	public QnaVO read(int productQuestionNumber) {
		logger.info("read() ȣ�� : productQuestionNumber = " + productQuestionNumber); 
		return dao.select1(productQuestionNumber); 
	} // end read()
	 
	@Override
	public int update(QnaVO vo) {
		logger.info("update() ȣ�� : vo = " + vo.toString());
		return dao.update(vo);
	} // end update()

	@Override
	public int delete(int productQuestionNumber) {
		logger.info("delete() ȣ�� : productQuestionNumber = " + productQuestionNumber);
		return dao.delete(productQuestionNumber);
	}

	@Override
	public int getTotalCounts(int productNumber) {
		logger.info("getTotalCounts() ȣ��, productNumber = " + productNumber);
		return dao.getTotalCounts(productNumber);
	} // end getTotalCounts()

} // end QnaServiceImple
