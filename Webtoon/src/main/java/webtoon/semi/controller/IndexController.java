package webtoon.semi.controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import webtoon.semi.dto.Inquiry;
import webtoon.semi.dto.Member;
import webtoon.semi.service.InquiryService;
import webtoon.semi.service.WebtoonService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;
import webtoon.semi.dto.Webtoon;

@Slf4j
@Controller
public class IndexController {
	
	@Autowired
	private InquiryService inquiryService;
	
	@Autowired
	private WebtoonService webtoonService;
	
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

	@GetMapping("/memberRegister")//index.html의 a href="/"와 같게
	public String memberRegister(Model model) {
		
		model.addAttribute("member", new Member());//Member import dto의Member로 할것(java내장 import조심)
		//눌렀을 때 Member객체생성 후 /memberRegister 아이디로 연결된
		//memberRegister.html의
		//form th:action="@{/register-member}" "member"로 전달
		
		return "memberRegister";//memberRegister.html로연결
	}

}





