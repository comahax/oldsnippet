<%@ page contentType="text/html;charset=GBK"%>
<%@ include file="/common/jspHead.jsp"%>
<html>
<head>
<!-- 公共CSS文件 -->
<%@ include file="/common/meta_allcss.jsp"%>
<style type="text/css">
<!--
body {
background-image:none;
padding-left:20px;
}
-->
</style>
</head>
<body>
	<!-- 头部导航条 -->
<div style="width:100%;text-align:left;">
<form action="ajaxOrderDtl.do" method="POST" id="frmResdetsQuery">
<input type="hidden" name="sumid" value="${adpaysum.sumid}">
</form>
				<!-- 订单基本信息 Begin-->
                 <div class="listboxtitle">垫资汇总单基本信息</div>
				<table class = "tb02" width="100%">
						<tr>
						  <td class="textRight">汇总单号：</td>
						  <td>${adpaysum.sumid}</td>
							<td class="textRight">订单金额：</td>
					        <td>${adpaysum.orderAmt}</td>
						</tr>
   						<tr>
   							<td class="textRight">退单金额：</td>
								<td width="35%" >${adpaysum.cancelAmt}</td>
					      <td width="15%"  class="textRight">应收金额：</td>
   						   <td >${adpaysum.recAmt}</td>
   						</tr>
   						<tr>
   						  <td class="textRight">提交时间：</td>
   						  <td><s:date name="adpaysum.submitTime" format="yyyy-MM-dd HH:mm" /></td>
   						  <td  class="textRight">确认人：</td>
   						  <td >${adpaysum.confirmCode}</td>
						  </tr>
   						<tr>
   						  <td class="textRight">开始时间：</td>
   						  <td><s:date name="adpaysum.beginTime" format="yyyy-MM-dd HH:mm" /></td>
   						  <td class="textRight">结束时间：</td>
   						  <td><s:date name="adpaysum.endTime" format="yyyy-MM-dd HH:mm" /></td>
				  		</tr>
   						<tr>
   						  <td class="textRight">确认时间：</td>
   						  <td><s:date name="adpaysum.confirmTime" format="yyyy-MM-dd HH:mm" /></td>
   						  <td class="textRight">确认状态：</td>
   						  <td id="stateTd">
   						  	${adpaysum.strState}
   						  	<s:if test="adpaysum.state=='WAITSUBMIT'"><input type="button" 
   						  	class="btn_blue_75" value="提交" onclick="f_submitState('${adpaysum.state }',${adpaysum.sumid})"/></s:if>
   						  	<s:if test="adpaysum.state=='CONFIRMED'"><input type="button" 
   						  	class="btn_blue_75" value="支付" onclick="f_submitState('${adpaysum.state }',${adpaysum.sumid})"/></s:if>
   						  </td>
				  		</tr>
					</table>
			<div class="listboxtitle">订购资源明细：</div>				
			<span id="showResdetsTbl"></span>
			<table class="page_table">
				<tr valign="middle">
					<td align="left" height="30">&nbsp;&nbsp;</td>
					<td align="right" style="font-size:12px;" id="resdetsNavigation"></td>
				</tr>
			</table>
				<!-- 订单基本信息 End-->
        <BR> 
				<div style="text-align:center;">
				<input type="button" class="btn_blue_75" value="关 闭" onClick="window.parent.closePage();"></div>
		</div>
</body>
<!-- 公共JS文件 -->
<%@ include file="/common/meta_js.jsp"%>
<script type="text/javascript" src="${ctx}/js/jQuery/table/jquery.table.js" ></script>
<script type="text/javascript" src="${ctx}/js/biz/info/adpay/adpaydtl.js"></script>
<script type="text/javascript">
// 订购资源明细列信息
var showResdetsCols = ${orderdtlColsString};//取后台列设置类数组，对应如下  //dataKey,key,name,width
//表格配置数组
var optin = {
	showCols:showResdetsCols,//显示列
	fmtLink:fmtLink,//用户自定义单元格内容
	pageSize:5,//页内大小
	navigation:$("#resdetsNavigation"),//翻页位置 jq对象
	width:"100%",
	queryFrom: $("#frmResdetsQuery")//查询表单
};
</script>
</html>