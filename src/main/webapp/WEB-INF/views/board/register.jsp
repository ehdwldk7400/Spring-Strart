<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../resources/js/jquery-3.5.1.js"></script>
<script type="text/javascript" src="../resources/js/registerAjax.js"></script>
<link rel="stylesheet" href="../resources/css/uploadAjax.css">
</head>
<body>
	<h1>게시판 글쓰기 확인. ${result }</h1>
	<form role="form" action="/jin/board/register" method="post">
		
		제 목 : <input type="text" name="title"> 
		내 용 : <input type="text" name="content"> 
		작성자 : <input type="text" name="writer">
	 	<input type="submit" value="글쓰기">
	</form>
	<br>
	<br>
	<!-- 파일 업로드 Drag&Drop 영역 -->
	<div class="fileDrop"></div>

	<!-- File Upload Drag&Drop 결과 이미지 list -->
	<div class="uploadList">
		<ul>
		
		</ul>
	</div>


</body>
</html>