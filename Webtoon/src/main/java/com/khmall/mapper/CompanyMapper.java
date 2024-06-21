package com.khmall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.khmall.dto.Companys;

@Mapper
public interface CompanyMapper {
//getAllCompany 작성하기 select 모든 목록을 가져올 때는 void가 아니라 List로 작성
	List<Companys> getAllCompanys();
}
