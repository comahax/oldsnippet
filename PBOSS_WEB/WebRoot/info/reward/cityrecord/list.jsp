<%@ page contentType="text/html;charset=GBK" pageEncoding="GBK"%>
<%@ include file="/common/jspHead.jsp"%>
<html>
	<head>
		<title>酬金结果明细</title>
		<!-- 公共静态文件 -->
		<%@ include file="/common/meta_allcss.jsp"%>
	</head>

	<body>
		<!--标准内容开始-->
		<div class="divspan">
				<s:form action="/reward/cityrecordAjax.do" method="POST" id="frmQuery">
					<input type="hidden" name="parameter.wayid" value="${parameter.wayid}"/>
					<input type="hidden" name="parameter.opnid2" value="${parameter.opnid2}"/>
					<input type="hidden" name="parameter.rewardtype" value="${parameter.rewardtype}"/>
					<input type="hidden" name="parameter.month" value="${parameter.month}"/>
					<input type="hidden" name="parameter.oprmonth" value="${parameter.oprmonth}"/>
					<input type="hidden" name="parameter.supportPaymonth" value="${parameter.supportPaymonth}"/>
					<input type="hidden" name="parameter.paymonth" value="${parameter.paymonth}"/>
				</s:form>
				<div class="listboxlist">
					<span id="showTbl"></span>
					<table class="page_table">
						<tr valign="middle">
							<td align="left" height="30">
								&nbsp;&nbsp;
							</td>
							<td align="right" style="font-size: 12px;" id="navigation"></td>
						</tr>
					</table>
				</div>
		</div>
	</body>
	<%@include file="/common/meta_js.jsp"%>
<script type="text/javascript" src="${ctx}/js/jQuery/table/jquery.table.js"></script>
<SCRIPT LANGUAGE="JavaScript">
	// 查询显示列信息 该页面要用Action请求，在Action中实现：JSONArray.fromObject(getsetCols()).toString();
	var showCols = ${ShowCols};//取后台列设置类数组，对应如下  //dataKey,key,name,width
	//设定查询参数
	var optin = {
		showCols : showCols,//显示列
		//fmtLink:fmtLink,//用户自定义单元格内容
		pageSize : 10,//页内大小
		//unableBtu : $('#btnQuery'),
		navigation : $("#navigation"),//翻页位置 jq对象
		width : "100%",
		queryFrom : $("#frmQuery")
	//查询表单
	};
$(document).ready(function() {
	$("#showTbl").queryTable(optin);
});
	//-->
</SCRIPT>
</html>