<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>공지게시판 글수정</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" 
rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>

</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<h3 class="m-4">공지사항 글 수정</h3>

<section class="col-lg-6">
<form action="update.iu?num=${boardDTO.num}" method="post">
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