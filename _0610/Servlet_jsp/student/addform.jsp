<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	 <!DOCTYPE html>             
	<html>                       
	<head>                       
	<meta charset='UTF-8'>       
	<title>학생관리</title>      
	</head>                      
	<body>                       
		<h1>학생추가</h1>        
		
		<form action='<%=request.getContextPath() %>/student/add.jsp' method='post'>	
		학번 : <input type='text' name='stuNo' /> <br>
		이름 : <input type='text' name='stuName' /> <br>
		성적 : <input type='text' name='stuScore' /> <br>
	 <input type='submit' value='저장'/>                                
	</form>   
		
	</body>                       
	</html>     