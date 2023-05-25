<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Taxes form</h1>
	<form action="ITreturns" method="get">
	Name <input type='text' name='name'/><br/>
	<select name='gender'>
	<option>Male</option>
	<option>Female</option>
	</select><br/>
	Salary <input type='text' name = 'salary'/><br/>
	Taxes <input type='text' name='tax'/><br/>
	<input type='submit' placeholder='submit'/>
	</form>
</body>
</html>