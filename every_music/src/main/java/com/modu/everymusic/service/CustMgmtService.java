package com.modu.everymusic.service;




import javax.servlet.http.HttpSession;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.modu.everymusic.dao.CustMgmtDAO;
import com.modu.everymusic.dto.CustMgmtDTO;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * <pre>
 * </pre>
 * @Class   : 고객관리 서비스
 * @File    : CustMgmtService.java
 * @Package : com.modu.everymusic.service
 * @author  : seokjunkang
 * @Date    : 2022. 3. 16. 오전 12:55:06
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class CustMgmtService {
	private final CustMgmtDAO custMgmtDAO;
	private final BCryptPasswordEncoder pwEncoder; // 암호화

	/**
	 * 
	 * <pre>
	 * </pre>
	 * @Name    : 고객 로그인
	 * @Method  : logIn
	 * @Return  : CustMgmtDTO
	 * @author  : seokjunkang
	 * @Date    : 2022. 3. 16. 오전 12:55:21
	 * @Version : V1
	 */
	public int logIn(CustMgmtDTO inDTO, HttpSession session) {
		
		CustMgmtDTO outDTO = custMgmtDAO.logIn(inDTO); 
		int outResult = 0;
		
		// id <=> pw 검증 로직
		if(pwEncoder.matches(inDTO.getCustPw(), outDTO.getCustPw())) {
			
			log.debug("패스워드 일치.");

			session.setAttribute("sId", inDTO.getCustId());
			// 세션 확인
			log.debug("Service session success : " + session.getAttribute("sId"));
			outResult = 1;
			
			return outResult;
					
		} else {
			// 세션 확인
			log.debug("Service session fail : " + session.getAttribute("sId"));
			outResult = 0;
			
			return outResult;
		}
		
		
		
	}
	
	/**
	 * 
	 * <pre>
	 * </pre>
	 * @Name    : 고객 가입
	 * @Method  : custEntr
	 * @Return  : String
	 * @author  : seokjunkang
	 * @Date    : 2022. 3. 16. 오전 1:16:25
	 * @Version : V1
	 */
	public String custEntr(CustMgmtDTO inDTO) {
		String toWhere = "";
		
		inDTO.setCustPw(pwEncoder.encode(inDTO.getCustPw())); // 고객비밀번호 암호화SET	
		
		int result = custMgmtDAO.custEntr(inDTO);
		if(result == 1) {
			toWhere = "회원가입 성공";
		}else {
			toWhere = "회원가입 실패";
		}
		
		
		return toWhere;
	}
	
}//class
