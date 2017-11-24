<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ include file="/inc/head.inc"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title><s:text name="组件库" />
		</title>
		<link href="<%=contextPath%>/up/common/css/layout.css" rel="stylesheet" type="text/css" />
		<link href="<%=contextPath%>/up/common/css/css.css" rel="stylesheet" type="text/css" />
	</head>

	
	<script type="text/javascript">

   function display(id){

      var traget=document.getElementById(id);
       if(traget.style.display=="none"){
                traget.style.display="";
       }else{
               traget.style.display="none";
    }
   }
</script>
	<body style="background: #ebf2f8;">
		<s:form name="formList" id="formList" theme="simple">
			
			<div class="widgetL">
		<div style="height:50px;">&nbsp;&nbsp;&nbsp;</div>
		&nbsp;&nbsp;&nbsp;
		<div style="float:left;">&nbsp;&nbsp;&nbsp;</div>
		<div style="width:110px; height:22px;">
<div>
<INPUT type="button" value="通过" style="width:80px;float:left;" onclick="javascript:history.go(-1);">
<img src="<%=contextPath%>/sy/images/icon.gif" onclick="display('menu')" style=" padding:8px 0 0 5px; cursor:pointer;">
</div>
<DIV id=menu style="position:absolute;display:none;;">
<INPUT type=submit  value="全部通过" style="width:80px;float:left; margin:10px 0 0 0;">

</DIV>
	</div>
		</s:form>
	</body>
</html>

