package com.modu.everymusic.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.modu.everymusic.dto.CustMgmtDTO;
import com.modu.everymusic.service.CustMgmtService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

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
@Slf4j
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
	@RequestMapping("custmgmt/cust/v1/logIn")
	@ResponseBody
	public int logIn(CustMgmtDTO inDTO, HttpSession session) {
		CustMgmtDTO outDTO = new CustMgmtDTO();

		log.debug("A controller Session ID : " + session.getId());
		log.debug("A controller Session 값 : " + session.getAttribute("sId"));
		
		int outResult = custMgmtService.logIn(inDTO, session);
		
		log.debug("B controller Session ID : " + session.getId());
		log.debug("B controller Session 값 : " + session.getAttribute("sId"));
		
		return outResult;
	}
	
	/**
	 * 
	 * <pre>
	 * </pre>
	 * @Name    : 고객 로그아웃 
	 * @Method  : logOut
	 * @Return  : void
	 * @author  : seokjunkang
	 * @Date    : 2022. 5. 23. 오후 11:43:39
	 * @Version : V1
	 */
	@RequestMapping("custmgmt/cust/v1/logOut")
	public String logOut(HttpSession session) {
		
		log.debug("A controller Session 값" + session.getAttribute("sId"));
		session.invalidate();
		
		
		return "logOut";
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
	@RequestMapping("custmgmt/cust/v1/custEntr")
	public String custEntr(CustMgmtDTO inDTO, Model model) {
		
		String result = custMgmtService.custEntr(inDTO);
		
		model.addAttribute("value", result);
		
		return "entrSuccess";
	}
	
}// class
