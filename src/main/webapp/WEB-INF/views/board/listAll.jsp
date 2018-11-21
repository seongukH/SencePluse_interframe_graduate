<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<head>
<title>Home</title>

<!-- Bootstrap 3.3.4 -->
<link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />


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
	function test() {
		//alert("버튼클릭됨");
		self.location("/delete");
		formObj.submit();
	}
</script>

<script>
	$(document).ready(
		function() {

			$('#searchBtn').on(
				"click",
				function(event) {

					self.location = "listAll"
					+ '${pageMaker.makeQuery(1)}'
					+ "&searchType="
					+ $("select option:selected").val()
					+ "&keyword=" + $('#keywordInput').val();

				});
		});
</script>

<body>
	<h1>게시글</h1>

	<div class='box-body'>
		<select name="searchType">
			<option value="n"
				<c:out value="${criteria.searchType == null?'selected' : '' }"/>>
				---</option>

			<option value="t"
				<c:out value="${criteria.searchType == 't'?'selected' : '' }"/>>
				title</option>

			<option value="c"
				<c:out value="${criteria.searchType == 'c'?'selected' : '' }"/>>
				content</option>

			<option value="w"
				<c:out value="${criteria.searchType == 'w'?'selected' : '' }"/>>
				writer</option>

			<option value="tc"
				<c:out value="${criteria.searchType == tc?'selected' : '' }"/>>
				title or content</option>

			<option value="cw"
				<c:out value="${criteria.searchType == cw?'selected' : '' }"/>>
				content or writer</option>

			<option value="tcw"
				<c:out value="${criteria.searchType == tcw?'selected' : '' }"/>>
				title or content or writer</option>

		</select> <input type="text" name='keyword' id="keywordInput"
			value='${criteria.keyword }'>
		<button id='searchBtn' onclick="location.href='/board/listAll' ">search</button>

	</div>




	<table class="table">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>날짜</th>
			<th>조회수</th>


		</tr>

		<c:forEach items="${list}" var="BoardVO">

			<tr>
				<td>${BoardVO.bno}</td>
				<td>${BoardVO.title}</td>
				<td>${BoardVO.writer}</td>
				<td>${BoardVO.regdate}</td>
				<td>${BoardVO.viewcnt}</td>



				<td>
					<form id="form1" name="form1" method="get">
						<input type="hidden" name="uid" value="${BoardVO.bno}"> <input
							class="btn btn-primary" type="button" id="deleteBtn" value="보기"
							onclick="location.href='/board/view?bno=${BoardVO.bno}' ">
					</form>
				</td>

			</tr>


		</c:forEach>

	</table>

	<div class="text-center">
		<ul class="pagination">

			<c:if test="${pageMaker.prev }">
				<li><a href="listAll?page=${pageMaker.startPage -1 }">&laquo;</a></li>
			</c:if>

			<c:forEach begin="${pageMaker.startPage }"
				end="${pageMaker.endPage }" var="idx">
				<li
					<c:out value="${pageMaker.criteria.page == idx?'class =active' : '' }"/>>
					<a href="listAll${pageMaker.makeQuery(idx) }">${idx }</a>
				</li>

			</c:forEach>


			<c:if test="${pageMaker.next} && ${pageMaker.endPage  >0}">
				<li><a
					href="listAll?page=${pageMaker.makeQuery(pageMaker.endPage+1) }">&raquo;</a>
				</li>
			</c:if>



		</ul>
	</div>



	<button type="button" id='goBack' class="btn btn-primary"
		onclick="location.href='/' ">Go Back</button>
	<button type="button" id='register' class="btn btn-primary"
		onclick="location.href='/board/register' ">Register</button>

</body>



