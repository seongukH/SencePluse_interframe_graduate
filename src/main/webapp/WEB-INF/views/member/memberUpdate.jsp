<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
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

<title>인터폰 관리 페이지</title>

<!-- Bootstrap Core CSS -->
<!--    <link href="../../resources/bootstrap/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

	<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/bootstrap/vendor/bootstrap/css/bootstrap.min.css">



<!-- MetisMenu CSS -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/bootstrap/vendor/metisMenu/metisMenu.min.css">
<!-- Social Buttons CSS -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/bootstrap/vendor/bootstrap-social/bootstrap-social.css">
<!-- Custom CSS -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/bootstrap/dist/css/sb-admin-2.css">
<!-- Custom Fonts -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/bootstrap/vendor/font-awesome/css/font-awesome.min.css">
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top" role="navigation"
			style="margin-bottom: 0">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index.html"> ${MemberVO.uname} 님
					로그인.</a>
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
							</div> <!-- /input-group -->
						</li>
						<li><a href="#"><i class="fa fa-user fa-fw"></i>회원관리<span
								class="fa arrow"></span></a>
							<ul class="nav nav-second-level">

								<li><a href="/interphone2/alarm/register">알람 추가</a></li>
								<li><a href="/interphone2/image/register">이미지 업로드</a></li>
								<li><a href="/interphone2/graph/caller/${MemberVO.uhome}">실내온습도</a></li>
								<li><a href="/interphone2/memberUpdate">회원정보 수정</a></li>

							</ul></li>
					</ul>
				</div>
				<!-- /.sidebar-collapse -->
			</div>
			<!-- /.navbar-static-side -->
		</nav>

		<div id="page-wrapper">
			<div class="row">
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-8">

					<h1 class="page-header">회원정보 수정</h1>



					<div class="panel-body">
						<div class="row">
							<div class="col-lg-6">
								<form role="form" method="post">

									<div class="form-group">


										   유저 이름 <label for="inputName" class="sr-only">User Name</label> <input
											type="text" name="uname" id="inputName" class="form-control"
											value=${MemberVO.uname } readonly required> 
											
										집	 <label
											for="home" class="sr-only">User Home</label> <input
											type="text" name="uhome" id="inputHome" class="form-control"
											placeholder="User Home" value=${MemberVO.uhome } readonly
											required> 
											
											<label for="inputPassword" class="sr-only">Password</label>
										
										 변경할 비밀번호 <input type="password" name="upw" id="inputPassword"
											class="form-control" placeholder="Password" required>

									</div>

									<!-- 				
	id:<input type="text" name="userId"> <br>
	pw:<input type="text" name="userPw"> <br>
	name:<input type="text" name="userName"> <br>
	age:<input type="text" name="userAge"> <br>
	gender:<input type="text" name="userGender"> <br>
	email:<input type="text" name="userEmail"> <br>
	hobby:<input type="text" name="userHobby"> <br>
 -->
									<button class="btn btn-primary" type="submit">Update</button>
								</form>

							</div>
							<!-- /.col-lg-6 (nested) -->
							<!-- /.col-lg-6 (nested) -->
						</div>
						<!-- /.row (nested) -->
					</div>
					<!-- /.panel -->
					<!-- /.panel -->
					<!-- /.panel -->
				</div>

				<!-- /.col-lg-8 -->
				<!-- /.col-lg-4 -->
			</div>

			<!-- /.row -->
		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->

	<!-- jQuery -->
	<script
		src="<c:url value="../../resources/bootstrap/vendor/jquery/jquery.min.js" />">

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


