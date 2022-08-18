<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인을 하세요</title>
</head>
<body>
	<div>
		<ul>
			<li><a href="/bankbook/list.iu">상품리스트</a></li>
			<li><a href="/board/list.iu">게시판</a></li>
			<li><a href="/member/login.iu">로그인</a></li>
			<li><a href="/member/join.iu">회원가입</a></li>
		</ul>
	</div>

<h3>Login Page</h3>

<form action="login.iu", method="post">
ID <input type="text" value="NAME1" name="userName"><br>
PW <input type="text" value="PW1" name="password">
<input type="submit">
</form>

</body>
</html>