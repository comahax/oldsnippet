<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%  String contextPath = request.getContextPath();
 %>
<html>
<head>
<title>营业管理子菜单</title>
<script>
	var contextPath = "<%=contextPath%>";	
</script>
<script type="text/javascript" src="<%= contextPath %>/js/baseframe.js"></script>
<script type="text/javascript" src="<%= contextPath %>/js/dtree.js"></script>
<script type="text/javascript" src="<%= contextPath %>/js/cookies.js"></script>
<script type="text/javascript">
	function getMenuID(menuid){
	window.dialogArguments.formItem['form.functionid'].value=menuid;
	window.close();
	}
</script>
<link href="<%=contextPath%>/css/dtree.css" rel="stylesheet" type="text/css">

</head>
<body leftmargin="0" topmargin="0" rightmargin="0">
<s:form action="functionitem_list.do" key="formList" cssStyle="formList" theme="simple">

<table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="100%" height="100%" align="left" valign="top">
    	<div class="dtree" >
	      <script type="text/javascript">
	          d = new dTree("d");                 
	           <s:iterator value="dp.datas">
	             d.add("<s:property value='funcid' />","<s:property value='parentid' />","<s:property value='funcname' />", 
		             "javascript:getMenuID('<s:property value="funcid" />');" 
	  	             );  //注意此处 target必须设为 空串， 由openMyURI方法来决定target，否则无法执行openMyURI方法。
	           </s:iterator>
			  document.write(d);
			  //openMyURI 方法在 baseframe中
	        </script>
    	</div>
    </td>
  </tr>
</table>
</s:form>
</body>
</html>