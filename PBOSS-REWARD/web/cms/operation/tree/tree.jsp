<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc" %>

<html>
<head>
<title>Ӫҵ�����Ӳ˵�</title>
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
	  	             );  //ע��˴� target������Ϊ �մ��� ��openMyURI����������target�������޷�ִ��openMyURI������
	          </c:forEach>
			  document.write(d);
			  //openMyURI ������ baseframe��
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