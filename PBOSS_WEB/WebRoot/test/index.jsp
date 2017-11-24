<%@ page contentType="text/html; charset=UTF-8"%>
<%@include file="/common/jspHead.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<title>Index</title>
		<%@include file="/common/meta_css.jsp"%>
		<%@include file="/common/meta_js.jsp"%>
	</head>

	<body>
		<s:form theme="simple" method="post" action="/user/Login.do">
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
						<td colspan="2" align="center"><s:submit accesskey="s" label="Submit" /></td>
					</tr>
				</tbody>
			</table>
		</s:form>
		<p style="width: 300px;"><a href="${ctx}/register.jsp">Register</a></p>
	</body>
</html>
