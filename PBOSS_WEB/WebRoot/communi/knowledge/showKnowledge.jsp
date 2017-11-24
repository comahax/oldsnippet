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
<body onselectstart="return false">
	<!-- 头部导航条 -->
<div style="width:100%;text-align:left;">
	
	<div align="center" class="advTitle"><B>${chPwAdvinfo.title }</B>（<fmt:formatDate value="${chPwAdvinfo.releasetime}" pattern="yyyy-MM-dd"/>）</div>
	<table class = "tb02" width="100%">
		<!--
		<tr>
			<td align="center">发布时间：[<fmt:formatDate value="${chPwAdvinfo.releasetime}" pattern="yyyy-MM-dd"/> ]</td>
		</tr>//-->
		<tr>
			<td>${chPwAdvinfo.content }</td>
		</tr>
	</table>
    
    <div class="listboxtitle">附件信息：</div>
    <table class = "tb02" width="100%">
    	<s:if test="chPwAdvaffixList==null || chPwAdvaffixList.size()==0">
    		<tr><td style="text-align: center;">没有数据</td></tr>
    	</s:if>
    	<s:else>
    		<s:iterator value="chPwAdvaffixList" id="var" status="sta" >
	    	<tr>
				<td class="textRight" width="15%">附件<s:property value="#sta.count"/>： </td>
				<td width="85%">
					<a href="affixDownload.do?parameter.affixid=<s:property value="#var.affixid"/>" >
						<s:property value="#var.affixname"/>
					</a>
				</td>
			</tr>
			</s:iterator>
    	</s:else>
	</table>
    <br><br>
				
	<div style="text-align:right">
	<input type="button" class="btn_blue_75" value="返 回" onClick="window.parent.closePage();"> &nbsp;
	 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
	</div>
</div>
</body>
<!-- 公共JS文件 -->
<%@ include file="/common/meta_js.jsp"%>
</html>