package webtoon.semi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import webtoon.semi.dto.Webtoon;

@Mapper
public interface WebtoonMapper {
	public void uploadWebtoon(Webtoon webtoon);
	// 웹툰 전체 리스트
	List<Webtoon> getAllWebtoon();
	
	// 랜덤 웹툰 리스트
	List<Webtoon> showRandomWeb();
	
	// 웹툰 요일별 리스트
	List<Webtoon> getMonWebtoon();
	List<Webtoon> getTuesWebtoon();
	List<Webtoon> getWednesWebtoon();
	List<Webtoon> getThursWebtoon();
	List<Webtoon> getFriWebtoon();
	List<Webtoon> getsaturWebtoon();
	List<Webtoon> getSunWebtoon();
	List<Webtoon> getChallengeWeb();
	
	// 웹툰 코드가져와서 상세보기 및 주소 연결하기
	Webtoon getWebByCode(int web_code);

}

