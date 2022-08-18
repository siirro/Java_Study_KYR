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
	<h1>BankBook Detail</h1>
	<a href="./list.iu">상품목록</a>
	
	<!-- /bankbook/detail -->
	<!-- link 주소는 상대경로 작 -->
	
	<!-- 상대경로 -->
	
	
	<a href="./update.iu?bookNum=${detail.bookNum}">수정</a>
	<a href="delete.iu?bookNum=${detail.bookNum}">삭제</a>

	<c:if test="${not empty sessionScope.member}">
		<a href="../bankAccount/add.iu?bookNum=${detail.bookNum}">통장개설</a>
	</c:if>
	
		<c:if test="${empty sessionScope.member}">
		<a href="/member/login.iu">Login</a>
		<a href="/member/join.iu">Join</a>
	</c:if>
	
	
<table border="1">
	<thead>
		<tr>
			<th>bookNum</th><th>bookName</th><th>bookRate</th><th>bookSale</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>${detail.bookNum}</td>
			<td>${detail.bookName}</td>
			<td>${detail.bookRate}</td>
			<td>${detail.bookSale}</td>
		</tr>
	</tbody>
</table>
</body>
</html>