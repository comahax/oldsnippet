<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%@ taglib prefix="j" uri="/jop-tags" %>
<html>
	<head>
		<link href="<%=contextPath%>/css/iframemenu.css" rel="stylesheet" type="text/css" media="all" />
	</head>
	<body>

		<div class="table_container">
			

			<div class="iframemenu">
				<script language="javascript">
				  var src = "";
				  addmenuleft();	
				  <j:purChk permid="FX_RU_UPLIMIT">
				  	addmenu('<%=contextPath%>/sales/orderuplimit_list.do','��������������');
				  	src = '<%=contextPath%>/sales/orderuplimit_list.do';
				  </j:purChk>
				  <j:purChk permid="FX_RU_CARDLIMIT">
				  	addmenu('<%=contextPath%>/sales/orderuplimit_listforcard.do','��ֵ������������');
				  	if(src.length==0)
				  	src = '<%=contextPath%>/sales/orderuplimit_listforcard.do';
				  </j:purChk>                                  
				  	addmenu('<%=contextPath%>/sales/orderuplimit_listforemptysimorder.do','�հ׿�SIM����������');
				  	if(src.length==0)
				  	src = '<%=contextPath%>/sales/orderuplimit_listforemptysimorder.do';
				  <j:purChk permid="FX_RU_CHGRULE">
				  	addmenu('<%=contextPath%>/sales/monamtchgrule_list.do', '������������������');
				  	if(src.length==0)
					src = '<%=contextPath%>/sales/monamtchgrule_list.do';
				  </j:purChk>
				  <j:purChk permid="FX_RU_ORDERSTD">
				  	addmenu('<%=contextPath%>/sales/orderstd_list.do','��Ʒ����ָ������');
				  	if(src.length==0)
					src = '<%=contextPath%>/sales/orderstd_list.do';
				  </j:purChk>
				  <j:purChk permid="FX_RU_LIMITSTOCK">
				  	addmenu('<%=contextPath%>/sales/orderuplimit_liststock.do', '�׿���׼�������');
				  	if(src.length==0)
					src = '<%=contextPath%>/sales/orderuplimit_liststock.do';
				  </j:purChk>
				  <j:purChk permid="FX_RU_ORDERUNIT">
				  	addmenu('<%=contextPath%>/sales/orderunit_list.do','��Ʒ������������');
				  	if(src.length==0)
					src = '<%=contextPath%>/sales/orderunit_list.do';
				  </j:purChk>
				  <j:purChk permid="FX_RU_ORDERUNITWEEK">
				  	addmenu('<%=contextPath%>/sales/orderunitweek_list.do', '��Ʒ�����������ã������ڣ�');
				  	if(src.length==0)
					src = '<%=contextPath%>/sales/orderunitweek_list.do';
				  </j:purChk>
				  <j:purChk permid="FX_RU_BASEAMT">
				  	addmenu('<%=contextPath%>/sales/baseorderamt_list.do', '�׿�����������');
				  	if(src.length==0)
					src = '<%=contextPath%>/sales/baseorderamt_list.do';
				  </j:purChk>
				  <j:purChk permid="FX_RU_COMSTATE">
				  	addmenu('<%=contextPath%>/sales/comorderstate_list.do', '��Ʒ����״̬����');
				  	if(src.length==0)
					src = '<%=contextPath%>/sales/comorderstate_list.do';
				  </j:purChk>
				  <j:purChk permid="FX_RU_COMPRICE">
				  	addmenu('<%=contextPath%>/sales/comprice_list.do', '��Ʒ���ۼ۸�����');
				  	if(src.length==0)
					src = '<%=contextPath%>/sales/comprice_list.do';
				  </j:purChk>
				  <j:purChk permid="FX_RU_SATRORDERTIMES">
				  	addmenu('<%=contextPath%>/sales/ordertimes_list.do?otlimitType=APPSTAR', '�¶�����������(�Ǽ�)');
				  	if(src.length==0)
					src = '<%=contextPath%>/sales/ordertimes_list.do?otlimitType=APPSTAR';
				  </j:purChk>
				  <j:purChk permid="FX_RU_WAYORDERTIMES">
				  	addmenu('<%=contextPath%>/sales/ordertimes_list.do?otlimitType=APPWAY', '�¶�����������(����)');
				  	if(src.length==0)
					src = '<%=contextPath%>/sales/ordertimes_list.do?otlimitType=APPWAY';
				  </j:purChk>
				  <j:purChk permid="FX_RU_LIMITSET">
				  	addmenu('<%=contextPath%>/sales/limitset_list.do', '������������');
				  	if(src.length==0)
					src = '<%=contextPath%>/sales/limitset_list.do';
				  </j:purChk>
					addmenuright();
				  addmenumore();
				  
				  $(document).ready(function(){
				  	$("#IFRM_MAIN").attr("src",src);
				  });
				</script>
			</div>

			<div class="iframewindow" id="message">
				<iframe framespacing="0" frameborder="NO" name="IFRM_MAIN" id="IFRM_MAIN" class="IFRM_MAIN_on"
					src="" height="100%"  scrolling="auto"></iframe>
			</div>
		</div>
	</body>
</html>
