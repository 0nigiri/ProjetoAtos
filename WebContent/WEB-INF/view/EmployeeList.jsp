<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@	taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<html>
<header>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</header>
<head>

<script type="text/javascript" src="res/js/jquery.js"></script>

<style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
</style>

</head>
<body>



	<a href="addJsonPage">Adicionar dados</a>


	<br />
	<br />
	<table style="width:80%">
		<tbody>
			<tr>
				<th>Nome</th>
				<th>Cargo</th>
				<th>Salario</th>
			</tr>
			<c:forEach items="${employees}" var="employees">

				<tr>
					<td>${employees.name}</td>
					<td>${employees.role}</td>
					<td>${employees.salary}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>




</body>
</html>
