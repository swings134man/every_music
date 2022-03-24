package com.modu.everymusic.dao;

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
	public void logIn(CustMgmtDTO inDTO) {
		
		db.selectOne("", inDTO);
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
	
	public CustMgmtDTO retrieveCustEntr(CustMgmtDTO inDTO) {
		
		CustMgmtDTO outDTO = db.selectOne("O_custMgmt.retrieveCustEntr", inDTO);
		return outDTO;
	}
	
	
}
