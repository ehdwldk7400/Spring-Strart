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
<script type="text/javascript" src="../resources/js/ajaxtest.js"></script>
<link rel="stylesheet" href="../resources/css/read.css">
</head>
<body>
	<form action="" role="form" id="fr">
	<input type="hidden" id="bno" name="bno" value="${read.bno }">
	
	<input type="text" name="pageNum" value="${cri.pageNum}">
	<table border="1">
		<tr > 
			<td colspan="2">${read.title} </td>
		</tr>
		
		<tr> 
			<td>${read.writer} </td><td>${read.viewcnt} </td>
		</tr>

		<tr > 
			<td colspan="2"> ${read.content}
				<div class="uploadList">
					<ul></ul>
				</div>
			</td>
			
		</tr>
		<tr> 
			<td colspan="2">
				<input type="submit" class="btn-warning" value="수정">
				<input type="submit" class="btn-danger" value="삭제">
				<input type="submit" class="btn-primary" value="목록">
			</td>
		</tr>
	</table>
	<!-- 댓글 수정 모달창 구현 -->
	<div id="modDiv">
		<div class="modal-title"></div>
		<div>
			<input type="text" id="replytext">
		</div>
		<div>
			<button type="button" id="replyModBtn">수정</button>
			<button type="button" id="replyDelBtn">삭제</button>
			<button type="button" id="closeBtn">닫기</button>
		</div>
	</div>

	<!-- 뎃글 리스트 영역 -->
	<ul id="replies">

	</ul>
	
	
	<!-- 댓글 페이징 처리 -->
	<ul id="replyPage">
	
	</ul>
		
	<!-- 댓글 작성란 구현  -->
	<div>
		<div>
			작성자 : <input type="text" name="replyer" id="newReplyWriter">
		</div>
		<div>
			내   용 : <input type="text" name="replytext" id="newReplyText">
		</div>
		<button id="replyAddBtn">댓글 등록</button>
	</div>
	
	</form>
</body>
</html>