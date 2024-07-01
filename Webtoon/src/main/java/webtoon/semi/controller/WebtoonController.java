package webtoon.semi.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;
import webtoon.semi.dto.Member;
import webtoon.semi.dto.Webtoon;
import webtoon.semi.service.MemberService;
import webtoon.semi.service.WebtoonService;

@Controller
public class WebtoonController {
	@Autowired
	private WebtoonService webtoonService;

	/****** 웹툰 보러가는 GetMapping *******/
	@GetMapping("/webtoon-Main")
	public String getAllWebtoon(Model model) {
		List<Webtoon> webtoon = webtoonService.getAllWebtoon();
		model.addAttribute("webtoon", webtoon);
		return "webtoon-Main";
	}
	
	@GetMapping("/")
	public String showRandomWeb(Model model) {
		List<Webtoon> webtoon = webtoonService.showRandomWeb();
		model.addAttribute("webtoon", webtoon);
		return "index";
	}
	
	
	/******  웹툰 정보를 등록할 수 있는 주소로 이동하는 getMapping  ******/
	@GetMapping("/web-register")
	public String registerForm(HttpSession session, Model model) {
		Member member = (Member) session.getAttribute("loginSession");
		
		if(member == null) {
			return "redirect:/login";
		}
		
		model.addAttribute("w", new Webtoon());
		return "webUpload";
	}

		

	/******  웹툰 정보 db 업로드 PostMapping  ******/
	@PostMapping("/web-upload")
	public String uploadWebtoon(
			@RequestParam("web_name") String web_name,
			@RequestParam("web_author") String web_author,
			@RequestParam("web_genre") String web_genre,
			@RequestParam("web_summary") String web_summary,
			@RequestParam("web_story") String web_story,
			@RequestParam("web_day") String web_day,
			@RequestParam("web_challengeYN") String web_challengeYN,
			@RequestParam("web_image_path") MultipartFile file,
			Model model) {
		webtoonService.uploadWebtoon(web_name, web_author, web_genre, web_summary, web_story, web_day, web_challengeYN, file);
		
		return "redirect:/webtoon-Main";
	}
	
	
	/******* 요일별 웹툰을 볼 술 있는 GetMapping *******/
	@GetMapping("/webtoon/Monday")
	public String getMonWebtoon(Model model) {
		List<Webtoon> webtoon = webtoonService.getMonWebtoon();
		model.addAttribute("webtoon", webtoon);
		return "mondayWeb";
	}
	@GetMapping("/webtoon/Tuesday")
	public String getTuesWebtoon(Model model) {
		List<Webtoon> webtoon = webtoonService.getTuesWebtoon();
		model.addAttribute("webtoon", webtoon);
		return "tuesdayWeb";
	}
	@GetMapping("/webtoon/Wednesday")
	public String getWednesWebtoon(Model model) {
		List<Webtoon> webtoon = webtoonService.getWednesWebtoon();
		model.addAttribute("webtoon", webtoon);
		return "wednesdayWeb";
	}
	@GetMapping("/webtoon/Thursday")
	public String getThursWebtoon(Model model) {
		List<Webtoon> webtoon = webtoonService.getThursWebtoon();
		model.addAttribute("webtoon", webtoon);
		return "thursdayWeb";
	}
	@GetMapping("/webtoon/Friday")
	public String getFriWebtoon(Model model) {
		List<Webtoon> webtoon = webtoonService.getFriWebtoon();
		model.addAttribute("webtoon", webtoon);
		return "fridayWeb";
	}
	@GetMapping("/webtoon/Saturday")
	public String getsaturWebtoon(Model model) {
		List<Webtoon> webtoon = webtoonService.getsaturWebtoon();
		model.addAttribute("webtoon", webtoon);
		return "saturdayWeb";
	}
	@GetMapping("/webtoon/Sunday")
	public String getSunWebtoon(Model model) {
		List<Webtoon> webtoon = webtoonService.getSunWebtoon();
		model.addAttribute("webtoon", webtoon);
		return "sundayWeb";
	}
	@GetMapping("/webtoon/Challenge")
	public String getChallengeWeb(Model model) {
		List<Webtoon> webtoon = webtoonService.getChallengeWeb();
		model.addAttribute("webtoon", webtoon);
		return "challengeWeb";
	}
	
	
	/******* 웹툰을 보거나 상세보기로 가는 GetMapping *******/
	@GetMapping("/Webtoon/{web_code}")
	public String getWebByCode(Model model, @PathVariable int web_code) {
		Webtoon webtoon = webtoonService.getWebByCode(web_code);
		model.addAttribute("webtoon", webtoon);
		
		String imageURL = webtoon.getWeb_image_path();
		int index1 = imageURL.indexOf("/", 2);
		int index2 = imageURL.indexOf(".");
		
		String url = imageURL.substring(index1+1, index2);
		
		String challengeYN = webtoon.getWeb_challengeYN();
		if(challengeYN.equals("Y")) {
			return "webDetail";
		} else {
			return "redirect:http://comic.naver.com/webtoon/list?titleId=" + url;
		}
	}
	
	
}
