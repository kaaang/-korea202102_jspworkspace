<%@page import="com.koreait.site0622.model.domain.News"%>
<%@page import="com.koreait.site0622.model.news.dao.MybatisNewsDAO"%>
<%@page import="com.koreait.site0622.model.news.dao.NewsDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%! NewsDAO newsDAO  = new MybatisNewsDAO(); %>
<%
	int news_id = Integer.parseInt(request.getParameter("news_id"));
	News news = newsDAO.select(news_id);
%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box;}

input[type=text], select, textarea {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  margin-top: 6px;
  margin-bottom: 16px;
  resize: vertical;
}

input[type=button] {
  background-color: #04AA6D;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=button]:hover {
  background-color: #45a049;
}

.container {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.ckeditor.com/4.16.1/standard/ckeditor.js"></script>
<script src="https://unpkg.com/react@16/umd/react.production.min.js"></script>
<script src="https://unpkg.com/react-dom@16/umd/react-dom.production.min.js"></script>
<script src="https://unpkg.com/babel-standalone@6.15.0/babel.min.js"></script>



<script src="/js/Comments.js"></script>
<script type="text/babel">
class CustomComments extends React.Component{
		render(){
			//return 영역 밖에서 원하는 태그를 구성한 후, 완성된 태그를 return 안에서 사용하면 된다...
			var tag=[];
			for(var i=0;i<10;i++){
				tag.push(
			<div>
				<input type="text" value={i}/>
				<input type="text" value={i}/>
				<input type="text" value={i}/>


			</div>
			);
			}
			return <div>
						{tag}
					</div>
		}
	} 
$(function(){

	

	
	


	CKEDITOR.replace("content");
	var bt_list=$("input[type='button']")[0];
	var bt_edit=$("input[type='button']")[1];
	var bt_del=$("input[type='button']")[2];
	
	//버튼에 이벤트 연결하기
	$(bt_list).click(function(){
		location.href="/news/list.jsp";
	});
	$(bt_edit).click(function(){
		
	});
	$(bt_del).click(function(){
		
	});



	//방법3 : 리액트를 사용
	getCommentsList();
	
});

function regist(){
	$("#form1").attr({
		"action":"/news/regist",
		"method":"post"
	});
	$("#form1").submit();
}

function registComments(){
	var formdata = $("#form2").serialize();//폼 양식을 전송할 수 있는 문자열로 변환
	$.ajax({
		url:"/comments/regist",
		type:"post",
		data:formdata,//폼을 전송할 수 있는 데이터화 시킨후, 자체를 전부 전송
		success:function(result, status, xhr){
			if(result==1){
				getCommentsList();//현재 뉴스에 딸린 댓글 가져오기
			}
		}
	});
}


function getCommentsList(){
	//비동기 방식으로 댓글 리스트 요청
	$.ajax({
		url:"/comments/list?news_id=<%=news.getNews_id()%>",
		type:"get",
		success:function(result,status,xhr){
			//넘겨 받은 데이터가 String일 경우, json으로 파싱
			//var json = JSON.parse(result);
			
			
			//넘겨받은 데이터가 json 자체일 경우는 파싱할 필요가 없다.
			console.log(result);

			ReactDOM.render(<CustomComments/>, document.getElementById("commentsArea"))
		}
	});
}

//댓글 목록 출력하기
function printCommentsList(json){
	
	
	//기존의 commentsArea의 컨텐츠를 초기화!(화면에서 제거)
	$("#commentsArea").html("");
	
	
	
	var tag="";
	
	for(var i=0;i<json.commentsList.length;i++){
		var comments=json.commentsList[i];
		tag+="<div>";
		tag+="<input type=\"text\" value=\""+comments.msg+"\" style=\"width: 50%\" readonly=\"readonly\">";	
		tag+="<input type=\"text\" value=\""+comments.cwriter+"\" style=\"width: 25%\" readonly=\"readonly\">";
		tag+="<input type=\"text\" value=\""+comments.cdate+"\" style=\"width: 20%\" readonly=\"readonly\">";
		tag+="</div>";		
	}
	
	
	/*
	var commentsArea = document.getElementById("commentsArea");
	commentsArea.innerHTML=tag;
	*/
	
	$("#commentsArea").append(tag);
	

}


//방법2 : 출력 대상이 되는 태그를 객체로 처리하는법
function printCommentsList2(json){
	$("#commentsArea").html("");
	for(var i=0;i<json.commentsList.length;i++){
		var obj=json.commentsList[i];
		var comments=new Comments(document.getElementById("commentsArea") ,obj.msg, obj.cwriter, obj.cdate);
	}
	
}



</script>




<script>


</script>



</head>
<body>

<h3>상세보기</h3>

<div class="container">
  <form id="form1">
    <input type="hidden" name="news_id" 		value="<%= news.getNews_id() %>">
    <input type="text" name="title" 		value="<%= news.getTitle() %>">
    <input type="text" name="writer" 		value="<%= news.getWriter() %>">
    <textarea 			   name="content" 	style="height:200px"><%=news.getContent() %></textarea>
    <input type="button" value="목록">
    <input type="button" value="수정">
    <input type="button" value="삭제">
  </form>
</div>


<div>
	<form id="form2">
	    <input type="hidden" name="news_id" 		value="<%= news.getNews_id() %>">
		<input type="text" name="msg" placeholder="댓글..." style="width: 50%">	
		<input type="text" name="cwriter" placeholder="작성자" style="width: 25%">	
	    <input type="button" value="등록" style="width: 20%" onclick="registComments()">
    </form>
</div>


<div id="commentsArea">
	
</div>



</body>
</html>
