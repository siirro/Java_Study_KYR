<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
	let result = ${result};
	alert(result);
	
	
	let message = '${message}'; //''가 없으면 변수명으로 인식한다.
	alert(message);
	
	location.href="${url}";

</script>

</body>
</html>