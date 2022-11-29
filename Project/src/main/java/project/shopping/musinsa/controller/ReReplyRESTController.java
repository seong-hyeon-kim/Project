package project.shopping.musinsa.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.shopping.musinsa.domain.ReReplyVO;
import project.shopping.musinsa.service.ReReplyService;

@RestController
@RequestMapping(value = "/re-replies")
public class ReReplyRESTController {
	private static final Logger logger = LoggerFactory.getLogger(ReReplyRESTController.class);

	@Autowired
	private ReReplyService reService;

	@PostMapping
	public ResponseEntity<Integer> createRe(@RequestBody ReReplyVO vo) {
		logger.info("createRe() 호출 : vo " + vo.toString());
		int result = reService.create(vo);
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	} // end createRe()

	@GetMapping("/all/{replyNumber}")
	public ResponseEntity<List<ReReplyVO>> readRe(@PathVariable("replyNumber") int replyNumber) {
		List<ReReplyVO> list = reService.read(replyNumber);
		return new ResponseEntity<List<ReReplyVO>>(list, HttpStatus.OK);
	} // end readRe()

	@DeleteMapping("/{reReplyNumber}")
	public ResponseEntity<Integer> deleteRe(@PathVariable("reReplyNumber") int reReplyNumber,
			@RequestBody ReReplyVO vo) {
		logger.info("deleteRe() 호출 : 대댓글 번호 : " + reReplyNumber);
		int result = reService.delete(reReplyNumber);
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	} // end deleteRe()

} // end ReReplyRESTController
