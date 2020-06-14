<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
	<h1>새 글 쓰기</h1>
	<br>
	<form action = "${pageContext.request.contextPath}/bbs/add.do" method="post">
	
	<table border="1">
		<tbody>
			<tr><th>제목</th><td><input type="text" name="bbsTitle"/><br></td></tr>
			<tr><th>내용</th><td><textarea name="bbsContent" rows="20" clos="30"></textarea><br></td></tr>
			<tr><th>작성자</th><td><input type="text" name="bbsWriter"/><br></td></tr>
		</tbody>
	</table>

	<input type="submit" value="저장"/>
	</form>
</body>
</html>