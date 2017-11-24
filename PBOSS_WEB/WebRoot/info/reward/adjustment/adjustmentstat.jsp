<%@ page contentType="text/html;charset=GBK" pageEncoding="GBK"%>
<%@ include file="/common/jspHead.jsp"%>
<html>
<head>
<!-- 公共静态文件 -->
<%@ include file="/common/meta_allcss.jsp"%>
</head>
<body>
	<!-- 头部 -->
	<%@ include file="/common/include/inc_head.jsp"%>	
	<!--标准内容开始-->
	<div class="divspan">
			<!-- 左则功能区-->
		<%@ include file="/common/include/inc_menu.jsp"%>
        <div class="context">
			<div class="listmyposition">
				<span class="font_breadcrumbtitle">您现在的位置：</span><span class="font_breadcrumb">${location}</span>
			</div>
			
			<s:form action="/reward/adjustmentAjax.do" method="POST" id="frmQuery">
			<s:hidden name="parameter.supportPaymonth" id="supportPaymonth"></s:hidden>
	        <s:hidden name="parameter.supportFee" id="supportFee"></s:hidden>
			<div class="listboxtitle">查询条件</div>
            <table class="tb02" width="100%">
			  <tr>
				<td class="input_label" align="right">网点编码：</td>
				<td>
					${_PBOSS_WEB_USER.channel.wayid}
				</td>
				<td class="input_label" align="right">结算月份：</td>
				<td>
					<input type="text" name="parameter.rewardmonth" value="${parameter.rewardmonth}" class="style_input" maxlength="6" id="rewardmonth">
					<s:if test="!parameter.supportPaymonth"><font color='red'>*</font></s:if>(如:201109)
				</td>
			 </tr>
			 <tr> 
			    <s:if test="parameter.supportPaymonth">
				<td class="input_label" align="right">付款月份：</td>
				<td>
					<input type="text" name="parameter.paymonth" value="${parameter.paymonth}" class="style_input" maxlength="6" id="paymonth">
					(如:201109)
				</td> 
				</s:if>
				 <td colspan="4"  align="center">
						<input name="btnQuery" type="button" id="btnQuery" value="查询" class="btn_blue_75" />&nbsp;&nbsp;	
				 </td>
		 </tr>
			</table>
			</s:form>
			<div class="listboxlist">
			<div class="listboxtitle">酬金结果</div>
			<span id="showTbl"></span>
			<table class="page_table">
				<tr valign="middle">
					<td align="left" height="30">&nbsp;&nbsp;</td>
					<td align="right" style="font-size:12px;" id="navigation"></td>
				</tr>
			</table>
            <br>
            <!--帮助信息开始-->
            <div class="column">
                 <div class="listboxtitle">功能说明：</div>
                   <div class="reminder">
      				  <p>1.统计各业务<font color='red'>税后酬金</font>。</p>
    				</div>
               </div>
               <div class="column">
                 <div class="listboxtitle">温馨提醒：</div>
                    <div class="reminder">
				       <s:if test="!parameter.supportPaymonth">
				       <p>1.查询条件中<font color='red'>“结算月份”</font>必须为<font color='red'>6位有效年月，必填</font>，如201109。</p>
				       </s:if>
				       <s:else>
				       <p>1.查询条件中<font color='red'>“结算月份”、“付款月份”</font>必须为<font color='red'>6位有效年月，不能同时为空</font>，如201109。</p>
				       </s:else>
   				 </div>
               </div>
          </div>
		</div>
		<!--标准内容结束-->
	<%@ include file="/common/include/inc_foot.jsp"%>
</div>
<iframe name="content" style="display: none;"></iframe>
</body>
<%@include file="/common/meta_js.jsp"%>
<script type="text/javascript" src="${ctx}/js/jQuery/table/jquery.table.js" ></script>
<script type="text/javascript" src="${ctx}/js/biz/info/reward/adjustment/adjustmentstat.js"></script>
<SCRIPT type="text/javascript">
//<!--
// 查询显示列信息
var showCols = ${ShowCols};//取后台列设置类数组，对应如下  //dataKey,key,name,width
//表格配置数组
var optin = {
	showCols:showCols,//显示列
	fmtLink:fmtLink,//用户自定义单元格内容
	pageSize:10,//页内大小
	navigation:$("#navigation"),//翻页位置 jq对象
	unableBtu:$('#btnQuery'),
	width:"100%",
	queryFrom: $("#frmQuery")//查询表单
};
//-->
</SCRIPT>
</html>