package project.shopping.musinsa.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.shopping.musinsa.domain.NonUserVO;
import project.shopping.musinsa.persistence.NonUserDAO;

@Service
public class NonUserServiceImple implements NonUserService{

	private static final Logger logger = LoggerFactory.getLogger(NonUserServiceImple.class);
	
	@Autowired
	private NonUserDAO dao;
	
	@Override
	public int create(NonUserVO vo) {
		logger.info("create »£√‚ : vo = " + vo.toString());
		return dao.insert(vo);
	}
	
}
