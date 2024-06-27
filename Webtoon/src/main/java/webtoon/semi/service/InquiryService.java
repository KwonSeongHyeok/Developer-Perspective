package webtoon.semi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webtoon.semi.dto.Inquiry;
<<<<<<< HEAD
=======
import webtoon.semi.dto.Webtoon;
>>>>>>> myungjun12-register
import webtoon.semi.mapper.InquiryMapper;

@Service
public class InquiryService {
	
	@Autowired
<<<<<<< HEAD
	private InquiryMapper inquiryMapper;
	// insert 값 받아오기
	public void insertInquiry(Inquiry inquiry) {//dto.Member import(다른import주의)
		inquiryMapper.insertInquiry(inquiry);
	}
	
	// 모든 정보 select
=======
	private InquiryMapper inquiryMapper; // 맵퍼 객체 생성 
	
	// insert 값 받아오기
	public void insertInquiry(Inquiry inquiry) { //맵퍼 인터페이스의 메서드 구현 
		inquiryMapper.insertInquiry(inquiry);
	}
	
	// 정보 select
>>>>>>> myungjun12-register
	public List<Inquiry> getAllInquiry(){
		return inquiryMapper.getAllInquiry();
	}
	
<<<<<<< HEAD

=======
	//getInquiryByTitle
	public Inquiry getInquiryById(int inquiry_id) {
		return inquiryMapper.getInquiryById(inquiry_id);
	}
	
	//search
	public List<Webtoon> searchWebtoon(String keyword){
		return inquiryMapper.searchWebtoon(keyword);
	}
	
>>>>>>> myungjun12-register
}
