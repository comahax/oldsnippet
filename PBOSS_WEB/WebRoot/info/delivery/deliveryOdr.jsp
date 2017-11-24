<%@ page contentType="text/html;charset=GBK" pageEncoding="GBK"%>
<%@ include file="/common/jspHead.jsp"%>
<html>
<head>
<!-- 公共静态文件 -->
<%@ include file="/common/meta_allcss.jsp"%>
<jsp:useBean id="constants"  class="com.gmcc.pboss.common.dictionary.ConstantsType" />
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
					<td class="input_label">配送单号：</td>
					<td><input name="parameter.recid" class="text_01" id="recid" /></td>
					<td class="input_label">订单编号：</td>
					<td><input name="parameter.orderid" class="text_01" /></td>
					<td class="input_label">配送单状态：</td>
					<td><s:select list="disstate" cssClass="select_3L" name="parameter.disstate" id="disstate"/>&nbsp;&nbsp;
					</td>
					</tr>
				  <tr>
					<td class="input_label">创建时间&gt;=：</td>
					<td>
						<s:textfield name="parameter.startDate" id="startDate" cssClass="text_01" >
							<s:param name="value">
								<s:date name="parameter.startDate" format="yyyy-MM-dd"/>
							</s:param>
						</s:textfield>
					</td>
					<td class="input_label">创建时间&lt;=：</td>
					<td>
						<s:textfield name="parameter.endDate" id="endDate" cssClass="text_01" >
							<s:param name="value">
								<s:date name="parameter.endDate" format="yyyy-MM-dd"/>
							</s:param>
						</s:textfield>
					</td>
					<td class="input_label">缴费方式：</td>
					<td><s:select list="payType" cssClass="select_3L" name="parameter.paytype" id="disstate" />&nbsp;&nbsp;
					</td>
					</tr>
				  <tr>
					<td class="input_label">分公司：</td>
					<td><s:select list="cntyComd" cssClass="select_3L" name="parameter.cntyComd" id="disstate" />&nbsp;&nbsp;
					</td>
					<td colspan="4" align="left">
						<input name="btnQuery" type="button" id="btnQuery" value="查询" class="btn_blue_75" disabled="disabled" />&nbsp;&nbsp;
						<input name="btnExport" type="button" id="btnExport" value="导出" class="btn_blue_75" />&nbsp;&nbsp;
						<input name="btnRest" type="reset" id="btnQuery" value="重置" class="btn_blue_75" />
					</td>
				  </tr>
				</table>
			</div>
			</s:form>
			<div class="listboxlist">
			<div style="width:100%; padding-bottom:5px;" align="right">
			<input name="btnOpenDis" type="button" id="btnOpenDis" value="启动配送" class="btn_blue_75" style="width:100px;" disabled="disabled" />
			<input name="btnFinishDis" type="button" id="btnFinishDis" value="完成配送" class="btn_blue_75" style="width:100px;" disabled="disabled" /></div>
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
                   配送单查询。可以对“待配送”的配送单进行“启动配送”操作；对“配送中”的配送单进行“配送完成”操作 </div>
               </div>
               <div class="column">
                 <div class="listboxtitle">温馨提醒：</div>
                 <div class="reminder">
					 <p>1，进入该功能页面时系统默认查询时间为当前月。</p>
					 <p>2，点击“配送单号”或者“订单编号”查看订购资源明细。</p>
					 <p>3，当选择的配送单状态全是“待配送”时，可以使用“启动配送”功能。</p>
					 <p>4，当选择的配送单状态全是“配送中”时，可以使用“配送完成”功能。</p>
                  </div>
               </div>
          </div>
		</div>
		<!--标准内容结束-->
	<%@ include file="/common/include/inc_foot.jsp"%>
</div>
<div style="display:none" id="selDisstate">
请选择要修改的状态：
<table width="100%" border="0" cellpadding="5" cellspacing="3">
	<tr>
	<td align="left">
		<s:radio list="mdyDisstate" name="parameter.disstate" id="disstate"/>
	</td>
	</tr>
	<tr>
		<td style="padding-top:10px;" align="center">
		<INPUT TYPE="button" VALUE="确认" ONCLICK="doDisstateMdf();" class="btn_blue_75" onmouseover="this.className='btn_blue_75_02';" onmouseout="this.className='btn_blue_75';">&nbsp;&nbsp;
		<INPUT TYPE="button" VALUE="取消" ONCLICK="closeDisstateMdf();" class="btn_blue_75"  onmouseover="this.className='btn_blue_75_02';" onmouseout="this.className='btn_blue_75';">
		</td>
	</tr>
</table>
</div>
</body>
<%@include file="/common/meta_js.jsp"%>
<iframe name="content" style="display: none;"></iframe>
<script type="text/javascript" src="${ctx}/js/jQuery/table/jquery.table.js" ></script>
<script type="text/javascript" src="${ctx}/js/biz/info/delivery/delivery.js"></script>
<SCRIPT type="text/javascript">
function selectCheck() {
	var scheck = $("#selectCheck").attr("checked");
	$("input[name='recids']").each(function(){
		if($(this).attr("disabled") != true){
			$(this).attr("checked", scheck);
		}
	});
}
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
//待配送、配送中
var WAITDIS = "${constants.DISSTATE_WAITDIS}",DISING="${constants.DISSTATE_DISING}";
//配送完成、作废
var DISOVER = "${constants.DISSTATE_DISOVER}",CANCEL ="${constants.DISSTATE_CANCEL}";

//转成手工指定var nonShow = ${nonShowDisstate};
var nonShow = [DISOVER,CANCEL];
//-->
</SCRIPT>
</html>