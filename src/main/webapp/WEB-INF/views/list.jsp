<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html lang="en">

<head>
<style>



</style>


    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Bootstrap Admin Theme</title>

    <!-- Bootstrap Core CSS -->
<!--    <link href="../../resources/bootstrap/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

	<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/bootstrap/vendor/bootstrap/css/bootstrap.min.css">

	
	
    <!-- MetisMenu CSS -->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/bootstrap/vendor/metisMenu/metisMenu.min.css">
    <!-- Social Buttons CSS -->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/bootstrap/vendor/bootstrap-social/bootstrap-social.css">
    <!-- Custom CSS -->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/bootstrap/dist/css/sb-admin-2.css">
    <!-- Custom Fonts -->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/bootstrap/vendor/font-awesome/css/font-awesome.min.css">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

	<link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />

	
	
</head>

  <script>
  	//var formObj = $("form[role='form']");
  	function test(){
  		//alert("버튼클릭됨");
  		self.location("/delete");
  		formObj.submit();
  	}
  </script>

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">관리자 ${MemberVO.uname} 로그인.</a>
            </div>
            <!-- /.navbar-header -->

            
                    <!-- /.dropdown-tasks -->
               
                <!-- /.dropdown -->
              
            <!-- /.navbar-top-links -->

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li class="sidebar-search">
                            <div class="input-group custom-search-form">
                                <input type="text" class="form-control" placeholder="Search...">
                                <span class="input-group-btn">
                                <button class="btn btn-default" type="button">
                                    <i class="fa fa-search"></i>
                                </button>
                            </span>
                            </div>
                            <!-- /input-group -->
                        </li>
						<li>
                             <a href="#"><i class="fa fa-user fa-fw"></i>회원관리<span class="fa arrow"></span></a>
							<ul class="nav nav-second-level">
                            
								<li>
                                    <a href="/interphone2/add">신규회원 추가</a>
                                </li>
								<li>
                                    <a href="/interphone2/list">회원정보 검색</a>
                                </li>
                                <li>
                                    <a href="morris.html">회원정보 수정</a>
                                </li>
								<li>
                                    <a href="morris.html">회원정보 삭제</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> 지역별 그래프</a>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="tables.html style="height:50px;""><i class="fa fa-table fa-fw"></i>지역별 검색 </a>
                        </li>
                        
                        <li>
                            <a href="#"><i class="fa fa-files-o fa-fw"></i> Sample Pages<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="blank.html">Blank Page</a>
                                </li>
                                <li>
                                    <a href="login.html">Login Page</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>

        <div id="page-wrapper">
			<br>
			<h1>회원목록</h1>
			<br>
<div>

<form action="">
<select name='searchType'>
  <option value='' selected>-- 검색어 선택 --</option>
  <option value='userName'>이름</option>
  <option value='userGender'>성별</option>
  <option value='userHobby'>취미</option>
</select>
<input type="text" name="word" width="20">
<button id='searchBtn' class="btn btn-primary" >Search</button>


</form>
<br>
</div>

<table class="table">
	<tr>
		<th>번호</th>
		<th>이름</th>
		<th>아이디</th>
		<th>패스워드</th>
		<th>집주소</th>
	
		
			
	</tr>
	
	<c:forEach items="${list}" var ="MemberVO">
	  
	<tr>
		<td>${MemberVO.uno}</td>
		<td>${MemberVO.uname}</td>
		<td>${MemberVO.uid}</td>
		<td>${MemberVO.upw}</td>
		<td>${MemberVO.uhome}</td>
	
		
		<td>
		<form id="form1" name="form1" method="get">
		 <input type="hidden" name="uid" value="${MemberVO.uid}">
          
                <input class="btn btn-primary" type="button"
                 id="deleteBtn"value="보기" onclick="location.href='/view?userNo=${MemberVO.uno}' ">
              </form>  
          </td>		 
                
	</tr>
	
	
	</c:forEach>
	
</table>

<button type="button" id='goBack' class="btn btn-primary" onclick="location.href='/' ">Go Back</button>

		
		
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="<c:url value="../../resources/bootstrap/vendor/jquery/jquery.min.js" />">

    <!-- Bootstrap Core JavaScript -->
    <script src="<c:url value="../../resources/bootstrap/vendor/bootstrap/js/bootstrap.min.js" />">

    <!-- Metis Menu Plugin JavaScript -->
    <script src="<c:url value="../../resources/bootstrap/vendor/metisMenu/metisMenu.min.js" />">

    <!-- Morris Charts JavaScript -->
    <script src="<c:url value="../../resources/bootstrap/vendor/raphael/raphael.min.js" />">
    <script src="<c:url value="../../resources/bootstrap/vendor/morrisjs/morris.min.js" />">
    <script src="<c:url value="../../resources/bootstrap/data/morris-data.js" />">

    <!-- Custom Theme JavaScript -->
    <script src="<c:url value="../../resources/bootstrap/dist/js/sb-admin-2.js" />">
	
	
	
	
	
	
	

</body>

</html>













