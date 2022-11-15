package project.shopping.musinsa.service;

import java.util.List;

import project.shopping.musinsa.domain.PaymentVO;

public interface PaymentService {
	int create(PaymentVO vo);
	List<PaymentVO> read(String userId);
}
