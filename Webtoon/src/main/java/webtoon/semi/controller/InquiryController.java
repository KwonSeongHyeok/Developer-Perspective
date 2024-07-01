package webtoon.semi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;
import webtoon.semi.dto.Inquiry;
import webtoon.semi.service.InquiryService;

@Controller
@Slf4j
public class InquiryController {
	
	@Autowired
	private InquiryService inquiryService;
	
	// 문의게시판에서 문의작성폼으로 이동
	@GetMapping("/inquiry_register")
	public String boardreturn() {
		return "redirect:/inquiryRegister";
	}
	
	@PostMapping("/register-inquiry")
	public String insertInquiry(Inquiry inquiry, Model model) {
		inquiryService.insertInquiry(inquiry);
		
		List<Inquiry> iList = inquiryService.getAllInquiry();
		log.info("값 가져오는지 확인하기 " + iList);
		model.addAttribute("iList",iList);
		return "inquiryBoard";
	}
	
	//id를 통한 정보조회 
	@GetMapping("/inquiry/{inquiry_id}")
	//주소값이 변할 때는 변하는 변수를 {}로 감싸줌
	//주소값으로 title을 가져와서 주소값에 지정된 타이틀 글자와 일치하는 db 값을 select
	public String getInquiryById(Model model, @PathVariable int inquiry_id) {
		Inquiry inquiry = inquiryService.getInquiryById(inquiry_id);
		model.addAttribute("inquiry",inquiry);
		return "inquiryDetail";
	}
	
	
	
	
	
	//문의게시판 검색하기 경로
	@PostMapping("/boardSearch-result")
	public String boardSearch(Model model, @RequestParam("keyword") String keyword) {
		List<Inquiry> inquiry = inquiryService.boardSearch(keyword);
		model.addAttribute("result",inquiry);
		log.info("게시판 검색 정보확인 : " + inquiry);
		
		if(inquiry == null) {
			return "redirect:/";
		}
		return "inquiryBoard";
	}

	// search 버튼 이동 경로 설정

	@GetMapping("/boardSearch-result")
	public String boardSearchView() {
	
	return "inquiryBoard";
}
	
}
