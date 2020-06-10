<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 연습</title>
</head>
<body>
	<%
		int n = 70;
		request.setAttribute("n", n);
	%>	
	
	<c:if test= "<%=n>=60%>">
			통과
	</c:if>	
	<c:if test= "<%=n<60%>">
			실패
	</c:if>	

	<c:if test= "${n>=60}">
			통과
	</c:if>	
	<c:if test= "${n<60}">
			실패
	</c:if>	
	
	<c:choose>
		<c:when test="${n<=60}">통과</c:when>
		<c:otherwise>실패</c:otherwise>
	</c:choose>
	
	<hr>
	<c:forEach begin="0" end="10" step="2">
<!-- 	0부터 10까지 2씩 증가 반복출력, for문 -->
		[반복출력]
	</c:forEach><br>
	<%
		ArrayList list = new ArrayList<String>();
		list.add("짜장");
		list.add("짬뽕");
		list.add("탕수육");
		request.setAttribute("foodList", list);
	%>
<!-- 	items에 지정한 배열/리스트의 값들을 하나씩 꺼내서 -->
<!-- 	var에 지정한 이름의 변수 넣으면서 반복 -->

 	
	<ul>
	<c:forEach var="food" items="${foodList}">
	<li>
		${food}
	</li>
	</c:forEach>
	</ul>
<!-- "짜장","짬뽕","탕수육"이 목록형태로 출력 -->
	<hr>
	<%
		request.setAttribute("s", "<h1>Hello</h1>");
	%>
	<h1>Hello</h1>
	${s}
	
<!-- 	&lt;h1&gt;Hello&lt;/h1&gt;요렇게 표현해주는게 아랫방식 -->
	<c:out value="${s}"></c:out>
<!-- 	escapeXml="false" 이걸 적어주면 <h1>Hello</h1> 이렇게 표시해주고, true 일 경우 &lt;h1&gt;Hello&lt;/h1&gt; 이렇게 표시 -->
	<c:out value="${s}" escapeXml="false"></c:out>
	<c:out value="${s}" escapeXml="true"></c:out>
<br>
<hr>
<!-- 다른 HTML, JSP, 서블릿 등의 내용을 포함 -->
<div>
	<c:import url="hello.jsp"></c:import>
	<hr>
	<c:import url="http://google.com"></c:import>
</div>

<hr>
<!-- 	아래 "헬로JSP로 가는 링크"를 클릭하면 hello.jsp 파일로 이동하도록 링크를 구현 -->
	<a href = "hello.jsp">헬로JSP로 가는 링크</a><br>
	<a href = "./hello.jsp">헬로JSP로 가는 링크</a><br>
	<a href = "/exweb/hello.jsp">헬로JSP로 가는 링크</a><br>
	<a href = "<%=request.getContextPath()%>/hello.jsp">헬로JSP로 가는 링크</a><br>
	<a href = "${pageContext.request.getContextPath()}/hello.jsp">헬로JSP로 가는 링크</a><br>
	<a href = "${pageContext.request.contextPath}/hello.jsp">헬로JSP로 가는 링크(가장 많이 활용)</a><br>
	<a href = "	<c:url value="/hello.jsp"></c:url>">헬로JSP로 가는 링크</a><br>
	<a href = "	<c:url value="/hello.jsp"/>">헬로JSP로 가는 링크</a><br>
	
	<br>
	<hr>
	<%
		Date d = new Date();
		request.setAttribute("now", d);
		double num = 12345678.9876;
		request.setAttribute("no", num);
	%>
	<div>현재시간 : ${now}</div> 
	<div>현재시간 : <fmt:formatDate value="${now}" pattern="yyyy/MM/dd HH:mm:ss"/></div> 
	<div>현재시간 : <fmt:formatDate value="${now}" pattern="yyyy년  MM월 dd일 hh시 mm분 ss초"/></div> 
<!-- 	fmt:formatDate 태그를 사용하여 날짜/시간 데이터를 문자열로 변환 / data >> string -->
<!-- 	pattern 속성에 자바의 SimpleDateFormat에서 사용시 사용하는 패턴으로 원하는 문자열 지정 -->
<%-- 	<div>현재시간 : <fmt:parseDate> ${now}</div>  --%>
<!-- 	string >> data -->
	<div>num 값 : ${no}</div> 
<!-- 	pattern 속성에 자바 DecimalFormat에서 사용하는 패턴으로 원하는 문자열 지정 -->
	<div>num 값 : <fmt:formatNumber value="${no}" pattern="#,###.##"></fmt:formatNumber> </div> 
	<div>num 값 : <fmt:formatNumber value="${no}" pattern="000,000,000.##"></fmt:formatNumber> </div> 
	
</body>
</html>