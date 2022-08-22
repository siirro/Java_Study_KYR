<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>상품 List</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" 
rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">

<title>Insert title here</title>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
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
<c:import url="../template/footer.jsp"></c:import>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" 
integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>

</body>
</html>