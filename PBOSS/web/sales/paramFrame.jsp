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
				  	addmenu('<%=contextPath%>/sales/orderuplimit_list.do','订购量上限设置');
				  	src = '<%=contextPath%>/sales/orderuplimit_list.do';
				  </j:purChk>
				  <j:purChk permid="FX_RU_CARDLIMIT">
				  	addmenu('<%=contextPath%>/sales/orderuplimit_listforcard.do','充值卡订购量设置');
				  	if(src.length==0)
				  	src = '<%=contextPath%>/sales/orderuplimit_listforcard.do';
				  </j:purChk>                                  
				  	addmenu('<%=contextPath%>/sales/orderuplimit_listforemptysimorder.do','空白卡SIM订购量设置');
				  	if(src.length==0)
				  	src = '<%=contextPath%>/sales/orderuplimit_listforemptysimorder.do';
				  <j:purChk permid="FX_RU_CHGRULE">
				  	addmenu('<%=contextPath%>/sales/monamtchgrule_list.do', '订购量浮动规则设置');
				  	if(src.length==0)
					src = '<%=contextPath%>/sales/monamtchgrule_list.do';
				  </j:purChk>
				  <j:purChk permid="FX_RU_ORDERSTD">
				  	addmenu('<%=contextPath%>/sales/orderstd_list.do','商品订购指标设置');
				  	if(src.length==0)
					src = '<%=contextPath%>/sales/orderstd_list.do';
				  </j:purChk>
				  <j:purChk permid="FX_RU_LIMITSTOCK">
				  	addmenu('<%=contextPath%>/sales/orderuplimit_liststock.do', '套卡基准库存设置');
				  	if(src.length==0)
					src = '<%=contextPath%>/sales/orderuplimit_liststock.do';
				  </j:purChk>
				  <j:purChk permid="FX_RU_ORDERUNIT">
				  	addmenu('<%=contextPath%>/sales/orderunit_list.do','商品订购基数设置');
				  	if(src.length==0)
					src = '<%=contextPath%>/sales/orderunit_list.do';
				  </j:purChk>
				  <j:purChk permid="FX_RU_ORDERUNITWEEK">
				  	addmenu('<%=contextPath%>/sales/orderunitweek_list.do', '商品订购基数设置（按星期）');
				  	if(src.length==0)
					src = '<%=contextPath%>/sales/orderunitweek_list.do';
				  </j:purChk>
				  <j:purChk permid="FX_RU_BASEAMT">
				  	addmenu('<%=contextPath%>/sales/baseorderamt_list.do', '套卡保底量设置');
				  	if(src.length==0)
					src = '<%=contextPath%>/sales/baseorderamt_list.do';
				  </j:purChk>
				  <j:purChk permid="FX_RU_COMSTATE">
				  	addmenu('<%=contextPath%>/sales/comorderstate_list.do', '商品订购状态设置');
				  	if(src.length==0)
					src = '<%=contextPath%>/sales/comorderstate_list.do';
				  </j:purChk>
				  <j:purChk permid="FX_RU_COMPRICE">
				  	addmenu('<%=contextPath%>/sales/comprice_list.do', '商品销售价格设置');
				  	if(src.length==0)
					src = '<%=contextPath%>/sales/comprice_list.do';
				  </j:purChk>
				  <j:purChk permid="FX_RU_SATRORDERTIMES">
				  	addmenu('<%=contextPath%>/sales/ordertimes_list.do?otlimitType=APPSTAR', '月订购次数设置(星级)');
				  	if(src.length==0)
					src = '<%=contextPath%>/sales/ordertimes_list.do?otlimitType=APPSTAR';
				  </j:purChk>
				  <j:purChk permid="FX_RU_WAYORDERTIMES">
				  	addmenu('<%=contextPath%>/sales/ordertimes_list.do?otlimitType=APPWAY', '月订购次数设置(渠道)');
				  	if(src.length==0)
					src = '<%=contextPath%>/sales/ordertimes_list.do?otlimitType=APPWAY';
				  </j:purChk>
				  <j:purChk permid="FX_RU_LIMITSET">
				  	addmenu('<%=contextPath%>/sales/limitset_list.do', '限量订购设置');
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
