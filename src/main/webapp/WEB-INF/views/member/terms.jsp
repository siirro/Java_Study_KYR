<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
    
    <title>약관</title>
</head>
<body>
<c:import url="../template/header.jsp"></c:import> 
    <h1 class="m-3">약관 동의 페이지</h1>

    <h3 class="m-5">동이</h3>
    <div>
        <input type="checkbox" id="all">모두 동의
        <input type="checkbox" id="" class="cb req">1번 동의 (필수)
        <input type="checkbox" id="" class="cb req">2번 동의 (필수)
        <input type="checkbox" id="" class="cb">3번 동의 (선택)
    </div>
    <form action="./join.iu" method="get" id="submitform">
        <button type="button" id="join">회원가입</button>
    </form>
<c:import url="../template/footer.jsp"></c:import>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
<script src="/resources/js/member.js"></script>
<script>
    check();

</script>
</body>
</html>