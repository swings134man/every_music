package com.modu.everymusic.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * <pre>
 * </pre>
 * @Class   : 환율 DTO 
 * @File    : ExchangeDTO.java
 * @Package : com.modu.everymusic.dto
 * @author  : seokjunkang
 * @Date    : 2022. 5. 27. 오후 6:40:56
 */
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeDTO {

	private String kor; 	/* 원 */
	private String jpn;		/* 엔 */
	private String eng;		/* 달러 */
	private String msg; 	/* 안내 메세지 */
	
}
