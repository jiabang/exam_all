<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>logined</title>
</head>
<body>
<% String path =this .getClass().getResource( "" ).getPath();
   System.out.println("path:"+path); %>
	<form action="${pageContext.request.contextPath}/dowloadServlet"
		method="post">
				<table border="1" cellspacing="0" cellpadding="5" align="center">
			<tr>
				<td colspan="2" align="center">hand欢迎你！！</td>
			</tr>
			<tr>
				<td>你的账号是：</td>
				<td><%=(String) request.getAttribute("name")%></td>
			</tr>
			<tr>
				<td>你的密码是:</td>
				<td><%=(String) request.getAttribute("pass")%></td>
			</tr>
			<tr>
				<td>1</td>
				<td><input type="image"
					src="${pageContext.request.contextPath}/1.jpg" /></td>
					</tr>
			<tr>
				<td>请输入图片序号：<input type="text" name="img_id"></input></td>
				<td><input type="submit" value="下载"></input></td>
			</tr>



		</table>
	</form>

</body>
</html>