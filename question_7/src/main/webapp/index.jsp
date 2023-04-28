<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	
	<div>
	<h1>Insert data</h1>
	<form action='insert' method='post'>
		ID  : <input type='number' name='id' /> <br/>
		Name: <input type='text' name='name' /> <br/>
		Age : <input type='number' name='age' /> <br/>
		Cause : <input type='text' name='cause' /> <br/>
		Doctor : <input type='text' name='doctor' /> <br/>
		Date : <input type='date' name='date' /> <br/>
		Treatment :<input type='text' name='treatment' /> <br/>
		<input type='submit' value='postData'>
	</form>
	
	<h1>Update data</h1>
	
	<form action='update' method='post'>
		ID  : <input type='number' name='id' /> <br/>
		Name: <input type='text' name='name' /> <br/>
		Age : <input type='number' name='age' /> <br/>
		Cause : <input type='text' name='cause' /> <br/>
		Doctor : <input type='text' name='doctor' /> <br/>
		Date : <input type='date' name='date' /> <br/>
		Treatment :<input type='text' name='treatment' /> <br/>
		<input type='submit'>
	</form>
	<h1>View Details</h1>
	
	<form action="view" method="GET">
		View Details<input type="submit">
	</form>
	</div>
</body>
</html>