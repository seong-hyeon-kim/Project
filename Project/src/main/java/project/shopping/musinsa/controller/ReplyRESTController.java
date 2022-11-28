package project.shopping.musinsa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.shopping.musinsa.domain.ReplyVO;
import project.shopping.musinsa.service.ReplyService;

@RestController
@RequestMapping(value="/replies")
public class ReplyRESTController {
	private static final Logger logger = 
			LoggerFactory.getLogger(ReplyRESTController.class);
	
	@Autowired
	private ReplyService replyService;
	
	@PostMapping
	public Object replySave(@RequestBody Map<String, Object> paramMap) {
		logger.info("replySave() 호출");
		logger.info((String)paramMap.get("replyContent"));
		Map<String, Object> rvo = new HashMap<String, Object>();
		int result = replyService.insertReply(paramMap);
		if(result == 1) {
			rvo.put("code", "OK");
			rvo.put("replyNumber", paramMap.get("replyNumber"));
			rvo.put("message", "등록 성공");
		} else {
			rvo.put("code", "FAIL");
			rvo.put("message", " 등록 실패");
		}
		return rvo;
	} // end replySave
	
	@GetMapping("/all/{reviewNumber}")
	public ResponseEntity<List<ReplyVO>> readReplies(@PathVariable("reviewNumber") int reviewNumber) {
		logger.info("-=-=-=-=-=--=readReplies() 호출 : reviewNumber = " + reviewNumber);
		List<ReplyVO> list = replyService.read(reviewNumber);
		return new ResponseEntity<List<ReplyVO>>(list, HttpStatus.OK);
	} // end replyView()

	@PutMapping("/{replyNumber}")
	public ResponseEntity<Integer> updateReply(
			@PathVariable("replyNumber") int replyNumber,
			@RequestBody ReplyVO vo) {
		vo.setReplyNumber(replyNumber);
		int result = replyService.update(vo);
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	} // end updateReply()
	
	@DeleteMapping("/{replyNumber}")
	public ResponseEntity<Integer> deleteReply(
			@PathVariable("replyNumber") int replyNumber,
			@RequestBody ReplyVO vo) {
		logger.info("replyNumber = " + replyNumber);
		int result = 0;
		result = replyService.delete(replyNumber);
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	} // end deleteReply()

} // end ReplyController
