package webtoon.semi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;
import webtoon.semi.dto.Member;
import webtoon.semi.service.MemberService;

@Controller
@Slf4j
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	//연결:memberRegister.html의<form th:action="@{/register-member}" method="post" th:object="${member}">
	//
	@PostMapping("/register-member")//주소창 : http://localhost:8181/register-member
	public String insertMember(Member member, Model model) {
		memberService.insertMember(member);
		
		List<Member> memList = memberService.getAllMember();//추가
		model.addAttribute("memList",memList);//추가
		
		model.addAttribute("msg","회원이 성공적으로 등록되었습니다.");
		return "memRegiSuccess";//memList .html 또는 memRegiSuccess - 성공메시지
	}
	
	//연결:index.html의 <button onclick="locatin.href='/member-list'">멤버보기</button>
	@GetMapping("/member-list")
	public String getAllMember(Model model) {
		List<Member> memList = memberService.getAllMember();
		log.info("멤버전체목록 : " + memList);
		model.addAttribute("memList", memList);
		return "memList";//memList.html
	}
	//insert-select 프로젝트참고하기

}
