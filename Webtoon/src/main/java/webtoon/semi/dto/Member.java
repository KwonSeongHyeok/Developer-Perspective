package webtoon.semi.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Member {
	private int mem_code;//member table pk, 1열
	private String mem_id;//2
	private String mem_name;//3
	private String mem_nickname;//4
	private String mem_pw;//5
	private String mem_address;//6
	private String mem_email;//7
	private String mem_phone;//8
	private String mem_ssn;//9
	private String mem_join_date;//10
	private String mem_gender;//char string 고민 M/F선택 //11	
}