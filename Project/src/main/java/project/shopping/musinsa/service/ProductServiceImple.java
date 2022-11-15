package project.shopping.musinsa.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.shopping.musinsa.domain.ProductVO;
import project.shopping.musinsa.pageutil.PageCriteria;
import project.shopping.musinsa.persistence.ProductDAO;

@Service
public class ProductServiceImple implements ProductService{
	private static final Logger logger = LoggerFactory.getLogger(ProductServiceImple.class);

	@Autowired
	private ProductDAO dao;

	@Override
	public int create(ProductVO vo) {
		logger.info("ServiceImple.create() 호출 : vo = " + vo.toString());
		return dao.insert(vo);
	}

	@Override
	public List<ProductVO> read(PageCriteria criteria) {
		logger.info("ServiceImple.read() 호출");
		logger.info("start = " + criteria.getStart());
		logger.info("end = " + criteria.getEnd());
		return dao.select(criteria);
	}

	@Override
	public int getTotalCounts() {
		logger.info("ServiceImple.getTotalCounts() 호출");
		return dao.getTotalCounts();
	}

	@Override
	public ProductVO read(int productNumber) {
		logger.info("ServiceImple.read() 호출");
		
		return dao.select(productNumber);
	}

	@Override
	public int update(ProductVO vo) {
		logger.info("ServiceImple.update() 호출 : vo = " + vo.toString());
		
		return dao.update(vo);
	}

	@Override
	public int delete(int productNumber) {
		logger.info("ServiceImple.delete() 호출 : productNumber = " + productNumber);
		return dao.delete(productNumber);
	}
	
	

}
