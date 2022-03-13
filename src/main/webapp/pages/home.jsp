<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home.jsp page</title>
</head>
<body>
	<h1>Welcome from home.jsp page.</h1>

	<h3>Add new Employee</h3>
	<form action="addEmployee">
		ID: <input type="text" name="id"><br> 
		Nombre: <input type="text" name="name"><br> 
		Edad: <input type="text" name="age"><br> 
		Salary: <input type="text" name="salary"><br>
		<input type="submit"><br>
	</form>
	
	<h3>Consultar employee por ID</h3>
	<form action="showEmployee">
		ID: <input type="text" name="id"><br> 
		<input type="submit"><br>
	</form>
	
	<h3>Delete employee por ID</h3>
	<form action="deleteEmployee">
		ID: <input type="text" name="id"><br> 
		<input type="submit"><br>
	</form>
	
	<h3>Show All employees por ID</h3>
	<form action="showAllEmployees">
		<input type="submit"><br>
	</form>
	
	
</body>
</html>