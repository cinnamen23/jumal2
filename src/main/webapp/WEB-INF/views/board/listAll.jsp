<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="false" %>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<table class="table table-bordered">
<tr>
<th style="width:10px">BNO</th>
<th>TITLE</th>
<th>WRITER</th>
<th>REGDATE</th>
<th style="width:40px">VIEWCNT</th>
</tr>


<c:forEach items="${list}" var="boardVO">
<tr>
<td>${boardVO.bno}</td>
<td><a href='/board/read?bno=${boardVO.bno}'>${boardVO.title}</a></td>
<td>${boardVO.writer}</td>
<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${boardVO.regdate}"/></td>
<td><span class="badge bg-red">${boardVO.viewcnt}</span></td>

</tr>

</c:forEach>

</table>




<ul>
<c:if test="${pagerMaker.prev}">
<a href="listAll?page=${pagerMaker.startPage-1}"> << </a>
</c:if>

<c:forEach begin="${pagerMaker.startPage}" end="${pagerMaker.endPage}" var="idx">
<a href="listAll?page=${idx}">${idx}</a>
</c:forEach>

<c:if test="${pagerMaker.next}">
<a href="listAll?page=${pagerMaker.endPage+1}">>></a>
</c:if>

</ul>
 
 <select>
 
 
 </select>
 
 
 
<script>
var result = '${msg}';
if(result=='success'){
	
	alert("처리가 완료되었습니다.");
	
}

</script>

</body>
</html>