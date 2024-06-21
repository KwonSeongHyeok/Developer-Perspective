package webtoon.semi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import webtoon.semi.dto.Webtoon;
import webtoon.semi.service.WebtoonService;

@Controller
public class WebtoonController {
	@Autowired
	private WebtoonService webtoonService;
		
	@GetMapping("/webtoon-Main")
	public String getAllWebtoon(Model model) {
		List<Webtoon> webtoon = webtoonService.getAllWebtoon();
		model.addAttribute("webtoon", webtoon);
		return "webtoon-Main";
	}
	
	/******  웹툰 정보를 등록할 수 있는 주소로 이동하는 getMapping  ******/
	@GetMapping("/web-register")
	public String registerForm(Model model) {
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
			@RequestParam("web_image_path") MultipartFile file,
			Model model) {
		webtoonService.uploadWebtoon(web_name, web_author, web_genre, web_summary, web_story, web_day, file);
		
		return "redirect:/";
	}
	

}
