<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>공지게시판 글작성</title>

<!-- 제이쿼리 -->
<script type="text/javascript" src="//code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- 부트스트랩 5 -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" 
rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<!-- 섬머노트 -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>


</head>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<h3 class="m-4">${board} 글작성</h3>

<section class="col-lg-6">
<form action="add.iu" method="post" enctype="multipart/form-data">
    <div class="form-floating">
      <input type="text" class="form-control" id="floatingWriter" placeholder="Writer" name="writer" value=${member.userName} readonly>
      <label for="floatingWriter">작성자</label>
    </div>
    <div class="form-floating">
      <input type="text" class="form-control" id="floatingPassword" placeholder="글제목" name="title">
      <label for="floatingPassword">글제목</label>
    </div>
    <div>
      <textarea class="form-control" id="contents1" placeholder="글내용" name="contents" rows="15" ></textarea>
    </div>
	 <div class="form-floating">
      <input type="file" class="form-control" id="file" placeholder="파일" name="files">
      <label for="floatingfile">파일첨부</label>
    </div>
    <div class="form-floating">
      <input type="file" class="form-control" id="file" placeholder="파일" name="files">
      <label for="floatingfile">파일첨부</label>
    </div>
    <div class="form-floating">
      <input type="file" class="form-control" id="file" placeholder="파일" name="files">
      <label for="floatingfile">파일첨부</label>
    </div>
    
    
    <br>
    <button class="w-100 btn btn-lg btn-primary" type="submit">작성</button>
  </form>
</section>	

<c:import url="../template/footer.jsp"></c:import>
<!-- 부트스트랩 5 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" 
integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
<script type="text/javascript">
	$("#contents").summernote();
</script>
</body>
</html>