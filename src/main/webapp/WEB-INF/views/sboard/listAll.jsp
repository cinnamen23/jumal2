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
<td><a href='/sboard/read${pagerMaker.makeSearch(pagerMaker.cri.page)} &bno=${boardVO.bno}'>${boardVO.title}</a></td>
<td>${boardVO.writer}</td>
<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${boardVO.regdate}"/></td>
<td><span class="badge bg-red">${boardVO.viewcnt}</span></td>

</tr>

</c:forEach>

</table>




<ul>
<c:if test="${pagerMaker.prev}">
<a href="listAll${pagerMaker.makeSearch(pagerMaker.startPage-1)}"> << </a>
</c:if>

<c:forEach begin="${pagerMaker.startPage}" end="${pagerMaker.endPage}" var="idx">
<a href="listAll${pagerMaker.makeSearch(idx)}">${idx}</a>
</c:forEach>

<c:if test="${pagerMaker.next}">
<a href="listAll${pagerMaker.makeSearch(pagerMaker.endPage+1)}">>></a>
</c:if>

</ul>
 
 <select>
  <option value="n" <c:out value="${cri.searchType==null?'selected':''}"/>>
 ----
 </option>
 <option value="t" <c:out value="${cri.searchType eq 't'?'selected':''}"/>>
제목
 </option>
 <option value="c" <c:out value="${cri.searchType eq 'c'?'selected':''}"/>>
 내용
 </option>
 <option value="w" <c:out value="${cri.searchType eq 'w'?'selected':''}"/>>
 작성자
 </option>
 <option value="tc" <c:out value="${cri.searchType eq 'tc'?'selected':''}"/>>
 제목 or 내용
 </option>
 <option value="cw" <c:out value="${cri.searchType eq 'cw'?'selected':''}"/>>
 내용 or 글쓴이
 </option>
 <option value="tcw" <c:out value="${cri.searchType eq 'tcw'?'selected':''}"/>>
 제목 or 내용 or 글쓴이
 </option>
 </select>
 
 
 
 <input type="text" name="keyword" id="keywordInput" value="${cri.keyword}">
 <button id='searchBtn'>검색</button>
 <button id="newBtn">새글등록?</button>
 
 
 
<script>
var result = '${msg}';
if(result=='success'){
	
	alert("처리가 완료되었습니다.");
	
}

</script>

<script>
$(document).ready(function(){
			
			$('#searchBtn').on("click",function(event){
				self.location="listAll"
					+'${pagerMaker.makeQuery(1)}'
					+"&searchType="
					+$("select option:selected").val()
					+"&keyword="
					+encodeURIComponent($('#keywordInput').val());
			});
			
			$('#newBtn').on("click",function(event){
				self.location="register";
			});
			
		});

</script>



</body>
</html>