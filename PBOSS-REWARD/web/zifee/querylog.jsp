<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<link href="<%= contextPath %>/css/css_1/iframemenu.css" rel="stylesheet" type="text/css" media="all" />
<html>
	<head>		
		<title>�ʷѹ�����־��ѯ</title>
		
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
				�ʷѹ�����־��ѯ
			</div>

			<div class="iframemenu">

				<script language="javascript">
				    addmenuleft();
				<s:PurChk controlid="<%=ID_1%>">  addmenu("<%=contextPath%>/zifee/pcpfprodfixflog/list.jsp","��Ʒ�̶��ѹ�����־"); </s:PurChk> 
				<s:PurChk controlid="<%=ID_2%>">  addmenu("<%=contextPath%>/zifee/fixfeedisclog/list.jsp","�̶����Ż���־"); </s:PurChk> 
				<s:PurChk controlid="<%=ID_3%>">  addmenu("<%=contextPath%>/zifee/yxplanlog/list.jsp","Ӫ������������Ϣ��־"); </s:PurChk> 
				<s:PurChk controlid="<%=ID_4%>">  addmenu("<%=contextPath%>/zifee/plandiscodlo/list.jsp","Ӫ�������Ʒ��Żݴ�����־"); </s:PurChk> 
				<s:PurChk controlid="<%=ID_5%>">  addmenu("<%=contextPath%>/zifee/disccodelog/list.jsp","�Żݴ�����־"); </s:PurChk> 
				<s:PurChk controlid="<%=ID_6%>">  addmenu("<%=contextPath%>/zifee/disckindlog/list.jsp","�Ż�����������־"); </s:PurChk> 
				<s:PurChk controlid="<%=ID_7%>">  addmenu("<%=contextPath%>/zifee/feedisclog/list.jsp","Ӫ�������ʷ��Ż���־"); </s:PurChk>   
				<s:PurChk controlid="<%=ID_8%>">  addmenu("<%=contextPath%>/zifee/eboxdisclog/list.jsp","�ʻ�Ԥ���Ż���־"); </s:PurChk> 
				
				<s:PurChk controlid="<%=ID_9%>">  addmenu("<%=contextPath%>/zifee/calcratelog/list.jsp","�ʻ��Żݱ������������־"); </s:PurChk> 
				<s:PurChk controlid="<%=ID_10%>">  addmenu("<%=contextPath%>/zifee/yxplancplog/list.jsp","Ӫ���������Ʋ�����־��ѯ"); </s:PurChk> 
				<s:PurChk controlid="<%=ID_11%>">  addmenu("<%=contextPath%>/zifee/feediscmolog/list.jsp","�µ������Ż�������־"); </s:PurChk> 
				addmenu("<%=contextPath%>/zifee/prodpresentlog/list.jsp","��׼��Ʒ��Ŀ�ֿ۹�����־");
				
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
