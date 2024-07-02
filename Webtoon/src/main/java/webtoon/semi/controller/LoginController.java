package webtoon.semi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import webtoon.semi.dto.Member;
import webtoon.semi.service.LoginService;

@Controller
@Slf4j

public class LoginController {

	@Autowired
	private LoginService loginService;
	

	@GetMapping("/login")
	public String showLoginForm(Model model) {
		model.addAttribute("login", new Member());
		return "login";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

	@PostMapping("/sign-in")
	public String postLogin(Model model, @RequestParam("mem_id") String mem_id, @RequestParam("mem_pw") String mem_pw,
			HttpSession session) {

		Member member = loginService.getLogin(mem_id, mem_pw);

		if (member != null) {
			session.setAttribute("loginSession", member);
			return "redirect:/";
		} else {
			model.addAttribute("error", "일치하는 아이디와 비밀번호가 없습니다.");
			model.addAttribute("login", new Member());
			return "login";
		}
	}

	@GetMapping("/findId")
	public String showFindIdForm(Model model) {
		model.addAttribute("foundId", new Member());
		return "findId";
	}

	@GetMapping("/findPw")
	public String showFindPwForm(Model model) {
		model.addAttribute("findPw", new Member());
		return "findPw";
	}

	@PostMapping("/findId")
	public String getFindId(Model model, @RequestParam("mem_name") String mem_name,
			@RequestParam("mem_email") String mem_email, HttpSession session) {

		Member member = loginService.getFindId(mem_name, mem_email);
		System.out.println("find id : " + member);
		if (member != null) {
			session.setAttribute("findIdSession", member);
			model.addAttribute("foundId", member);
			return "redirect:/findResultId";
		} else {
			model.addAttribute("error", "일치하는 정보가 없습니다.");
			return "loginIndex";
		}
	}

	@PostMapping("/findPassword")
	public String getFindPw(Model model, @RequestParam("mem_id") String mem_id,
			@RequestParam("mem_email") String mem_email, HttpSession session) {

		Member member = loginService.getFindPw(mem_id, mem_email);
		System.out.println("find pw : " + member);
		if (member != null) {
			session.setAttribute("findPwSession", member);
			model.addAttribute("findPassword", member);
			return "findResultPw";
		} else {
			model.addAttribute("error", "일치하는 정보가 없습니다.");
			return "loginIndex";
		}
	}

	@GetMapping("/findResultId")
	public String showFindIdResult(Model model, HttpSession session) {
		// Model s = model.addAttribute("foundId", new Member());

		Member foundId = (Member) session.getAttribute("findIdSession");

		System.out.println("sss : " + foundId);

		if (foundId != null) {
			model.addAttribute("foundId", foundId);
			return "findResultId";
		}
		return "findResultId";
	}

	@GetMapping("/findResultPw")
	public String showFindPwResult(Model model, HttpSession session) {

		Member foundPw = (Member) session.getAttribute("findPwSession");

		System.out.println("sss : " + foundPw);

		if (foundPw != null) {
			model.addAttribute("foundPw", foundPw);
			return "findResultPw";
		}
		return "findResultPw";
	}

}
