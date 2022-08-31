<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<title>회원가입</title>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>

	<h3 class="m-3">Join Page</h1>
	
	<form action="join.iu" method="post" enctype="multipart/form-data" id="gg">
	<div>
		<div class="form-floating col-4 m-1">
	      <input type="text" class="form-control" id="idid" name="userName">
	      <div id="iderror" style="color: red; font-size: small;""></div>
		  <label for="floatingID">ID</label>
    	</div>
        <div class="form-floating col-4 m-1">
			<input type="password" class="form-control" id="password" name="password">
			<div id="pwerror" style="color: red; font-size: small;"></div>
			<label for="floatingID">비밀번호</label>
		</div>
		<div class="form-floating col-4 m-1">
			<input type="password" class="form-control" id="passwordCheck" name="passwordc">
			<div id="pce" style="color: red; font-size: small;"></div>
			<label for="floatingID">비밀번호확인</label>
		</div>

		<div class="form-floating col-4 m-1">
			<input type="text" class="form-control" name="name" id="namen">
			<div id="nerror" style="color: red; font-size: small;"></div>
			<label for="floatingID">이름</label>
		</div>

		<div class="form-floating col-4 m-1">
			<input type="email" required class="form-control" name="email" id="email"> <br>
			<div id="eerror" style="color: red; font-size: small;"></div>
			<label for="floatingID">이메일 </label>
		</div>

		<div class="form-floating col-4 m-1">
			<input type="tel" class="form-control" name="phone" id="phone"> <br>
			<div id="perror" style="color: red; font-size: small;"></div>
			<label for="floatingID">전화번호</label>
		</div>

	    <div class="form-floating col-2">
	      <input type="file" class="form-control" id="files" placeholder="글제목" name="photo">
	      <label for="files">파일첨부</label>
	    </div>
       
        <button type="submit" class="btn btn-primary" id="jbutton" >회원가입</button>

    </div>
    </form>

<c:import url="../template/footer.jsp"></c:import>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
  
<script src="/resources/js/join.js"></script>
</body>
</html>