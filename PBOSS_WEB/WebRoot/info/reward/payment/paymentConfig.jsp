<%@ page contentType="text/html;charset=GBK" pageEncoding="GBK"%>
<%@ include file="/common/jspHead.jsp"%>
<html>
<head>
<title>酬金一体化配置</title>
<!-- 公共静态文件 -->
<%@ include file="/common/meta_allcss.jsp"%>
</head>

<body>
	<!-- 头部 -->
	<%@ include file="/common/include/inc_gdhead.jsp"%>
	<!--标准内容开始-->
	<div class="divspan">
		<!-- 左则功能区-->
		<%@ include file="/common/include/inc_citymenu.jsp"%>
        <div class="context">
			<div class="listmyposition">
				<span class="font_breadcrumbtitle">您现在的位置：</span><span class="font_breadcrumb">${location}</span>
			</div>
           
			<form action="/gdView/paymentConfigAjax.do" method="POST" id="frmQuery"> 
			  <table class="tb02" width="100%">
			  <tr>
				<td class="input_label" align="right">设置审核开关：</td>
				<td>
				   <select id="chkswitch" name="chkswitch">
                       <option VALUE="open" selected="selected">开启</option>
                       <option VALUE="close">关闭</option>
                   </select>
				</td>
			  </tr>
			  <tr>
				<td valign="top" class="input_label">&nbsp;</td>
				<td colspan="2" align="left">
				    <input name="btnQuery" type="button" id="btnQuery" value="查询" class="btn_blue_75" />&nbsp;&nbsp;
				    <input name="btnSave" type="button" id="btnSave" value="保存" class="btn_blue_75" />
				</td>
			  </tr>
			</table>
			</form>
			
            <!--帮助信息开始-->
            <div class="listboxlist">
			    <div class="listboxtitle">查询结果</div>
			    <span id="showTbl"></span>
			    <table class="page_table">
				    <tr valign="middle">
					    <td align="left" height="30">&nbsp;&nbsp;</td>
					    <td align="right" style="font-size:12px;" id="navigation"></td>
				    </tr>
			    </table>
			</div>    
            <!--帮助信息结束-->

	    </div>
	
	<!--标准内容结束-->
	<%@ include file="/common/include/inc_foot.jsp"%>
	<div id="_rndImageDIV" style="border:solid 1px #545454;position:absolute;background:#E8FBFF;padding:3px;display:none;zIndex:3000"></div>
</body>
<%@include file="/common/meta_js.jsp"%>
<script type="text/javascript" src="${ctx}/js/jQuery/table/jquery.table.js" ></script>
<script type="text/javascript" src="${ctx}/js/biz/info/reward/common.js"></script>
<script type="text/javascript" src="${ctx}/js/biz/info/reward/payment/paymentConfig.js"></script> 
<SCRIPT type="text/javascript">
<!--
// 查询显示列信息
var showCols = ${ShowCols};//取后台列设置类数组，对应如下  key,value,explain
//表格配置数组
var optin = {
	showCols:showCols,//显示列
	fmtLink:fmtLink,//用户自定义单元格内容
	pageSize:10,//页内大小
	navigation:$("#navigation"),//翻页位置 jq对象
	unableBtu:$("#btnQuery"),
	width:"100%",
	queryFrom: $("#frmQuery")//查询表单
};
var jaacOPERATION = "${jqac.OPERATION}";
//-->
</SCRIPT> 

</html>