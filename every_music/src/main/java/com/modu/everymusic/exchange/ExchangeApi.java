package com.modu.everymusic.exchange;import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.modu.everymusic.dto.ExchangeDTO;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * <pre>
 * </pre>
 * @Class   : 환율 API CLASS 
 * @File    : ExchangeApi.java
 * @Package : com.modu.everymusic.exchange
 * @author  : seokjunkang
 * @Date    : 2022. 5. 27. 오후 7:15:26
 */
@Slf4j
public class ExchangeApi {

	//https://app.exchangerate-api.com/dashboard // 환율 API DashBoard
	
	/**
	 * 
	 * <pre>
	 * </pre>
	 * @Name    : 환율 REST API GET METHOD 
	 * @Method  : get
	 * @Return  : ExchangeDTO
	 * @author  : seokjunkang
	 * @Date    : 2022. 5. 27. 오후 7:15:04
	 * @Version : V1
	 */
	public ExchangeDTO get() throws Exception{
		
		//선언 
		JsonObject result = null;
		StringBuilder sb = new StringBuilder();
		
		//URL 
		String url_str = "https://v6.exchangerate-api.com/v6/fed76e7ab9b03ad8f3c2a9c1/latest/KRW";
		HttpURLConnection conn = null;
		
		try {
		
			// Request
			URL url = new URL(url_str);
			conn = (HttpURLConnection)url.openConnection();
			conn.setConnectTimeout(5000);
			conn.setReadTimeout(5000);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");
			conn.setDoOutput(true); // JSON 데이터를 출력 가능상태로 변경
			conn.connect();
		} catch (Exception e){
			log.debug("error : " + e.toString());
			
		}
		
		
		// data 입력 스트림에 담기
		// String 타입으로 변환
//		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
//		
//		while(br.ready()) {
//			sb.append(br.readLine());
//		}
		//result = (JSONObject)conn.getContent();
		
		
		
		// JSON Parsing
		JsonParser jp = new JsonParser();
		JsonElement je = jp.parse(new InputStreamReader(conn.getInputStream(), "UTF-8"));
		result = je.getAsJsonObject(); //JSON DATA 
		String ob_result = result.get("result").getAsString(); // 성공여부

		// JSON array에 담을시 [] 괄호 안에 들어감.
//		JSONArray ja = new JSONArray();
//		ja.put(result);
		
		log.debug("JSON : " + ob_result);
//		log.debug("JSON : " + ja);
		log.debug("object" + result.get("conversion_rates"));
		
		conn.disconnect(); // 연결 종료
		
		// DTO set
		JsonObject job = (JsonObject)result.get("conversion_rates");
		
		// 형변환
		float kori = job.get("KRW").getAsFloat() * 1000;
		float jpni = job.get("JPY").getAsFloat() * 1000;
		float usdi = job.get("USD").getAsFloat() * 1000;
		
		ExchangeDTO outDTO = ExchangeDTO.builder().kor(Float.toString(kori))
											 .jpn(Float.toString(jpni))
											 .eng(Float.toString(usdi))
											 .msg("원화 기준 엔, 달러 설정값임.")
											 .build();
		
		
		return outDTO;
	}//get
	
	
}
