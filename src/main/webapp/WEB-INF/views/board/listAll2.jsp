<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<head>
	<title>Home</title>
	
 <!-- Bootstrap 3.3.4 -->
    <link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />


</head>

<!--
<script>
$(document.ready(function(){
	var formObj = $("form[role='form']");
	function test(){
		formObj.attr("action", "/delete");
		formObj.submit();
	}
	
});
</script>
  -->
  
  <script>
  	//var formObj = $("form[role='form']");
  	function test(){
  		//alert("버튼클릭됨");
  		self.location("/delete");
  		formObj.submit();
  	}
  </script>

<body>




<h1>
	회원목록
</h1>



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
</div>

<table class="table">
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>날짜</th>
		<th>조회수</th>
		
			
	</tr>
	
	<c:forEach items="${list}" var ="BoardVO">
	  
	<tr>
		<td>${BoardVO.bno}</td>
		<td>${BoardVO.title}</td>
		<td>${BoardVO.writer}</td>
		<td>${BoardVO.regdate}</td>
		<td>${BoardVO.viewcnt}</td>
		
	
		
		<td>
		<form id="form1" name="form1" method="get">
		 <input type="hidden" name="uid" value="${BoardVO.bno}">
          
                <input class="btn btn-primary" type="button"
                 id="deleteBtn"value="보기" onclick="location.href='/board/view?bno=${BoardVO.bno}' ">
              </form>  
          </td>		 
                
	</tr>
	
	
	</c:forEach>
	
</table>

<button type="button" id='goBack' class="btn btn-primary" onclick="location.href='/' ">Go Back</button>
<button type="button" id='register' class="btn btn-primary" onclick="location.href='/board/register' ">Register</button>

</body>



