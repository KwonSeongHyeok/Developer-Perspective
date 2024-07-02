package webtoon.semi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webtoon.semi.dto.Member;
import webtoon.semi.mapper.MemberMapper;

@Service
public class MemberService {
	
	@Autowired
	private MemberMapper memberMapper;//.mapper/ MemberMapper.java import
	
	//MemberMapper의 메서드와 이름같음
	public void insertMember(Member member) {//dto.Member import(다른import주의)
		memberMapper.insertMember(member);
	}
	
	//멤버 db에서 가져온 목록들을 controller에 전달해주기
	public List<Member> getAllMember(){
		return memberMapper.getAllMember();
	}
	
	
	
	//추가
	public void deleteMember(String member_id) {
		memberMapper.deleteMember(member_id);
	}

}
