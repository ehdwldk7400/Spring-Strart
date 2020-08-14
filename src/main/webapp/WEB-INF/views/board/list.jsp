<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="../resources/js/jquery-3.5.1.js"></script>
<script type="text/javascript" src="../resources/js/read.js"></script>
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
			<td><a href="/jin/board/read?bno=${board.bno}&pageNum=${pageMaker.cri.pageNum}">${board.title}</a></td>
			<td>${board.writer}</td>
			<td>${board.regdate}</td>
			<td>${board.viewcnt}</td> 
		</tr>
		</c:forEach>
		<tr>
			<td colspn="5">
				<a href="/jin/board/register"><button>글쓰기</button></a>
			</td>
		</tr>
	</table>
 	<c:if test="${pageMaker.prev}">
		<a href="/jin/board/list?pageNum=${pageMaker.startPage-1}">이전</a>
	</c:if> 
	<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
		<a href="/jin/board/list?pageNum=${num}">${num}</a>
	</c:forEach>
	<c:if test="${pageMaker.next}">
		<a href="/jin/board/list?pageNum=${pageMaker.endPage+1}">다음</a>
	</c:if>
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
	
</body>
</html>