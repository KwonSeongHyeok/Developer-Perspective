package webtoon.semi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import webtoon.semi.dto.Member;

@Controller
public class IndexController {
	
	//index.html의 가입하러가기 a 태그와 연결
	@GetMapping("/memberRegister")//index.html의 a href="/"와 같게
	public String memberRegister(Model model) {
		
		model.addAttribute("member", new Member());//Member import dto의Member로 할것(java내장 import조심)
		//눌렀을 때 Member객체생성 후 /memberRegister 아이디로 연결된
		//memberRegister.html의
		//form th:action="@{/register-member}" "member"로 전달
		
		return "memberRegister";//memberRegister.html로연결
	}

}
