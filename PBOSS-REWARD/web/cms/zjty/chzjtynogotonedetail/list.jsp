<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ include file="/inc/listhead.inc"%>
<%
    String ID_1 = "00010701";
    String ID_2 = "00010702";
    String ID_3 = "00010703";
    String ID_4 = "00010704";
%>
<html>
<head>
    <title>非全球通基础酬金明细</title>
    <script language="JavaScript" type="text/JavaScript">
        function ev_check() {
            addfield('_se_rewardreporttime', '月份', 'c', false, '14');
            return checkval(window);
        }
        
        function doExport(url){
			formList.action = contextPath + url + "?CMD=EXCEL";
  			formList.submit();
  			formList.action="<%=contextPath%>/cms/zjty/chzjtynogotonedetail.do?CMD=LIST";
		}
		
		function doDele(url) {
			ev_check();
			var month = document.getElementById("_se_rewardreporttime").value;
			var msg = "确定要删除" + month + "月的记录吗？"
			if (!confirm(msg)) {
				return false;
			}
			formList.action = contextPath + url + "?CMD=DELETE";
  			formList.submit();
  			formList.action="<%=contextPath%>/cms/zjty/chzjtynogotonedetail.do?CMD=LIST";
		}
    </script>
</head>

<body onload="if(window.loadforiframe) loadforiframe();">
<div class="table_container">
<html:form action="/cms/zjty/chzjtynogotonedetail.do?CMD=LIST" styleId="formList" method="post" onsubmit="return ev_check();">
    <html:hidden property="_orderby"/>
    <html:hidden property="_desc"/>
    <html:hidden property="_pageno"/>
    <html:hidden property="_pagesize" value="20"/>
    <input type="hidden" name="query" value="true">
    <input type="hidden" name="_rowcount" value="<c:out value='${requestScope.LIST.rowCount}' />">
    <c:set var="form" scope="request" value="${requestScope['/cms/zjty/chzjtynogotonedetail/ChzjtynogotonedetailForm']}"/>

    <!--##################################添加标题内容##################################################-->
    <div class="table_div">
    <table class="top_table">
    	<tr>
    		<td>非全球通基础酬金明细</td>
    	</tr>
    </table>
    </div>
    <div class="table_div">	
   		 <table width="100%" class="error_text">
    		<html:errors/><s:Msg />
    	</table>
    </div>
	<div class="table_div">
        <table class="form_table">
            <tr>
                <td width="20%" height="20" align="right" class="form_table_right" >月份:</td>
                <td width="30%" class="form_table_left">
                    <html:text styleClass="form_input_1x" property="_se_rewardreporttime" onclick="WdatePicker({dateFmt:'yyyyMM', maxDate:'%y {%M}'})"></html:text>
                </td>
                <td width="20%" height="20" align="right" class="form_table_right" ><c:if test="${protoken}">地市:</c:if></td>
                <td width="30%" class="form_table_left">
                    <c:if test="${protoken}">
                    	<html:select property="_sk_city">
							<s:Options definition="#CITYNAME_ZH_CN"/>
						</html:select>
                    </c:if>
                </td>
            </tr>
        </table>
    </div>
	<div class="table_div">
		<table class="table_button_list">
			<tr> 
                <td align=right>
                    <input type="button" class="query" onmouseover="buttonover(this);" onclick="doQuery();"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<bean:message bundle="public" key="button_search"/>" />
                    <input type="button" class="button_4" onmouseover="buttonover(this);" 
            			onclick="doExport('/cms/zjty/chzjtynogotonedetail.do')" 
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<bean:message bundle="public" key="button_export_excel"/>" />
                    <c:if test="${!protoken}">
                    <input type="button" name="btnDelete" class="delete" onmouseover="buttonover(this);"
                        onmouseout="buttonout(this);" onfocus="buttonover(this)" onblur="buttonout(this)"
                        value="<bean:message bundle="public" key="button_delete"/>" 
                        onClick="doDele('/cms/zjty/chzjtynogotonedetail.do')">
                    </c:if>
                </td>
			</tr>
		</table>
	</div>

    <div class="table_div">
      <div class="table_LongTable">
        <table class="table_style" ID="Table2">
            <tr class="table_style_head">
	    		<td rowspan="4">合作商</td>
				<td rowspan="4">地市</td>
				<td rowspan="4">营业厅名称</td>
				<td rowspan="4">月份</td>
				<td colspan="5">套卡销售</td>
				<td>充值业务</td>
				<td rowspan="4">（13）动感地带网聊卡</td>
				<td colspan="19">（14）定制终端销售量</td>
				<td colspan="7">综合业务</td>
				<td colspan="3">自助业务</td>
				<td>宽带业务</td>
				<td colspan="5">&nbsp;</td>
				<td colspan="5">套卡销售</td>
				<td>充值业务</td>
				<td rowspan="4">（13）动感地带网聊卡</td>
				<td colspan="19">（14）定制终端销售量</td>
				<td colspan="7">综合业务</td>
				<td colspan="3">自助业务</td>
				<td colspan="5">&nbsp;</td>
				<td>宽带业务</td>
				<td colspan="5">套卡销售</td>
				<td>充值业务</td>
				<td rowspan="4">（13）动感地带网聊卡</td>
				<td colspan="19">（14）定制终端销售量</td>
				<td colspan="7">综合业务</td>
				<td colspan="3">自助业务</td>
				<td>宽带业务</td>
				<td colspan="5">&nbsp;</td>
				<td colspan="4">四、考核系数</td>
				<td rowspan="4">全省统一基础酬金总额</td>
	    	</tr>
	    	<tr class="table_style_head">
	    		<td rowspan="3">（7）动感地带100元</td>
				<td rowspan="3">（8）动感地带55元</td>
				<td rowspan="3">（9）动感地带25元</td>
				<td rowspan="3">（10）神州行100元</td>
				<td rowspan="3">（11）神州行55元</td>
				<td rowspan="3">（12）充值总金额(含30、50、100、300元充值卡)</td>
				<td colspan="2">低于500</td>
				<td colspan="2">501-1000</td>
				<td colspan="2">1001-1500</td>
				<td colspan="2">1501-2000</td>
				<td colspan="2">2001-2500</td>
				<td colspan="2">2501-3000</td>
				<td colspan="2">3001-3500</td>
				<td colspan="2">3501-4000</td>
				<td colspan="2">4000以上</td>
				<td rowspan="3">MIFI</td>
				<td rowspan="3">（15）补换卡</td>
				<td rowspan="3">（16）停/开机</td>
				<td rowspan="3">（17）服务功能变更（服务功能变更包括中文秘书、主叫显示、 语音信箱、三方通话、呼叫限制、沟通100通讯录、会议通话、理财通等8种的新增或取消。同一号码每月只计算一次）</td>
				<td rowspan="3">（18A）套餐变更（高改低）</td>
				<td rowspan="3">（18B）套餐变更（低改高）</td>
				<td rowspan="3">（19）现金缴费金额</td>
				<td rowspan="3">（20）预存话费金额（注：定制终端营销案所产生的预存话费不计入此列）</td>
				<td rowspan="3">（21）套餐变更</td>
				<td rowspan="3">（22）服务功能变更（包括中文秘书、主叫显示、 语音信箱、三方通话、呼叫限制、沟通100通讯录、会议通话、理财通等8种的新增或取消及停/开机业务）</td>
				<td rowspan="3">（23）现金缴费金额</td>
				<td rowspan="3">家庭宽带开户</td>
				<td colspan="4">(24)欢乐在线(含商务版)</td>
				<td rowspan="3">(25)信息机套卡</td>
				<td rowspan="3">（7）动感地带100元</td>
				<td rowspan="3">（8）动感地带55元</td>
				<td rowspan="3">（9）动感地带25元</td>
				<td rowspan="3">（10）神州行100元</td>
				<td rowspan="3">（11）神州行55元</td>
				<td rowspan="3">（12）充值总金额(含30、50、100、300元充值卡)</td>
				<td colspan="2">低于500</td>
				<td colspan="2">501-1000</td>
				<td colspan="2">1001-1500</td>
				<td colspan="2">1501-2000</td>
				<td colspan="2">2001-2500</td>
				<td colspan="2">2501-3000</td>
				<td colspan="2">3001-3500</td>
				<td colspan="2">3501-4000</td>
				<td colspan="2">4000以上</td>
				<td rowspan="3">MIFI</td>
				<td rowspan="3">（15）补换卡</td>
				<td rowspan="3">（16）停/开机</td>
				<td rowspan="3">（17）服务功能变更（服务功能变更包括中文秘书、主叫显示、 语音信箱、三方通话、呼叫限制、沟通100通讯录、会议通话、理财通等8种的新增或取消。同一号码每月只计算一次）</td>
				<td rowspan="3">（18A）套餐变更（高改低）</td>
				<td rowspan="3">（18B）套餐变更（低改高）</td>
				<td rowspan="3">（19）现金缴费金额</td>
				<td rowspan="3">（20）预存话费金额（注：定制终端营销案所产生的预存话费不计入此列）</td>
				<td rowspan="3">（21）套餐变更</td>
				<td rowspan="3">（22）服务功能变更（包括中文秘书、主叫显示、 语音信箱、三方通话、呼叫限制、沟通100通讯录、会议通话、理财通等8种的新增或取消及停/开机业务）</td>
				<td rowspan="3">（23）现金缴费金额</td>
				<td colspan="4">(24)欢乐在线(含商务版)</td>
				<td rowspan="3">(25)信息机套卡</td>
				<td rowspan="3">家庭宽带开户</td>
				<td rowspan="3">（7）动感地带100元</td>
				<td rowspan="3">（8）动感地带55元</td>
				<td rowspan="3">（9）动感地带25元</td>
				<td rowspan="3">（10）神州行100元</td>
				<td rowspan="3">（11）神州行55元</td>
				<td rowspan="3">（12）充值总金额(含30、50、100、300元充值卡)</td>
				<td colspan="2">低于500</td>
				<td colspan="2">501-1000</td>
				<td colspan="2">1001-1500</td>
				<td colspan="2">1501-2000</td>
				<td colspan="2">2001-2500</td>
				<td colspan="2">2501-3000</td>
				<td colspan="2">3001-3500</td>
				<td colspan="2">3501-4000</td>
				<td colspan="2">4000以上</td>
				<td rowspan="3">MIFI</td>
				<td rowspan="3">（15）补换卡</td>
				<td rowspan="3">（16）停/开机</td>
				<td rowspan="3">（17）服务功能变更（服务功能变更包括中文秘书、主叫显示、 语音信箱、三方通话、呼叫限制、沟通100通讯录、会议通话、理财通等8种的新增或取消。同一号码每月只计算一次）</td>
				<td rowspan="3">（18A）套餐变更（高改低）</td>
				<td rowspan="3">（18B）套餐变更（低改高）</td>
				<td rowspan="3">（19）现金缴费金额</td>
				<td rowspan="3">（20）预存话费金额（注：定制终端营销案所产生的预存话费不计入此列）</td>
				<td rowspan="3">（21）套餐变更</td>
				<td rowspan="3">（22）服务功能变更（包括中文秘书、主叫显示、 语音信箱、三方通话、呼叫限制、沟通100通讯录、会议通话、理财通等8种的新增或取消及停/开机业务）</td>
				<td rowspan="3">（23）现金缴费金额</td>
				<td rowspan="3">家庭宽带开户</td>
				<td colspan="4">(24)欢乐在线(含商务版)</td>
				<td rowspan="3">(25)信息机套卡</td>
				<td rowspan="3">管理考核系数</td>
				<td rowspan="3">否决系数</td>
				<td rowspan="3">综合排名系数</td>
				<td rowspan="3">竞标系数</td>
	    	</tr>
	    	<tr class="table_style_head">
	    		<td rowspan="2">2G终端</td>
				<td rowspan="2">3G终端</td>
				<td rowspan="2">2G终端</td>
				<td rowspan="2">3G终端</td>
				<td rowspan="2">2G终端</td>
				<td rowspan="2">3G终端</td>
				<td rowspan="2">2G终端</td>
				<td rowspan="2">3G终端</td>
				<td rowspan="2">2G终端</td>
				<td rowspan="2">3G终端</td>
				<td rowspan="2">2G终端</td>
				<td rowspan="2">3G终端</td>
				<td rowspan="2">2G终端</td>
				<td rowspan="2">3G终端</td>
				<td rowspan="2">2G终端</td>
				<td rowspan="2">3G终端</td>
				<td rowspan="2">2G终端</td>
				<td rowspan="2">3G终端</td>
				<td colspan="2">5元套餐</td>
				<td colspan="2">10元套餐</td>
				<td rowspan="2">2G终端</td>
				<td rowspan="2">3G终端</td>
				<td rowspan="2">2G终端</td>
				<td rowspan="2">3G终端</td>
				<td rowspan="2">2G终端</td>
				<td rowspan="2">3G终端</td>
				<td rowspan="2">2G终端</td>
				<td rowspan="2">3G终端</td>
				<td rowspan="2">2G终端</td>
				<td rowspan="2">3G终端</td>
				<td rowspan="2">2G终端</td>
				<td rowspan="2">3G终端</td>
				<td rowspan="2">2G终端</td>
				<td rowspan="2">3G终端</td>
				<td rowspan="2">2G终端</td>
				<td rowspan="2">3G终端</td>
				<td rowspan="2">2G终端</td>
				<td rowspan="2">3G终端</td>
				<td colspan="2">5元套餐</td>
				<td colspan="2">10元套餐</td>
				<td rowspan="2">2G终端</td>
				<td rowspan="2">3G终端</td>
				<td rowspan="2">2G终端</td>
				<td rowspan="2">3G终端</td>
				<td rowspan="2">2G终端</td>
				<td rowspan="2">3G终端</td>
				<td rowspan="2">2G终端</td>
				<td rowspan="2">3G终端</td>
				<td rowspan="2">2G终端</td>
				<td rowspan="2">3G终端</td>
				<td rowspan="2">2G终端</td>
				<td rowspan="2">3G终端</td>
				<td rowspan="2">2G终端</td>
				<td rowspan="2">3G终端</td>
				<td rowspan="2">2G终端</td>
				<td rowspan="2">3G终端</td>
				<td rowspan="2">2G终端</td>
				<td rowspan="2">3G终端</td>
				<td colspan="2">5元套餐</td>
				<td colspan="2">10元套餐</td>
	    	</tr>
	        <tr class="table_style_head">
				<td>1个月后</td>
				<td>3个月后</td>
				<td>1个月后</td>
				<td>3个月后</td>
				<td>1个月后</td>
				<td>3个月后</td>
				<td>1个月后</td>
				<td>3个月后</td>
				<td>1个月后</td>
				<td>3个月后</td>
				<td>1个月后</td>
				<td>3个月后</td>
			</tr>
            <c:forEach var="item" items="${requestScope.LIST.datas}">
                 <tr class="table_style_content" align="center">
                    <td><c:out value="${item.cooperauid}"/></td>
					<td><c:out value="${item.city}"/></td>
					<td><c:out value="${item.wayname}"/></td>
					<td><c:out value="${item.rewardreporttime}"/></td>
					<td><c:out value="${item.ywlmzone100}"/></td>
					<td><c:out value="${item.ywlmzone55}"/></td>
					<td><c:out value="${item.ywlmzone25}"/></td>
					<td><c:out value="${item.ywlsz100}"/></td>
					<td><c:out value="${item.ywlsz55}"/></td>
					<td><c:out value="${item.ywlcardtotal}"/></td>
					<td><c:out value="${item.ywlmzonewl}"/></td>
					<td><c:out value="${item.ywlt52g}"/></td>
					<td><c:out value="${item.ywlt53g}"/></td>
					<td><c:out value="${item.ywlt102g}"/></td>
					<td><c:out value="${item.ywlt103g}"/></td>
					<td><c:out value="${item.ywlt152g}"/></td>
					<td><c:out value="${item.ywlt153g}"/></td>
					<td><c:out value="${item.ywlt202g}"/></td>
					<td><c:out value="${item.ywlt203g}"/></td>
					<td><c:out value="${item.ywlt252g}"/></td>
					<td><c:out value="${item.ywlt253g}"/></td>
					<td><c:out value="${item.ywlt302g}"/></td>
					<td><c:out value="${item.ywlt303g}"/></td>
					<td><c:out value="${item.ywlt352g}"/></td>
					<td><c:out value="${item.ywlt353g}"/></td>
					<td><c:out value="${item.ywlt402g}"/></td>
					<td><c:out value="${item.ywlt403g}"/></td>
					<td><c:out value="${item.ywlt502g}"/></td>
					<td><c:out value="${item.ywlt503g}"/></td>
					<td><c:out value="${item.ywlmifi}"/></td>
					<td><c:out value="${item.ywlchangecard}"/></td>
					<td><c:out value="${item.ywlopenmobile}"/></td>
					<td><c:out value="${item.ywlservicechange}"/></td>
					<td><c:out value="${item.ywlpkchanlow}"/></td>
					<td><c:out value="${item.ywlpkchanhigh}"/></td>
					<td><c:out value="${item.ywlcash}"/></td>
					<td><c:out value="${item.ywlmoneyamount}"/></td>
					<td><c:out value="${item.ywlpkchan}"/></td>
					<td><c:out value="${item.ywlzuservicechange}"/></td>
					<td><c:out value="${item.ywlcashamount}"/></td>
					<td><c:out value="${item.ywlfamilybroadband}"/></td>
					<td><c:out value="${item.ywlhlzx51}"/></td>
					<td><c:out value="${item.ywlhlzx53}"/></td>
					<td><c:out value="${item.ywlhlzx101}"/></td>
					<td><c:out value="${item.ywlhlzx103}"/></td>
					<td><c:out value="${item.ywlinfocomress}"/></td>
					<td><c:out value="${item.dwmzone100}"/></td>
					<td><c:out value="${item.dwmzone55}"/></td>
					<td><c:out value="${item.dwmzone25}"/></td>
					<td><c:out value="${item.dwsz100}"/></td>
					<td><c:out value="${item.dwsz55}"/></td>
					<td><c:out value="${item.dwcardtotal}"/></td>
					<td><c:out value="${item.dwmzonewl}"/></td>
					<td><c:out value="${item.dwt52g}"/></td>
					<td><c:out value="${item.dwt53g}"/></td>
					<td><c:out value="${item.dwt102g}"/></td>
					<td><c:out value="${item.dwt103g}"/></td>
					<td><c:out value="${item.dwt152g}"/></td>
					<td><c:out value="${item.dwt153g}"/></td>
					<td><c:out value="${item.dwt202g}"/></td>
					<td><c:out value="${item.dwt203g}"/></td>
					<td><c:out value="${item.dwt252g}"/></td>
					<td><c:out value="${item.dwt253g}"/></td>
					<td><c:out value="${item.dwt302g}"/></td>
					<td><c:out value="${item.dwt303g}"/></td>
					<td><c:out value="${item.dwt352g}"/></td>
					<td><c:out value="${item.dwt353g}"/></td>
					<td><c:out value="${item.dwt402g}"/></td>
					<td><c:out value="${item.dwt403g}"/></td>
					<td><c:out value="${item.dwt502g}"/></td>
					<td><c:out value="${item.dwt503g}"/></td>
					<td><c:out value="${item.dwmifi}"/></td>
					<td><c:out value="${item.dwchangecard}"/></td>
					<td><c:out value="${item.dwopenmobile}"/></td>
					<td><c:out value="${item.dwservicechange}"/></td>
					<td><c:out value="${item.dwpkchanlow}"/></td>
					<td><c:out value="${item.dwpkchanhigh}"/></td>
					<td><c:out value="${item.dwcash}"/></td>
					<td><c:out value="${item.dwmoneyamount}"/></td>
					<td><c:out value="${item.dwpkchan}"/></td>
					<td><c:out value="${item.dwzuservicechange}"/></td>
					<td><c:out value="${item.dwcashamount}"/></td>
					<td><c:out value="${item.dwfamilybroadband}"/></td>
					<td><c:out value="${item.dwhlzx51}"/></td>
					<td><c:out value="${item.dwhlzx53}"/></td>
					<td><c:out value="${item.dwhlzx101}"/></td>
					<td><c:out value="${item.dwhlzx103}"/></td>
					<td><c:out value="${item.dwinfocomress}"/></td>
					<td><c:out value="${item.cjtotalmzone100}"/></td>
					<td><c:out value="${item.cjtotalmzone55}"/></td>
					<td><c:out value="${item.cjtotalmzone25}"/></td>
					<td><c:out value="${item.cjtotalsz100}"/></td>
					<td><c:out value="${item.cjtotalsz55}"/></td>
					<td><c:out value="${item.cjtotalcardtotal}"/></td>
					<td><c:out value="${item.cjtotalmzonewl}"/></td>
					<td><c:out value="${item.cjtotalt52g}"/></td>
					<td><c:out value="${item.cjtotalt53g}"/></td>
					<td><c:out value="${item.cjtotalt102g}"/></td>
					<td><c:out value="${item.cjtotalt103g}"/></td>
					<td><c:out value="${item.cjtotalt152g}"/></td>
					<td><c:out value="${item.cjtotalt153g}"/></td>
					<td><c:out value="${item.cjtotalt202g}"/></td>
					<td><c:out value="${item.cjtotalt203g}"/></td>
					<td><c:out value="${item.cjtotalt252g}"/></td>
					<td><c:out value="${item.cjtotalt253g}"/></td>
					<td><c:out value="${item.cjtotalt302g}"/></td>
					<td><c:out value="${item.cjtotalt303g}"/></td>
					<td><c:out value="${item.cjtotalt352g}"/></td>
					<td><c:out value="${item.cjtotalt353g}"/></td>
					<td><c:out value="${item.cjtotalt402g}"/></td>
					<td><c:out value="${item.cjtotalt403g}"/></td>
					<td><c:out value="${item.cjtotalt502g}"/></td>
					<td><c:out value="${item.cjtotalt503g}"/></td>
					<td><c:out value="${item.cjtotalmifi}"/></td>
					<td><c:out value="${item.cjtotalchangecard}"/></td>
					<td><c:out value="${item.cjtotalopenmobile}"/></td>
					<td><c:out value="${item.cjtotalservicechange}"/></td>
					<td><c:out value="${item.cjtotalpkchanlow}"/></td>
					<td><c:out value="${item.cjtotalpkchanhigh}"/></td>
					<td><c:out value="${item.cjtotalcash}"/></td>
					<td><c:out value="${item.cjtotalmoneyamount}"/></td>
					<td><c:out value="${item.cjtotalpkchan}"/></td>
					<td><c:out value="${item.cjtotalzuservicechange}"/></td>
					<td><c:out value="${item.cjtotalcashamount}"/></td>
					<td><c:out value="${item.cjtotalfamilybroadband}"/></td>
					<td><c:out value="${item.cjtotalhlzx51}"/></td>
					<td><c:out value="${item.cjtotalhlzx53}"/></td>
					<td><c:out value="${item.cjtotalhlzx101}"/></td>
					<td><c:out value="${item.cjtotalhlzx103}"/></td>
					<td><c:out value="${item.cjtotalinfocomress}"/></td>
					<td><c:out value="${item.manageexamine}"/></td>
					<td><c:out value="${item.vetocoefficient}"/></td>
					<td><c:out value="${item.ordercoefficient}"/></td>
					<td><c:out value="${item.campaigncoefficient}"/></td>
					<td><c:out value="${item.totalreward}"/></td>
                 </tr>
             </c:forEach>
        </table>
     </div>
   </div>

   <div class="table_div">
		<s:PageNav dpName="LIST"/>
   </div>
</html:form>
</div>
</body>
</html>
