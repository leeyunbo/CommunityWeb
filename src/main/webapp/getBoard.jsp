<%@page contentType="text/html; charset=EUC-KR"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>�� ��</title>
</head>
<body>
<center>
<h1>�� ��</h1>
<a href="logout.do">Log-out</a>
<hr>
<form action="updateBoard.do" method="post">
<input name="seq" type="hidden" value="${board.seq }"/>
<table border="1" cellpadding="0" cellspacing="0">
	<tr>
		<td bgcolor="orange" width="70">����</td>
		<td align="left"><input name="title" type="text" value="${board.title }"/></td>
	</tr>
	<tr>
		<td bgcolor="orange">�ۼ���</td>
		<td align="left"><${board.writer }</td>
	</tr>
	<tr>
		<td bgcolor="orange">����</td>
		<td align="left"><textarea name="content" cols="40" rows="10">${board.content }</textarea></td>
	<tr>
		<td bgcolor="orange">�����</td>
		<td align="left">${board.regDate }</td>
	</tr>
	<tr>
		<td bgcolor="orange">��ȸ��</td>
		<td align="left">${board.cnt }</td>
	</tr>
	<tr>
		<td bgcolor="orange">���ε� ����</td>
		<td align="left">${board.uploadFileName }</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="�� ����"/>
		</td>
	</tr>
</table>
</form>
<hr>
<a href="insertBoard.jsp">�۵��</a>&nbsp;&nbsp;&nbsp;
<a href="deleteBoard.do?seq=${board.seq }">�ۻ���</a>&nbsp;&nbsp;&nbsp;
<a href="getBoardList.do">�۸��</a>&nbsp;&nbsp;

<hr>

<!-- ��� �ۼ� -->
<table>
<form action="insertComment.do">
<input name="board_seq" type="hidden" value="${board.seq }"/>
<table border="1" cellpadding="0" cellspacing="0" width="700">
	<tr>
		<td bgcolor="orange">�ۼ���</td>
		<td align="left"><textarea name="writer" cols="10" rows="1"></textarea></td>
		<td bgcolor="orange">����</td>
		<td align="left"><textarea name="content" cols="40" rows="3"></textarea></td>
	</tr>
</table>
</form> 

<!-- ��� ���� -->
<c:forEach items="${commentList }" var="comment">
<tr>
	<td>${comment.writer }</td> 
	<td>${comment.content }</td>
	<td>${comment.regDate }</td>
	<td><a href="deleteComment.do?seq=${comment.seq }?board_seq=${comment.board_seq}">����</a></td>
</tr>
</c:forEach>
</table>
</center>

</body>
</html>