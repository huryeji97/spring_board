<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 작성 페이지</title>
</head>
<body>
	<h2>글 작성 페이지</h2>
	<form action="register" method="POST">
		<div>
			<p>제목 :
			<input type="text" name="title" placeholder="제목 입력" required="required"> 
			</p>
		</div>
		<div>
			<p>작성자 :
			<input type="text" name="userId" placeholder="작성자 입력" required="required">
			</p>
		</div>
		<div>
			<textarea rows="20" cols="120" name="content" placeholder="내용 입력" required="required"></textarea>
		</div>
		<div>
			<input type="submit" value="등록">
		</div>
	</form>
</body>
</html>