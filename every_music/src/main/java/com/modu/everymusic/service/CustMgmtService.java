package com.modu.everymusic.service;

import org.springframework.stereotype.Service;

import com.modu.everymusic.dao.CustMgmtDAO;
import com.modu.everymusic.dto.CustMgmtDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustMgmtService {

	private CustMgmtDAO custMgmtDAO;
	
	public CustMgmtDTO logIn(CustMgmtDTO inDTO) {
		
		custMgmtDAO.logIn(inDTO);
		return inDTO;
	}
}
