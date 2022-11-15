package project.shopping.musinsa.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.shopping.musinsa.domain.CartVO;
import project.shopping.musinsa.persistence.CartDAO;

@Service
public class CartServiceImple implements CartService{
	private static final Logger logger = LoggerFactory.getLogger(CartServiceImple.class);
	
	@Autowired
	private CartDAO dao;

	@Override
	public int create(CartVO vo) {
		logger.info("create() 호출 : vo = " + vo.toString());
		
		return dao.insert(vo);
	}

	@Override
	public List<CartVO> read(String userId) {
		logger.info("read 호출 : userId = " + userId);
		return dao.select(userId);
	}

	@Override
	public int update(CartVO vo) {
		logger.info("update() 호출 : vo = " + vo.toString());
		
		return dao.update(vo);
	}

	@Override
	public int delete(int cartNumber) {
		logger.info("delete() 호출 : cartNumber" + cartNumber);
		return dao.delete(cartNumber);
	}

	@Override
	public List<String> readC(String userId) {
		logger.info("readC : productNumber = " + userId);
		return dao.select2(userId);
	}
	
	
	
	
	
}
