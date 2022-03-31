package com.modu.everymusic.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.modu.everymusic.dao.CustMgmtDAO;
import com.modu.everymusic.dto.CustMgmtDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class RestCustMgmtService {

	//private static final Logger logger = LoggerFactory.getLogger(RestCustMgmtService.class); // 어노테이션 사용 X 시 loging 하는법.
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
		
		log.info("service Entr : " + inDTO);
		
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
			
			//logger.info("service : ", outDTO);
			log.info("service retrieve : " + outDTO);
			
			return outDTO;
		}
		
	}
	
	/**
	 * 
	 * <pre>
	 * </pre>
	 * @Name    : API 회원정보삭제
	 * @Method  : deleteCustEntr
	 * @Return  : String
	 * @author  : seokjunkang
	 * @Date    : 2022. 3. 28. 오후 6:53:43
	 * @Version : V1
	 */
	public String deleteCustEntr(CustMgmtDTO inDTO) {
		String msg = "";
		
		int result = custMgmtDAO.deleteCustEntr(inDTO);
		if(result == 1) {
			msg = "delete success";
		} else {
			msg = "delete fail";
		}
		
		return msg;
	}
	
	/**
	 * 
	 * <pre>
	 * </pre>
	 * @Name    : API 회원정보 검색 페이징
	 * @Method  : retrieveCustAllPage
	 * @Return  : List<CustMgmtDTO>
	 * @author  : seokjunkang
	 * @Date    : 2022. 3. 29. 오전 3:26:32
	 * @Version : V1
	 */
	public List<CustMgmtDTO> retrieveCustAllPage(CustMgmtDTO inDTO, int pageNo, int pageRow) {
		String msg = "";
		
		List<CustMgmtDTO> outDTO = custMgmtDAO.retrieveCustAllPage(inDTO, pageNo, pageRow);
		if(outDTO == null) {
			msg = "조회 값이 존재하지 않습니다.";
			
		} else {
			msg = "조회 완료.";
		}
		
		return outDTO; 
	}
	
	/**
	 * 
	 * <pre>
	 * </pre>
	 * @Name    : API 회원정보 수정
	 * @Method  : updateCustEntr
	 * @Return  : String
	 * @author  : seokjunkang
	 * @Date    : 2022. 3. 31. 오후 6:34:23
	 * @Version : V1
	 */
	public String updateCustEntr(CustMgmtDTO inDTO) {
		String msg = "";
		
		log.debug("UPDATE 입력 정보 : " + inDTO);
		
		if(inDTO.getCustId() == null) {
			msg = "ID 가 없습니다.";
			return msg;
		}
		
		int result = custMgmtDAO.updateCustEntr(inDTO);
		if(result == 1) {
			msg =  "회원정보 수정이 완료되었습니다.";
			
		}else {
			msg =  "회원정보 수정이 실패했습니다.";
		}
		
		return msg;
	}
	
}
