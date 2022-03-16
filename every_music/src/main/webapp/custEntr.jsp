<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>s회원가입</title>
</head>
<script type="text/javascript" src="resources/js/jquery-3.6.0.js"></script>
<script type="text/javascript">
 	/* $(function() {
		$('#btn_entr').click(function() {
			$.ajax({
				url : "custmgmt/cust/v1/custEntr",
				type : 'POST',
				data : {
					custId : $('#custId').val(),
					custPw : $('#custPw').val(),
					custEmal : $('#custEmal').val(),
					custNm : $('#custNm').val(),
					custGen : $('#custGen').val(),
					custAge : $('#custAge').val(),
					custHphn : $('#custHphn').val(),
					custAddr : $('#custAddr').val()
				},
				success : function(data) {
					if(data.result == "entrSuccess"){
						location.href = "entrSuccess.jsp";
					}else {
						alert("다시 시도하세요.");
						console.log(data);
					}
						
				}//success
			}) //ajax
		})//click
	}) //function   */
</script>
<body>
	<h1>회원가입 창</h1>
	 <form action="custmgmt/cust/v1/custEntr"> 
		이메일 : <input type="email" id="custEmal" name="custEmal"><br>
		아이디 : <input type="text" id="custId" name="custId"><br>
		비밀번호 : <input type="password" id="custPw" name="custPw"><br>
		이름 : <input type="text" id="custNm" name="custNm"><br>
		
		성별 : <br> <input type="radio" id="custGen" name="custGen" value="M">남성
				   <input type="radio" id="custGen" name="custGen" value="F">여성
		<br>
		
		핸드폰번호 : <input type="text" id="custHphn" name="custHphn"><br>
		나이 : <input type="text" id="custAge" name="custAge"><br>
		주소 : <input type="text" id="custAddr" name="custAddr"><br>
		
		<button id="btn_entr">회원가입</button>
	 </form>
	<hr>
	
	<a href="index.jsp"><button>홈으로</button></a>

</body>
</html>