<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<%
String contextPath = request.getContextPath();
%>

<html>
<head>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/default.css" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<script src="<%= contextPath %>/js/style.js"></script>
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
<title>异常提示</title>
</head>
<body bgcolor="#FFFFFF" text="#000000" marginwidth="0" marginheight="0" leftmargin="0" rightmargin="0" topmargin="0" bottommargin="0">
<p>&nbsp;</p>
<table width="90%" border="0" cellspacing="5" cellpadding="4" align="center" valign="middle">
  <tr>
    <th align="center" colspan="2">系 统 错 误</th>
  </tr>
  <tr>
    <td class="row-light" rowspan="5" valign="top" width="20%" align="center"><img src="<%= request.getContextPath() %>/images/error.gif" width="75" height="76">
    </td>
    <td class="row-light">提示信息： </td>
  <tr>
    <td class="row-light"><c:out value='${requestScope.ERROR_SUMMARY}' /></td>
  </tr>
  <tr>
    <td class="row-light">详细信息： </td>
  </tr>
  <tr>
    <td class="row-light" height=200><textarea readonly wrap="off" class="input-area" style="width:100%; height:100%;">
      <c:out value='${requestScope.ERROR_DETAIL}' /></textarea></td>
  </tr>
  <tr>
    <td align=center  class="row-light"> <input type="button" onmouseover="javascript:overButton(this);" onmouseout="javascript:overOutButton(this);" class="bt" accesskey="b" onClick="doback()" value="返回（B）">
      &nbsp; <input type="button" onmouseover="javascript:overButton(this);" onmouseout="javascript:overOutButton(this);" class="bt" accesskey="c" onClick="docontinue()" value="继续（C）">
      &nbsp; <input type="button" onmouseover="javascript:overButton(this);" onmouseout="javascript:overOutButton(this);" class="bt" accesskey="x" onClick="doclose()" value="关闭（X）">
      &nbsp; </td>
  </tr>
</table>
<p>&nbsp; </p>
</body>
</html>
