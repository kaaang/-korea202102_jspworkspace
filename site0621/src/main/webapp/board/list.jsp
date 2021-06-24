<%@page import="site0621.board.model.domain.Board"%>
<%@page import="java.util.List"%>
<%@page import="site0621.board.model.dao.BoardDAO"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%!BoardDAO boardDAO = new BoardDAO() ;%>

<%
	List<Board> boardList = boardDAO.selectAll();
	int totalRecord=boardList.size();//총 게시물 수
	int pageSize=10;//총 게시물을 몇건씩 나누어서 보여줄지를 결정짓는 변수, 즉 페이지당 보여줄 레코드 수
	
	int totalPage=(int)Math.ceil((float)totalRecord/pageSize);//총 페이지 수
	int blockSize=10;
	
	int currentPage=1;//현재 페이지 변수
	if(request.getParameter("currentPage")!=null){
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
	}
	
	int firstPage=currentPage-((currentPage-1)%blockSize);
	int lastPage=firstPage+(blockSize-1);
	
	int num=totalRecord-(currentPage-1)*pageSize;
	
%>
<%="당신이 보고있는 페이지는"+currentPage+"<br>" %>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<style>
table {
  border-collapse: collapse;
  border-spacing: 0;
  width: 100%;
  border: 1px solid #ddd;
  position:relative;
}
th, td {
  text-align: left;
  padding: 16px;
}
tr:nth-child(even) {
  background-color: #f2f2f2;
}

/*나만의 페이지 번호 스타일 정의*/
.pageNum{
	font-weight:bold;
	font-size:20px;
	color:red;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(function(){

});
</script>
</head>
<body>

<h2>게시판 목록</h2>

<table>
	<tr>
		<th>No</th>
		<th>이미지</th>
		<th>제목</th>
		<th>작성자</th>
		<th>등록일</th>
		<th>조회수</th>
	</tr>
	<%for(int i=1;i<=pageSize;i++){ %>
	<%if(num<1)break; %>
	<tr>
		<td><%=num-- %></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
		<td></td>
	</tr>
	<%} %>
	<tr>
		<td colspan="6" style="text-align:center">
			<a href="/board/list.jsp?currentPage=<%=firstPage-1%>">◀</a>
			<%for(int i=firstPage;i<=lastPage;i++){ %>
			<%if(i>totalPage)break; %>
			<a href="/board/list.jsp?currentPage=<%=i%>" <%if(currentPage==i){ %>class="pageNum"<%} %>>[<%=i %>]</a>
			<% }%>
			<a href="/board/list.jsp?currentPage=<%=lastPage+1%>">▶</a>
		</td>
	</tr>
</table>
</body>
</html>