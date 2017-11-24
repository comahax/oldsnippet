<%@ page language="java" contentType="text/html;charset=GBK"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ include file="/inc/listhead.inc" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<html>
  <head>    
    <title>选择地市</title>    
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
.citybutton {
	font-size: 15px;
	text-align: center;
}
</style>
	<script type="text/javascript">	
		function doChoose(key){
			//window.parent.document.getElementById("cityno").value = key;
			//window.parent.closePage();
			
			//window.returnValue = key;
			//window.close();
			
			try{
				if(window.parent.document.getElementById("cityno")!=null){//登录页面弹出框
					window.parent.document.getElementById("cityno").value = key;
					window.parent.closePage();
				}else{//登录后，主页面弹出框
					window.returnValue = key;
					window.close();
				}
			}catch(ex){
				alert(ex.message);
			}
		}
	</script>

  </head>
  
  <body background="<%=contextPath%>/images/pop_up_bg.jpg">  	
  	<table align="center" border="0" cellPadding="0">
  	<tr>
  	<s:iterator value="citymap" id="cityinfo" status="itStatus">  	
  		<td width="80" height="50" align="center">
  			<input type="hidden" id="<s:property value='key'/>" value="<s:property value='key'/>"/> 			 
  			<input type="button" class="citybutton" value='<s:property value="value"/>' 
  			onmouseover="buttonover(this);" onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
  			onClick="doChoose('<s:property value="key"/>')"/>			
  			</td>
  		<s:if test='(((#itStatus.count))%7) == 0'>
  		    </tr>
  		    <tr>
  		</s:if>
  	</s:iterator>
  	</tr>  	 
  	</table>
  </body>
</html>
