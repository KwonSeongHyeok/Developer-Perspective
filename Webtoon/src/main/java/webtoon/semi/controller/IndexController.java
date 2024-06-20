package webtoon.semi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import webtoon.semi.dto.Member;

@Controller
public class IndexController {
	
	//멤버가입하기(등록하기)버튼연결
	@GetMapping("/memberRegister")//index.html의 href="/"와 같게
	public String memberRegister(Model model) {
		model.addAttribute("member", new Member());//Member import dto의Member로 할것(java내장 import조심)
		return "memberRegister";//memberRegister.html로연결
	}

}
