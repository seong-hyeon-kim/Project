package project.shopping.musinsa.persistence;

import java.util.List;

import project.shopping.musinsa.domain.QnaVO;
import project.shopping.musinsa.pageutil.PageCriteria;

public interface QnaDAO {
	// ���
	int insert(QnaVO vo);
	
	// ��ü�˻�
	List<QnaVO> select();
	
	// �󼼰˻�(�ϳ���)
	QnaVO select(int productQuestionNumber);
	
	// ����
	int update(QnaVO vo);
	
	// ����
	int delete(int productQuestionNumber);
	
	// ����¡ ó��
	List<QnaVO> select(PageCriteria criteria);
	
	// �� �Խñ� ��
	int getTotalCounts();
	
	

} // end QnaDAO
