<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>공지 List</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" 
rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>

<h3 class="m-4">${board} 목록</h3>

<section class="col-lg-6">
<table class="table table-bordered border-primary">
  <thead class="table-primary">
    <tr>
    	<th>글번호</th>
    	<th>글제목</th>
    	<th>작성자</th>
    	<th>등록일</th>
    	<th>조회수</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${requestScope.list}" var="nl">
    <tr>
    	<td>${nl.num}</td>
    	<td><a href="./detail.iu?num=${nl.num}">${nl.title}</a></td>
    	<td>${nl.writer}</td>
    	<td>${nl.regDate}</td>
    	<td>${nl.hit}</td>
    </tr>
    </c:forEach>
  </tbody>
</table>
</section>

<nav aria-label="Page navigation example">
  <ul class="pagination">
  
  	<c:if test="${pager.pre}">
    <li class="page-item">
      <a class="page-link" href="./list.iu?page=${pager.startNum-1}" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    </c:if>
    
    <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
    <li class="page-item"><a class="page-link" href="./list.iu?page=${i}">${i}</a></li>    
    </c:forEach>
	

		<li class="page-item ${pager.next?'':'disabled'}">
    	  <a class="page-link" href="./list.iu?page=${pager.lastNum+1}" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </ul>
</nav>



<c:if test="${not empty sessionScope.member}">
<a class="btn btn-primary" href="./add.iu" role="button">글쓰기</a>
</c:if>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" 
integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
<c:import url="../template/footer.jsp"></c:import>
</body>
</html>