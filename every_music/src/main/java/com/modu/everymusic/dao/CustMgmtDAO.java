package com.modu.everymusic.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.modu.everymusic.dto.CustMgmtDTO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class CustMgmtDAO {

	private SqlSessionTemplate dao;
	
	public void logIn(CustMgmtDTO inDTO) {
		dao.selectOne("", inDTO);
	}
	
	
}
