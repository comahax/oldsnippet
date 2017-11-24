<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<link href="<%= contextPath %>/css/css_1/iframemenu.css" rel="stylesheet" type="text/css" media="all" />
<html>
	<head>		
		<title>资费管理日志查询</title>
		
<jsp:include page="/inc/acl.jsp">
<jsp:param name="PID" value="3C4E" />
</jsp:include>

<%
    String PID = "3C4E" ;
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
    String ID_11 = PID + "BT12"; 
%>
	</head>
	<body>
		<div class="table_iframe">

			<div class="iframetop">
				资费管理日志查询
			</div>

			<div class="iframemenu">

				<script language="javascript">
				    addmenuleft();
				<s:PurChk controlid="<%=ID_1%>">  addmenu("<%=contextPath%>/zifee/pcpfprodfixflog/list.jsp","产品固定费管理日志"); </s:PurChk> 
				<s:PurChk controlid="<%=ID_2%>">  addmenu("<%=contextPath%>/zifee/fixfeedisclog/list.jsp","固定费优惠日志"); </s:PurChk> 
				<s:PurChk controlid="<%=ID_3%>">  addmenu("<%=contextPath%>/zifee/yxplanlog/list.jsp","营销方案基本信息日志"); </s:PurChk> 
				<s:PurChk controlid="<%=ID_4%>">  addmenu("<%=contextPath%>/zifee/plandiscodlo/list.jsp","营销方案计费优惠代码日志"); </s:PurChk> 
				<s:PurChk controlid="<%=ID_5%>">  addmenu("<%=contextPath%>/zifee/disccodelog/list.jsp","优惠代码日志"); </s:PurChk> 
				<s:PurChk controlid="<%=ID_6%>">  addmenu("<%=contextPath%>/zifee/disckindlog/list.jsp","优惠种类设置日志"); </s:PurChk> 
				<s:PurChk controlid="<%=ID_7%>">  addmenu("<%=contextPath%>/zifee/feedisclog/list.jsp","营销方案资费优惠日志"); </s:PurChk>   
				<s:PurChk controlid="<%=ID_8%>">  addmenu("<%=contextPath%>/zifee/eboxdisclog/list.jsp","帐户预存优惠日志"); </s:PurChk> 
				
				<s:PurChk controlid="<%=ID_9%>">  addmenu("<%=contextPath%>/zifee/calcratelog/list.jsp","帐户优惠比例计算管理日志"); </s:PurChk> 
				<s:PurChk controlid="<%=ID_10%>">  addmenu("<%=contextPath%>/zifee/yxplancplog/list.jsp","营销方案复制操作日志查询"); </s:PurChk> 
				<s:PurChk controlid="<%=ID_11%>">  addmenu("<%=contextPath%>/zifee/feediscmolog/list.jsp","月底帐务优惠设置日志"); </s:PurChk> 
				addmenu("<%=contextPath%>/zifee/prodpresentlog/list.jsp","标准商品帐目抵扣管理日志");
				
				    addmenuright();
				    addmenumore();
				</script>


			</div> 

			<div class="iframewindow" id="message">
				<iframe framespacing="0" frameborder="NO" Scrolling="no"
					name="IFRM_MAIN" id="IFRM_MAIN" class="IFRM_MAIN_on" src="<%=contextPath%>/zifee/pcpfprodfixflog/list.jsp"></iframe>
			</div>

		</div>
	</body>
</html>
