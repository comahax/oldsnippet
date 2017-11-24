<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%  String contextPath = request.getContextPath();
 %>
<html>
<head>
    <title><s:text name="titleList"/></title>
    <script>
	var contextPath = "<%=contextPath%>";	
</script>
<script type="text/javascript" src="<%= contextPath %>/js/baseframe.js"></script>
<script type="text/javascript" src="<%= contextPath %>/js/dtree.js"></script>
<script type="text/javascript" src="<%= contextPath %>/js/cookies.js"></script>
<link href="<%=contextPath%>/css/dtree.css" rel="stylesheet" type="text/css">
</head>

<body leftmargin="0" topmargin="0" rightmargin="0">
<s:form action="functionitem_list.do" key="formList" cssStyle="formList" theme="simple">

<table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
    <td width="100%" height="100%" align="left" valign="top">
		  <div class="dtree">
		    <script type="text/javascript">
		      d = new dTree('d');
		      <s:iterator value="dp.datas">
		      <s:if test="#{parentid == '0'}">
			      d.add('${funcid}', -1, '${funcname}', "");
			      top.leftFrame.lefttopFrame.menuname.innerHTML='${funcname}';
		      </s:if>
		      <s:else>
		      	  d.add('${funcid}', '${parentid}', '${funcname}',
			      	<s:if test="guiobject!=null">
					  "javascript:setlocation('<s:property value="funcid"/>','<s:property value="funcname" />','<%=contextPath%><s:property value="guiobject"/>',top.maintop);" 
					</s:if>
			        <s:else>
			          ""
			        </s:else>
			  	    );
		      </s:else>
		      </s:iterator>
		      document.write(d);
		    </script>
		  </div>
	</td>
  	</tr>
</table>
</s:form>
</body>
</html>
