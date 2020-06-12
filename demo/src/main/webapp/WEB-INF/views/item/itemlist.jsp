<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이템</title>
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.css"  rel="stylesheet"/>
</head>
<body>
	<div class="container">
		<h4>아이템</h4>
		
		<table class="table">
			<thead>
				<tr>
		         	<th>물건번호</th>
		         	<th>물건이름</th>
		         	<th>물건내용</th>
		         	<th>물건가격</th>
		         	<th>물건수량</th>
		         	<th>물건날짜</th>
			</thead>
			
			<tbody>
			<c:forEach var="tmp" items="${list}">
				<tr>
					<td>${tmp.itemno}</td>
					<td>${tmp.itemname}</td>
					<td>${tmp.itemicontent}</td>
					<td>${tmp.itemprice}</td>
					<td>${tmp.itemqty}</td>
					<td>${tmp.itemdate}</td>
				</tr>
				</c:forEach>
			</tbody>
		
		</table>
		
		<nav aria-label="Page navigation example">
	  	<ul class="pagination">
	    <li class="page-item"><a class="page-link" href="#">Previous</a></li>
	    <c:forEach var ="i" begin="1" end="${cnt}" step="1">
	    <li class="page-item"><a class="page-link" href="/item/list?page=${i}">${i}</a></li>
	   
	    </c:forEach>
	      <li class="page-item"><a class="page-link" href="#">Next</a></li>
  </ul>
</nav>
		</div>

</body>
</html>