package webtoon.semi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import webtoon.semi.dto.Inquiry;

@Mapper
public interface InquiryMapper {
	
	void insertInquiry(Inquiry inquiry);
	
	List<Inquiry> getIdTitleInquiry();
	//title을 통한 정보조회
	Inquiry getInquiryById(int inquiay_id);

}
