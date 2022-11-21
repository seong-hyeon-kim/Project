package project.shopping.musinsa.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import project.shopping.musinsa.domain.BoardVO;
import project.shopping.musinsa.pageutil.PageCriteria;
import project.shopping.musinsa.pageutil.PageMaker;
import project.shopping.musinsa.service.BoardService;

@Controller
@RequestMapping(value = "/board")
public class BoardController {
	private static final Logger logger =
			LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService boardService;
	
	// �Խù� ���
	@GetMapping("/csqnaRegister")
	public void csqnaregisterGET() {
		logger.info("csqnaRegisterGET() ȣ��");
	} // end csqnaregisterGET
	
	@PostMapping("/csqnaRegister")
	public String csqnaregisterPOST(BoardVO vo, RedirectAttributes reAttr) {
		logger.info("csqnaRegisterPOST() ȣ��");
		logger.info(vo.toString());
		int result = boardService.create(vo);
		logger.info(result + "���� �Ϸ�");
		if(result == 1) {
			reAttr.addFlashAttribute("insert_result", "success");
			return "redirect:/board/csqnaList";
	} else {
		return "redirect:/board/csqnaRegister";
	  }
	} // end csqnaregisterPOST
	
	
	  @GetMapping("/csqnaList")
	   public void list(Model model, Integer page, Integer numsPerPage) {
	      logger.info("csqnalist() ȣ��");
	      logger.info("page = " + page + ", numsPerPage = " + numsPerPage);
	      
	      // Paging ó��
	      PageCriteria criteria = new PageCriteria();
	      if(page != null) {
	         criteria.setPage(page);
	      }
	      
	      if(numsPerPage != null) {
	         criteria.setNumsPerPage(numsPerPage);
	      }
	      
	      List<BoardVO> list = boardService.read(criteria);
	      model.addAttribute("list" , list);
	      
	      PageMaker pageMaker = new PageMaker();
	      pageMaker.setCriteria(criteria);
	      pageMaker.setTotalCount(boardService.getTotalCounts());
	      pageMaker.setPageData();
	      model.addAttribute("pageMaker", pageMaker);
	      
	   } // end csqnalist()
	
	   @GetMapping("/csqnaDetail")
	   public void detail(Model model, Integer boardNumber, Integer page) {
		   logger.info("csqnaDetail() ȣ��  : boardNumber = " + boardNumber);
		   BoardVO vo = boardService.read(boardNumber);
		   model.addAttribute("vo", vo);
		   model.addAttribute("page", page);
	   } // end csqnadetail
	   
	   @GetMapping("/csqnaUpdate")
	   public void updateGET(Model model, Integer boardNumber, Integer page) {
		   logger.info("csqnaUpdateGET() ȣ�� : boardNumber = : " + boardNumber);
		   BoardVO vo = boardService.read(boardNumber); // �������� 
		   model.addAttribute("vo", vo); //�������� ����
		   model.addAttribute("page", page);
	   } // end csqnaupdateGET
	   
	   @PostMapping("/csqnaUpdate")
	   public String updatePOST(BoardVO vo, Integer page) {
		   logger.info("csqnaUpdatePOST() ȣ�� : vo = " + vo.toString());
		   int result = boardService.update(vo);
		   if(result == 1) {
			   return "redirect:/board/csqnaList?page=" + page;
		   } else {
			   return "redirect:/board/csqnaupdate?boardNumber=" + vo.getBoardNumber();
		   } 
	   } // end csqnaUpdatePOST
	   
	   
	   @PostMapping("/csqnaDelete")
	   public String deletePOST(Integer boardNumber) {
		   logger.info("delete() ȣ�� : boardNumber = " + boardNumber);
		   int result = boardService.delete(boardNumber);
		   if(result == 1) {
			   return "redirect:/board/csqnaList";
		   } else {
			   return "redirect:/board/csqnaList";
		   }
	   } // end csqnaDeletePOST
	   
} // end BoardController
