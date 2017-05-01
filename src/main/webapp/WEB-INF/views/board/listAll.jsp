<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="false" %>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
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



<script>
var result = '${msg}';
if(result=='success'){
	
	alert("ó���� �Ϸ�Ǿ����ϴ�.");
	
}

</script>

</body>
</html>