<%@ page contentType="text/html;charset=GBK" pageEncoding="GBK"%>
<%@ taglib prefix="fun" uri="/fun-tags" %>
<%@ include file="/common/jspHead.jsp"%>
<%@page import="java.util.List,java.util.ArrayList" %>
<html>
<head>
<!-- 公共静态文件 -->
<%@ include file="/common/meta_allcss.jsp"%>
<jsp:useBean id="constants"  class="com.gmcc.pboss.common.dictionary.ConstantsType" />
<c:set var="fmtNumber" value ="#0.00"/>
<c:set var="TYPEDTL" value ="${constants.RPWDLocalRPT}"/>
<!-- 本地CSS //-->
<style>
.tb02 th{
	background-color: #bcd2e9;
	border: 1px solid #bcd2e9;
	color: #0073C8;
	line-height:18px;
	padding:2px;
}
.tb02 td.dtl{
	text-align:center;
}
.tb02 td.baseContext{
	TEXT-INDENT: 15px;
}
</style>
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
			
		<div class="listboxtitle">${fun:getRewardtypehName(parameter.rewardtype )}：</div>
		<c:set var="qryRslt" value="${servResult.retResult}"/>
			<table class = "tb_comn" width="100%">
				<thead>
					<tr>
						 <td>结算月份</td>
						 <td>酬金类型</td>
						 <td>计酬号码</td>
						 <td>失败原因</td>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${qryRslt.data }" var="dtlObj" varStatus="i">
					<tr>
						<td class="red_01">${dtlObj.rewardmonth}</td>
						<td class="red_01">${dtlObj.type}</td>
						<td class="red_01">${dtlObj.mobleno} </td>
						<td class="red_01">${dtlObj.failureexplain}</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
<TABLE class="page_table">
<TR vAlign="center">
	<TD align="left" height="30">&nbsp;&nbsp;</TD>
	<TD id="navigation" align="right">
	总计<FONT color=red>${qryRslt.page.numbers}</FONT>页,共${qryRslt.page.rows}记录&nbsp;
	当前第<FONT color=red>${qryRslt.page.current}</FONT>页<c:if test="${qryRslt.page.current >1}">
	<A style="TEXT-DECORATION: none" href="#" onclick="doDtlPage(1)"><IMG alt="第一页" src="/images/frist.gif" border=0></A> 
	<A style="TEXT-DECORATION: none" href="#" onclick="doDtlPage(${qryRslt.page.current-1})"><IMG alt="前一页" src="/images/pre.gif" border=0></A></c:if><c:if test="${qryRslt.page.current < qryRslt.page.numbers}">
	<A style="TEXT-DECORATION: none" href="#" onclick="doDtlPage(${qryRslt.page.current+1})"><IMG alt="下一页" src="/images/next.gif" border=0></A>
	<A style="TEXT-DECORATION: none" href="#" onclick="doDtlPage(${qryRslt.page.numbers})"><IMG alt="最后一页" src="/images/last.gif" border=0></A> </c:if>&nbsp; 
	</TD></TR>
	<tr>
		<td align="right" colspan="2">
                        <input name="btnQuery" type="button" id="btnQuery" value="返回" class="btn_blue_75" onclick="javascript:history.go(-1);" />&nbsp;&nbsp;&nbsp;
                       
		</td>
	</tr>
	</TBODY></TABLE>
  
	
	  </div>
		<!--标准内容结束-->
	<%@ include file="/common/include/inc_foot.jsp"%>
</div>
</body>
<%@include file="/common/meta_js.jsp"%>
<script type="text/javascript" src="${ctx}/js/jQuery/validation/jquery.validation.js"></script> 
<script type="text/javascript" src="${ctx}/js/jQuery/validation/common.js"></script> 
<script type="text/javascript" src="${ctx}/js/biz/info/reward/rewardlocal.js"></script> 
<SCRIPT LANGUAGE="JavaScript">
<!--
	var taskId='${taskID}'//待办信息ID
	var TYPEDTL = '${TYPEDTL}';//明细报表类型标识（参数固定，修改注意）
//-->
</SCRIPT>
</html>