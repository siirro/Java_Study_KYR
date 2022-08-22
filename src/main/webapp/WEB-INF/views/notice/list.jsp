<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>공지사항 목록</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" 
rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
<c:import url="../template/header.jsp"></c:import>


<h3 class="m-4">notice list</h3>

<section class="col-lg-8">
<table border="1" class="table table-striped">
		<thead>
			<tr>
				<th>num</th>
				<th>title</th>
				<th>writer</th>
				<th>regDate</th>
				<th>hit</th>
			</tr>
		</thead>
		
		<tbody>
		<c:forEach items="${requestScope.noticeList}" var="dto">
			<tr>
				<td>${pageScope.dto.num}</td>
				<td><a href="./detail.iu?num=${pageScope.dto.num}">${pageScope.dto.title}</td>
				<td>${pageScope.dto.writer}</td>
				<td>${pageScope.dto.regDate}</td>
				<td>${pageScope.dto.hit}</td>
			</tr>
		</c:forEach>
		</tbody>

	</table>
</section>

<c:if test="${not empty sessionScope.member}">
<a class="btn btn-primary" href="./add.iu" role="button">글쓰기</a>
</c:if>



<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" 
integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
<c:import url="../template/footer.jsp"></c:import>
</body>
</html>