<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>글 상세 페이지</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" 
rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
<c:import url="../template/header.jsp"></c:import>


<h3 class="m-4">QNA detail</h3>


<section class="col-lg-8">
<table border="1" class="table table-striped" >
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
			<tr>
				<td>${qnaDetail.num}</td>
				<td>${qnaDetail.title}</td>
				<td>${qnaDetail.writer}</td>
				<td>${qnaDetail.regDate}</td>
				<td>${qnaDetail.hit}</td>
			</tr>
		</tbody>

	</table>
	
	<table border="1" class="table table-striped">
		<thead>
			<tr>
				<th>글내용</th>
			</tr>
	</thead>
	<tbody>
		<tr>
			<td>${qnaDetail.contents}</tr>
		</tr>
		</tbody>
	</table>
</section>

<a class="btn btn-primary" href="./update.iu?num=${qnaDetail.num}" role="button">글수정</a>
<a class="btn btn-primary" href="./delete.iu?num=${qnaDetail.num}" role="button">글삭제</a>



<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" 
integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
<c:import url="../template/footer.jsp"></c:import>
</body>
</html>