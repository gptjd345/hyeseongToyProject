<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 컨트롤러에서 alert 메시지를 보내고 싶을 때 사용한다. -->
<script type="text/javascript">
var message = "${msg}";
var returnUrl = "${url}";
alert(message);
document.location.replace(returnUrl);

</script>



</body>
</html>