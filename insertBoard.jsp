<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<center> 
<a href="logout.do">Log-out</a>
<hr>
<form action="insertBoard.do" method="post" enctype="multipart/form-data">
<table border="1" cellpadding="0" cellspacing="0">
	<tr>
		<td bgcolor="orange" width="70">����</td>
		<td align="left"><input type="text" name="title"></td>
	</tr>
	<tr>
		<td bgcolor="orange">�ۼ���</td>
		<td align="left"><input type="text" name="writer"></td>
	</tr>
	<tr>
		<td bgcolor="orange">����</td>
		<td align="left"><textarea name="content" cols="40" rows="10"></textarea></td>
	</tr>
	<tr>
		<td bgcolor="orange" width="70">���ε�</td>
		<td align="left"><input type="file" name="uploadFile"/></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit" value="���� ���"/></td>
	</tr>
</table>
</form>
<a href="getBoardList.do">�� ��� ����</a>
</center>

</body>
</html>