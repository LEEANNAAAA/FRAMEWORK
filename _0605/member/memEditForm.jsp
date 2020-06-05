<%@page import="kr.ac.kopo.member.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%	
	MemberVo vo = (MemberVo)request.getAttribute("memVo"); //강제로 형변환
%>

<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>회원관리</title>
</head>
<body>
	<h1>회원 정보 수정</h1>

	<form action='<%=request.getContextPath() %>/member/edit.do' method='post'>
		아이디 : <input type='text' name='memId' value='<%= vo.getMemId()%>'readOnly /> <br> 
		이름 : <input type='text' name='memName' value='<%= vo.getMemName()%>' /> <br> 
		포인트 : <input type='text' name='memPoint' value='<%= vo.getMemPoint()%>' /> <br> 
		<input type='submit' value='저장' /> 
		<a href='<%= request.getContextPath()%>/member/del.do?memId=<%= vo.getMemId()%>'><button type='button'>삭제</button></a><br>
	</form>

</body>
</html>
