<%-- <%@page import="java.util.ArrayList"%> --%>
<%-- <%@page import="kr.ac.kopo.member.MemberVo"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<jsp:include page="/WEB-INF/views/comm/menu.jsp"></jsp:include>

	<%-- 3> <c:import/> : <jsp:include/>와 유사하지만, 외부의 다른 사이트까지 포함 가능 --%>
	<%-- <c:import url="/WEB-INF/jsp/comm/menu.jsp"></c:import> --%>

	<h1>회원목록</h1>
	<%-- 	<a href='<%=request.getContextPath() %>/member/addform.do'>회원추가</a><br> --%>
	<a href='${pageContext.request.contextPath}/member/login.do'>로그인하기</a>
	<br>
	<hr>
	<a href='${pageContext.request.contextPath}/member/add.do'>회원추가</a>
	<br>

	<c:forEach var="vo" items="${memList}">
		<a
			href='${pageContext.request.contextPath}/member/edit.do?memId=${vo.memId}'>
			<c:out value="${vo.memId}" />
		</a>
	 : <c:out value="${vo.memName}"></c:out>
		<br>
	</c:forEach>

	${searchInfo.pageHtml}
	
	<form action="" id="searchForm">
		<select name="searchType">
			<option value="id" ${searchInfo.searchType == 'id'?'selected':''}>아이디</option>
			<option value="name" ${searchInfo.searchType == 'name'?'selected':''}>이름</option>
			<option value="idname" ${searchInfo.searchType == 'idname'?'selected':''}>아이디+이름</option>
		</select> 
<!-- 		<script type="text/javascript"> -->
<%-- 			document.querySelector('[name="searchType"]').value = '${searchInfo.searchType}'; --%>
<!-- 		</script> -->
		<input type="text" name="searchWord" value="${searchInfo.searchWord}" />
		<input type="submit"value="검색" />
		<input type="hidden" name="page" value="1" >
	</form>
	
	<script>
		function goPage(p) {
			document.querySelector('[name="page"]').value = p;
			document.querySelector('#searchForm').submit();
		}
	</script>

<!-- 1.검색조건에 '아이디+이름' 조건 추가 -->
<!-- 2.대소문자 구별없이 검색 -->
</body>
</html>

