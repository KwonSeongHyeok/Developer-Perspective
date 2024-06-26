package webtoon.semi.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;
import webtoon.semi.dto.Inquiry;
import webtoon.semi.dto.Webtoon;
import webtoon.semi.service.InquiryService;
@Slf4j
@Controller
public class IndexController {
	
	@Autowired
	private InquiryService inquiryService;
	
	//메인에서 문의게시판 이동
	@GetMapping("/inquiry-Board")
	public String inquiryBoard() {
		return "inquiryBoard";
	}
	
	//사용자 문의 입력창에 기본 필드 전달
	@GetMapping("/inquiryRegister")
	public String inquiryRegister(Model model) {
		
		model.addAttribute("inquiry",new Inquiry()); // dto Inquiry 의 멤버로 할것
		
		return "inquiryRegister";//html 연결
	}
	
	// 검색결과 정보 담아서 전달
		@PostMapping("/search-result")
		public String searchWebtoon(Model model, @RequestParam("keyword") String keyword) {
			List<Webtoon> webtoon = inquiryService.searchWebtoon(keyword);
			model.addAttribute("result",webtoon);
			log.info("webtoon 정보확인 : " + webtoon);
			
			if(webtoon == null) {
				return "redirect:/";
			}
			return "searchResult";
		}
	
		// search 버튼 이동 경로 설정
	@GetMapping("/search-result")
	public String searchView() {
		
		return "searchResult";
	}
	
	
	
}
