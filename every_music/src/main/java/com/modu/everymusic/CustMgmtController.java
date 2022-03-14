package com.modu.everymusic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.modu.everymusic.dto.CustMgmtDTO;
import com.modu.everymusic.service.CustMgmtService;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class CustMgmtController {
	private final CustMgmtService custMgmtService;
	
//	@Autowired
//	CustMgmtService service;
	
	@RequestMapping("custmgmt/cust/v1/logIn")
	@ResponseBody
	public CustMgmtDTO logIn(CustMgmtDTO inDTO) {
		CustMgmtDTO outDTO = new CustMgmtDTO();

		outDTO = custMgmtService.logIn(inDTO);
		//outDTO = service.logIn(inDTO);
		System.out.println(outDTO);
		
		return outDTO;
		
	}//method
	
	
}
