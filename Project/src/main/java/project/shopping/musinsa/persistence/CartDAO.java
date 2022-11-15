package project.shopping.musinsa.persistence;

import java.util.List;

import project.shopping.musinsa.domain.CartVO;

public interface CartDAO {
	int insert(CartVO vo);
	List<CartVO> select(String userId);
	int update(CartVO vo);
	int delete(int cartNumber);
	List<String> select2(String userId);
}
