package project.shopping.musinsa.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.shopping.musinsa.domain.PaymentVO;
import project.shopping.musinsa.persistence.PaymentDAO;

@Service
public class PaymentServiceImple implements PaymentService{
	private static final Logger logger = LoggerFactory.getLogger(PaymentServiceImple.class);
	
	@Autowired
	private PaymentDAO dao;

	@Override
	public int create(PaymentVO vo) {
		logger.info("create() 호출 : vo = " + vo.toString());
		return dao.insert(vo);
	}

	@Override
	public List<PaymentVO> read(String userId) {
		logger.info("read 호출 : userId = " + userId);
		return dao.select(userId);
	}
	
	
	
	
}
