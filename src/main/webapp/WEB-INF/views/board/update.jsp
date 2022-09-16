<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>${board} 글수정</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" 
rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<!-- 섬머노트 -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
<!-- 섬머노트 제이쿼리 -->
<script type="text/javascript" src="//code.jquery.com/jquery-3.6.0.min.js"></script>


</head>

</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<h3 class="m-4">${board} 글 수정</h3>

<section class="col-lg-6">
<form action="update.iu?num=${boardDTO.num}" method="post" enctype="multipart/form-data">
    <div class="form-floating">
      <input type="text" class="form-control" id="floatingPassword" placeholder="글제목" name="title" value="${boardDTO.title}">
      <label for="floatingPassword">글제목</label>
    </div>
    <div>
      <textarea rows="10" class="form-control"  id="contents" placeholder="글내용" name="contents" value="${boardDTO.contents}">${boardDTO.contents}</textarea>
    </div>
    
    <c:forEach items="${boardDTO.boardFileDTO}" var="fileDTO">
    	<div class="mb-3">
    		<span class="form-control">${fileDTO.oriName}</span>
    		<button type="button" class="fileDelete" date-file-num="${fileDTO.fileNum}">삭제</button>
    	</div>
    </c:forEach>
    <div id="addFiles">
      <button class="btn btn-danger m-1" type="button" id="addFilesb">파일 추가</button>
    </div>
    
    <br>
    <button class="w-100 btn btn-lg btn-primary" type="submit">수정</button>
  </form>
</section>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" 
integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
<script src="/resources/js/board.js"></script>
<script type="text/javascript">
  setCount(${boardDTO.boardFileDTO.size()});
  $("#contents").summernote();
</script>
<c:import url="../template/footer.jsp"></c:import>
</body>
</html>