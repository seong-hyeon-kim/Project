package project.shopping.musinsa.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.shopping.musinsa.domain.BoardVO;
import project.shopping.musinsa.pageutil.PageCriteria;
import project.shopping.musinsa.persistence.BoardDAO;

@Service
public class BoardServiceImple implements BoardService {

	private static final Logger logger =
			LoggerFactory.getLogger(BoardServiceImple.class);
	
	@Autowired
	private BoardDAO dao;
	
	@Override
	public int create(BoardVO vo) {
		logger.info("create() ȣ�� : vo = " + vo.toString());
		return dao.insert(vo);
	}

	@Override
	public BoardVO read(int boardNumber) {
		logger.info("read() ȣ��  : boardId = " + boardNumber);
		return dao.select(boardNumber);
	}

	@Override
	public List<BoardVO> read(PageCriteria criteria) {
		logger.info("read() ȣ��");
		logger.info("start = " + criteria.getStart());
		logger.info("end = " + criteria.getEnd());
		return dao.select(criteria);
	}

	@Override
	public int update(BoardVO vo) {
		logger.info("update() ȣ��  : vo = " + vo.toString());
		return dao.update(vo);
	}

	@Override
	public int delete(int boardNumber) {
		logger.info("delete() ȣ��  : boardId = " + boardNumber);
		return dao.delete(boardNumber);
	}

	@Override
	public int getTotalCounts() {
		logger.info("getTotalCounts() ȣ��" );
		return dao.getTotalCounts();
	}


} // end BoardServiceimple
