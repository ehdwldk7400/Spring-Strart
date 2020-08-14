<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../resources/js/jquery-3.5.1.js"></script>
<script type="text/javascript" src="../resources/js/read.js"></script>
</head>
<body>
	<form action="" role="form" id="fr">
	<input type="hidden" name="bno" value="${read.bno }">
	
	<input type="text" name="pageNum" value="${cri.pageNum}">
	<table border="1">
		<tr > 
			<td colspan="2">${read.title} </td>
		</tr>
		
		<tr> 
			<td>${read.writer} </td><td>${read.viewcnt} </td>
		</tr>

		<tr > 
			<td colspan="2"> ${read.content}</td>
		</tr>
		<tr> 
			<td colspan="2">
				<input type="submit" class="btn-warning" value="수정">
				<input type="submit" class="btn-danger" value="삭제">
				<input type="submit" class="btn-primary" value="목록">
			</td>
		</tr>
	</table>
	</form>
</body>
</html>