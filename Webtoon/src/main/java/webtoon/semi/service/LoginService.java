package webtoon.semi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webtoon.semi.dto.Member;
import webtoon.semi.mapper.LoginMapper;

@Service
public class LoginService {
	
	@Autowired
    private LoginMapper loginMapper;

    public Member getLogin(String mem_id, String mem_pw) {
        return loginMapper.getLogin(mem_id, mem_pw);
    }
    
    public Member getFindId(String mem_name, String mem_email) {
    	return loginMapper.getFindId(mem_name, mem_email);   
    }
    
    public Member getFindPw(String mem_id, String mem_email) {
    	return loginMapper.getFindPw(mem_id, mem_email);   
    }
}
