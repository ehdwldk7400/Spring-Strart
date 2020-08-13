<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정하기</title>
</head>
<body>

<form action="/jin/board/update?bno=${update.bno}" method="post">
	제목 : <input type="text" placeholder="제목" name="title" value="${update.title}"><br>
	내용 : <textarea name="content" placeholder="내용">${update.content}</textarea><br>
	작성자 : ${update.writer }<br>
	<input type="submit" value="수정하기"><br>
</form>

</body>
</html>