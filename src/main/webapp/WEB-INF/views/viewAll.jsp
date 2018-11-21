<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<head>
	<title>Home</title>
	
 <!-- Bootstrap 3.3.4 -->
 <!--     <link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
 -->


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
	종합 화면	
	

</h1>
 <!-- <img src="http://14.63.164.14:8080/interphone2/image/displayFile?filename=/106b00dc-399d-44d8-b4cd-9c5e3048833c_TARO-광고-이미지_판매대리점-추가.jpg"></img>
  -->
  linux
<audio controls>
    <source src="http://14.63.164.14:8080/interphone2/tts/sendSpeech/image/1" type="audio/mpeg">
  
Your browser does not support the audio element.
</audio>

window
<audio controls>
    <source src="http://localhost:18080/interphone2/tts/sendSpeech/image/1" type="audio/mpeg">
  
Your browser does not support the audio element.
</audio>

<div>
	
</div>
	<iframe src="../displayTextFile"></iframe>
<img src="../displayTextFile"></img>
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
		<th>집</th>
		<th>파일이름</th>	
		<th>이미지</th>			
	</tr>
	
	<c:forEach items="${ImageVO}" var ="ImageVO">
	  
	  
	<tr>
		<td>${ImageVO.uhome}</td>
		<td>${ImageVO.imageName}</td>
		<td>
			<c:catch var="e">
 			<c:import url="/img/nhnent_${pngNum}.png" var="imgSrc"/> 
 			</c:catch> 
 
 		<c:choose> 
 			<c:when test="${empty e}"> 
 				<img src="../image/displayFile?filename=/${ImageVO.imageName}"> 
 			</c:when> 
 			<c:otherwise> 
 				<img src="/img/nhnent_1.png">
 			 </c:otherwise>
 		 </c:choose>		
		</td>
	
                
	</tr>
	
	
	</c:forEach>
	
</table>

<table class="table">
	<tr>
		<th>집</th>
		<th>온도</th>	
		<th>습도</th>		
		<th>미세먼지</th>
		<th>시간</th>	
	</tr>
	
	<c:forEach items="${AirVO}" var ="AirVO">
	  
	  
	<tr>
		<td>${AirVO.uhome}</td>
		<td>${AirVO.temp}</td>
		<td>${AirVO.humid}</td>
		<td>${AirVO.dust}</td>
		<td>${AirVO.time}</td>
		
	
                
	</tr>
	
	
	</c:forEach>
	
</table>



<button type="button" id='goBack' class="btn btn-primary" onclick="location.href='/interphone2' ">Go Back</button>
</body>



