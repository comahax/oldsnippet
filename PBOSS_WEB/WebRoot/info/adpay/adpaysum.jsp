<%@ page contentType="text/html;charset=GBK" pageEncoding="GBK"%>
<%@ include file="/common/jspHead.jsp"%>
<html>
<head>
<!-- 公共静态文件 -->
<%@ include file="/common/meta_allcss.jsp"%>
</head>
<body>
<form action="ajaxModify.do" method="POST" id="frmModify">
<INPUT TYPE="hidden" NAME="parameter.recids" value="">
<INPUT TYPE="hidden" NAME="parameter.disstate" value="">
</form>
<!-- 头部导航条 -->
<%@ include file="/common/include/inc_deliveryhead.jsp"%>
<!--标准内容开始-->
<div class="divspan">
<!-- 左则功能区-->
<%@ include file="/common/include/inc_menu.jsp"%>
	<div class="context">
		<div class="listmyposition">
			<span class="font_breadcrumbtitle">您现在的位置：</span><span class="font_breadcrumb">${location}</span>
		</div>
		<div class="listboxtitle">查询条件</div>
			<s:form action="ajaxQuery" method="POST" id="frmQuery">
				<div class="listboxform">
					<table border="0" width="100%">
					  <tr>
							<td class="input_label">汇总单号：</td>
							<td><input name="parameter.sumid" id="sumid" class="text_01" /></td>
							<td class="input_label">状态：</td>
							<td>
								<s:select list="sumstate" cssClass="select_2L" name="parameter.state" />
							</td>
					  </tr>
					  <tr>
							<td class="input_label">创建时间：</td>
							<td colspan="3">
								<s:textfield name="parameter.createTimeFrom" id="createTimeFrom" cssClass="text_01" >
									<s:param name="value">
										<s:date name="parameter.createTimeFrom" format="yyyy-MM-dd"/>
									</s:param>
								</s:textfield>至
								<s:textfield name="parameter.createTimeTo" cssClass="text_01" id="createTimeTo" >
									<s:param name="value">
										<s:date name="parameter.createTimeTo" format="yyyy-MM-dd"/>
									</s:param>
								</s:textfield>
							</td>
						</tr>
					  <tr>
							<td valign="top" class="input_label">&nbsp;</td>
							<td colspan="3" align="left">
								<input type="button" id="btnQuery" value="查询" class="btn_blue_75" disabled="disabled" />&nbsp;&nbsp;
								<input type="button" id="btnExport" value="导出" class="btn_blue_75" />&nbsp;&nbsp;
								<input type="reset" id="btnReset" value="重置" class="btn_blue_75" />
							</td>
					  </tr>
					</table>
				</div>
			</s:form>
		<div class="listboxlist">
			<div style="width:100%; padding-bottom:5px;" align="right">
				
			</div>
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
        <div class="reminder">垫资汇总单查询。可以对“待提交”的垫资单元格进行“提交”操作。 </div>
      </div>
			<div class="column">
      	<div class="listboxtitle">温馨提醒：</div>
        <div class="reminder">
					 <p>1，进入该功能页面时系统默认查询时间为当前月。</p>
					 <p>2，点击“汇总单号”或者“查看详情”按扭，可以打开订购资源明细页面。</p>
					 <p>3，汇总单状态为“待提交”时，可以通过“提交”按钮进行提交操作。</p>
					 <p>3，汇总单状态为“已确认”时，可以通过“支付”按钮进行支付操作。</p>
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
<script type="text/javascript" src="${ctx}/js/biz/info/adpay/adpaysum.js"></script>
<SCRIPT type="text/javascript">
<!--
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
	succeesFn:successFncn,
	queryFrom: $("#frmQuery")//查询表单
};
//-->
</SCRIPT>
</html>