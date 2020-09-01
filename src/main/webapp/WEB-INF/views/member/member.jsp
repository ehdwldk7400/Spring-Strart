<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="../resources/js/jquery-3.5.1.js"></script>
<script type="text/javascript" src="../resources/js/member.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원 가입 폼</h1>
<form action="/jin/member/member" method="post" onsubmit="return checkmem()">
	<table>
		<tr>
			<td>
				<label>아이디</label><br>
				<input type="text" name="userid" id="userid">
				<input type="button" value="아이디 중복확인" id="test"><br>
				<label id="idmsg"></label>
			</td>
		</tr>
		<tr>
			<td>
				<label>비밀번호</label><br>
				<input type="password" name="userpw" id="userpw"><br>
				<label id="pwmsg"></label>
			</td>
		</tr>
		<tr>
			<td>
				<label>비밀번호 재확인</label><br>
				<input type="password" name="re_userpw" id="re_userpw"><br>
				<label id="repwmsg"></label>
			</td>
		</tr>
		<tr>
			<td>
				<label>이름</label><br>
				<input type="text" name="username" id =" username">
			</td>
		</tr>
		<tr>
			<td>
				<label>이메일</label><br>
				<input type="text" name="email" id="email">
			</td>
		</tr>
		<tr>
			<td>
				<input type="submit" value="가입하기">
			</td>
		</tr>
	</table>
</form>
</body>
</html>