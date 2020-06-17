<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<style>
body{
text-align: center}
</style>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/comm/menu.jsp"></jsp:include>

	<h1>게시글 목록</h1>
	
	<a href="${pageContext.request.contextPath}/bbs/add.do">새글쓰기</a>

	
	<table border="1" align='center'>
		<thead>
			<tr><th>글번호</th><th>제목</th><th>작성자</th><th>등록일</th></tr>
		</thead>
		<tbody>
<!-- 			<tr><td>1</td><td>첫글</td><td>a001</td><td>2020/06/12 09:45:21</td></tr> -->
<!-- 			<tr><td>2</td><td>두번째글</td><td>a001</td><td>2020/06/12 09:47:11</td></tr> -->
			<c:forEach var="vo" items="${bbsList}">	
<!-- 			배열에 있는 값 하나씩 뺴서 사용하기 -->
			<tr>
			<td>${vo.bbsNo}</td>
			<td><a href='${pageContext.request.contextPath}/bbs/edit.do?bbsNo=${vo.bbsNo}'>${vo.bbsTitle}</a></td>
			<td>${vo.bbsWriter}</td>
			<td><fmt:formatDate value="${vo.bbsRegDate}" pattern= "yyyy/MM/dd hh:mm:ss" /></td>
			
			</tr>
			</c:forEach>
		</tbody>
	</table>
	</body>
</html>