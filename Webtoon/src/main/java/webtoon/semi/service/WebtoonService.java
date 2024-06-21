package webtoon.semi.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

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
	
	
	//uploadWebtoon
	public void uploadWebtoon(String web_name, String web_author, String web_genre, String web_summary, String web_story, String web_day, MultipartFile file) {
		String fileName = file.getOriginalFilename();
		String uploadDir = "C:/Users/user1/Test1/Test/src/main/resources/static/images/";
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
			webtoon.setWeb_image_path("/images/" + fileName);
			
			webtoonMapper.uploadWebtoon(webtoon);
			
		}  catch (IOException e) {
			e.printStackTrace();
		}
		
			
	}

}