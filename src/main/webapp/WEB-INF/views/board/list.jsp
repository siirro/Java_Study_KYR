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

	<div class="row m-2">
	<form action="./list.iu" method="get" class="row row-cols-lg-auto g-1 align-items-center">
	 
	  <div class="col-2">
	    <label class="visually-hidden" for="find">Preference</label>
	    <select name="kind" class="form-select" id="find">
	      <option class="kinds" value="title" selected="true">제목</option>
	      <option class="kinds" value="contents">내용</option>
	      <option class="kinds" value="writer">작성자</option>
	    </select>
	  </div>
	  
	    <div class="col-3">
	    <label class="visually-hidden" for="search">입력</label>
	    <div class="input-group">
	      <input type="text" name="search" value="${param.search}" class="form-control" id="search" placeholder="입력">
	    </div>
	  </div>
	
	  <div class="col-12">
	    <button type="submit" class="btn btn-primary">검색</button>
	  </div>
	</form>
	</div>


<div>
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
    	<td>
    	
    	<c:catch>
    	<c:forEach begin="1" end="${nl.depth}">&nbsp;--</c:forEach>
    	</c:catch>
    	
    	<a href="./detail.iu?num=${nl.num}">${nl.title}</a></td>
    	<td>${nl.writer}</td>
    	<td>${nl.regDate}</td>
    	<td>${nl.hit}</td>
    </tr>
    </c:forEach>
  </tbody>
</table>
</section>
</div>

<nav aria-label="Page navigation example">
  <ul class="pagination">
  
  	<c:if test="${pager.pre}">
    <li class="page-item">
      <a class="page-link" href="./list.iu?page=${pager.startNum-1}&kind=${paser.kind}&search=${pager.search}" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    </c:if>
    
    <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
    <li class="page-item"><a class="page-link" href="./list.iu?page=${i}&kind=${paser.kind}&search=${pager.search}">${i}</a></li>    
    </c:forEach>
	

		<li class="page-item ${pager.next?'':'disabled'}">
    	  <a class="page-link" href="./list.iu?page=${pager.lastNum+1}&kind=${paser.kind}&search=${pager.search}" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </ul>
</nav>


<a class="btn btn-primary" href="./add.iu" role="button">글쓰기</a>


<%-- <c:if test="${not empty sessionScope.member}">
<a class="btn btn-primary" href="./add.iu" role="button">글쓰기</a>
</c:if> --%>

<c:import url="../template/footer.jsp"></c:import>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" 
integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>

<script src="/resources/js/board.js"></script>
<script>
	let k = '${param.kind}'; //title, writer, contents 셋 중하나가 들어가요
	const kinds = document.getElementsByClassName('kinds');

	for(let i=0;i<kinds.length;i++) {
		if(k==kinds[i].value) {
			//kinds[i].setAttribute("selected",'true');
			kinds[i].selected=true;
			break;
		}
}
</script>
</body>
</html>