package webtoon.semi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;
import webtoon.semi.dto.Inquiry;
import webtoon.semi.service.InquiryService;

@Controller
@Slf4j

public class InquiryController {
	
	@Autowired
	private InquiryService inquiryService;
	
	@PostMapping("/register-inquiry")
	public String insertInquiry(Inquiry inquiry, Model model) {
		inquiryService.insertInquiry(inquiry);
		List<Inquiry> idTitleList = inquiryService.getIdTitleInquiry();
		log.info("값 가져오는지 확인하기 " + idTitleList);
		model.addAttribute("idTitleList",idTitleList);
		model.addAttribute("msg","등록이 완료되었습니다.");
		return "inquiryBoard";
	}
	
	@GetMapping("/inquiryBoard")
	public String getIdTitleInquiry(Model model) {
		List<Inquiry> idTitleList = inquiryService.getIdTitleInquiry();
		model.addAttribute("idTitleList",idTitleList);
		return "inquiryBoard";
	}
	
	//title을 통한 정보조회 
	@GetMapping("/inquiry/{inquiry_id}")
	//주소값이 변할 때는 변하는 변수를 {}로 감싸줌
	//주소값으로 title을 가져와서 주소값에 지정된 타이틀 글자와 일치하는 db 값을 select
	public String getInquiryById(Model model, @PathVariable int inquiry_id) {
		Inquiry inquiry = inquiryService.getInquiryById(inquiry_id);
		model.addAttribute("inquiry",inquiry);
		return "inquiryDetail";
	}
	
}
