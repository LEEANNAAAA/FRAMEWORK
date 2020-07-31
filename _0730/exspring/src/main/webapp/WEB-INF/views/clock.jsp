<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CLOCK</title>
<script src="${pageContext.request.contextPath}/js/jquery-3.5.1.js"></script>
<script type="text/javascript">
	$(function() { //문서 끝까지 모두 읽은 후 이 함수를 실행 
		setInterval(function() {
		// 		location.reload();	//현재페이지로 다시 이동
		$.ajax({
			url : "${pageContext.request.contextPath}/data.do", //요청주소
			// 	  method: "POST",	//요청방식
			// 	  data: { id : menuId },	//요청전송시함께 전송할 파라미터들
			dataType : "json" //응답으로 받을 데이터의 타입(text,html,xml,json,...)
		}).done(function(data) {
			//요청에 대한 응답을 정상적으로 받은 경우 실행
			//받은 응답 데이터가 인자로 전달
// 			console.log(msg);
// 			var data = JSON.parse(msg); //JSON문자열을 자바스크립트 객체로(분할)
// 			ajax요청이 dataType : "json"으로 지정하면
// 			jQuery가 응답으로 받은 JSON문자열을 자바스크립트로 변환하여 인자로 전달
			console.log(data);
			$('#time').html(data.now);
			$('#no').html(data.num);
		}).fail(function(jqXHR, textStatus) {
			//요청전송이나 응답 수신이 실패한 경우
			alert("Request failed: " + textStatus);
		});

	}, 1000);

	//제이쿼리를 사용하여 id가 test인 엘리먼트의 내용을 'ABC'로 설정
	// 	document.getElementById('test').innerHTML = 'ABC';
	// 	document.getElementById('test').textContent = 'ABC';
	// 	document.querySelector('#test').innerHTML = 'ABC';
	// 	document.querySelector('#test').textContent = 'ABC';
	// 	$('#test').text('ABC');
	// 	$('#test').html('ABC');
	});
</script>
</head>
<body>
	<div id="test"></div>
	<h1>엄청나게 많은 태그들이 존재</h1>
	<h2>현재시간 : <span id='time'></span></h2>
	<h2>행운의 숫자 : <span id='no'></span></h2>
	<h1>엄청나게 많은 태그들이 존재</h1>
</body>
</html>