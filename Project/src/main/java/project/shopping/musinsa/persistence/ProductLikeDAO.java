package project.shopping.musinsa.persistence;

import java.util.List;

import project.shopping.musinsa.domain.ProductLikeVO;
import project.shopping.musinsa.domain.ProductVO;

public interface ProductLikeDAO {
	int insert(ProductLikeVO vo);
	List<ProductVO> select(int productNumber);
	int selectLikeCnt(ProductLikeVO vo);
	int delete(ProductLikeVO vo);
	List<ProductLikeVO> selectLike(String userId);
}
