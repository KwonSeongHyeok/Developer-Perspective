package webtoon.semi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import webtoon.semi.dto.Webtoon;

@Mapper
public interface WebtoonMapper {
	public void uploadWebtoon(Webtoon webtoon);
	
	List<Webtoon> getAllWebtoon();
}

