package com.modu.everymusic.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.modu.everymusic.dto.CustMgmtDTO;
import com.modu.everymusic.service.RestCustMgmtService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("restcustmgmt/cust")
@Api("Rest CustMgmt Controller API") // API 컨트롤러 이름
public class RestCustMgmtController {
	
	private final RestCustMgmtService restCustMgmtService;
	
	@ApiOperation(value = "회원 등록", notes = "회원가입 정보를 등록.")
	@PostMapping("/v1/insert")
	public String userInsert(@RequestBody 
						   @ApiParam(value = "한명의 회원정보 등록", required = true) CustMgmtDTO inDTO) {
		
		String out = restCustMgmtService.userInsert(inDTO);
		
		return out;
	}
	
	
}//class
