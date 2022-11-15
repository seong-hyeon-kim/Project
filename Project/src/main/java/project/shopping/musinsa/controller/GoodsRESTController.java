package project.shopping.musinsa.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.shopping.musinsa.domain.ProductLikeVO;
import project.shopping.musinsa.domain.ProductVO;
import project.shopping.musinsa.service.ProductLikeService;
import project.shopping.musinsa.service.ProductService;

@RestController
@RequestMapping(value = "/detail")
public class GoodsRESTController {
	private static final Logger logger = LoggerFactory.getLogger(GoodsRESTController.class);
	
	@Autowired
	private ProductLikeService productLikeService;
	@Autowired
	private ProductService productService;
	
	@PostMapping
	public ResponseEntity<Integer> createLike(@RequestBody ProductLikeVO vo) {
		int result = productLikeService.read(vo);
		try {
			if(result == 0) {
				result = productLikeService.create(vo);
			} else {
				result = productLikeService.delete(vo);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}
	
	@GetMapping("?productNumber={productNumber}")
	public ResponseEntity<List<ProductVO>> readProductDetail(
			@PathVariable("productNumber") int productNumber) {
		
		List<ProductVO> list = (List<ProductVO>) productService.read(productNumber);
		return new ResponseEntity<List<ProductVO>>(list, HttpStatus.OK);
	}
	
	
	
}
