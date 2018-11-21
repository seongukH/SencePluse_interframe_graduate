<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    
<html>
<head>

 <!-- Bootstrap 3.3.4 -->
    <link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    
    
	<title>Home</title>
</head>
<body>

<div class="container">

<p> 해당 회원의 정보가 없습니다. <br>
	아이디/패스워드를 확인해주세요
	<input class="btn btn-primary" type="button" id="editBtn" value="확인" onclick="location.href='/interphone' ">
</p>
</div> 

</body>
</html>
