<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%
request.setCharacterEncoding("utf-8");
%>
    
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Alarm GET
</h1>

<form action="/interphone2/alarm/register" method="post" enctype = "multipart/form-data" accept-charset="UTF-8">
  
  <input type="text" name="uhome" value=${uhome} readonly>
   
   알림 이름 <input type="text" name="sname" >
  
  
  <select name="rutine">
    <option value="0">당일</option>
    <option value="1">반복</option>
    
</select>

 <select name="hour_10">
    <option value="0">0</option>
    <option value="1">1</option>
    <option value="2">2</option>    
</select>

<select name="hour_1">
    <option value="0">0</option>
    <option value="1">1</option>
    <option value="2">2</option>  
    <option value="3">3</option> 
    <option value="4">4</option>
    <option value="5">5</option>
    <option value="6">6</option>
    <option value="7">7</option>
    <option value="8">8</option>
    <option value="9">9</option>        
</select>
 : 
 <select name="minute_10">
    <option value="0">0</option>
    <option value="1">1</option>
    <option value="2">2</option>  
    <option value="3">3</option> 
    <option value="4">4</option>
    <option value="5">5</option>   
</select>

 <select name="minute_1">
    <option value="0">0</option>
    <option value="1">1</option>
    <option value="2">2</option>  
    <option value="3">3</option> 
    <option value="4">4</option>
    <option value="5">5</option>   
    <option value="6">6</option>
    <option value="7">7</option>
    <option value="8">8</option>
    <option value="9">9</option>     
</select>
  
  
  
  <input type="submit">
</form>
</body>
</html>
