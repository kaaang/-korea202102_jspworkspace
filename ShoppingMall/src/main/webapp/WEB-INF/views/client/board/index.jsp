<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.wrapper{
	width:100%;
	height:600px;
	overflow:hidden;
}
.regist-area{
	width:20%;
	height:100%;
	background:pink;
	float:left;
}
#list-area{
	width:60%;
	height:100%;
	background:#CCCEEE;
	float:left;
}
.detail-area{
	width:20%;
	height:100%;
	background:#EE66DD;
	float:left;
}
</style>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
function regist(){
	
	var json={
			title:$("input[name='title']").val(),
			writer:$("input[name='writer']").val(),
			content:$("textarea[name='content']").val()
	}
	
	$.ajax({
		url:"/client/cs/board/regist",
		type:"post",
		data:JSON.stringify(json),
		contentType:"application/json;charset=utf-8",
		success:function(result,status,xhr){
			alert(result);
		},
		error:function(xhr,status,error){
			alert(error);
		}
	});
}
</script>

</head>
<body>
	<div class="wrapper">
		<div class="regist-area">
			<form>
				<input type="text" placeholder="제목" name="title">
				<input type="text" placeholder="작성자" name="writer">
				<textarea placeholder="내용" name="content"></textarea>
				<button type="button" onClick="regist()">등록</button>
			</form>
		</div>
		<div id="list-area">리스트</div>
		<div class="detail-area">상세영역</div>
	</div>
</body>
</html>