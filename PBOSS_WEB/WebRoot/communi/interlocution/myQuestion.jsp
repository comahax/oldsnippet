<%@ page contentType="text/html;charset=GBK" pageEncoding="GBK"%>
<%@page import="com.gmcc.pboss.biz.communi.CPDictionary"%>
<%@ include file="/common/jspHead.jsp"%>
<%@ taglib prefix="st" uri="/select-tag"%>
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

<s:form action="queryInfos" method="POST" id="frmQuery">
<div class="listboxtitle">查询条件</div>
<table class="tb02" width="100%" >
	<tr>
	  <td class="input_label" >发布时间：</td>
	  <td style="width: 160px;">
	  	<input name="parameter.startDate" id="selStartDate" class="text_01" style="width:80px;"
	  	value="${parameter.startDate }" /></td>
	  <td class="input_label">至：</td>
	  <td style="width: 160px;">
	  	<input name="parameter.accountDate" id="selAccountDate" class="text_01" style="width:80px;"
	  	value="${parameter.accountDate }" />
	  </td>
	 </tr>
	 <tr>
	 	<td class="input_label" >标题：</td>
	  <td>
	  	<input name="parameter.title" id="" class="text_01" style="width:150px;" />
	  </td>
	  <td class="input_label">状态：</td>
	  <td>
	  	<st:st name="parameter.state" className="formSelect_3L" type="<%=ConstantsType.QUESTION_STATE%>"/>
	  </td>
	 </tr>
	 <tr>
	 <td class="input_label" ></td>
	  <td colspan="3">
		<input name="btnQuery" type="button" id="btnQuery" value="查询" class="btn_blue_75" disabled="disabled" />&nbsp;&nbsp;
	  	<input name="btnRest" type="reset" id="btnReset" value="重置" class="btn_blue_75" />
	  </td>
	</tr>
</table>
<input type="hidden" name="parameter.type" id="advType" value="<%=CPDictionary.INTERLOCUTION %>" />
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
        <div class="reminder"></div>
	</div>
    <div class="column">
    	<div class="listboxtitle">温馨提醒：</div>
        <div class="reminder"></div>
    </div>
</div>
</div>
</div>
<!--标准内容结束-->
<%@ include file="/common/include/inc_foot.jsp"%>
</body>
<%@include file="/common/meta_js.jsp"%>
<script type="text/javascript" src="${ctx}/js/jQuery/table/jquery.table.js" ></script>
<script type="text/javascript" src="${ctx}/js/biz/communi/interlocution/myQuestion.js"></script>
<SCRIPT type="text/javascript">
<!--
// 查询显示列信息
var showCols = ${myQuestionColsString};//取后台列设置类数组，对应如下  //dataKey,key,name,width
//表格配置数组
var optin = {
	showCols:showCols,//显示列
	fmtLink:fmtLink,//用户自定义单元格内容
	pageSize:4,//页内大小
	navigation:$("#navigation"),//翻页位置 jq对象
	unableBtu:$('#btnQuery'),
	width:"100%",
	queryFrom: $("#frmQuery")//查询表单
};
var jaacOPERATION = "${jqac.OPERATION}";
//-->
</SCRIPT>
</html>