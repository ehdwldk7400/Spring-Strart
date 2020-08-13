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
	<table border="1">
		<tr>
			<td colspan="2">제목</td><td>작성자</td><td>작성일</td><td>조회</td> 
		</tr>
		<c:forEach items = "${list}" var = "board">
		<tr>
			<td>${board.bno}</td>
			<td><a href="/jin/board/read?bno=${board.bno}">${board.title}</a></td>
			<td>${board.writer}</td>
			<td>${board.regdate}</td>
			<td>${board.viewcnt}</td> 
		</tr>
		</c:forEach>
		<tr>
			<td colspan="5"> 1 2 3 4</td>
		</tr>
	</table>
	<c:if test="${msg eq 'success' }">
			<script type="text/javascript">
				alert('수정되었습니다.');
			</script>
		</c:if>
		<c:if test="${delmsg eq 'success' }">
			<script type="text/javascript">
				alert('삭제되었습니다.');
			</script>
		</c:if>
		<a href="/jin/board/register"><button>글쓰기</button></a>
</body>
</html>