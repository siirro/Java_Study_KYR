<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>질문게시판 수정 페이지</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" 
rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<section class="m-3">
	<h3>QNA Edit</h3>
	</section>

<section class="col-lg-6">
<form action="update.iu?num=${updateinfo.num}" method="post">
    <div class="form-floating">
      <input type="text" class="form-control" id="floatingPassword" placeholder="글제목" name="title">
      <label for="floatingPassword">글제목</label>
    </div>
    <div>
      <textarea rows="10" class="form-control"  id="floatingPassword" placeholder="글내용" name="contents"></textarea>
    </div>
    <br>
    <button class="w-100 btn btn-lg btn-primary" type="submit">수정</button>
  </form>
</section>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" 
integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
<c:import url="../template/footer.jsp"></c:import>
</body>
</html>