<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<title>ID 찾기</title>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>    

	<section class="mt-3">
	<h3>Member Search</h3>
	</section>
	
	<section class="col-lg-2 mt-3">
	<form action="search.iu" method="post">
	<div class="input-group mb-3">
	  <input type="text" name="search" class="form-control" placeholder="ID 입력" aria-label="ID 입력" aria-describedby="button-addon2">
	  <button class="btn btn-outline-secondary" type="submit" id="button-addon2">검색</button>
	</div>
	</form>
	</section>
	

<c:import url="../template/footer.jsp"></c:import>
</body>
</html>