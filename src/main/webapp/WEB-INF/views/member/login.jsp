<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<title>로그인을 하세요</title>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>

<section class="container-fluid mt-4">
<div class="row">

<form action="login.iu", method="post", id="aa">
  <div class="mb-3">
    <label for="userName" class="form-label">ID</label>
    <input type="text" name="userName" value="NAME1" class="form-control" id="userName" aria-describedby="emailHelp">
    <div id="iderror" class="form-text">아이디를 입력하세요 ★</div>
  </div>
  <div class="mb-3">
    <label for="password" class="form-label">Password</label>
    <input type="password" name="password" value="PW1" class="form-control" id="password">
    <div id="iderror" class="form-text">아이디를 입력하세요 ★</div>
  </div>
  <h5 id="h5">로그인오류창</h5>
  <div class="mb-3 form-check">
    <input type="checkbox" class="form-check-input" id="exampleCheck1">
    <label class="form-check-label" for="exampleCheck1">로그인 유지하기</label>
  </div>
  <button type="button" class="btn btn-primary" id="bb">로그인</button>

  <a href="./search.iu">회원정보찾기</a>
</form>

</div>
</section>

<div class="col-md-6">
  <label for="validationServer03" class="form-label">City</label>
  <input type="text" class="form-control is-invalid" id="validationServer03" aria-describedby="validationServer03Feedback" required>
  <div id="validationServer03Feedback" class="invalid-feedback">
    Please provide a valid city.
  </div>
</div>




<!--  
<h3>Login Page</h3>
<form action="login.iu", method="post">
ID <input type="text" value="NAME1" name="userName"><br>
PW <input type="text" value="PW1" name="password">
<input type="submit">
</form>
-->

<c:import url="../template/footer.jsp"></c:import>


<script src="/resources/js/member.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
<script>
  loginCheck();
</script>
</body>
</html>