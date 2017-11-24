<%@ page isErrorPage="true"%>
<%@ page contentType="text/html; charset=GBK"%>
<%
String contextPath = request.getContextPath();
String pageId=request.getParameter("pageId");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>异常提示<%=pageId%></title>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<link href="<%= contextPath %>/css/css_1/interfacebase.css"
	rel="stylesheet" type="text/css" media="all" />
<link href="<%= contextPath %>/css/css_1/navigate.css" rel="stylesheet"
	type="text/css" media="all" />
<link href="<%= contextPath %>/css/css_1/common.css" rel="stylesheet"
	type="text/css" media="all" />
<link href="<%= contextPath %>/css/css_1/form.css" rel="stylesheet"
	type="text/css" media="all" />
<link href="<%= contextPath %>/css/css_1/button.css" rel="stylesheet"
	type="text/css" media="all" />
<link href="<%= contextPath %>/css/css_1/table.css" rel="stylesheet"
	type="text/css" media="all" />
<link href="<%= contextPath %>/css/css_1/menu.css" rel="stylesheet"
	type="text/css" media="all" />
<script type="text/javascript" src="<%= contextPath %>/js/baseframe.js"></script>
<script type="text/javascript" src="<%= contextPath %>/js/otherwin.js"></script>
<script type="text/javascript" src="<%= contextPath %>/js/title.js"></script>
<script type="text/javascript" src="<%= contextPath %>/js/rightclick.js"></script>
<script type="text/javascript" src="<%= contextPath %>/js/pub/util.js"></script>
<script language="javascript">
function doback() {
  history.back();
}
function docontinue() {
  window.location.replace("");
}
function doclose() {
  parent.close();
}
</script>
</head>
<body style="background-color:#F1F1F1;" onload="loadforiframe();">
<br/>
<br/>
<table border="0" align="center" cellpadding="0" cellspacing="0">
	<tr>
		<td height=29 background="<%= contextPath %>/images/errortitle.gif"
			class="table_error_title">操作错误 Error</td>
	</tr>
	<tr>
		<td><img src="<%= contextPath %>/images/error2.gif"></td>
	</tr>
	<tr class="table_error_content">
		<td class="table_error_content_td">
		<div>
		<table width="100%" valign="top">
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td valign="top" align="right" width="80" height="40"><img
					src="<%= contextPath %>/images/error_sign.gif"></td>
				<td valign="top" width="60">提示信息:</td>
				<td valign="top" width="480"><%= exception.getMessage() != null ? exception.getMessage() : "" %></td>
			</tr>
			<tr valign="top">
				<td valign="top" align="right" height="150"><img
					src="<%= contextPath %>/images/error_sign.gif"></td>
				<td valign="top">详细信息:</td>
				<td valign="top" width="480"><textarea readonly wrap="off"
					class="input-area" style="width:100%;" rows="10"><%
									      java.io.CharArrayWriter cw = new java.io.CharArrayWriter();
									      java.io.PrintWriter pw = new java.io.PrintWriter(cw,true);
									      exception.printStackTrace(pw);
									      out.println(cw.toString());
									      %></textarea></td>
			</tr>
		</table>
		</div>
		</td>
	</tr>
	<tr>
		<td><img src="<%= contextPath %>/images/error_bottom.gif"></td>
	</tr>
</table>
<br>
<table border="0" align="center" cellpadding="0" cellspacing="0">
	<tr>
		<td><input type="button" value="确 定" class="comfir"
			onmouseover="buttonover(this)" onmouseout="buttonout(this)"
			onfocus="buttonover(this)" onblur="buttonout(this)"
			onClick="docontinue()" id="btnConfirm"> <input type="button"
			value="返 回" class="comfir" onmouseover="buttonover(this)"
			onmouseout="buttonout(this)" onfocus="buttonover(this)"
			onblur="buttonout(this)" onClick="doback()" id="btnReturn"></td>
	</tr>
</table>
</body>
</html>

