<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>

 <!-- Bootstrap 3.3.4 -->
    <link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    
    
	<title>Home</title>
</head>
<body>
<h1>
	회원정보 상세보기
</h1>

<div class="form-group row pull-right"></div>

<form role="form" method="post">

	<div class="form-group">
		<label for="inputEmail" class="sr-only">User ID</label>
        <input type="text" name="uid" id="inputEmail" class="form-control" placeholder=" ${MemberVO.uid }" required autofocus>
        
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" name="upw" id="inputPassword" class="form-control" placeholder=" ${MemberVO.upw }" required>
	
		<label for="inputName" class="sr-only">User Name</label>
        <input type="text" name="uname" id="inputName" class="form-control" placeholder="${MemberVO.uname }" required>
	
		
	
	<!-- 
		<label for="inputGender" class="sr-only">User Gender</label>
        <input type="text" name="userGender" id="inputGender" class="form-control" placeholder="User Gender" required>
	 -->
		
		
        <input type="text" name="umail" id="inputGender" class="form-control" placeholder="${MemberVO.umail }" required>
	
		<!-- 
		<label for="inputHobby" class="sr-only">User Hobby</label>
        <input type="text" name="userHobby" id="inputGender" class="form-control" placeholder="User Hobby" required>
	-->
		
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
	<button class="btn btn-primary" type="submit">수정</button>
</form>

</div>

</body>
</html>
