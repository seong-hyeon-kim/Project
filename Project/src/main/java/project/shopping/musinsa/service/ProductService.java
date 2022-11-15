package project.shopping.musinsa.service;



import java.util.List;

import project.shopping.musinsa.domain.ProductVO;
import project.shopping.musinsa.pageutil.PageCriteria;

public interface ProductService {
	int create(ProductVO vo);
	List<ProductVO> read(PageCriteria criteria);
	ProductVO read(int productNumber);

	int update(ProductVO vo);
	int delete(int productNumber);
	int getTotalCounts();
	
}
