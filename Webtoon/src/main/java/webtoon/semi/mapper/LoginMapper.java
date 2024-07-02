package webtoon.semi.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import webtoon.semi.dto.Member;

@Mapper
public interface LoginMapper {
	//getLogin
    Member getLogin(@Param("mem_id") String mem_id,   @Param("mem_pw") String mem_pw);
    //getFindId
    Member getFindId(@Param("mem_name")String mem_name, @Param("mem_email") String mem_email);
    //getFindPw
    Member getFindPw(@Param("mem_id")String mem_id, @Param("mem_email") String mem_email);
}
