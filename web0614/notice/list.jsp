<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <title>Document</title>
 </head>
 <body>
   <table width= "100%" border= "1px">
      <tr>
         <th>No </th>
         <th> 제목</th>
         <th>작성자</th>
         <th>등록일</th>
         <th>조회수</th>
      </tr>
      <%for(int i=0; i<11; i++){%>
      <tr>
         <td>1</td>
         <td>안녕</td>
         <td>김진아</td>
         <td>2021-06-14</td>
         <td>1</td>
      <%}%>
      </tr>
   </table>
 </body>
</html>