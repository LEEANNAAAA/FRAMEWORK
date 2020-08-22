<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<div>
		<h1>도서목록</h1>
		<div>
			<table border="1">
				<thead>
					<tr>
						<th>도서번호</th>
						<th>도서명</th>
						<th>출판사</th>
						<th>가격</th>
						<th>관리</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${liist.size() > 0}">
							<c:forEach var="ittem" items="${liist}">
								<tr>
									<td>${ittem.bookid}</td>
									<td>${ittem.bookname}</td>
									<td>${ittem.publisher}</td>
									<td>${ittem.price}</td>
									<td><a href="${ittem.bookid}/delete">삭제</a><a href="${ittem.bookid}/update">변경</a></td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td colspan="5">등록된 도서가 없습니다.</td>
							</tr>
						</c:otherwise>
					</c:choose>

				</tbody>
			</table>
			<div>
				<div><a href="">처음</a></div>
				<div><a href="">이전</a></div>
				<ul>
				<c:forEach begin="1" end="${ppager.total / ppager.perPage}" varStatus="status">
					<li><a href="?page=${status.count}">${status.count}</a></li>
				</c:forEach>
				</ul>
				<div><a href="">다음</a></div>
				<div><a href="">마지막</a></div>
			</div>
		</div>
		<div>
			<a href="add">등록</a>
		</div>
		<div>
			<a href="dummy">대량등록</a>
		</div>
		<div>
			<a href="init">초기화</a>
		</div>
	</div>
</body>
</html>