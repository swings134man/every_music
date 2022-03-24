package com.modu.everymusic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.modu.everymusic.dto.CustMgmtDTO;
import com.modu.everymusic.service.RestCustMgmtService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/restcustmgmt/cust")
@Api("Rest CustMgmt Controller API") // API 컨트롤러 이름
public class RestCustMgmtController {
	
	// 스웨거 주소 : http://localhost:8889/everymusic/swagger-ui.html
	
	private final RestCustMgmtService restCustMgmtService;
	
	@ApiOperation(value = "회원 등록", notes = "회원가입 정보를 등록.")
	@PostMapping("/v1/insert")
	@ResponseBody
	public String userInsert(@RequestBody @ApiParam(value = "한명의 회원정보 등록", required = true) CustMgmtDTO inDTO) {
		
		String out = restCustMgmtService.userInsert(inDTO);
		
		return out;
	}
	
	@ApiOperation(value = "회원 ID로 정보 찾기", notes = "회원가입 정보를 검색.")
	@GetMapping("/v1/search")
	@ResponseBody
	public CustMgmtDTO retrieveCustEntr(@RequestParam String userId) {
		CustMgmtDTO inDTO = new CustMgmtDTO();
		inDTO.setCustId(userId);
		
		CustMgmtDTO outDTO = restCustMgmtService.retrieveCustEntr(inDTO);
		
		return outDTO;
	}
	
	
}//class
