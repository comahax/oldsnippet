<%@ page contentType="text/html;charset=GBK" pageEncoding="GBK"%>
<%@ taglib prefix="fun" uri="/fun-tags" %>
<%@ include file="/common/jspHead.jsp"%>
<%@page import="java.util.List,java.util.ArrayList" %>
<html>
<head>
<!-- ������̬�ļ� -->
<%@ include file="/common/meta_allcss.jsp"%>
<jsp:useBean id="constants"  class="com.gmcc.pboss.common.dictionary.ConstantsType" />
<c:set var="fmtNumber" value ="#0.00"/>
<c:set var="TYPEDTL" value ="${constants.RPWDLocalRPT}"/>
<!-- ����CSS //-->
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
	<!-- ͷ�� -->
	<%@ include file="/common/include/inc_head.jsp"%>	
	<!--��׼���ݿ�ʼ-->
	<div class="divspan">
			<!-- ��������-->
		<%@ include file="/common/include/inc_menu.jsp"%>
        <div class="context">
			<div class="listmyposition">
				<span class="font_breadcrumbtitle">�����ڵ�λ�ã�</span><span class="font_breadcrumb">${location}</span>
			</div>
			
		<div class="listboxtitle">${fun:getRewardtypehName(parameter.rewardtype )}��</div>
		<c:set var="qryRslt" value="${servResult.retResult}"/>
			<table class = "tb_comn" width="100%">
				<thead>
					<tr>
						 <td>�����·�</td>
						 <td>�������</td>
						 <td>�Ƴ����</td>
						 <td>ʧ��ԭ��</td>
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
	�ܼ�<FONT color=red>${qryRslt.page.numbers}</FONT>ҳ,��${qryRslt.page.rows}��¼&nbsp;
	��ǰ��<FONT color=red>${qryRslt.page.current}</FONT>ҳ<c:if test="${qryRslt.page.current >1}">
	<A style="TEXT-DECORATION: none" href="#" onclick="doDtlPage(1)"><IMG alt="��һҳ" src="/images/frist.gif" border=0></A> 
	<A style="TEXT-DECORATION: none" href="#" onclick="doDtlPage(${qryRslt.page.current-1})"><IMG alt="ǰһҳ" src="/images/pre.gif" border=0></A></c:if><c:if test="${qryRslt.page.current < qryRslt.page.numbers}">
	<A style="TEXT-DECORATION: none" href="#" onclick="doDtlPage(${qryRslt.page.current+1})"><IMG alt="��һҳ" src="/images/next.gif" border=0></A>
	<A style="TEXT-DECORATION: none" href="#" onclick="doDtlPage(${qryRslt.page.numbers})"><IMG alt="���һҳ" src="/images/last.gif" border=0></A> </c:if>&nbsp; 
	</TD></TR>
	<tr>
		<td align="right" colspan="2">
                        <input name="btnQuery" type="button" id="btnQuery" value="����" class="btn_blue_75" onclick="javascript:history.go(-1);" />&nbsp;&nbsp;&nbsp;
                       
		</td>
	</tr>
	</TBODY></TABLE>
  
	
	  </div>
		<!--��׼���ݽ���-->
	<%@ include file="/common/include/inc_foot.jsp"%>
</div>
</body>
<%@include file="/common/meta_js.jsp"%>
<script type="text/javascript" src="${ctx}/js/jQuery/validation/jquery.validation.js"></script> 
<script type="text/javascript" src="${ctx}/js/jQuery/validation/common.js"></script> 
<script type="text/javascript" src="${ctx}/js/biz/info/reward/rewardlocal.js"></script> 
<SCRIPT LANGUAGE="JavaScript">
<!--
	var taskId='${taskID}'//������ϢID
	var TYPEDTL = '${TYPEDTL}';//��ϸ�������ͱ�ʶ�������̶����޸�ע�⣩
//-->
</SCRIPT>
</html>