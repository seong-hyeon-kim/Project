package project.shopping.musinsa.persistence;

import java.util.List;

import project.shopping.musinsa.domain.QnaVO;
import project.shopping.musinsa.pageutil.PageCriteria;

public interface QnaDAO {
	// ���
	int insert(QnaVO vo);
	
	// ��ü�˻�
	List<QnaVO> select(int productNumber);
	
	// �󼼰˻�(�ϳ���)
	QnaVO select1(int productQuestionNumber);
	
	// ����
	int update(QnaVO vo);
	
	// ����
	int delete(int productQuestionNumber);
	
	// ����¡ ó��
	List<QnaVO> select(PageCriteria criteria, int productNumber);
	
	// �� �Խñ� ��
	int getTotalCounts(int productNumber);
	
	

} // end QnaDAO
