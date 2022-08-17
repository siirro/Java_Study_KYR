<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<div>
	<h4>MEMBER</h4>
	<a href="./member/login.iu">로그인</a>
	<a href="./member/join.iu">회원가입</a>
	<a href="./member/search.iu">ID찾기</a>
</div>


<div>
	<h4>BANKBOOK</h4>
	<a href="./bankbook/list.iu">상품 List</a>

</div>



</body>
</html>
