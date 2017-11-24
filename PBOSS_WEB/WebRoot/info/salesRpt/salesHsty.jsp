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
			
			<s:form action="ajaxQuery" method="POST" id="frmQuery">
			<div class="listboxtitle">查询条件</div>
            <table class="tb02" width="100%">
			  <tr>
				<td class="input_label">商品种类：</td>
				<td><s:select list="dictItem" cssClass="select_3L" name="parameter.comType" id="comType"/></td>
				<td class="input_label">套卡/充值卡号码：</td>
				<td><input name="parameter.mobileNo" id="mobile" class="text_01" style="width:100px;" maxlength="11"/></td>
				<td class="input_label">查询时间：</td>
				<td><select name="parameter.month" class="select_3L" id="selMonth" orgval="${parameter.month}"></select></td>
				</tr>
			  <tr>
				<td valign="top" class="input_label">&nbsp;</td>
				<td colspan="5" align="left"><input name="btnQuery" type="button" id="btnQuery" value="查询" class="btn_blue_75" disabled="disabled" />&nbsp;&nbsp;<input name="btnRest" type="reset" id="btnQuery" value="重置" class="btn_blue_75" /></td>
			  </tr>
			</table>
			</s:form>
			<div class="listboxlist">
			<div class="listboxtitle">查询结果</div>
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
                   商品订购历史查询。 </div>
               </div>
               <div class="column">
                 <div class="listboxtitle">温馨提醒：</div>
                 <div class="reminder">
					 <p>进入该功能页面时系统默认查询时间为当前月。</p>
                  </div>
               </div>
          </div>
		</div>
		<!--标准内容结束-->
	<%@ include file="/common/include/inc_foot.jsp"%>
</div>
</body>
<%@include file="/common/meta_js.jsp"%>
<script type="text/javascript" src="${ctx}/js/jQuery/table/jquery.table.js" ></script>
<script type="text/javascript" src="${ctx}/js/jQuery/validation/jquery.validation.js" ></script>
<script type="text/javascript" src="${ctx}/js/biz/info/salesRpt/salesHsty.js"></script>
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
	queryFrom: $("#frmQuery")//查询表单
};
var jaacOPERATION = "${jqac.OPERATION}";
//-->
</SCRIPT>
</html>