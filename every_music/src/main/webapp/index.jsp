<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	//java 
    	
    	String sId = (String)session.getAttribute("sId");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>REST TEST</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
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
					/* $('#result').append(data.custId + "<br>")
					$('#result').append(data.custPw) */
					
					if(data == 0) {
						console.log("로그인 실패");
						alert('아이디 혹은 비밀번호 틀렸음.');
						
					} else {
						location.reload();
					}
					
					
				} //success
			})//ajax
		})//click
	}) //function

</script>
<body>
<% if(sId == null) {%>
	아이디 : <input type="text" id="CustId"> <br>
	비밀번호 : <input type="text" id="CustPw"> <br>
	<button id="btn_login">로그인</button>
<%} else {%>	
	<%=sId %>님 환영 합니다! <br>
	<a href="custmgmt/cust/v1/logOut"><button id="btn_logout">로그아웃</button></a>
<%} %>
	
	<hr color="red">
	
	<a href="custEntr.jsp"> <button>회원가입</button></a> <br>

<div id="result">

</div>	<br>
<a href="http://localhost:8889/everymusic/swagger-ui.html">swagger TEST</a> <br>
<hr>

<a href="api/exchange"> <button>환율받아오기</button> </a>


</body>
</html>