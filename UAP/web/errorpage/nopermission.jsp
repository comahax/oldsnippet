<%@ page isErrorPage="true"%>
<%@ page contentType="text/html; charset=utf-8"%>
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
		<script type="text/javascript" src="<%= contextPath %>/js/baseframe.js"></script>
		<script type="text/javascript" src="<%= contextPath %>/js/otherwin.js"></script>
		<script type="text/javascript" src="<%= contextPath %>/js/title.js"></script>
		<script type="text/javascript" src="<%= contextPath %>/js/rightclick.js"></script>
		<script language="javascript">
			function doback() {
			  history.back();
			}
			function docontinue() {
			  top.window.location.replace("<%= contextPath %>/login.jsp");
			}
			function doclose() {
			  parent.close();
			}
		</script>
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
									<td valign=top width=60>提示信息:</td>
									<td valign=top width=480>你没有权限进行该操作</td>
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

