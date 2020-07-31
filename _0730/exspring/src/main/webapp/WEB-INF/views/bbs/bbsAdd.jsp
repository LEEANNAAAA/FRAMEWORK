<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/comm/menu.jsp"></jsp:include>

	<h1>새 글 쓰기</h1>
	<br>
	<!-- 	파일(업로드)이 포함된 경우에는, enctype="multipart/form-data" 속성을 지정 -->
	<form action = "${pageContext.request.contextPath}/bbs/add.do" method="post" enctype="multipart/form-data">
	
	<table border="1">
		<tbody>
			<tr><th>제목</th><td><input type="text" name="bbsTitle"/><br></td></tr>
			<tr><th>내용</th><td><textarea name="bbsContent" rows="20" clos="30"></textarea><br></td></tr>
			<tr><th>첨부파일1</th><td><input type="file" name="upfileList" "/><br></td></tr>	
			<tr><th>첨부파일2</th><td><input type="file" name="upfileList" "/><br></td></tr>	
<!-- 보안은 화면에서 구현하는게 아니라 백엔드 자바코드에서 구현해야 한다. 이곳에 적으면 보안 안됨 -->
			
		</tbody>
	</table>

	<input type="submit" value="저장"/>
	</form>
</body>
</html>