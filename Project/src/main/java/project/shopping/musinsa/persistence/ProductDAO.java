package project.shopping.musinsa.persistence;

import java.util.List;

import project.shopping.musinsa.domain.ProductVO;
import project.shopping.musinsa.pageutil.PageCriteria;

public interface ProductDAO {
	int insert(ProductVO vo);
	List<ProductVO> select();
	List<ProductVO> select(PageCriteria criteria);
	ProductVO select(int productNumber);
	int update(ProductVO vo);
	int delete(int productNumber);
	
	
	int getTotalCounts();
	int updateProductGood(int amount, int productNumber);
}
