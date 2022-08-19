<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>

	<body>
		<h1>bankAccount</h1>
		<form action="add.iu?bookNum=${add.bookNum}" method="post">
			<div>
			<input type="text" readonly value="${member.userName}"> 아이디로
			</div>
			<div>
			<input type="text" readonly value="${add.bookNum}"> 통장을 만드시겠습니까?
			</div> 
			<div>
			<input type="submit" value="등록">
			</div>	
		</form>
	</body>
</html>