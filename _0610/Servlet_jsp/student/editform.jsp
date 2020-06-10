<%@page import="kr.ac.kopo.student.StudentVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%	
	StudentVo vo = (StudentVo)request.getAttribute("stuVo"); //강제로 형변환
%>
    
		<!DOCTYPE html>            
		<html>                     
		<head>                     
		<meta charset='UTF-8'>     
		<title>학생관리</title>    
		</head>                    
		<body>                     
			<h1>학생 정보 수정</h1>


	<form action='<%= request.getContextPath()%>/student/edit.do' method='post'>
		학번 : <input type='text' name='stuNo' value='<%=vo.getStuNo()%>' readOnly/> <br>
		이름 : <input type='text' name='stuName' value='<%=vo.getStuName()%>'/> <br> 
		성적 : <input type='text' name='stuScore' value='<%=vo.getStuScore()%>'/> <br> 
		<input type='submit' value='저장' /> <a href='<%= request.getContextPath()%>/student/del.jsp?stuNo=<%=vo.getStuNo()%>'><button type='button'>삭제</button></a><br>                    
	</form>
	
		</body>                     
		</html>  
