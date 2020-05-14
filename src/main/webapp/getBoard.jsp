<%@page contentType="text/html; charset=EUC-KR"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>글 상세</title>
</head>
<body>
<center>
<h1>글 상세</h1>
<a href="logout.do">Log-out</a>
<hr>
<form action="updateBoard.do" method="post">
<input name="seq" type="hidden" value="${board.seq }"/>
<table border="1" cellpadding="0" cellspacing="0">
	<tr>
		<td bgcolor="orange" width="70">제목</td>
		<td align="left"><input name="title" type="text" value="${board.title }"/></td>
	</tr>
	<tr>
		<td bgcolor="orange">작성자</td>
		<td align="left"><${board.writer }</td>
	</tr>
	<tr>
		<td bgcolor="orange">내용</td>
		<td align="left"><textarea name="content" cols="40" rows="10">${board.content }</textarea></td>
	<tr>
		<td bgcolor="orange">등록일</td>
		<td align="left">${board.regDate }</td>
	</tr>
	<tr>
		<td bgcolor="orange">조회수</td>
		<td align="left">${board.cnt }</td>
	</tr>
	<tr>
		<td bgcolor="orange">업로드 파일</td>
		<td align="left">${board.uploadFileName }</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="글 수정"/>
		</td>
	</tr>
</table>
</form>
<hr>
<a href="insertBoard.jsp">글등록</a>&nbsp;&nbsp;&nbsp;
<a href="deleteBoard.do?seq=${board.seq }">글삭제</a>&nbsp;&nbsp;&nbsp;
<a href="getBoardList.do">글목록</a>&nbsp;&nbsp;

<hr>

<!-- 댓글 작성 -->
<table>
<form action="insertComment.do">
<input name="board_seq" type="hidden" value="${board.seq }"/>
<table border="1" cellpadding="0" cellspacing="0" width="700">
	<tr>
		<td bgcolor="orange">작성자</td>
		<td align="left"><textarea name="writer" cols="10" rows="1"></textarea></td>
		<td bgcolor="orange">내용</td>
		<td align="left"><textarea name="content" cols="40" rows="3"></textarea></td>
	</tr>
</table>
</form> 

<!-- 댓글 정보 -->
<c:forEach items="${commentList }" var="comment">
<tr>
	<td>${comment.writer }</td> 
	<td>${comment.content }</td>
	<td>${comment.regDate }</td>
	<td><a href="deleteComment.do?seq=${comment.seq }?board_seq=${comment.board_seq}">제거</a></td>
</tr>
</c:forEach>
</table>
</center>

</body>
</html>