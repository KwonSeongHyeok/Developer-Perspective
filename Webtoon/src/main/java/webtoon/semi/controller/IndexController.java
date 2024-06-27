package webtoon.semi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import webtoon.semi.dto.Inquiry;
import webtoon.semi.service.InquiryService;

@Controller
public class IndexController {
	
	@Autowired
	private InquiryService inquiryService;
	
	
	@GetMapping("/InquiryRegister")
	public String getAllInquiry(Model model) {
		List<Inquiry> iList = inquiryService.getAllInquiry();
		model.addAttribute("inquiry",iList);//Member import dto의Member로 할것(java내장 import조심)
		return "InquiryRegister";//memberRegister.html로연결
	}

}
