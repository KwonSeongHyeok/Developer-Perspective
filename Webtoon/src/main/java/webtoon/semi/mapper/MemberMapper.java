package webtoon.semi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import webtoon.semi.dto.Member;

@Mapper
public interface MemberMapper {
	void insertMember(Member member);//member-mapper.xml의 id와 같게설정
	
	List<Member> getAllMember();
	
	//로그인해서 한명 정보가져오기
	Member getLogin(
			@Param("mem_id") String mem_id,
			@Param("mem_pw") String mem_pw
			);
	
	//한명 아이디로 삭제
	void deleteMember(@Param("mem_id") String mem_id);
	

}
