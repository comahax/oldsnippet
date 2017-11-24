<%@ page contentType="text/html;charset=GBK"%>
<%@ include file="/common/jspHead.jsp"%>
<%@page import="com.gmcc.pboss.common.file.dictionary.*"%>

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
    
    <div class="listboxtitle">问卷模板：</div>
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
	
	<div class="listboxtitle">反馈信息：</div>
    <span id="showTbl"></span>
	<table class="page_table">
		<tr valign="middle">
			<td align="left" height="30">&nbsp;&nbsp;</td>
			<td align="right" style="font-size:12px;" id="navigation"></td>
		</tr>
	</table>
    
    <s:if test="chPwAdvaffixList != null && chPwAdvaffixList.size() > 0">
	<div class="listboxtitle">${_PBOSS_WEB_USER.employeename}：</div>
    <table class = "tb02" width="100%">
		<tr>
			<td class="textRight" width="15%">上传调查问卷：</td>
			<td width="85%">
	            <form action="/fileHandle?operation=<%=FileHandleType.UPLOAD %>&uploadType=<%=UploadFileType.INDAGATE_QUESTIONNAIRE %>&advinfoid=${chPwAdvinfo.advinfoid}" 
	            	  id="uploadForm" name="uploadForm" enctype="multipart/form-data"  method="post" target="hidden_frame" >
	            	<input type="file" id="uploadFile" name="uploadFile" style="width:250">
	            	(<font color="#FF0000">上传格式为：${uploadConfig.fileSuffix }文件，上传大小不超过${uploadConfig.maxSizeKb }Kb</font>)
	            	<iframe name='hidden_frame' id="hidden_frame" style='display:none'></iframe>
	            </form>
			</td>
		</tr>
	</table>
	<input type="hidden" name="fileSize" id="fileSize" value="${uploadConfig.maxSize}" />
	</s:if>
	
	<br><br>		
	<div style="text-align:right">
	<s:if test="chPwAdvaffixList != null && chPwAdvaffixList.size() > 0">
	<input type="button" class="btn_blue_75" value="提 交" id="uploadButton" onClick="f_submitUpload();"> &nbsp;
	</s:if>
	<input type="button" class="btn_blue_75" value="返 回" onClick="window.parent.closePage();"> &nbsp;
	 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
	</div>
</div>
<form action="showQuestionnaireReplyInfo.do" method="POST" id="queryReply">
<input type="hidden" name="parameter.advinfoid" value="${chPwAdvinfo.advinfoid }">
<input type="hidden" name="parameter.type" value="3">
</form>

</body>
<!-- 公共JS文件 -->
<%@ include file="/common/meta_js.jsp"%>
<!-- 引入文件处理JS -->
<script type="text/javascript" src="${ctx}/js/common/fileHandle.js" ></script>
<script type="text/javascript" src="${ctx}/js/jQuery/table/jquery.table.js" ></script>
<script type="text/javascript" src="${ctx}/js/jQuery/validation/jquery.validation.js"></script>
<script type="text/javascript" src="${ctx}/js/jQuery/validation/common.js"></script>
</html>
<script type="text/javascript">
var showCols = ${questionnaireColsString};//取后台列设置类数组，对应如下  //dataKey,key,name,width

var fmtLink = function(elCell, oRecord, oData,oColumnSet) { 
	var rtn = oData;
	if(oColumnSet.key=="replytime"){
		rtn="<div style='text-align: right;width:100%'>"+rtn+"</div>";
	}else if(oColumnSet.key=="oid"){
		rtn = rtn+"回复:";
		rtn="<div style='text-align: right;width:100%'>"+rtn+"</div>";
	}else if(oColumnSet.key=="affix"){
		rtn = "<div style='text-align: left;'><a href='questionnaireReplyAffixDownload.do?fileName="+rtn+"'>"+rtn+"</a></div>"
	}
	return rtn;
}
//表格配置数组
var optin = {
	showCols:showCols,//显示列
	pageSize:5,//页内大小
	fmtLink:fmtLink,
	navigation:$("#navigation"),//翻页位置 jq对象
	width:"100%",
	showTable:false,
	queryFrom: $("#queryReply")//查询表单
};

function doQuery(){
	$("#showTbl").queryTable(optin);
}

$(document).ready(function() {
	doQuery();
});
</script>
