package project.shopping.musinsa.service;

import java.util.List;

import project.shopping.musinsa.domain.ProductLikeVO;
import project.shopping.musinsa.domain.ProductVO;

public interface ProductLikeService {
	int create(ProductLikeVO vo);
	List<ProductVO> read(int productNumber);
	int read(ProductLikeVO vo); // ���ƿ� ���� ã��
	int delete(ProductLikeVO vo) throws Exception;
	List<ProductLikeVO> readLike(String userId);
}
