<%@ page contentType="text/html;charset=GBK"%>
<%@ include file="/common/jspHead.jsp"%>
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
					<a href="affixPDownload.do?publicParameter.affixid=<s:property value="#var.affixid"/>&cityid=${cityid }&publicParameter.advinfoid=${chPwAdvinfo.advinfoid }" >
						<s:property value="#var.affixname"/>
					</a>
				</td>
			</tr>
			</s:iterator>
    	</s:else>
	</table>
	<br><br>
	<div style="text-align:right">
	<input type="button" class="btn_blue_75" value="�� ��" onClick="window.parent.closePage();"> &nbsp;
	 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
	</div>
</div>
</body>
<!-- ����JS�ļ� -->
<%@ include file="/common/meta_js.jsp"%>
</html>