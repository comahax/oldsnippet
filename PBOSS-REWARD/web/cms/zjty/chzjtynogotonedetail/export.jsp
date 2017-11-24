<%@ page language="java" contentType="text/html;charset=GBK"%>
<%@ page  import="java.text.SimpleDateFormat,java.util.Date"%>
<%@ include file="/inc/listhead.inc"%>
<%
	response.setCharacterEncoding("GBK");
	response.setHeader("pragma", "no-cache");
	response.setHeader("Cache-control", "public");
	response.setHeader("Expires", "01 Apr 1995 01:10:10 GMT");
	String fn = "attachment; filename=非全球通基础酬金明细.xls";
	response.setHeader("Content-Disposition", new String(fn.getBytes("GBK"), "ISO-8859-1"));
	response.setContentType("application/x-msdownload");
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	String nowDate = format.format(new Date());
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body>
	<table>
	 	<tr><td colspan="3">导出工号：<c:out value="${_USER.opercode}"/></td></tr>
	 	<tr><td colspan="3">导出时间：<%=nowDate%></td></tr>
 	</table>
    <table border="1" bordercolor="#A8A8A8">
    	<tr align="center">
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
    	<tr align="center">
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
    	<tr align="center">
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
        <tr align="center">
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
			<tr align="center">
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
  </body>
</html>
