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
말하기	

</h1>
 <!-- <img src="http://14.63.164.14:8080/interphone2/image/displayFile?filename=/106b00dc-399d-44d8-b4cd-9c5e3048833c_TARO-광고-이미지_판매대리점-추가.jpg"></img>
  -->
  linux
<audio controls autoplay>
    <source src="http://14.63.164.14:8080/interphone2/tts/sendSpeech/url/${text }" type="audio/mpeg">
  
Your browser does not support the audio element.
</audio>

window
<audio controls autoplay>
    <source src="http://localhost:18090/interphone2/tts/sendSpeech/url/${text }" type="audio/mpeg">
  
Your browser does not support the audio element.
</audio>

<audio id="player" autoplay loop>
    <source src="http://localhost:18080/interphone2/tts/sendSpeech/url/${text }" type="audio/mp3">
</audio> 




</body>



