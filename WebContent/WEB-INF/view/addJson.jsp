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
<script type="text/javascript" src="res/js/fileReader.js"></script>


</head>
<body>


	<a href="EmployeeList">Voltar</a>


	<form action="AddJson" id="cadastro" class="simple-form">
		<div>
			<label for="input-file">Selecione o arquivo JSON:</label><br /> <input
				type="file" id="input-file">
		</div>
		<label>Preview do JSON</label> <br />

		<textarea name="jsonString" id="content-target"></textarea>
		<br /> <input type="submit" value="Enviar">
	</form>


	<script>
		document.getElementById('input-file').addEventListener('change',
				getFile)
	</script>

</body>
</html>
