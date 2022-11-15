package project.shopping.musinsa.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project.shopping.musinsa.domain.ProductLikeVO;
import project.shopping.musinsa.domain.ProductVO;
import project.shopping.musinsa.persistence.ProductDAO;
import project.shopping.musinsa.persistence.ProductLikeDAO;

@Service
public class ProductLikeServiceImple implements ProductLikeService{
	private static final Logger logger = LoggerFactory.getLogger(ProductLikeServiceImple.class);
	
	@Autowired
	ProductLikeDAO productLikeDAO;
	@Autowired
	ProductDAO productDAO;

	@Transactional
	@Override
	public int create(ProductLikeVO vo) {
		logger.info("ProductLike.ServiceImple.create() 호출 : vo = " + vo.toString());
		productLikeDAO.insert(vo);
		logger.info("좋아요 성공");
		productDAO.updateProductGood(1, vo.getProductNumber());
		logger.info("상품 좋아요 갯수 업데이트 성공");
		return 1;
	}

	@Override
	public List<ProductVO> read(int productNumber) {
		logger.info("read() 호출");
		return productLikeDAO.select(productNumber);
	}

	@Override
	public int read(ProductLikeVO vo) {
		logger.info("좋아요 여부 read 찾기");
		return productLikeDAO.selectLikeCnt(vo);
	}

	@Transactional
	@Override
	public int delete(ProductLikeVO vo) throws Exception {
		productLikeDAO.delete(vo);
		productDAO.updateProductGood(-1, vo.getProductNumber());
		logger.info("좋아요 취소");
		return 1;
	}

	@Override
	public List<ProductLikeVO> readLike(String userId) {
		logger.info("readLike() 호출");
		return productLikeDAO.selectLike(userId);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
