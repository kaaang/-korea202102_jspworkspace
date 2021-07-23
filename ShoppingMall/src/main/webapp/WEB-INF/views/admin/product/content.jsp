  
<%@page import="com.koreait.shoppingmall.domain.Product"%>
<%@page import="com.koreait.shoppingmall.domain.TopCategoryCount"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
	Product product=(Product)request.getAttribute("product");
	List<TopCategoryCount> topList = (List)request.getAttribute("topList");
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>AdminLTE 3 | Dashboard</title>
  
  <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="/resources/admin/plugins/fontawesome-free/css/all.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
  <!-- Tempusdominus Bootstrap 4 -->
  <link rel="stylesheet" href="/resources/admin/plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css">
  <!-- iCheck -->
  <link rel="stylesheet" href="/resources/admin/plugins/icheck-bootstrap/icheck-bootstrap.min.css">
  <!-- JQVMap -->
  <link rel="stylesheet" href="/resources/admin/plugins/jqvmap/jqvmap.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="/resources/admin/dist/css/adminlte.min.css">
  <!-- overlayScrollbars -->
  <link rel="stylesheet" href="/resources/admin/plugins/overlayScrollbars/css/OverlayScrollbars.min.css">
  <!-- Daterange picker -->
  <link rel="stylesheet" href="/resources/admin/plugins/daterangepicker/daterangepicker.css">
  <!-- summernote -->
  <link rel="stylesheet" href="/resources/admin/plugins/summernote/summernote-bs4.min.css">
  

  
</head>
<body class="hold-transition sidebar-mini layout-fixed">
<div class="wrapper">

  <!-- Preloader -->
  <div class="preloader flex-column justify-content-center align-items-center">
    <img class="animation__shake" src="/resources/admin/dist/img/AdminLTELogo.png" alt="AdminLTELogo" height="60" width="60">
  </div>

  <!-- Navbar -->
	<%@ include file="../inc/top_navi.jsp" %>
  <!-- /.navbar -->

  <!-- Main Sidebar Container -->
  <%@ include file="../inc/side_navi.jsp" %>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1 class="m-0">상품 상세정보</h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">Dashboard v1</li>
            </ol>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content-header -->

    <!-- Main content -->
    <section class="content">
      <div class="container-fluid">
		<!--등록폼 시작-->
			<div class="card card-primary">
              <div class="card-header">
                <h3 class="card-title">Quick Example</h3>
              </div>
              <!-- /.card-header -->
              <!-- form start -->
              <form name="form1">
              <input type="hidden" name="product_id" value="<%=product.getProduct_id()%>">
              <input type="hidden" name="product_img" value="<%=product.getProduct_img()%>">
                <div class="card-body">
                  <div class="form-group">
                    <label for="exampleInputEmail1">상위 카테고리</label>
						<div class="form-group">
	                        <select class="form-control" name="topcategory_id">
	                        	<option value="0">카테고리 선택</option>
	                          <%for(TopCategoryCount topCategory: topList){ %>
	                          <option value="<%=topCategory.getTopcategory_id()%>" <%if(product.getSubCategory().getTopcategory_id()==topCategory.getTopcategory_id()){%>selected<%}%>  ><%=topCategory.getTop_name()%></option>
	                          <%}%>
	                        </select>
                      </div>
                    
                  </div>
                  <div class="form-group">
                    <label for="exampleInputEmail1">하위 카테고리</label>
					<div class="form-group">
                        <select class="form-control" name="subcategory_id">
                        	<option value="<%=product.getSubCategory().getSubcategory_id()%>"><%=product.getSubCategory().getSub_name() %></option>
                        </select>
                     </div>
                    
                  </div>
                  <div class="form-group">
                    <label for="exampleInputEmail1">상품명</label>
                    <input type="text" class="form-control" id="exampleInputEmail1" placeholder="Enter email" name="product_name">
                  </div>
                  <div class="form-group">
                    <label for="exampleInputPassword1">브랜드</label>
                    <input type="text" class="form-control" id="exampleInputPassword1" placeholder="Password" name="brand">
                  </div>
                  <div class="form-group">
                    <label for="exampleInputPassword1">가격</label>
                    <input type="text" class="form-control" id="exampleInputPassword1" placeholder="Password" name="price">
                  </div>
                  <div class="form-group">
                    <label for="exampleInputPassword1">상세정보</label>
                    <textarea class="form-control" placeholder="상품 상세정보" name="info"></textarea>
                  </div>
                  
                  <div class="form-group">
                    <label for="exampleInputFile">File input</label>
                    <div class="input-group">
                      <div class="custom-file">
                        <input type="file" class="custom-file-input" id="exampleInputFile" name="photo">
                        <label class="custom-file-label" for="exampleInputFile">Choose file</label>
                      </div>
                      <div class="input-group-append">
                        <span class="input-group-text">Upload</span>
                      </div>
                    </div>
                  </div>
                </div>
                <!-- /.card-body -->

                <div class="card-footer">
                  <button type="button" class="btn btn-primary" onClick="getList()">목록</button>
                  <button type="button" class="btn btn-primary" onClick="update()">수정</button>
                  <button type="button" class="btn btn-primary" onClick="del()">삭제</button>
                </div>
              </form>
            </div>		
		<!--등록폼 종료-->
      </div>
        <!-- /.container-fluid -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
  <footer class="main-footer">
    <strong>Copyright &copy; 2014-2021 <a href="https://adminlte.io">AdminLTE.io</a>.</strong>
    All rights reserved.
    <div class="float-right d-none d-sm-inline-block">
      <b>Version</b> 3.1.0
    </div>
  </footer>

  <!-- Control Sidebar -->
  <aside class="control-sidebar control-sidebar-dark">
    <!-- Control sidebar content goes here -->
  </aside>
  <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->

<!-- jQuery -->
<script src="/resources/admin/plugins/jquery/jquery.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="/resources/admin/plugins/jquery-ui/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
  $.widget.bridge('uibutton', $.ui.button)
</script>
<!-- Bootstrap 4 -->
<script src="/resources/admin/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- ChartJS -->
<script src="/resources/admin/plugins/chart.js/Chart.min.js"></script>
<!-- Sparkline -->
<script src="/resources/admin/plugins/sparklines/sparkline.js"></script>
<!-- JQVMap -->
<script src="/resources/admin/plugins/jqvmap/jquery.vmap.min.js"></script>
<script src="/resources/admin/plugins/jqvmap/maps/jquery.vmap.usa.js"></script>
<!-- jQuery Knob Chart -->
<script src="/resources/admin/plugins/jquery-knob/jquery.knob.min.js"></script>
<!-- daterangepicker -->
<script src="/resources/admin/plugins/moment/moment.min.js"></script>
<script src="/resources/admin/plugins/daterangepicker/daterangepicker.js"></script>
<!-- Tempusdominus Bootstrap 4 -->
<script src="/resources/admin/plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js"></script>
<!-- Summernote -->
<script src="/resources/admin/plugins/summernote/summernote-bs4.min.js"></script>
<!-- overlayScrollbars -->
<script src="/resources/admin/plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js"></script>
<!-- AdminLTE App -->
<script src="/resources/admin/dist/js/adminlte.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="/resources/admin/dist/js/demo.js"></script>
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<script src="/resources/admin/dist/js/pages/dashboard.js"></script>

<!-- 등록폼 관련 시작-->
<!-- jQuery -->
<script src="/resources/admin/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="/resources/admin/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- bs-custom-file-input -->
<script src="/resources/admin/plugins/bs-custom-file-input/bs-custom-file-input.min.js"></script>
<!-- AdminLTE App -->
<script src="/resources/admin/dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="/resources/admin/dist/js/demo.js"></script>
<!-- Page specific script -->
<script>
$(function () {
	bsCustomFileInput.init();
	
	$("select[name='topcategory_id']").change(function(){
		getSubList($(this).val());		
	});
});
function getSubList(topcategory_id){
	
	//비동기 방식으로 하위 카테고리를 가져오기 
	$.ajax({
		url:"/admin/category/topdetail?topcategory_id="+topcategory_id,
		type:"GET", 
		success:function(result, status, xhr){
			$("select[name='subcategory_id']").html("");//초기화
			
			var tag="";
			tag+="<option value='0'>하위 카테고리 선택</option>";
			
			for(var i=0;i<result.length;i++){
				var json = result[i];
				tag+="<option value='"+json.subcategory_id+"'>"+json.sub_name+"</option>";
			}
			
			$("select[name='subcategory_id']").append(tag);	
		}
	});
}
//상품 수정 요청
function regist(){
	$("form").attr({
		action:"",
		method:"post",
		enctype:"multipart/form-data"
	});
	$("form").submit();
}

function del(){
	if(confirm("삭제하시겠어요?")){
		$("form").attr({
			action:"/admin/product/del",
			method:"post"
		});
		$("form").submit();
	}
}
</script>
<!-- 등록폼 관련 종료 -->
</body>
</html>