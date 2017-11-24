<%@ page language="java" pageEncoding="GBK" contentType="text/html; charset=GBK"%>
<%@include file="/common/jspHead.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<title><s:property value="title" /></title>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
		<style type="text/css">
			body {text-align: center;}
			.input {width: 98%;}
			p {margin: 0; text-align: right;}
		</style>
	</head>

	<body>
		提交成功,${param.txtTest}!<br>
		<INPUT TYPE="button" VALUE="关闭" ONCLICK="window.parent.closePage();">
	</body>
</html>
