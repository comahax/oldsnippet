<%@ page language="java" contentType="text/html;charset=GBK"%>
<%
	String contextPath = request.getContextPath();
%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GBK">
		<title>登陆界面..</title>
	</head>
	<body onload="fun()" style=" background:url(images/Left_Menu3_Bg.jpg);">
		<br />
		<br />
		<td>
			（这个只是展示页面所以没有用到国际化，大家注意在正式页面上要用国际化的写法）
		</td>
		<br />
		<br />
		<td>
			该登陆界面用于生成一个User,并把User保存到session里面。很简单，大家点登陆就可以了。
		</td>
		<br />
		<br />
		<form action="<%=contextPath%>/login.do" method="post">
			<table>
				<tr>
					<td>
						操作员：
					</td>
					<td>
						<input type="text" maxlength="20" value="pboss" name="opercode">
					</td>
				</tr>
				<tr>
					<td>
						渠道:
					</td>
					<td>
						<input type="text" maxlength="20" value="TDZS-----" name="wayid">
					</td>
				</tr>
				<tr>
					<td>
						市标识:
					</td>
					<td>
						<input type="text" maxlength="20" value="760" name="cityid">
					</td>
				</tr>
				<tr>
					<td>
						<input type="submit" value="登陆" name="login">
						<a href="admin/logincase.do?CMD=LIST">快速登录</a>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
