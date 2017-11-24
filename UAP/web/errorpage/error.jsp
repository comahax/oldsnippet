<%@ page isErrorPage="true"%>
<%@ page contentType="text/html; charset=GBK"%>
<%
String contextPath = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<title>异常提示</title>
		<link href="<%= contextPath %>/css/css_1/interfacebase.css" rel="stylesheet" type="text/css" media="all" />
		<link href="<%= contextPath %>/css/css_1/navigate.css" rel="stylesheet" type="text/css" media="all" />
		<link href="<%= contextPath %>/css/css_1/common.css" rel="stylesheet" type="text/css" media="all" />
		<link href="<%= contextPath %>/css/css_1/form.css" rel="stylesheet" type="text/css" media="all" />
		<link href="<%= contextPath %>/css/css_1/button.css" rel="stylesheet" type="text/css" media="all" />
		<link href="<%= contextPath %>/css/css_1/table.css" rel="stylesheet" type="text/css" media="all" />
		<link href="<%= contextPath %>/css/css_1/menu.css" rel="stylesheet" type="text/css" media="all" />
	</head>
	<body style="background-color:#F1F1F1;">
		<br/>
		<br/>
		<table border="0" align="center" cellpadding="0" cellspacing="0">
				<tr>
					<td height=29 background="<%= contextPath %>/images/errortitle.gif" class="table_error_title">系 统 错 误</td>
				</tr>
				<tr>
					<td><img src="<%= contextPath %>/images/error2.gif"></td>
				</tr>
				<tr class="table_error_content">
					<td class="table_error_content_td">
						<div>
							<table width=100% valign=top>
								<tr>
									<td>&nbsp;</td>
								</tr>
								<tr>
									<td valign=top align=right width=80 height=60><img src="<%= contextPath %>/images/error_sign.gif"></td>
									<td valign=top width=60>提示信息：</td>
									<td valign=top align=left width=480>系统内部错误，请联系管理员。</td>
								</tr>								
							</table>
						</div>
					</td>
				</tr>
				<tr>
					<td><img src="<%= contextPath %>/images/error_bottom.gif"></td>
				</tr>
		</table>
		<br/>
		<table border="0" align="center" cellpadding="0" cellspacing="0" ID="Table1">
				<tr>
					<td>&nbsp;</td>
				</tr>
		</table>
	</body>
</html>

