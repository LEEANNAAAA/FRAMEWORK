<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
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
			<tr><th>작성자</th><td>${bbsVo.bbsWriter}<br></td></tr>
		</tbody>
	</table>
	<input type="submit" value="저장"/>
<%-- 	<a href='${pageContext.request.contextPath}/bbs/del.do?bbsNo=${bbsVo.bbsNo}'><button type='button'>삭제</button></a> --%>
	<a href='${pageContext.request.contextPath}/bbs/del.do?bbsNo=${bbsVo.bbsNo}'><input type="button" value="삭제"/></a>
	</form>
</body>
</html>