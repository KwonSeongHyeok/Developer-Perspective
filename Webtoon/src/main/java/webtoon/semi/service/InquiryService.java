package webtoon.semi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webtoon.semi.dto.Inquiry;
import webtoon.semi.mapper.InquiryMapper;

@Service
public class InquiryService {
	
	@Autowired
	private InquiryMapper inquiryMapper;
	// insert 값 받아오기
	public void insertInquiry(Inquiry inquiry) {//dto.Member import(다른import주의)
		inquiryMapper.insertInquiry(inquiry);
	}
	
	// 모든 정보 select
	public List<Inquiry> getAllInquiry(){
		return inquiryMapper.getAllInquiry();
	}
	

}
