<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>REST TEST</title>
</head>
<script type="text/javascript" src="resources/js/jquery-3.6.0.js"></script>
<script type="text/javascript">
	
	// 비동기 통신 시작
	$(function() {
		$('#btn_login').click(function(){
			
			var id = $('#CustId').val();
			var pw = $('#CustPw').val();
			
			$.ajax({
				url: "custmgmt/cust/v1/logIn",
				data: {
						custId :  id,
						custPw :  pw
					  },
				success : function(data){
					$('#result').append(data.custId + "<br>")
					$('#result').append(data.custPw)
				} //success
			})//ajax
		})//click
	}) //function

</script>
<body>
	아이디 : <input type="text" id="CustId"> <br>
	비밀번호 : <input type="text" id="CustPw"> <br>
	<button id="btn_login">로그인</button>
	<hr color="red">
	
	<a href=""> <button>회원가입</button></a> <br>

<div id="result">

</div>	<br>


</body>
</html>