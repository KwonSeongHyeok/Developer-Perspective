package webtoon.semi.service;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import webtoon.semi.dto.Webtoon;
import webtoon.semi.mapper.WebtoonMapper;

@Service
public class WebtoonService {
	@Autowired
	private WebtoonMapper webtoonMapper;
	
	public List<Webtoon> getAllWebtoon(){
		return webtoonMapper.getAllWebtoon();
	}
	
	public List<Webtoon> showRandomWeb(){
		return webtoonMapper.showRandomWeb();
	}
	
	
	
	
	//uploadWebtoon
	public void uploadWebtoon(String web_name, String web_author, String web_genre, String web_summary, String web_story, String web_day, String web_challengeYN, MultipartFile file) {
		String fileName = file.getOriginalFilename();
		String uploadDir = "C:/Users/user1/semiProject/Webtoon/src/main/resources/static/images/";
		File imgFile = new File(uploadDir + fileName);
		
		if(!imgFile.exists()) {
			imgFile.mkdirs();
		}
		
		try {
			file.transferTo(imgFile);
			
			Webtoon webtoon = new Webtoon();
			webtoon.setWeb_name(web_name);
			webtoon.setWeb_author(web_author);
			webtoon.setWeb_genre(web_genre);
			webtoon.setWeb_summary(web_summary);
			webtoon.setWeb_story(web_story);
			webtoon.setWeb_day(web_day);
			webtoon.setWeb_challengeYN(web_challengeYN);
			webtoon.setWeb_image_path("/images/" + fileName);
			webtoonMapper.uploadWebtoon(webtoon);
			
		}  catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 요일별 
	public List<Webtoon> getMonWebtoon() {
		return webtoonMapper.getMonWebtoon();
	}
	public List<Webtoon> getTuesWebtoon() {
		return webtoonMapper.getTuesWebtoon();
	}
	public List<Webtoon> getWednesWebtoon() {
		return webtoonMapper.getWednesWebtoon();
	}
	public List<Webtoon> getThursWebtoon() {
		return webtoonMapper.getThursWebtoon();
	}
	public List<Webtoon> getFriWebtoon() {
		return webtoonMapper.getFriWebtoon();
	}
	public List<Webtoon> getsaturWebtoon() {
		return webtoonMapper.getsaturWebtoon();
	}
	public List<Webtoon> getSunWebtoon() {
		return webtoonMapper.getSunWebtoon();
	}
	public List<Webtoon> getChallengeWeb() {
		return webtoonMapper.getChallengeWeb();
	}
	
	
	// 코드 가져와서 상세보기 및 만화보기 연결
	public Webtoon getWebByCode(int web_code) {
		return webtoonMapper.getWebByCode(web_code);
	}
	
		

}