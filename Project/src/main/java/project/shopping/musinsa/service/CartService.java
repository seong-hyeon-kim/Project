package project.shopping.musinsa.service;

import java.util.List;

import project.shopping.musinsa.domain.CartVO;

public interface CartService {
	int create(CartVO vo);
	List<CartVO> read(String userId);
	int update(CartVO vo);
	int delete(int cartNumber);
	List<String> readC(String userId);
}
