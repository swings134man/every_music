package com.modu.everymusic.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.modu.everymusic.dto.CustMgmtDTO;
import com.modu.everymusic.service.RestCustMgmtService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/restcustmgmt/cust")
@Api("Rest CustMgmt Controller API") // API 컨트롤러 이름
@Slf4j
public class RestCustMgmtController {
	
	// 스웨거 주소 : http://localhost:8889/everymusic/swagger-ui.html
	
	private final RestCustMgmtService restCustMgmtService;
	
	/**
	 * 
	 * <pre>
	 * </pre>
	 * @Name    : API 고객 가입
	 * @Method  : userInsert
	 * @Return  : String
	 * @author  : seokjunkang
	 * @Date    : 2022. 3. 26. 오후 8:56:37
	 * @Version : V1
	 */
	@ApiOperation(value = "회원 등록", notes = "회원가입 정보를 등록.")
	@PostMapping("/v1/insert")
	@ResponseBody
	public String userInsert(@RequestBody @ApiParam(value = "한명의 회원정보 등록", required = true) CustMgmtDTO inDTO) {
		
		String out = restCustMgmtService.userInsert(inDTO);
		
		return out;
	}
	
	/**
	 * 
	 * <pre>
	 * </pre>
	 * @Name    : API 고객가입정보 확인
	 * @Method  : retrieveCustEntr
	 * @Return  : CustMgmtDTO
	 * @author  : seokjunkang
	 * @Date    : 2022. 3. 26. 오후 8:56:55
	 * @Version : V1
	 */
	@ApiOperation(value = "회원 ID로 정보 찾기", notes = "회원가입 정보를 검색.")
	@GetMapping("/v1/search")
	@ResponseBody
	public CustMgmtDTO retrieveCustEntr(@RequestParam @ApiParam(value = "ID로 고객 가입 정보 확인", required = true) 
										String userId) {
		
		CustMgmtDTO inDTO = new CustMgmtDTO();
		inDTO.setCustId(userId);
		
		CustMgmtDTO outDTO = restCustMgmtService.retrieveCustEntr(inDTO);
		
		return outDTO;
	}
	
	/**
	 * 
	 * <pre>
	 * </pre>
	 * @Name    : API 회원 정보 삭제
	 * @Method  : deleteCustEntr
	 * @Return  : String
	 * @author  : seokjunkang
	 * @Date    : 2022. 3. 28. 오후 6:53:26
	 * @Version : V1
	 */
	@ApiOperation(value = "회원 ID로 회원 정보 삭제", notes = "회원가입 정보를 삭제.")
	@DeleteMapping("/v1/delete")
	@ResponseBody
	public String deleteCustEntr(@RequestParam @ApiParam(value = "ID로 고객 정보 삭제", required = true) String userId) {
		CustMgmtDTO inDTO = new CustMgmtDTO();
		inDTO.setCustId(userId);
		
		String msg = restCustMgmtService.deleteCustEntr(inDTO);
		
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
	 * @Date    : 2022. 3. 29. 오전 3:26:46
	 * @Version : V1
	 */
	@ApiOperation(value = "회원 정보로 조회 Paging", notes = "회원가입 정보 페이징")
	@GetMapping("/v1/custpage")
	@ResponseBody
	public List<CustMgmtDTO> retrieveCustAllPage(@RequestParam(required = false) String custId, @RequestParam(required = false) String custNm,
												 @RequestParam(defaultValue = "1") int pageNo, @RequestParam int pageRow) {
		
		CustMgmtDTO inDTO = CustMgmtDTO.builder().custId(custId)
					   							 .custNm(custNm)
					   							 .build();
		
		log.debug("입력값 : " + inDTO);
		
		List<CustMgmtDTO> outDTO = restCustMgmtService.retrieveCustAllPage(inDTO, pageNo, pageRow);
		return outDTO;
	}
	
	/**
	 * 
	 * <pre>
	 * String 타입 ResponseBody로 return 시(한글) 
	 * 한글 인식 불가시
	 * produces = "text/plain;charset=UTF-8" 해당 설정 set 필요
	 * </pre>
	 * @Name    : API 회원정보 수정
	 * @Method  : updateCustEntr
	 * @Return  : String
	 * @author  : seokjunkang
	 * @Date    : 2022. 3. 31. 오후 6:34:10
	 * @Version : V1
	 */
	@ApiOperation(value = "한명의 회원정보 수정", notes = "회원가입 정보 수정")
	@PutMapping(value = "/v1/custupdate", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String updateCustEntr(@RequestBody @ApiParam(value = "한명의 회원정보 수정", required = true) CustMgmtDTO inDTO,
								 @RequestParam(required = true) String custId
								) {
		
		inDTO.setCustId(custId);
		
		String msg = restCustMgmtService.updateCustEntr(inDTO);
		return msg;
	}
	
	/**
	 * 
	 * <pre>
	 * </pre>
	 * @Name    : API 로그인 확인
	 * @Method  : custLogin
	 * @Return  : String
	 * @author  : seokjunkang
	 * @Date    : 2022. 4. 5. 오후 5:59:26
	 * @Version : V1
	 */
	@ApiOperation(value = "로그인", notes = "회원 로그인")
	@PostMapping(value = "/v1/custlogin", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String custLogin(@RequestParam(required = true) String custId,
						  @RequestParam(required = true) String custPw
						 ) {
		CustMgmtDTO inDTO = new CustMgmtDTO();
		inDTO.setCustId(custId);
		inDTO.setCustPw(custPw);
		
		String msg = restCustMgmtService.custLogin(inDTO);
		
		return msg;
	}
	
}//class
