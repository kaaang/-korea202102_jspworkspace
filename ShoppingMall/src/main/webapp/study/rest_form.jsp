<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">

function requestByGet(){
	$.ajax({
		url:"/rest/member",
		type:"get",
		success:function(result,status ,xhr){
			console.log(result);
		}
	});
}
function requestByGet2(){
	$.ajax({
		url:"/rest/member/56",
		type:"get",
		success:function(result,status ,xhr){
			console.log(result);
		}
	});
}
function requestByPost(){
	var param=$("#form1").serialize(); //폼에 입력된 데이터를 문자열로 직렬화
	
	$.ajax({
		url:"/rest/member",
		type:"post",
		data:param,
		success:function(result,status ,xhr){
			console.log(result);
		}
	});
}
//put : 수정 요청시 사용되는 http요청 메서드
function requestByPut(){
	var param=$("#form1").serialize(); //폼에 입력된 데이터를 문자열로 직렬화
	$.ajax({
		url:"/rest/member",
		type:"post",
		data:param,
		success:function(result,status ,xhr){
			console.log(result);
		}
	});
}
function requestByDelete(){
	var param=$("#form1").serialize(); //폼에 입력된 데이터를 문자열로 직렬화
	$.ajax({
		url:"/rest/member",
		type:"post",
		data:param,
		success:function(result,status ,xhr){
			console.log(result);
		}
	});
}

</script>

</head>
<body>

<h2>REST 클라이언트 (form으로 요청시)</h2>

<pre>
<form id="form1">

	<input type="hidden" name="_method" value="delete">
	<input type="text" name="member_id" placeholder="member_id 입력">
	<input type="text" name="user_id" placeholder="user_id 입력">
	<input type="text" name="pass" placeholder="pass 입력">
	<input type="text" name="name" placeholder="name 입력">
	
</form>
</pre>
	<button type="button" onclick="requestByGet()">Get</button>
	<button type="button" onclick="requestByGet2()">Get 한건</button>
	<button type="button" onclick="requestByPost()">Post</button>
	<button type="button" onclick="requestByPut()">Put</button>
	<button type="button" onclick="requestByDelete()">Delete</button>

</body>
</html>