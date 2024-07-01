package webtoon.semi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webtoon.semi.dto.Inquiry;
import webtoon.semi.dto.Webtoon;
import webtoon.semi.mapper.InquiryMapper;

@Service
public class InquiryService {
	
	@Autowired
	private InquiryMapper inquiryMapper; // 맵퍼 객체 생성 
	
	// insert 값 받아오기
	public void insertInquiry(Inquiry inquiry) { //맵퍼 인터페이스의 메서드 구현 
		inquiryMapper.insertInquiry(inquiry);
	}
	
	// 정보 select
	public List<Inquiry> getAllInquiry(){
		return inquiryMapper.getAllInquiry();
	}
	
	//getInquiryByTitle
	public Inquiry getInquiryById(int inquiry_id) {
		return inquiryMapper.getInquiryById(inquiry_id);
	}
	
	//메인 search
	public List<Webtoon> searchWebtoon(String keyword){
		return inquiryMapper.searchWebtoon(keyword);
	}
	
	//게시판 search
    public List<Inquiry> boardSearch(String keyword){
    	return inquiryMapper.boardSearch(keyword);
    }
}
