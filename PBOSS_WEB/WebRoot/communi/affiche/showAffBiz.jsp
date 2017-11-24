<%@ page contentType="text/html;charset=GBK"%>
<%@ include file="/common/jspHead.jsp"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<!-- ����CSS�ļ� -->
<%@ include file="/common/meta_allcss.jsp"%>

<style type="text/css">
<!--
body {
background-image:none;
padding-left:20px;
}
.ttt{
	color:red;
	text-align: right;
}
-->
</style>
</head>
<body onselectstart="return false">
	<!-- ͷ�������� -->
<div style="width:100%;text-align:left;">
	<div align="center" class="advTitle"><B>${chPwAdvinfo.title }</B>��<fmt:formatDate value="${chPwAdvinfo.releasetime}" pattern="yyyy-MM-dd"/>��</div>
	<table class = "tb02" width="100%">
		<!--
		<tr>
			<td align="center">����ʱ�䣺[<fmt:formatDate value="${chPwAdvinfo.releasetime}" pattern="yyyy-MM-dd"/> ]</td>
		</tr>//-->
		<tr>
			<td>${chPwAdvinfo.content }</td>
		</tr>
	</table>
	<%--
	<div align="center">[<fmt:formatDate value="${chPwAdvinfo.releasetime}" pattern="yyyy-MM-dd"/>]</div>
	<div class="reminder">
		${chPwAdvinfo.content }
	</div>
    --%>
    <div class="listboxtitle">������Ϣ��</div>
    <table class = "tb02" width="100%">
    	<s:if test="chPwAdvaffixList==null || chPwAdvaffixList.size()==0">
    		<tr><td style="text-align: center;">û������</td></tr>
    	</s:if>
    	<s:else>
    		<s:iterator value="chPwAdvaffixList" id="var" status="sta" >
	    	<tr>
				<td class="textRight" width="15%">����<s:property value="#sta.count"/>�� </td>
				<td width="85%">
					<a href="affixDownload.do?parameter.affixid=<s:property value="#var.affixid"/>" >
						<s:property value="#var.affixname"/>
					</a>
				</td>
			</tr>
			</s:iterator>
    	</s:else>
	</table>
    
    <div class="listboxtitle">������Ϣ��</div>
    <span id="showTbl"></span>
	<table class="page_table">
		<tr valign="middle">
			<td align="left" height="30">&nbsp;&nbsp;</td>
			<td align="right" style="font-size:12px;" id="navigation"></td>
		</tr>
	</table>
	<form action="reply.do" id="saveFrm" method="post" >
	<input type="hidden" name="parameter.advinfoid" value="${chPwAdvinfo.advinfoid }" >
	<div class="listboxtitle">${_PBOSS_WEB_USER.employeename}��</div>
    <table class = "tb02" width="100%">
		<tr>
			<td class="textRight" width="15%">���룺</td>
			<td width="85%">
			<textarea name="parameter.content" id="replyContent" class="textarea_01" onkeydown="textdown(event,'replyContent',100)" onkeyup="textup('replyContent',100)"></textarea>
			<font color="#FF0000">*</font>
			</td>
		</tr>
	</table>
	</form>
	<br>
	<div style="text-align:right">
	<input type="button" class="btn_blue_75" value="�� ��" onClick="doReply()">&nbsp;
	<input type="button" class="btn_blue_75" value="�� ��" onClick="doRead()">&nbsp;
	<input type="button" class="btn_blue_75" value="�� ��" onClick="window.parent.closePage();">&nbsp;
	 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
	</div>
</div>
<form action="showReplyInfo.do" method="POST" id="queryReply" >
<input type="hidden" name="parameter.advinfoid" value="${chPwAdvinfo.advinfoid }">
</form>
</body>
<!-- ����JS�ļ� -->
<%@ include file="/common/meta_js.jsp"%>
<script type="text/javascript" src="${ctx}/js/jQuery/table/jquery.table.js" ></script>
<script type="text/javascript" src="/js/jQuery/validation/jquery.validation.js"></script>
<script type="text/javascript" src="/js/jQuery/validation/common.js"></script>
<script type="text/javascript">
var showCols = ${replyColsString};//ȡ��̨�����������飬��Ӧ����  //dataKey,key,name,width

var fmtLink = function(elCell, oRecord, oData,oColumnSet) { 
	var rtn = oData;
	if(oColumnSet.key=="replytime"){
		rtn="<div style='text-align: right;width:100%'>"+rtn+"</div>";
	}else if(oColumnSet.key=="oid"){
		if(rtn=="0"){
			rtn="��������";
		}else{
			rtn="${_PBOSS_WEB_USER.employeename}";
		}
		rtn = rtn+"�ظ�:";
		rtn="<div style='text-align: left;width:100%'>"+rtn+"</div>";
	}else if(oColumnSet.key=="replycontent"){
		rtn="<div style='text-align: left;width:100%'>"+rtn+"</div>";
	}
	return rtn;
}
</script>
<script type="text/javascript" src="${ctx}/js/biz/communi/affiche/showAffBiz.js"></script>
</html>