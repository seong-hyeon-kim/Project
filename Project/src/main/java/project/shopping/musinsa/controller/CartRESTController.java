package project.shopping.musinsa.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.shopping.musinsa.domain.CartVO;
import project.shopping.musinsa.service.CartService;

@RestController
@RequestMapping(value = "/cart")
public class CartRESTController {
	private static final Logger logger = LoggerFactory.getLogger(CartRESTController.class);
	
	@Autowired
	private CartService cartService;
	
	@PutMapping("/{cartNumber}")
	public ResponseEntity<Integer> updateCart(
			@PathVariable("cartNumber") int cartNumber,
			@RequestBody CartVO vo) {
		vo.setCartNumber(cartNumber);
		int result = cartService.update(vo);
				return new ResponseEntity<Integer>(result, HttpStatus.OK);
		
	} // end updateCart
	
	@DeleteMapping("/{cartNumber}")
	public ResponseEntity<Integer> deleteCart(@PathVariable("cartNumber") int cartNumber) {
		int result = 0;
		try {
			result = cartService.delete(cartNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
} // end cartRESTController
