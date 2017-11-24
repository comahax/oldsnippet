<%@page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page  import="com.sunrise.jop.ui.component.ThemeSelector"%>
<%
  String contextPath = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+contextPath+"/";
  String currentTheme = "default";
  currentTheme = ThemeSelector.getCurrentTheme(request);
%>
<html>
<head>
<title>广东移动统一出账平台</title>
<script type="text/javascript" src="js/base.js"></script>
<style type="text/css">
<!--
body {
	
	background-image: url("images/bg.jpg");
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
}
#Layer1 {
	position:absolute;
	left:0px;
	top:0px;
	width:162px;
	height:114px;
	z-index:1;
}
.errorMessage {
	font-size:12px;
	color:red;
}
-->
</style>
<link href="<%=contextPath%>/css/<%=currentTheme%>/peijian.css" rel="stylesheet" type="text/css">
</head>

<body scroll=no>

<s:i18n name="public">   
 <form action="login.do" method="post">
	<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
	  
	  <tr>
	    <td align="center" valign="middle"><table border="0" cellspacing="0" cellpadding="0" >
	      <tr>
	        <td class="enter_m_top"><br>&nbsp;</td>
	      </tr>
	      <tr>
	        <td class="enter_m_m" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
	          <tr>
	            <td><div class="enter_m_bid" style="align:center"><s:text name="userName"/>：<input name="user.oprcode" type="text" class="biaodan_biaodan_denter" />
	    </div></td>
	          </tr>
	          <tr>
	            <td> <div class="enter_m_bid"><s:text name="password"/>：<input name="user.password" type="password" class="biaodan_biaodan_denter" />
	    </div></td>
	          </tr>
	          <!-- 
	          <tr>
	            <td> <div class="enter_m_bid"><s:text name="cityid"/>：<input name="user.cityid" type="text" class="biaodan_biaodan_denter" />
	    </div></td>
	          </tr>
	           -->
	        </table></td>
	      </tr>     
	      
	      <tr>
	        <td class="enter_m_bo">
	        <table><tr><td style="width:75%;padding:10px 0">
	     	<label><s:actionerror/><s:actionmessage/></label></td>
	     	<td style="width:25%;padding-bottom:25px">
           	<s:i18n name="public">
		      <input type="submit" class="enter_anniu" value="<s:text name="button_login"/>" >
           	</s:i18n>
           	</td></tr></table>
	     </td>
	      </tr>
	    </table></td>
	  </tr>
	  
	</table>
  </form>
</s:i18n>
</body>
</html>
