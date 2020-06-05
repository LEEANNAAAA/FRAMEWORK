<%@page import="java.util.ArrayList"%>
<%@page import="kr.ac.kopo.member.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>회원관리</title>
</head>
<body>
	<h1>회원목록</h1>
	<a href='<%=request.getContextPath() %>/member/addform.do'>회원추가</a><br>

<%
	//요청객체에 "memList"하는 이름으로 저장되어있는 데이터 가져오기
	ArrayList<MemberVo> list = (ArrayList<MemberVo>)request.getAttribute("memList");	
	for (MemberVo vo : list) {	//:오른쪽에 배열이나 리스트를 넣어줌, 위에 두 줄을 함축해서 사용할 수 있는 for문
%>
			
	<a href='<%=request.getContextPath()%>/member/editform.do?memId=<%=vo.getMemId() %>'><%= vo.getMemId()%></a>
	 : <%=vo.getMemPass() %>  : <%=vo.getMemName() %> :  <%=vo.getMemPoint() %>
	<br>
<% 
	}
%>		

</body>
</html>

