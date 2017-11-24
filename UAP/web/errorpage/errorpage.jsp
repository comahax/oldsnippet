<%@ page isErrorPage="true"%>
<%@ page contentType="text/html; charset=GBK"%>
<%@ include file="/inc/head.inc" %>
<%String pageId=request.getParameter("pageId");%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<s:i18n name="public">
<title><s:text name="error_SysTem"/><%=pageId%></title>
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
<style>

</style>
</head>
<body style="background-color:#F1F1F1;" onload="loadforiframe();">
<br/>
<br/>
<table border="0" align="center" cellpadding="0" cellspacing="0" with="100%">
	<tr>
		<td height=29 background="<%= contextPath %>/images/errortitle.gif"	class="table_error_title" colspan="2">
			<s:text name="error_SysTem"/>
		</td>
	</tr>	
	<tr>	
		<td valign="top" width="80"><s:text name="error_clew_msg_1"/></td>
		<td valign="top" width="90%"><s:property value="%{exception.message}"/></td>
	</tr>
	<tr valign="top">			
		<td valign="top" width="80"><s:text name="error_detail_msg"/></td>
		<td valign="top" width="90%">
			<textarea readonly wrap="off" class="input-area" style="width:100%;" rows="30">
				<s:property value="%{exceptionStack}"/>
			</textarea>
		</td>
	</tr>	
</table>
<br>
<table border="0" align="center" cellpadding="0" cellspacing="0">
	<tr>
		<td><input type="button" value="<s:text name="button_confirm"/>" class="comfir" onmouseover="buttonover(this)" onmouseout="buttonout(this)"
			onfocus="buttonover(this)" onblur="buttonout(this)" onClick="docontinue()" id="btnConfirm"> 
			<input type="button" value="<s:text name="button_return"/>" class="comfir" onmouseover="buttonover(this)" onmouseout="buttonout(this)" 
			onfocus="buttonover(this)" onblur="buttonout(this)" onClick="doback()" id="btnReturn"></td>
	</tr>
</table>
</body>
</s:i18n>
</html>

