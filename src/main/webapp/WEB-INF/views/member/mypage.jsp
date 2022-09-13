<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<title>회원정보</title>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>    
<h3 class="m-4 text-center" style="color:purple">Member Info</h3>

<div class="text-center m-3">
	<img width=400 height=250 src="../resources/upload/member/${dto.bankMembersFileDTO.fileName}" >
</div>

<div class="text-center">
	<c:forEach items="${member.roleDTOs}" var="roleDTO">
	<div>${roleDTO.roleNum}, ${roleDTO.roleName}</div>
	</c:forEach>
	
	<h1>당신은 ${member.roleDTOs.get(0).roleName}등급입니다</h1>
	<h1>당신은 ${member.roleDTOs["0"].roleName}등급입니다</h1>
</div>

<section class="col-6 m-auto mt-3 text-center">
<table border="1" class="table border-primary">
		<thead class="table-primary">
			<tr>
				<th>ID</th>
				<th>이름</th>
				<th>이메일</th>
				<th>전화번호</th>
			</tr>
		</thead>
		<tbody>
				<tr>
					<td>${requestScope.dto.userName}</td>
					<td>${requestScope.dto.name}</td>
					<td>${requestScope.dto.email}</td>
					<td>${requestScope.dto.phone}</td>
				</tr>
		</tbody>
	</table>
</section>


<h3 class="m-4 text-center" style="color:purple">보유 계좌 현황</h3>


<section class="text-center col-6 m-auto">
	<table border="1" class="table table-striped">
		<thead>
			<tr>
				<th>계좌번호</th>
				<th>통장이름</th>
				<th>개설일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${dto.bankAccountDTOs}" var="mypage2">
				<tr>
					<td>${mypage2.accountNum}</td>
					<td>${mypage2.bankBookDTO.bookName}</td>
					<td>${mypage2.accountDate}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</section>




<!-- map버전
<section class="col-lg-6">
<table border="1" class="table table-striped">
		<thead>
			<tr>
				<th>userName</th>
				<th>name</th>
				<th>email</th>
				<th>phone</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>ID : ${mypageMap.dto.userName}</td>
				<td>${mypageMap.dto.name}</td>
				<td>${mypageMap.dto.email}</td>
				<td>${mypageMap.dto.phone}</td>
			</tr>
		</tbody>

	</table>
</section>


<section class="col-lg-6">
<table border="1" class="table table-striped">
		<thead>
			<tr>
				<th>accountNum</th>
				<th>bookName</th>
				<th>accountDate</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${mypageMap.list}" var="mypage2">
			<tr>
				<td>${mypage2.accountNum}</td>
				<td>${mypage2.bankBookDTO.bookName}</td>
				<td>${mypage2.accountDate}</td>
			</tr>
		</c:forEach>
		</tbody>

	</table>
</section>
  -->

<c:import url="../template/footer.jsp"></c:import>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>