<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<div>
		<h2>마당서점</h2>
		<c:if test="${sessionScope.user != null}">
			<div><a href="logout">${sessionScope.user.name} 로그아웃</a></div>
		</c:if>
		<c:if test="${sessionScope.user == null}">
			<div><a href="login">로그인</a></div>
		</c:if>
		<ul>
			<li><a href="book/list">도서관리</a></li>
			<li><a href="customer/list">고객관리</a></li>
			<li><a href="order/list">주문관리</a></li>
		</ul>
	</div>
</body>
</html>