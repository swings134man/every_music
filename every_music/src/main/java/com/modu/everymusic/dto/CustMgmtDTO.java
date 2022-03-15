package com.modu.everymusic.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * <pre>
 * </pre>
 * @Class   : 고객관리 DTO 
 * @File    : CustMgmtDTO.java
 * @Package : com.modu.everymusic.dto
 * @author  : seokjunkang
 * @Date    : 2022. 3. 16. 오전 12:52:08
 */
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustMgmtDTO {

	private String custEmal;		/*고객email*/
	private String custId;			/*고객ID*/
	private String custPw;			/*고객PW*/
	private String custNm;			/*고객이름*/
	private String custHphn;		/*고객핸드폰번호*/
	private String custGen;			/*고객성별*/
	private String custAge;			/*고객나이*/
	private String custAddr;		/*고객주소*/
	
}
