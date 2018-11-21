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
	게시글
</h1>

<div class="box-body">
	<div class="form-group">
		<label for="exampleInputEmail1">Title</label>
		<input type="text" name="title" class="form-control" value="${boardVO.title}" readonly="readonly">
	</div>
	
	<div class="form-group">
		<label for="exampleInputEmail1">Content</label>
		<input type="text" name="title" class="form-control" value="${boardVO.content}" readonly="readonly">
	</div>
	
	<div class="form-group">
		<label for="exampleInputEmail1">Writer</label>
		<input type="text" name="title" class="form-control" value="${boardVO.writer}" readonly="readonly">
	</div>

	<div class="box-footer">
		<div>
		<button type="submit" class="btn btn-warning" onclick="location.href='/board/modify?bno=${boardVO.bno}' ">Modify</button>
		</div>
		
		<form action="/board/remove?bno=${boardVO.bno}" method="post">
		<button type="submit" class="btn btn-danger"  >Remove</button>
		</form>
		
		<div>
		<button type="submit" class="btn btn-primary" onclick="location.href='/board/listAll' ">ListAll</button>
		</div>
	
	</div>
	
	
	
</div>


</body>




</html>


