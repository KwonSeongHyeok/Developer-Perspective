package com.khmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.khmall.dto.Companys;
import com.khmall.service.CompanysService;

@Controller
public class CompanyController {
	@Autowired
	private CompanysService companysService;
	
	@GetMapping("/inquiry")
	public String getAllCompanys(Model model) {
	//회사목록 리스트를 companyList.html 전달
	List<Companys> companyList = companysService.getAllCompanys();
	//companyList.html에 companyList 가져온 목록들을 
	model.addAttribute("comList",companyList);
	return "companyList"; //벨류값 companyList <tr th:each=" c : ${companyList}">
	}
}
