<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/comm/menu.jsp"></jsp:include>

	<h1>글 상세정보</h1>
	<br>
	<form action = "${pageContext.request.contextPath}/bbs/edit.do" method="post">
	<input type="hidden" name="bbsNo" value="${bbsVo.bbsNo}" />
	<table border="1">
		<tbody>
<%-- 		<tr><th>글번호</th><td><input type="text" name="bbsNo" value="${bbsVo.bbsNo}" readOnly="readOnly"/><br></td></tr> --%>
			<tr><th>제목</th><td><input type="text" name="bbsTitle" value="${bbsVo.bbsTitle}"/><br></td></tr>
			<tr><th>내용</th><td><textarea name="bbsContent" rows="20" clos="30" >${bbsVo.bbsContent}</textarea><br></td></tr>
			<!-- textarea는 바깥쪽에 value값을 적어줘야 엔터값이랑 내용이 쭉 나온다 -->
			<tr><th>작성자</th><td><c:out value="${bbsVo.bbsWriter}"></c:out><br></td></tr>
			<tr><th>등록일</th><td><fmt:formatDate value="${bbsVo.bbsRegDate}" pattern= "yyyy년 MM월 dd일  HH시 mm분 ss초" /><br></td></tr>
			
		</tbody>
	</table>
	<input type="submit" value="저장"/>
<%-- 	<a href='${pageContext.request.contextPath}/bbs/del.do?bbsNo=${bbsVo.bbsNo}'><button type='button'>삭제</button></a> --%>
	<a href='${pageContext.request.contextPath}/bbs/del.do?bbsNo=${bbsVo.bbsNo}'><input type="button" value="삭제"/></a>
	</form>
</body>
</html>