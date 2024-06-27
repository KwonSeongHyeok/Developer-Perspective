package webtoon.semi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import webtoon.semi.dto.Inquiry;

@Mapper
public interface InquiryMapper {
	void insertInquiry(Inquiry inquiry);
	
	List<Inquiry> getAllInquiry();

}
