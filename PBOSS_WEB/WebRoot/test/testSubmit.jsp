<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<title>Index</title>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
		<style type="text/css">
			body {text-align: center;}
			.input {width: 98%;}
			p {margin: 0; text-align: right;}
		</style>
	</head>

	<body>
		<s:form theme="simple" method="post" action="/user/Register.do">
			<table border="1" width="300px">
				<caption>Login</caption>
				<tbody>
					<tr>
						<td width="80px">username:</td>
						<td><s:textfield name="user.username" accesskey="u" cssClass="input" /></td>
					</tr>
					<tr>
						<td>password:</td>
						<td><s:password name="user.password" accesskey="p" cssClass="input" /></td>
					</tr>
					<tr>
						<td>description:</td>
						<td><s:textarea name="user.description" accesskey="d" /></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><s:submit accesskey="s" label="Submit" /></td>
					</tr>
				</tbody>
			</table>
		</s:form>
		<p style="width: 300px;"><a href="/index.jsp">Login</a></p>
	</body>
</html>
