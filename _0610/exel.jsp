<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL 연습</title>
</head>
<body>
	<div>
		<%="문자열" %>	${"문자열"}
		<%="문자열" %>	${'문자열'}
		<%=123 %>	${123}
		<%=true %>	${true}
	</div>
	<div>
		<%=8+4%> <%=8-4%> <%=8*4%> <%=8/4%> <br>
		${8+4} ${8-4} ${8*4} ${8/4} ${8 div 4} ${8 mod 4}
	</div>
	<div>
		<%=3==4%> <%=3!=4%> <%=3<4%> <%=3>4%> <br>
		${3==4 } ${3!=4 } ${3<4 } ${3>4 } <br>
		${3 eq 4 } ${3 ne 4 } ${3 lt 4 } ${3 gt 4 }
	</div>
	<div>
	<%
		String s = "Hello, EL";	
	%>
	<%=s%><br> <%--문자열을 불러올 때 java형식은 가능하지만 EL형식은 불가능 --%>
	<%-- 	${s} --%>
	
<!-- 		String xparam = request.getParameter("x"); -->
<!-- 		out.println(xparam); -->
		
<!-- 		out.println(request.getParameter("x")); -->
		
		x 파라미터 값 : <%=request.getParameter("x") %> <br>
		x 파라미터 값 : ${param.x} <br>
<!-- 		[]를 쓰고 안에 속성이름을 써주는 것도 가능, 변수명으로 사용할 수 없는 경우는 []로로 필수! 아닌경우는 위에 것처럼 간단하게 사용하면 된다.  -->
		x 파라미터 값 : ${param["x"]} <br> 
		User-Agent 헤더 값 : <%=request.getHeader("User-Agent") %><br>
		User-Agent 헤더 값 : ${header["User-Agent"]} <br>
<!-- 	JSP 기본객체 (request, reponse, session, application,...)는 < html 주석 -->
<!-- 	pageContext에 포함되어 있으므로 꺼내서 사용 가능 -->
		현재 웹애플리케이션(프로젝트)의 고유경로(컨텍스트패스) : <%=request.getContextPath() %> <br>
		현재 웹애플리케이션(프로젝트)의 고유경로(컨텍스트패스) : ${pageContext.request.getContextPath()} <br>
		현재 웹애플리케이션(프로젝트)의 고유경로(컨텍스트패스) : ${pageContext.request.contextPath} <br>
<%-- 		${} 내부에서는  .getXxx() 메서드 대신 .xxx 와 같이 속성(변수)이름만 사용 가능  < jsp주석, 실행처리가 안되고 페이지 코드검사에서 안나타남--%>
	</div>
	<div>
		<%
// 			자바웹애플리케이션에서 데이터를 저장할 수 있는 공간(객체)
			pageContext.setAttribute("a", 1);	//pageContext는 현재 JSP 파일 안에서만 사용가능
			request.setAttribute("b", 2);	//request는 현재 요청이 처리되는 동안에만 사용가능
			session.setAttribute("c", 3);	
			application.setAttribute("d", 4);
			
// 			pageContext.setAttribute("z", 5);	//pageContext는 현재 JSP 파일 안에서만 사용가능
			request.setAttribute("z", 6);	//request는 현재 요청이 처리되는 동안에만 사용가능
			session.setAttribute("z", 7);	
			application.setAttribute("z", 8);
		%>
		pageContext에 "a"라는 이름으로 저장한 값 : <%=pageContext.getAttribute("a") %><br>
		pageContext에 "a"라는 이름으로 저장한 값 : ${pageScope.a}<br>
		pageContext에 "a"라는 이름으로 저장한 값 : ${a}<br>
		request에 "b"라는 이름으로 저장한 값 : <%=request.getAttribute("b") %><br>
		request에 "b"라는 이름으로 저장한 값 : ${requestScope.b}<br>
		request에 "b"라는 이름으로 저장한 값 : ${b}<br>
		session에 "c"라는 이름으로 저장한 값 : <%=session.getAttribute("c") %><br>
		session에 "c"라는 이름으로 저장한 값 : ${sessionScope.c}<br>
		session에 "c"라는 이름으로 저장한 값 : ${c}<br>
		application에 "d"라는 이름으로 저장한 값 : <%=application.getAttribute("d") %><br>
		application에 "d"라는 이름으로 저장한 값 : ${applicationScope.d}<br>
		application에 "d"라는 이름으로 저장한 값 : ${d}<br>
		"z"라는 이름으로 저장한 값 : ${z}<br>
		"z"라는 이름으로 저장한 값 : ${z}<br>
	</div>
	
</body>
</html>