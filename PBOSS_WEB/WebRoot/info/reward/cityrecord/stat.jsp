<%@ page contentType="text/html;charset=GBK" pageEncoding="GBK"%>
<%@ include file="/common/jspHead.jsp"%>
<html>
<head>
<!-- 公共静态文件 -->
<%@ include file="/common/meta_allcss.jsp"%>
</head>
<body>
<!-- 头部导航条 -->
<%@ include file="/common/include/inc_head.jsp"%>	
<!--标准内容开始-->
<div class="divspan">
<!-- 左则功能区-->
<%@ include file="/common/include/inc_menu.jsp"%>
<div class="context">
<div class="listmyposition">
	<span class="font_breadcrumbtitle">您现在的位置：</span><span class="font_breadcrumb">${location}</span>
</div>

<s:form action="/reward/cityrecordStat.do" method="POST" id="frmQuery" onsubmit="return doSubmit();">
	<s:hidden name="parameter.supportPaymonth" id="supportPaymonth"></s:hidden>
	<div class="listboxtitle">查询条件</div>
    <table class="tb02" width="100%">
	  <tr>
		<td class="input_label" align="right">网点编码：</td>
		<td>
			${_PBOSS_WEB_USER.channel.wayid}
		</td>
		<td class="input_label" align="right">结算月份：</td>
		<td>
			<input type="text" name="parameter.month" value="${parameter.month}" class="style_input" maxlength="6" id="month">
			<s:if test="!parameter.supportPaymonth"><font color='red'>*</font></s:if>(如:201109)
		</td>
	  </tr>
	  <tr>
	  	<td class="input_label" align="right">业务发生月：</td>
	    <td>
			<input type="text" name="parameter.oprmonth" value="${parameter.oprmonth}" class="style_input" maxlength="6" id="oprmonth">
			(如:201109)
		</td>
	    <s:if test="parameter.supportPaymonth">
		<td class="input_label" align="right">付款月份：</td>
		<td>
			<input type="text" name="parameter.paymonth" value="${parameter.paymonth}" class="style_input" maxlength="6" id="paymonth">
			(如:201109)
		</td>
		</s:if>
	  </tr>
	  <tr>		
	     <td colspan="4"  align="center">
			<input type="submit" id="submit" value="查 询" class="btn_blue_75" />&nbsp;&nbsp;	
		 </td>
	</tr>
	</table>
</s:form>

<div class="column">
<font color='red'><s:actionmessage/></font>
<div class="listboxtitle">汇总明细</div>
<s:if test="retlist.size>0">
<table class = "tb_comn" width="100%">	
	<thead >
		<tr align="center">
			<td>业务类型</td>
			<td>业务归属</td>
			<td>酬金期数</td>
			<td>业务发生月</td>
			<td>办理量</td>
			<td>本期应发酬金</td>
			<td>操作</td>
			
		</tr>
	</thead>
	<s:iterator value="retlist">
       <tr align="center" >					
		<s:if test="opn1count > 0">
		<td rowspan="<s:property value="opn1count"/>"><s:property value="opn1name"/></td>
		</s:if>
		<s:if test="opn2count > 0">
		<td rowspan="<s:property value="opn2count"/>"><s:property value="opn2name"/></td>
		</s:if>
		<s:if test="rewardcount > 0">
		<td rowspan="<s:property value="rewardcount"/>"><s:property value="rewardname"/></td>
		</s:if>
		<td><s:property value="oprmonth"/></td>
		<td><s:property value="busitotal"/></td>
		<td><s:property value="paytotal"/></td>	
		<td>
		<input type="button" id="reset" value="明 细" class="btn_blue_75" 
			onclick="doShowDetail('${_PBOSS_WEB_USER.channel.wayid }','${opnid2}','${rewardtype}','${parameter.month}','${oprmonth}','${parameter.supportPaymonth}','${parameter.paymonth}');"/>
		</td>		
     </tr>
   </s:iterator>
   <tr align="center" >	
   	<td>&nbsp;</td><td >&nbsp;</td><td >&nbsp;</td><td >&nbsp;</td>
   	<td align="right">税前酬金</td>
   	<td align="left"><s:property value="paytotal"/></td>
   	<td>&nbsp;</td>
   </tr>	
</table>
</s:if>
</div>
<br>
<!--帮助信息开始-->
<div class="column">
	<div class="listboxtitle">功能说明</div>
    <div class="reminder">
        <p>1.统计各业务<font color='red'>税前酬金</font>及汇总信息。</p>
    </div>
</div>
<div class="column">
   <div class="listboxtitle">温馨提醒</div>
   <div class="reminder">
       <s:if test="!parameter.supportPaymonth">
       <p>1.查询条件中<font color='red'>“结算月份”</font>必须为<font color='red'>6位有效年月，必填</font>，如201109。</p>
       </s:if>
       <s:else>
       <p>1.查询条件中<font color='red'>“结算月份”、“付款月份”、“业务发生月”</font>必须为<font color='red'>6位有效年月，不能同时为空</font>，如201109。</p>
       </s:else>
   </div>
</div>

</div>
<!--标准内容结束-->
<%@ include file="/common/include/inc_foot.jsp"%>
</div>
</body>
<%@include file="/common/meta_js.jsp"%>
<script type="text/javascript" src="${ctx}/js/biz/info/reward/cityrecord/stat.js">
</script>
</html>