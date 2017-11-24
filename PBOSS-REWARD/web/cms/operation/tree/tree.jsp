<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>

<html>
<head>
<title>营业管理子菜单</title>
<script>
	var contextPath = "<%=contextPath%>";	
</script>
<script type="text/javascript" src="<%= contextPath %>/js/baseframe.js"></script>
<script type="text/javascript" src="<%= contextPath %>/js/dtree.js"></script>
<script type="text/javascript" src="<%= contextPath %>/js/cookies.js"></script>
<link href="<%=contextPath%>/css/dtree.css" rel="stylesheet" type="text/css">

</head>
<body leftmargin="0" topmargin="0" rightmargin="0">
<html:form action="/cms/operation.do?CMD=Listopntree">

<table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="100%" height="100%" align="left" valign="top">
    	<div class="dtree" >
	      <script type="text/javascript">
	          d = new dTree("d");             
	            <c:forEach var="item" items="${requestScope.LIST.datas}">
	             d.add("${item.opnid}","${item.parentid}","${item.name}", 
		             "javascript:setMainLocation('<%=contextPath%>/cms/operation.do?CMD=Listopntree&&_se_parentid=0');" 
	  	             );  //注意此处 target必须设为 空串， 由openMyURI方法来决定target，否则无法执行openMyURI方法。
	          </c:forEach>
			  document.write(d);
			  //openMyURI 方法在 baseframe中
	        </script>
	        <script>
	        	function setMainLocation(url){
	        		window.parent.mainFrame.location.href=url;
	        	}
	        	//top.leftFrame.lefttopFrame.menuname.innerHTML=document.title;        
	        </script>  
    	</div>
    </td>
  </tr>
</table>
</html:form>
</body>
</html>