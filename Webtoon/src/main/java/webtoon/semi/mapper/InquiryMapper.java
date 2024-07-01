package webtoon.semi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import webtoon.semi.dto.Inquiry;

import org.apache.ibatis.annotations.Param;
import webtoon.semi.dto.Webtoon;

@Mapper
public interface InquiryMapper {
	
	void insertInquiry(Inquiry inquiry);
	
	List<Inquiry> getAllInquiry();
	//title을 통한 정보조회
	Inquiry getInquiryById(int inquiay_id);
	//키워로 검색
	List<Webtoon> searchWebtoon(@Param("keyword") String keyword);
	
}
