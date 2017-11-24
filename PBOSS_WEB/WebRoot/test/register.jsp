<%@ page contentType="text/html;charset=GBK"%>
<%@ include file="/common/jspHead.jsp"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
<%@ include file="/common/include/static_p.jsp"%>
		<title>Index</title>
		<meta http-equiv="content-type" content="text/html; charset=GBK" />
		<style type="text/css">
			body {text-align: center;}
			.input {width: 98%;}
			p {margin: 0; text-align: right;}
		</style>
	</head>
	<%=request.getParameter("user.username")%>
	<body>
		<s:form name="fmFrom" id="fmFrom" method="post" action="/test/register.jsp" onsubmit="return doSubmit();">
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
						<td>mobel:</td>
						<td><s:textfield name="user.mobile" accesskey="p" cssClass="input" /></td>
					</tr>
					<tr>
						<td>description:</td>
						<td><s:textarea name="user.description" accesskey="d" /></td>
					</tr>
					<tr>
						<td colspan="2" align="center">
						<INPUT TYPE="button" VALUE="ע���¼�" ONCLICK="doTest();">
						<INPUT TYPE="submit" VALUE="�ύ">
						</td>
					</tr>
				</tbody>
			</table>
		</s:form>
		<p style="width: 300px;"><a href="/index.jsp">Login</a></p>
	</body>
<%@ include file="/common/meta_js.jsp"%>
<script type="text/javascript" src="/js/jQuery/validation/jquery.validation.js"></script>
<script type="text/javascript" src="/js/jQuery/validation/common.js"></script>
<SCRIPT LANGUAGE="JavaScript">
<!--
	var v;
	var doTest=function(){
		//���������
		var requiredSet = [
			{name:"user.username",desc:"username",typeDesc:"username����Ϊ��",type:"notNull",checkNullType:"length",checkValue:3},
			{name:"user.password",desc:"password",typeDesc:"���벻��Ϊ��",type:"notNull"},
			{name:"user.mobile",desc:"mobile",typeDesc:"mobileֻ�����ƶ����ֻ�",type:"mobile",typeCheck:true}
		]
		//setValidation(frmID,requiredSet) -- frmIDֻ��ΪForm ID��requiredSet - ����
		v = setValidation("fmFrom",requiredSet);
	}
	
	var doSubmit=function(){
		//���������
		alert('doSubmit');
		return false;
	}
	
//-->
</SCRIPT>
</html>
