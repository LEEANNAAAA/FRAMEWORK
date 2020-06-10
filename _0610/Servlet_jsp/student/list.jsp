
<%@page import="kr.ac.kopo.student.StudentVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!--     // 4. 학생목록을 다음과 같은 표 형태로 출력하고, -->
<!-- // '학번'을 클릭하면 학번 오름차순으로 정력하여 출력하고, -->
<!-- // '이름'을 클릭하면 이름순으로 정력하여 출력 -->
<!-- // -------------------- -->
<!-- // | 학번	| 이름	| -->
<!-- // -------------------- -->
<!-- // | 1234	| 포로리	| -->
<!-- // -------------------- -->
<!-- // | 5678	| 너부리	| -->
<!-- // -------------------- -->

<!-- // '학번'기준으로 정렬된 상태에서 '학번'을 다시 클릭하면, -->
<!-- // 오름차순 또는 내림차순을 번갈아서 정렬 -->
<!-- // '이름'기준으로 정렬된 상태에서 '이름'을 다시 클릭하면, -->
<!-- // 오름차순과 내림차순을 번갈아서 정렬 -->
    
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>학생목록</title>
<style>
talble{
width: 500%;
}
table, th, td{
border: 1px solid black;
}
</style>
<script>
</script>
</head>
<body>
	<h1>학생목록</h1>

	<table>
		<caption>학생목록</caption>
		<thead>
			<tr>
				<th>학번</th>
				<th>이름</th>
				<th>점수</th>
			</tr>
		</thead>
			<a href='<%=request.getContextPath()%>/student/addform.do'>학생추가</a>

<%
	ArrayList<StudentVo> list = (ArrayList<StudentVo>)request.getAttribute("stuList");	
	for (StudentVo vo : list) {	
%>
			<tr>
				<td><a href='<%=request.getContextPath()%>/student/editform.do?stuNo=<%=vo.getStuNo()%>'>
				<%=vo.getStuNo()%></a></td>
				<td><%=vo.getStuName()%></td>
				<td><%=vo.getStuScore()%></td>
			</tr>
	<br>
	<%
	}
	%>
	
	</table>
</body>
</html>
