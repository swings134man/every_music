package com.modu.everymusic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.modu.everymusic.dto.CustMgmtDTO;
import com.modu.everymusic.service.CustMgmtService;

import lombok.RequiredArgsConstructor;

/**
 * 
 * <pre>
 * </pre>
 * @Class   : 고객관리 컨트롤러
 * @File    : CustMgmtController.java
 * @Package : com.modu.everymusic
 * @author  : seokjunkang
 * @Date    : 2022. 3. 16. 오전 12:54:32
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("custmgmt/cust")
public class CustMgmtController {
	private final CustMgmtService custMgmtService;
	
	/**
	 * 
	 * <pre>
	 * </pre>
	 * @Name    : 고객 로그인
	 * @Method  : logIn
	 * @Return  : CustMgmtDTO
	 * @author  : seokjunkang
	 * @Date    : 2022. 3. 16. 오전 12:53:48
	 * @Version : V1
	 */
	@RequestMapping("/v1/logIn")
	@ResponseBody
	public CustMgmtDTO logIn(CustMgmtDTO inDTO) {
		CustMgmtDTO outDTO = new CustMgmtDTO();

		outDTO = custMgmtService.logIn(inDTO);
		return outDTO;
	}
	
	/**
	 * 
	 * <pre>
	 * </pre>
	 * @Name    : 고객 가입
	 * @Method  : custEntr
	 * @Return  : String
	 * @author  : seokjunkang
	 * @Date    : 2022. 3. 16. 오전 1:15:14
	 * @Version : V1
	 */
	@RequestMapping("/v1/custEntr")
	@ResponseBody
	public String custEntr(CustMgmtDTO inDTO) {
		
		String result = custMgmtService.custEntr(inDTO);
		
		return result;
	}
	
}// class
