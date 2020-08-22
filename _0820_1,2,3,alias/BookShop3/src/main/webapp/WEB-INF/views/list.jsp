<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style>
	.active{
		background-color: skyblue;
	}
</style>
</head>
<body>
	<div>
		<h1>도서목록</h1>
		<div>
			<form method="get" action="">
				<span>
					<select name="search">
						<option value="0">선택</option>
						<option value="1" ${pager.search == 1 ? 'selected' : ''}>도서번호</option>
						<option value="2" ${pager.search == 2 ? 'selected' : ''}>도서명</option>
						<option value="3" ${pager.search == 3 ? 'selected' : ''}>도서출판사</option>
						<option value="4" ${pager.search == 4 ? 'selected' : ''}>가격</option>
					</select>
				</span>
				<span>
					<input type="text" name="keyword" placeholder="검색어를 입력해주세요" value="${pager.keyword}">
				</span>
				<span>
					<input type="submit" value="검색">
				</span>
			</form>
			<table border="1">
				<thead>
					<tr>
						<th><a href="?${pager.query}&header=1&order=${pager.header == 1 ? (pager.order+1) % 2 : 0}">도서번호</a></th>
						<th><a href="?${pager.query}&header=2&order=${pager.header == 2 ? (pager.order+1) % 2 : 0}">도서명</a></th>
						<th><a href="?${pager.query}&header=3&order=${pager.header == 3 ? (pager.order+1) % 2 : 0}">출판사</a></th>
						<th><a href="?${pager.query}&header=4&order=${pager.header == 4 ? (pager.order+1) % 2 : 0}">가격</a></th>
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
				<div><a href="?page=1&${pager.query}">처음</a></div>
				<div><a href="?page=${pager.prev}&${pager.query}">이전</a></div>
				<ul>
				<c:forEach var="page" items="${pager.list}">
					<li class="${page==pager.page ? 'active' : ''}"><a href="?page=${page}&${pager.query}">${page}</a></li>
				</c:forEach>
				</ul>
				<div><a href="?page=${pager.next}&${pager.query}">다음</a></div>
				<div><a href="?page=${pager.last}&${pager.query}">마지막</a></div>
				
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