<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改學生信息</title>
</head>
<body>
	<form action="modify" method="post">
	<input name="id" type="hidden" value="${stu.id }">
	<span>姓名</span>
	<input name="name" type="text" value="${stu.name }"><br>
	<span>班级</span>
	<input name="clazz" type="text" value="${stu.clazz }"><br>
	<span>出生日期</span>
	<input name="birthday" type="datetime" value="${stu.birthday }"><br>
	<input  type="submit" value="修改">
	
	</form>
</body>
</html>