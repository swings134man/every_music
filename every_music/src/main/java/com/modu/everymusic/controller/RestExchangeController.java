package com.modu.everymusic.controller;

import org.json.JSONArray;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonObject;
import com.modu.everymusic.dto.ExchangeDTO;
import com.modu.everymusic.exchange.ExchangeApi;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * <pre>
 * </pre>
 * @Class   : 환율 API Controller 
 * @File    : RestExchange.java
 * @Package : com.modu.everymusic.controller
 * @author  : seokjunkang
 * @Date    : 2022. 5. 27. 오후 7:13:49
 */
@RestController
@RequiredArgsConstructor
@Slf4j
public class RestExchangeController {
	
	/**
	 * 
	 * <pre>
	 * </pre>
	 * @Name    : 환율 get method 
	 * @Method  : exchange
	 * @Return  : ExchangeDTO
	 * @author  : seokjunkang
	 * @Date    : 2022. 5. 27. 오후 7:13:36
	 * @Version : V1
	 */
	@RequestMapping("api/exchange")
	@ResponseBody
	public ExchangeDTO exchange() {
		
		ExchangeApi eApi = new ExchangeApi();
		ExchangeDTO result = null;
		
		try {
			result = eApi.get();
			
		} catch(Exception e) {
			
			e.printStackTrace();
		} 
		
		
		log.debug("컨트롤러 환율 : " + result);
		
		return result;
	}
	
	
}
