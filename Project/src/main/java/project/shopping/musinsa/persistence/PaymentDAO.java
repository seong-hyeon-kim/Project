package project.shopping.musinsa.persistence;

import java.util.List;

import project.shopping.musinsa.domain.PaymentVO;

public interface PaymentDAO {
	int insert(PaymentVO vo);
	List<PaymentVO> select(String userId);
	int update(PaymentVO vo);
}
