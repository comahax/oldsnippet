<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ page import="org.apache.commons.lang.StringUtils" %>
<%@ page import="com.sunrise.boss.ui.commons.WebConstant" %>
<%@ page import="com.sunrise.boss.delegate.cms.waytype.WaytypeDelegate" %>
<%@ page import="com.sunrise.boss.ui.commons.User"%>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/commons" prefix="s" %>
<jsp:include page="/inc/acl.jsp">
  <jsp:param name="PID" value="2B1A3CBB" />
</jsp:include>
<%
	//业务控制点标识，暂时没用上，先保留  
    String PID = "2B1A3CBB";
    String ID_1 = PID + "BT1";
    String ID_2 = PID + "BT2";
    String ID_3 = PID + "BT3";
    String ID_4 = PID + "BT4"; 
    String ID_5 = PID + "BT5"; 
    String ID_6 = PID + "BT6"; 
    String ID_7 = PID + "BT7"; 
    String ID_8 = PID + "BT8"; 
    String ID_9 = PID + "BT9";  
    String ID_10 = PID + "BT10"; 
    String ID_11 = PID + "BT11"; 
    String ID_12 = PID + "BT12";
%>
<%
	String contextPath = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName()
			+ ":" + request.getServerPort() + contextPath + "/";
%>
<html>
<head>
<base href="<%=basePath%>">
<title><bean:message bundle="Way" key="wayinfo"/></title> 
<meta http-equiv="content-type" content="text/html; charset=GBK">
<meta name="author" content="www.sunrise.com" />
<!-- css and javascript -->

<script type="text/javascript" language="javascript">
    var contextPath = "<%= contextPath %>";
</script>
 	
<link href="<%=contextPath%>/css/css_1/iframemenu.css" rel="stylesheet" type="text/css" media="all" />	
<link href="<%=contextPath%>/css/css_1/button.css" rel="stylesheet" type="text/css" media="all" />	
<link href="<%=contextPath%>/css/css_1/form.css" rel="stylesheet" type="text/css" media="all" />	
<link href="<%=contextPath%>/css/css_1/table.css" rel="stylesheet" type="text/css" media="all" />	
<script type="text/javascript" src="<%=contextPath%>/js/baseframe.js"></script>
	<script type="text/javascript" src="<%=contextPath%>/js/pub/content.js"></script>
 	
	<%	
		String parameter = request.getParameter(WebConstant.REQUEST_ATTRIBUTE_PK);
		String pWayid = request.getParameter("wayid");
		String wayid = !StringUtils.isEmpty(parameter)  ?  parameter : null;
		if(wayid ==null) wayid =!StringUtils.isEmpty(pWayid)  ?  pWayid : null ;
		
		String wayType = (String)request.getAttribute("wayType" );
    	String waySubType =  (String)request.getAttribute("waySubType");
    	
    	pageContext.setAttribute("wayid",wayid);
    	pageContext.setAttribute("wayType",wayType);
    	pageContext.setAttribute("waySubType,user",waySubType);
    	
	%>
</head>
<body>	 
	
	<div class="table_div">				
		<table class="top_table">
			<tr> 
				<td>
					<bean:message bundle="Way" key="wayinfo"/>
					
					 &nbsp; &nbsp; 
				 <bean:message bundle="Way" key="wayid"/>:<c:out value="${wayid}"/> 
				 &nbsp; &nbsp; 
				 <bean:message bundle="Way" key="waytype"/>:<s:Code2Name code="${wayType}" definition="#WAYTYPE"/> 
				 <s:Code2Name code="${waySubType,user}" definition="#WAYTYPE"/> 
				</td>
			</tr>
		</table>
	</div>
	
	<div class="table_div">	
		<table width="100%" class="error_text">
		    <html:errors/><s:Msg />
	    </table>	
    </div>
	
	<div class="table_div">
				<table class="table_button_list">
					<tr>
						<td>
						   <!--按钮的左中右位置分别为 form_table_left、form_table_center、form_table_right-->
                           <% if(wayid == null) { %> <bean:message bundle="Wayunit" key="wayidRequried"/> <% } %>
                           &nbsp;
                           <input type="button" onmouseover="buttonover(this);" onmouseout="buttonout(this);"
	                           name="btnReturn" onfocus="buttonover(this)" onblur="buttonout(this)" 
	                           value="<bean:message bundle="public" key="button_return"/>" 
	                           class="close" onclick="location.href='<%=contextPath%>/cms/way/frame.jsp';">
						</td>
				</tr>
			</table>
	</div>	
	<% 
		WaytypeDelegate delegate = new WaytypeDelegate();
		User user = (User)request.getSession().getAttribute( WebConstant.SESSION_ATTRIBUTE_USER);
		String defaultURL = "";
		
		boolean isETWay = delegate.isET(waySubType,user);
		boolean isETBranchWay = delegate.isETBranch(waySubType,user);
		
		boolean isAGWay = delegate.isAG(waySubType,user);
		boolean isAGBranchWay = delegate.isAGBranch(waySubType,user);
		
	if(wayid!=null) { %>	   
	<div class="iframemenu">
		<script language="javascript">
		addmenuleft();	
		<s:PurChk controlid="<%=ID_1%>"> 
			<%if(  isAGWay) { %>	addmenu("<%=contextPath%>/cms/wayunit.do?CMD=EDITNEW&PK=<%=wayid%>&wayid=<%=wayid%>","单位资料");  <% } %>  
		</s:PurChk>
		<s:PurChk controlid="<%=ID_2%>"> 
			<%if(  isAGBranchWay) { %>	addmenu("<%=contextPath%>/cms/wayagentbch.do?CMD=EDITNEW&PK=<%=wayid%>&wayid=<%=wayid%>","网点资料(代理渠道)");  <% } %> 
		</s:PurChk>
		<s:PurChk controlid="<%=ID_3%>"> 
			<%if(  isETBranchWay) { %>	addmenu("<%=contextPath%>/cms/wayentitybch.do?CMD=EDITNEW&PK=<%=wayid%>&wayid=<%=wayid%>","网点资料(实体渠道)");  <% } %> 
		</s:PurChk>
		
		<s:PurChk controlid="<%=ID_4%>">  
			<%if(  isAGWay || isAGBranchWay || isETBranchWay) { %>	
			addmenu("<%=contextPath%>/cms/waylicence.do?CMD=EDITNEW&PK=<%=wayid%>&wayid=<%=wayid%>","工商执照资料"); 
		<% } %> 
		</s:PurChk>
		<s:PurChk controlid="<%=ID_5%>">  
			<%if(  isAGWay) { %>	addmenu("<%=contextPath%>/cms/waycompact.do?CMD=EDITNEW&PK=<%=wayid%>&wayid=<%=wayid%>","合同协议资料");<% } %> 
		</s:PurChk>
			
			
		<s:PurChk controlid="<%=ID_6%>">  
			<%if(  isAGWay) { %>	addmenu("<%=contextPath%>/cms/agentcontact.do?CMD=EDITNEW&PK=<%=wayid%>&wayid=<%=wayid%>","联系资料(代理渠道)"); <% } %> 
		</s:PurChk>
		<s:PurChk controlid="<%=ID_7%>">  
			<%if(  isAGBranchWay || isETBranchWay) { %>	addmenu("<%=contextPath%>/cms/bchcontact.do?CMD=EDITNEW&PK=<%=wayid%>&wayid=<%=wayid%>","联系资料(渠道网点)"); <% } %> 
		</s:PurChk>
			
			
		<s:PurChk controlid="<%=ID_8%>">  
			<%if(  isAGWay || isAGBranchWay) { %>	addmenu("<%=contextPath%>/cms/wayaccount.do?CMD=LIST&_se_wayid=<%=wayid%>","账户资料"); <% } %> 
		</s:PurChk>
		<s:PurChk controlid="<%=ID_9%>">  
			<%if(  isAGWay || isAGBranchWay) { %>	addmenu("<%=contextPath%>/cms/wayguarat.do?CMD=LIST&_se_wayid=<%=wayid%>","保证金资料"); <% } %> 
		</s:PurChk>
			
		<s:PurChk controlid="<%=ID_10%>">  
			<%if(  isETBranchWay) { %>	addmenu("<%=contextPath%>/cms/wayfacility.do?CMD=LIST&_se_wayid=<%=wayid%>","自助设备资料"); <% } %> 
		</s:PurChk>
		<s:PurChk controlid="<%=ID_11%>">  
			<%if(  isETBranchWay) { %>	addmenu("<%=contextPath%>/cms/waybussarea.do?CMD=EDITNEW&PK=<%=wayid%>&wayid=<%=wayid%>","营业面积资料"); <% } %> 
		</s:PurChk>
		<s:PurChk controlid="<%=ID_12%>">  
			<%if(  isETBranchWay) { %>	addmenu("<%=contextPath%>/cms/wayseatdet.do?CMD=EDITNEW&PK=<%=wayid%>&wayid=<%=wayid%>","坐席资料"); <% } %> 
		</s:PurChk>
	
		addmenuright();
		addmenumore();
		</script>
	</div>
	
	<%
		
		if( isAGWay) {		
			defaultURL = contextPath + "/cms/wayunit.do?CMD=EDITNEW&PK=" + wayid +"&wayid=" + wayid;
			
		}else if( isETWay) {
			defaultURL = "";  //实体渠道没有资料修改,也即 实体类只有实体渠道网点;
			
		}else if( isAGBranchWay )  {
			defaultURL = contextPath + "/cms/wayagentbch.do?CMD=EDITNEW&PK=" + wayid +"&wayid=" + wayid;			
			
		}else 	if( isETBranchWay) {
			defaultURL = contextPath + "/cms/wayentitybch.do?CMD=EDITNEW&PK=" + wayid +"&wayid=" + wayid;		
		}
	%>
	
	<div class="iframewindow" id="message">
    	 <!--这里是IFRM_MAIN窗口部分，调用用该id-->
    	<s:PurChk controlid="<%=ID_1%>"> 
    		 <iframe  framespacing="0" frameborder="NO"  name="IFRM_MAIN" id="IFRM_MAIN" class="IFRM_MAIN_on"  src="<%=defaultURL%>" ></iframe>
    	</s:PurChk>	 
	</div>	
	<% } %>
</body>
</html>