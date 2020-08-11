<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>게시판 글쓰기 확인. ${result }</h1>
<form action="/jin/board/register" method="post">
	제   목 : <input type="text" name="title">
	내   용 : <input type="text" name="content">
	작성자 : <input type="text" name="writer">
	
	<input type="submit" value="글쓰기">
</form>
</body>
</html>