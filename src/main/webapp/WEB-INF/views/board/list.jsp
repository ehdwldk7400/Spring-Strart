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
	<table border="1" style="text-align:center" >
		<tr>
			<td colspan="2">제목</td><td>작성자</td><td>작성일</td><td>조회</td> 
		</tr>
		<c:forEach items = "${list}" var = "board">
		<tr>
			<td>${board.bno}</td>
			<td width="300px"><a href="/jin/board/read?bno=${board.bno}&pageNum=${pageMaker.cri.pageNum}">${board.title}</a></td>
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
	
	
	<!-- 페이지 리스트 구현 -->
 	<c:if test="${pageMaker.prev}">
		<a href="/jin/board/list?pageNum=${pageMaker.startPage-1}&type=${pageMaker.cri.type}&keyword=${pageMaker.cri.keyword}">이전</a>
	</c:if> 
	<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
		<a href="/jin/board/list?pageNum=${num}&type=${pageMaker.cri.type}&keyword=${pageMaker.cri.keyword}">${num}</a>
	</c:forEach>
	<c:if test="${pageMaker.next}">
		<a href="/jin/board/list?pageNum=${pageMaker.endPage+1}&type=${pageMaker.cri.type}&keyword=${pageMaker.cri.keyword}">다음</a>
	</c:if>
	
	<!-- 검색바 구현 -->
	<form action="/jin/board/list?keyword=${pageMaker.cri.keyword} " method="get">
         <select name="type" style="text-align:center" >
            <option value="T" <c:out value="${pageMaker.cri.type eq 'T' ? 'selected' : ''}"/>>제목 </option>
            <option value="C" <c:out value="${pageMaker.cri.type eq 'C' ? 'selected' : ''}"/>>내용
            <option value="W" <c:out value="${pageMaker.cri.type eq 'W' ? 'selected' : ''}"/>>>작성자
            <option value="TC" <c:out value="${pageMaker.cri.type eq 'TC' ? 'selected' : ''}"/>>>제목+내용
            <option value="TCW" <c:out value="${pageMaker.cri.type eq 'TCW' ? 'selected' : ''}"/>>>제목+내용+작성자
         </select>
         <input type="text" name="keyword">
         <input type="submit" value="검색">
      </form>
	
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