package com.modu.everymusic.controller;

import org.json.JSONArray;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonObject;
import com.modu.everymusic.exchange.ExchangeApi;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
public class RestExchange {

	@RequestMapping("api/exchange")
	@ResponseBody
	public String exchange() throws Exception{
		
		ExchangeApi api = new ExchangeApi();
		JsonObject result = api.get();
		
		log.debug("컨트롤러 환율 : " + result);
		
		return result.toString();
	}
	
	
}
