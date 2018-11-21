<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>인터폰 회원가입</title>

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

	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="login-panel panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Please Sign In</h3>
					</div>
					<div class="panel-body">
						<form role="form" method="post">

							<div class="form-group">
								<label for="inputEmail" class="sr-only">User ID</label> <input
									type="text" name="uid" id="inputEmail" class="form-control"
									placeholder="User Id" required autofocus> <label
									for="inputPassword" class="sr-only">Password</label> <input
									type="password" name="upw" id="inputPassword"
									class="form-control" placeholder="Password" required> <label
									for="inputName" class="sr-only">User Name</label> <input
									type="text" name="uname" id="inputName" class="form-control"
									placeholder="User Name" required> <label for="home"
									class="sr-only">User Home</label> <input type="text"
									name="uhome" id="inputHome" class="form-control"
									placeholder="User Home" required>
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
							<button class="btn btn-primary" type="submit">Sign Up</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- jQuery -->
	<script src="../vendor/jquery/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="../vendor/bootstrap/js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script src="../vendor/metisMenu/metisMenu.min.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="../dist/js/sb-admin-2.js"></script>

</body>

</html>
