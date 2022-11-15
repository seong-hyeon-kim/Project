package project.shopping.musinsa;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.shopping.musinsa.domain.ProductVO;
import project.shopping.musinsa.pageutil.PageCriteria;
import project.shopping.musinsa.pageutil.PageMaker;
import project.shopping.musinsa.service.ProductService;

@Controller
public class HomeController {
	
	// TODO : root-context 설정 안함
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, Integer page, Integer numsPerPage) {
		numsPerPage = 50;
		logger.info("main() 호출");
		logger.info("page = " + page + ", numsPerPage = " + numsPerPage);
		
		PageCriteria criteria = new PageCriteria();
		if(page != null) {
			criteria.setPage(page);
		}
		
		if(numsPerPage != null) {
			criteria.setNumsPerPage(numsPerPage);
		}
		
		List<ProductVO> list = productService.read(criteria);
		for (ProductVO vo : list) {
			logger.info(vo.toString());
		}
		model.addAttribute("list", list);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);
		pageMaker.setTotalCount(productService.getTotalCounts());
		pageMaker.setPageData();
		model.addAttribute("pageMaker", pageMaker);
		
		return "main";
	}
	
}
