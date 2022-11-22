package project.shopping.musinsa.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import project.shopping.musinsa.domain.ProductVO;
import project.shopping.musinsa.pageutil.PageCriteria;
import project.shopping.musinsa.pageutil.PageMaker;
import project.shopping.musinsa.service.ProductLikeService;
import project.shopping.musinsa.service.ProductService;
import project.shopping.musinsa.util.MediaUtil;

@Controller
@RequestMapping(value = "/product")
public class ProductController {
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Resource(name = "uploadPath")
	private String uploadPath;

	@Autowired
	private ProductService productService;
	@Autowired
	private ProductLikeService productLikeService;

	@GetMapping("/list")
	public void list(Model model, Integer page, Integer numsPerPage) {
		logger.info("list() 호출");
		logger.info("page = " + page + ", numsPerPage = " + numsPerPage);

		PageCriteria criteria = new PageCriteria();
		if (page != null) {
			criteria.setPage(page);
		}

		if (numsPerPage != null) {
			criteria.setNumsPerPage(numsPerPage);
		}

		List<ProductVO> list = productService.read(criteria);
		logger.info(list.toString());

		String[] imgList = null;
		for (ProductVO vo : list) {
			
			 logger.info(vo.toString()); 
			 imgList = vo.getProductImg().split(" "); 
			 vo.setProductImg(imgList[0].toString());
			 logger.info("이미지 리스트 = " + imgList[0].toString());
		}
		model.addAttribute("imgList", imgList);
		model.addAttribute("list", list);

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);
		pageMaker.setTotalCount(productService.getTotalCounts());
		pageMaker.setPageData();
		model.addAttribute("pageMaker", pageMaker);

	}

	@GetMapping("/register")
	public void registerGET() {
		logger.info("regiseterGET 호출");
	}

	@PostMapping("/register")
	public String regiterPOST(MultipartFile[] files, HttpServletRequest request, ProductVO vo,
			RedirectAttributes reAttr) {
		logger.info("registerPOST 호출");
		String[] sizeList = request.getParameterValues("size");
		vo.setProductSize(String.join(", ", sizeList));

		String category = request.getParameter("productCategory");
		vo.setProductCategory(category);

		String img = "";
		for (MultipartFile f : files) {
			img += saveUploadFile(f) + " ";
		}
		logger.info("파일 저장 경로" + uploadPath);
		logger.info("img = " + img);
		vo.setProductImg(img);

		int result = productService.create(vo);
		logger.info(result + "행 삽입");

		return "redirect:/product/list";

	}

	@GetMapping("/display")
	public ResponseEntity<byte[]> display(String fileName) throws Exception {
		logger.info("display() 호출");

		ResponseEntity<byte[]> entity = null;
		InputStream in = null;

		String filePath = uploadPath + fileName;
		in = new FileInputStream(filePath);

		String extension = filePath.substring(filePath.lastIndexOf(".") + 1);

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaUtil.getMediaType(extension));

		entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), httpHeaders, HttpStatus.OK);

		return entity;

	}

	private String saveUploadFile(MultipartFile file) {
		UUID uuid = UUID.randomUUID();
		String savedName = uuid + "_" + file.getOriginalFilename();
		File target = new File(uploadPath, savedName);

		try {
			FileCopyUtils.copy(file.getBytes(), target);
			logger.info("파일 저장 성공");
			return savedName;
		} catch (Exception e) {
			logger.info("파일 저장 실패");
			return null;
		}
	}

	@GetMapping("/detail")
	public void detail(Model model, Integer productNumber, Integer page) {
		logger.info("detail() 호출 : productNumber = " + productNumber);
		ProductVO vo = productService.read(productNumber);
		String[] imgList = vo.getProductImg().split(" ");
		vo.setProductImg(imgList[0].toString());
		List<String> Llist = new ArrayList<String>(Arrays.asList(imgList));
		Llist.remove(0);
		imgList = Llist.toArray(new String[0]);
		model.addAttribute("imgList", imgList);
		model.addAttribute("vo", vo);
		model.addAttribute("page", page);
	}

	@GetMapping("/update")
	public void updateGET(Model model, Integer productNumber, Integer page) {
		logger.info("updateGET() 호출 : productNumber = " + productNumber);
		ProductVO vo = productService.read(productNumber);
		model.addAttribute("vo", vo);
		model.addAttribute("page", page);
	}

	@PostMapping("/update")
	public String updatePOST(ProductVO vo, Integer page, MultipartFile[] files, HttpServletRequest request) {
		logger.info("updatePOST() 호출 : vo = " + vo.toString());

		String[] sizeList = request.getParameterValues("size");
		vo.setProductSize(String.join(", ", sizeList));

		String category = request.getParameter("productCategory");
		vo.setProductCategory(category);

		String img = "";
		for (MultipartFile f : files) {
			img += saveUploadFile(f) + "";
		}
		logger.info("파일 저장 경로" + uploadPath);
		logger.info("img = " + img);
		vo.setProductImg(img);

		int result = productService.update(vo);
		if (result == 1) {
			return "redirect:/product/detail?productNumber=" + vo.getProductNumber() + "&page=" + page;
		} else {
			return "redirect:/product/detail?productNumber=" + vo.getProductNumber() + "&page=" + page;
		}
	}

	@PostMapping("/delete")
	public String delete(Integer productNumber) {
		logger.info("Controller.deletePOST() 호출 : productNumber = " + productNumber);
		int result = productService.delete(productNumber);
		if (result == 1) {
			return "redirect:/product/list";
		} else {
			return "redirect:/product/list";
		}
	}

}
