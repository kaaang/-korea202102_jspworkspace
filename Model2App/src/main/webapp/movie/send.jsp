<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


	<style type="text/css">
		select:{
			width:400px;
			font-size:30px;
		}
	</style>
	
	
<script>
	function send(){
		form1.action="/movie.do";
		form1.method="post";
		form1.submit();
	}
</script>
	
</head>
<body>

	<form name="form1">
	<select name="movie">
		<option>영화를 선택하세요</option>
		<option value="미션임파서블">미션임파서블</option>
		<option value="크루엘라">크루엘라</option>
		<option value="어바웃타임">어바웃타임</option>
		<option value="어벤져스">어벤져스</option>
	</select>
	</form>
	<button onclick="send()">결과보기</button>
	
	
</body>
</html>