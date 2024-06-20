package webtoon.semi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import webtoon.semi.dto.Member;

@Mapper
public interface MemberMapper {
	void insertMember(Member member);//member-mapper.xml의 id와 같게설정
	
	List<Member> getAllMember();

}
