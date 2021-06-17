<%@page import="site0616.medel.domain.Board"%>
<%@page import="site0616.board.medel.dao.BoardDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page  contentType="text/html; charset=UTF-8"%>
<%!
	BoardDAO boardDAO = new BoardDAO();

%>
<%
	String board_id = request.getParameter("board_id");
	Board board = boardDAO.select(Integer.parseInt(board_id));
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
<script type="text/javascript">
$(function(){
	CKEDITOR.replace("content");
	
	//버튼에 이벤트 연결하기
	$("#bt_edit").click(function(){
		if(confirm("수정 하시겠습니까?")){
		edit();			
		}
	});
	$("#bt_del").click(function(){
		if(confirm("삭제 하시겠습니까?")){
		del();			
		}
	});
	$("#bt_list").click(function(){
		location.href="/board/list.jsp";
	});
});

function edit(){
	$("form").attr({
		"action":"/board/edit.jsp",
		"method":"post"
	});
	$("form").submit();
}
function del(){
	$("form").attr({
		"action":"/board/del.jsp",
		"method":"post"
	});
	$("form").submit();
}

</script>
</head>
<body>

<h3>상세보기</h3>

<div class="container">
  <form>
  	
    <input type="hidden" name="board_id" value="<%=board.getBoard_id()%>">
    <input type="text" name="title" 		value="<%=board.getTitle()%>">
    <input type="text" name="writer" 		value="<%=board.getWriter()%>">
    <textarea 			   name="content" 	style="height:200px"><%=board.getContent()%></textarea>
    <input type="button" value="수정" id="bt_edit">
    <input type="button" value="삭제" id="bt_del">
    <input type="button" value="목록" id="bt_list">
  </form>
</div>

</body>
</html>

