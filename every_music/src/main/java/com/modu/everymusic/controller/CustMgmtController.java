package com.modu.everymusic.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
	public int logIn(CustMgmtDTO inDTO, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		CustMgmtDTO outDTO = new CustMgmtDTO();

		// 세션 설정 전
		log.debug("A controller Session ID : " + session.getId());
		log.debug("A controller Session 값 : " + session.getAttribute("sId"));
		
		// request
		HttpSession sess = request.getSession(); // HttpSession이 존재하면 현재 session 반환, 존재 x 시 세션 생성. (true)값과 같음.
		log.debug("A Controller Request : " + sess);
		
		int outResult = custMgmtService.logIn(inDTO, session); // 로그인정보 및 세션 정보 보냄.
		
		// cookie
		Cookie[] cookies = request.getCookies();	// 쿠키 객체 받아옴.
		log.debug("Cookie : " + cookies);
		
		
		Cookie cookie_log = new Cookie("cookie_log", (String)session.getAttribute("sId")); // 쿠키 값 설정.
		cookie_log.setMaxAge(24 * 30 * 60 * 60 * 1000); // 30일동안 유효함. 계산 -> 초 분 시간 일.
		cookie_log.setPath("/"); // 모든경로에서 쿠키 설정 가능.
		// 쿠키 response
		response.addCookie(cookie_log); // 쿠키 응답.
		
		// 세션 설정 후 
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
	public String logOut(HttpSession session, HttpServletResponse response) {
		
		log.debug("A controller Session 값" + session.getAttribute("sId"));
		session.invalidate();
		
		Cookie cookie_log = new Cookie("cookie_log", null); // 쿠키값 null
		cookie_log.setMaxAge(0); // 만료시간 0 설정.
		cookie_log.setPath("/");
		response.addCookie(cookie_log); // 응답.
		
		
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
