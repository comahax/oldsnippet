<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%  String contextPath = request.getContextPath();
 %>
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
<s:form action="webfunctionitem_list.do" key="formList" cssStyle="formList" theme="simple">

<table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="100%" height="100%" align="left" valign="top">
    	<div class="dtree" >
	      <script type="text/javascript">
	          d = new dTree("d");                 
	           <s:iterator value="dp.datas">
	             d.add("<s:property value='funcid' />","<s:property value='parentid' />","<s:property value='funcname' />", 
		             //"javascript:setlocation('<s:property value="funcname" />','<%=contextPath%><s:property value="guiobject"/>','');" 
		             "javascript:setMainLocation('<%=contextPath%>/base/webfunctionitem_ListByParent.do?param._se_parentid=<s:property value="funcid" />');" 
	  	             );  //ע��˴� target������Ϊ �մ��� ��openMyURI����������target�������޷�ִ��openMyURI������
	           </s:iterator>
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
</s:form>
</body>
</html>