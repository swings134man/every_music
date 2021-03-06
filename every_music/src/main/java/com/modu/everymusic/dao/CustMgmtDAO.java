package com.modu.everymusic.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.modu.everymusic.dto.CustMgmtDTO;

import lombok.RequiredArgsConstructor;

/**
 * 
 * <pre>
 * </pre>
 * @Class   : 고객관리 DAO 
 * @File    : CustMgmtDAO.java
 * @Package : com.modu.everymusic.dao
 * @author  : seokjunkang
 * @Date    : 2022. 3. 16. 오전 12:55:37
 */
@Repository
@RequiredArgsConstructor
public class CustMgmtDAO {

	private final SqlSessionTemplate db;
	
	/**
	 * 
	 * <pre>
	 * </pre>
	 * @Name    : 고객 로그인
	 * @Method  : logIn
	 * @Return  : void
	 * @author  : seokjunkang
	 * @Date    : 2022. 3. 16. 오전 1:10:41
	 * @Version : V1
	 */
	public CustMgmtDTO logIn(CustMgmtDTO inDTO) {
		
		CustMgmtDTO outDTO = db.selectOne("O_custMgmt.retrieveCustLogin", inDTO);
		return outDTO;
		
	}
	
	/**
	 * 
	 * <pre>
	 * </pre>
	 * @Name    : 고객 가입
	 * @Method  : custEntr
	 * @Return  : int
	 * @author  : seokjunkang
	 * @Date    : 2022. 3. 16. 오전 1:16:07
	 * @Version : V1
	 */
	public int custEntr(CustMgmtDTO inDTO) {
		
		int result = db.insert("O_custMgmt.custEntr", inDTO);
		return result;
	}
	
	/**
	 * 
	 * <pre>
	 * </pre>
	 * @Name    : API 고객가입정보 검색
	 * @Method  : retrieveCustEntr
	 * @Return  : CustMgmtDTO
	 * @author  : seokjunkang
	 * @Date    : 2022. 3. 26. 오후 9:01:55
	 * @Version : V1
	 */
	public CustMgmtDTO retrieveCustEntr(CustMgmtDTO inDTO) {
		
		CustMgmtDTO outDTO = db.selectOne("O_custMgmt.retrieveCustEntr", inDTO);
		return outDTO;
	}
	
	/**
	 * 
	 * <pre>
	 * </pre>
	 * @Name    : API 회원정보 삭제
	 * @Method  : deleteCustEntr
	 * @Return  : int
	 * @author  : seokjunkang
	 * @Date    : 2022. 3. 28. 오후 6:54:10
	 * @Version : V1
	 */
	public int deleteCustEntr(CustMgmtDTO inDTO) {
		int result = db.delete("O_custMgmt.deleteCustEntr", inDTO);
		return result; 
	}
	
	/**
	 * 
	 * <pre>
	 * </pre>
	 * @Name    : API 회원정보 검색 페이징
	 * @Method  : retrieveCustAllPage
	 * @Return  : List<CustMgmtDTO>
	 * @author  : seokjunkang
	 * @Date    : 2022. 3. 29. 오전 3:26:11
	 * @Version : V1
	 */
	public List<CustMgmtDTO> retrieveCustAllPage(CustMgmtDTO inDTO, int pageNo, int pageRow) {
		int pageNumber = (pageNo -1) * pageRow;
		
		RowBounds rowBounds = new RowBounds(pageNumber, pageRow);
		
		List<CustMgmtDTO> outDTO = db.selectList("O_custMgmt.retrieveCustAllPage", inDTO, rowBounds);
		return outDTO;
	}
	
	/**
	 * 
	 * <pre>
	 * </pre>
	 * @Name    : API 회원정보 수정 
	 * @Method  : updateCustEntr
	 * @Return  : int
	 * @author  : seokjunkang
	 * @Date    : 2022. 3. 31. 오후 6:34:33
	 * @Version : V1
	 */
	public int updateCustEntr(CustMgmtDTO inDTO) {
		
		int result = db.update("O_custMgmt.updateCustEntr", inDTO);
		
		return result;
	}
	
	/**
	 * 
	 * <pre>
	 * </pre>
	 * @Name    : API 로그인 확인
	 * @Method  : custLogin
	 * @Return  : String
	 * @author  : seokjunkang
	 * @Date    : 2022. 4. 5. 오후 5:59:45
	 * @Version : V1
	 */
	public String custLogin(CustMgmtDTO inDTO) {
		String getPw = db.selectOne("O_custMgmt.retrieveCustLogin", inDTO);
		
		return getPw;
	}
	
}
