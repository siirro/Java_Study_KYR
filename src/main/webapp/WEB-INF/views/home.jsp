<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" href="./resources/css/test.css">
	<style>
		li {
			color: blue;
		}

	</style>
</head>
<body>

	<!--nav-->
	<!--Group-->
	<div>
		<ul>
			<li><a href="/bankbook/list.iu">상품리스트</a></li>
			<li><a href="/board/list.iu">게시판</a></li>
			<li><a href="/member/login.iu">로그인</a></li>
			<li><a href="/member/join.iu">회원가입</a></li>
		</ul>
	</div>

	<img src="./resources/images/jssdf.jpg" alt="이미지1">
	<img src="./img/jssdf.jpg" alt="이미지">
	<iframe width="560" height="315" src="https://www.youtube.com/embed/SPwmsflmL_0" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>


	<h1>Index page</h1>
	<!--순서가 있는 List-->
	<ol>
		<li style="color:red;">First</li>
		<li>Second</li>
		<li>Third</li>
	</ol>

	<!--순서가 없는 List-->
	<ul>
		<li>SKT</li>
		<li>KT</li>
		<li>LGT</li>
	</ul>

</body>
</html>
