package webtoon.semi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import webtoon.semi.dto.Inquiry;

@Controller
public class IndexController {
	
	@GetMapping("/inquiryRegister")
	public String inquiryRegister(Model model) {
		
		model.addAttribute("inquiry",new Inquiry()); // dto Inquiry 의 멤버로 할것
		
		return "inquiryRegister";//html 연결
	}
	
}
