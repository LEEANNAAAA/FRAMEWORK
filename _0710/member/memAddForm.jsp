<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/comm/menu.jsp"></jsp:include>

	<h1>회원추가</h1>
	<form action="${pageContext.request.contextPath}/member/add.do" method="post">
		아이디 : <input type="text" name="memId" placeholder="아이디를 입력하세요" /><br>
		비밀번호 : <input type="text" name="memPass" placeholder="비밀번호를 입력하세요" /><br> 
		이름 : <input type="text" name="memName" placeholder="이름을 입력하세요" /> <br> 
		포인트 : <input type="text" name="memPoint" placeholder="포인트를 입력하세요" /> <br> 
		<input type="submit" value="저장" />
	</form>

</body>
</html>
