<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 태그이름에 form: 접두어를 붙여서 스프링이 제공하는 폼 관련 태그를 사용 -->
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
		아이디 : <input type="text" name="memId" value="${memberVo.memId}" /><br>
		비밀번호 : <input type="text" name="memPass" value="${memberVo.memPass}" /><br> 
		이름 : <input type="text" name="memName" value="${memberVo.memName}" /> <br> 
		포인트 : <input type="text" name="memPoint" value="${memberVo.memPoint}" /> <br> 
		<input type="submit" value="저장" />
	</form>

	<!-- 스프링 form태그의 modelAttribute 속성에 모델 객체의 이름을 설정하고 -->
	<!-- 폼 내부의 입력 엘리먼트들의 path속성에 모델 객체의 속성(변수) 이름을 설정하면 -->
	<!-- 입력 엘리먼트들의 id, name, value 속성값을 자동으로 설정 -->
	<!-- errors 태그를 사용하면, @Valid로 검증한 결과의 에러메시지를 출력 가능 -->
	<form:form modelAttribute="memberVo" action="${pageContext.request.contextPath}/member/add.do" method="post">
		아이디 : <form:input path="memId"/><form:errors path="memId"/> <br>
		비밀번호 : <form:input path="memPass"/><form:errors path="memPass"/><br>
		이름 : <form:input path="memName"/><form:errors path="memName"/><br>
		포인트 : <form:input path="memPoint"/><form:errors path="memPoint"/><br>
		<input type="submit" value="저장" />
	</form:form>
	
</body>
</html>
