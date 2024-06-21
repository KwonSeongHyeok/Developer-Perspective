package com.khmall.dto;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Companys {

	private int company_id;
	private String company_name;
	private String company_address;
	private String company_phone;
	//핸드폰 번호는 앞이 0으로 시작하기 때문에 String 으로 사용
	//int는 맨 앞에 붙은 0을 자동으로 없애주기 때문
}
