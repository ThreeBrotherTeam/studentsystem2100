<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生信息展示</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<th>学号</th>
				<th>姓名</th>
				<th>班级</th>
				<th>出生日期</th>
				<th colspan="2">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="stu" items="${stus}" varStatus="status">
			
			<tr>
				<td>${stu.id }</td>
				<td>${stu.name }</td>
				<td>${stu.clazz}</td>
				<td>${stu.birthday}</td>
				<td><a href="modify?id=${stu.id }">修改学生信息</a></td>
				<td><a href="delete?id=${stu.id }">删除学生信息</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:set var="currentPage" value="${page.currentPage }"></c:set>
	<c:if test="${currentPage>1 }">
		<a href="findAll?currentPage=${currentPage-1 }">
		上一页</a>&nbsp;
	</c:if>
	${currentPage}&nbsp;
	<c:if test="${currentPage<page.totalPage }">
		<a href="findAll?currentPage=${currentPage+1 }">
		下一页</a>
	</c:if>
</body>
</html>