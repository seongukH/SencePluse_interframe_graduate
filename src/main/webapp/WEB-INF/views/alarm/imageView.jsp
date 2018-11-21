<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<head>
	<title>Home</title>
	
 <!-- Bootstrap 3.3.4 -->
    <link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />


</head>


<body>




<h1>
	image
</h1>

${filename}
<script>
	var url = 'diaplayFile'+${filename}
	<img src = url>
</script>

<c:catch var="e">
 	<c:import url="/img/nhnent_${pngNum}.png" var="imgSrc"/> 
 </c:catch> 
 
 <c:choose> 
 	<c:when test="${empty e}"> 
 		<img src="displayFile?filename=/${filename}"> 
 	</c:when> 
 		<c:otherwise> 
 			<img src="/img/nhnent_1.png">
 	 </c:otherwise>
  </c:choose>

</body>











