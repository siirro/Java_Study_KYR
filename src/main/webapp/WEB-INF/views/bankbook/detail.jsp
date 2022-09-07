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
	
<div class="col-6 m-3">
<table border="1" class="table table-primary">
	<thead>
		<tr>
			<th>bookNum</th>
			<th>bookName</th>
			<th>bookRate</th>
			<th>bookSale</th>
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
</div>

<!-- Comment  -->
<div class="row col-6 m-3">

	<div class="mb-3">
		<label for="writer" class="form-label">USERNAME</label>
		<input type="text" class="form-control" id="writer" placeholder="Enter Your USERNAME">
	</div>
	<div class="mb-3">
		<label for="contents" class="form-label">WRITE CONTENTS</label>
		<textarea class="form-control" id="contents" rows="3"></textarea>
	</div>
	<div class="mb-3">
		<button class="btn btn-danger" type="button" id="commentAdd" data-book-num="${detail.bookNum}">댓글작성</button>
	</div>
</div>


<!-- Comment List 출력 -->
<div class="col-6 m-3">
	<table border="1" class="table table-primary" id="commentList">

	</table>
</div>

<button class="btn btn-primary ml-3" type="button" id="more">더보기</button>

<!-- Comment  -->

<div>
	<button type="button" style="display: none;" class="btn btn-primary m-3" id="up" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="@getbootstrap">댓글 수정</button>

	<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Update</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			</div>
			<div class="modal-body">
				<form>
				<div class="mb-3">
					<label for="recipient-name" class="col-form-label">writer:</label>
					<input type="text" class="form-control" id="recipient-name">
				</div>
				<div class="mb-3">
					<label for="message-text" class="col-form-label">Contents:</label>
					<textarea class="form-control" id="message-text"></textarea>
				</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary">Send message</button>
			</div>
			</div>
		</div>
	</div>

</div>



<c:import url="../template/footer.jsp"></c:import>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" 
integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
<script src="/resources/js/bankbookComment.js"></script>
</body>
</html>