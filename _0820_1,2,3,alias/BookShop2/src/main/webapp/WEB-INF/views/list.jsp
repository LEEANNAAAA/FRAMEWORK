<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
						<c:when test="${list.size() > 0}">
							<c:forEach var="item" items="${list}">
								<tr>
									<td>${item.bookid}</td>
									<td>${item.bookname}</td>
									<td>${item.publisher}</td>
									<td>${item.price}</td>
									<td><a href="${item.bookid}/delete">삭제</a><a href="${item.bookid}/update">변경</a></td>
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
				<ul>
				<c:forEach begin="1" end="${pager.total / pager.perPage}" varStatus="status">
					<li><a href="?page=${status.count}">${status.count}</a></li>
				</c:forEach>
				</ul>
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