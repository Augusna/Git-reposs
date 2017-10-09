<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="findByCondition" method="POST">
		产品代码<input name="id" />
		风险评级
		<select name="risk">
			<option value="">请选择</option>
			<option value="1">R1</option>
			<option value="2">R2</option>
			<option value="3">R3</option>
		</select>
		<input type="submit" value="查询" />
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="add.jsp">新增理财信息</a><br><br><br><br><br>
	</form>
	<table border="1">
		<c:forEach var="financingProduct" items="${financingProducts }">
			<tr>
				<td>${financingProduct.id}</td>
				<td>${financingProduct.risk}</td>
				<td>${financingProduct.income}</td>
				<td>${financingProduct.saleStarting}</td>
				<td>${financingProduct.saleEnd}</td>
				<td>${financingProduct.end}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>