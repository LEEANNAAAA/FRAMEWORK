<%-- <%@page import="java.util.ArrayList"%> --%>
<%-- <%@page import="kr.ac.kopo.member.MemberVo"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 	core태그 라이브러리 사용하겠다 -->

<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>회원관리</title>
</head>
<body>
<!-- 다른 JSP파일 (또는 서블릿 출력)을 현재 위치에 포함 -->
<%-- 1> <%@ include %> : 다른 JSP파일의 내용을 복사하여 현재위치에 붙여넣기한 것과 동일 --%>
<%-- <%@ include file="/WEB-INF/jsp/comm/menu.jsp" %> --%>

<%-- 2> <jsp:include/> : 다른 JSP파일로 이동하여 실행한 후 다시 현재 위치로 돌아옴, 파일이 개별적으로 돔(forward랑 비슷(forward대신에 include사용해도 됨)), 제일 자주 사용 --%>
<jsp:include page="/WEB-INF/jsp/comm/menu.jsp"></jsp:include>

<%-- 3> <c:import/> : <jsp:include/>와 유사하지만, 외부의 다른 사이트까지 포함 가능 --%>
<%-- <c:import url="/WEB-INF/jsp/comm/menu.jsp"></c:import> --%>

	<h1>회원목록</h1>
<%-- 	<a href='<%=request.getContextPath() %>/member/addform.do'>회원추가</a><br> --%>
	<a href='${pageContext.request.contextPath}/member/login.do'>로그인하기</a><br><hr>
	<a href='${pageContext.request.contextPath}/member/add.do'>회원추가</a><br>
<%-- <% --%>
<!-- 	//요청객체에 "memList"하는 이름으로 저장되어있는 데이터 가져오기 -->
<!--  	ArrayList<MemberVo> list = (ArrayList<MemberVo>)request.getAttribute("memList");	 -->
<!--  	for (MemberVo vo : list) {	//:오른쪽에 배열이나 리스트를 넣어줌, 위에 두 줄을 함축해서 사용할 수 있는 for문 -->
<!-- %> -->

	<c:forEach var="vo" items="${memList}">	
	<a href='${pageContext.request.contextPath}/member/edit.do?memId=${vo.memId}'>${vo.memId}</a>
	 : ${vo.memPass}  : ${vo.memName} :  ${vo.memPoint}
	<br>
	</c:forEach>
	
<%-- <%  --%>
<!-- 	} -->
<!-- %>		 -->

</body>
</html>

