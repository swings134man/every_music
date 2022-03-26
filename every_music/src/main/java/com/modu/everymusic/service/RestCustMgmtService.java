package com.modu.everymusic.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.modu.everymusic.dao.CustMgmtDAO;
import com.modu.everymusic.dto.CustMgmtDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RestCustMgmtService {

	private final CustMgmtDAO custMgmtDAO;
	private final BCryptPasswordEncoder pwEncoder; // 암호화
	
	/**
	 * 
	 * <pre>
	 * </pre>
	 * @Name    : User 등록 API service 
	 * @Method  : userInsert
	 * @Return  : String
	 * @author  : seokjunkang
	 * @Date    : 2022. 3. 25. 오전 5:19:27
	 * @Version : V1
	 */
	public String userInsert(CustMgmtDTO inDTO) {
		
		inDTO.setCustPw(pwEncoder.encode(inDTO.getCustPw())); // 고객비밀번호 암호화SET
		
		int result = custMgmtDAO.custEntr(inDTO);
		
		if(result == 1) {
			return "Success";
		} else {
			return "fail";
		}
		
	}
	
	/**
	 * 
	 * <pre>
	 * </pre>
	 * @Name    : API 고객가입정보확인 
	 * @Method  : retrieveCustEntr
	 * @Return  : CustMgmtDTO
	 * @author  : seokjunkang
	 * @Date    : 2022. 3. 25. 오전 5:19:46
	 * @Version : V1
	 */
	public CustMgmtDTO retrieveCustEntr(CustMgmtDTO inDTO) {
		CustMgmtDTO errorDTO = new CustMgmtDTO();
		
		CustMgmtDTO outDTO = custMgmtDAO.retrieveCustEntr(inDTO);
		System.out.println(outDTO);
		
		if(outDTO == null) {
			errorDTO.setMsg("User 정보 없음");
			return errorDTO;
		} else {
			outDTO.setMsg("User 정보 검색 완료");
			return outDTO;
		}
		
	}
	
}
