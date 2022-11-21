package project.shopping.musinsa.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import project.shopping.musinsa.domain.BoardVO;
import project.shopping.musinsa.pageutil.PageCriteria;

@Repository
public class BoardDAOImple implements BoardDAO{

		private static final Logger logger =  
				LoggerFactory.getLogger(BoardDAOImple.class);
		private static final String NAMESPACE = 
				"project.shopping.musinsa.boardMapper";
	
		@Autowired
		private SqlSession sqlSession;
		
	// �Խù� ���
	@Override
	public int insert(BoardVO vo) {
		logger.info("insert() ȣ�� : vo = " + vo.toString());
		return sqlSession.insert(NAMESPACE + ".board_insert", vo);
	}

	// �Խù� �˻�
	@Override
	public BoardVO select(int boardNumber) {
		logger.info("select() ȣ�� : boardNumber = " + boardNumber);
		return sqlSession.selectOne(NAMESPACE + ".select_by_board_number", boardNumber);
	}

	// �Խù� ��ü �˻�
	@Override
	public List<BoardVO> select() {
		logger.info("select() ȣ��");
		return sqlSession.selectList(NAMESPACE + ".select_all");
	}

	// �Խù� ����
	@Override
	public int update(BoardVO vo) {
		logger.info("update()ȣ�� : vo = " + vo.toString()); 
		return sqlSession.update(NAMESPACE + ".board_update", vo) ;
	}

	// �Խù� ����
	@Override
	public int delete(int boardNumber) {
		logger.info("delete()ȣ�� : boardNumber = " + boardNumber);
		return sqlSession.delete(NAMESPACE + ".board_delete", boardNumber);
	}

	// ����¡ ó��
	@Override
	public List<BoardVO> select(PageCriteria criteria) {
		logger.info("select() ȣ��");
		logger.info("start = " + criteria.getStart());
		logger.info("end = " + criteria.getEnd());
		return sqlSession.selectList(NAMESPACE + ".paging", criteria);
	}

	// �� �Խñ� ��
	@Override
	public int getTotalCounts() {
		logger.info("getTotalCounts() ȣ��");
		return sqlSession.selectOne(NAMESPACE + ".total_count");
	}

	@Override
	public List<BoardVO> select(String boardNumber) {
		logger.info("select() ȣ�� : memberId = " + boardNumber);
		return sqlSession.selectList(NAMESPACE + ".select_by_userid" , "%" + boardNumber + "%");
	}

} // end BoardDAOImple
