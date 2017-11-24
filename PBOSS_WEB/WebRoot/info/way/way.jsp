<%@ page contentType="text/html;charset=GBK" pageEncoding="GBK"%>
<%@ include file="/common/jspHead.jsp"%>
<html>
<head>
<!-- 公共静态文件 -->
<%@ include file="/common/meta_allcss.jsp"%>
</head>
<body>
	<!--标准内容开始-->
	<div class="divspan">
        <div class="context">
			<div class="listmyposition">
				<span class="font_breadcrumbtitle">网点查询</span>
			</div>
			
			<s:form action="ajaxQuery" method="POST" id="frmQuery">
			<div class="listboxtitle">查询条件</div>
            <table class="tb02" width="74%">
			  <tr>
			    <td class="input_label">网点编码：</td>
			    <td><input name="parameter.wayid" class="select_3L" id="wayid" orgval="${parameter.wayid}" size="11"  maxlength="30"/></td>
			    <td class="input_label">网点名称：</td>
			    <td><input name="parameter.wayname" id="wayname" class="text_01" value="${parameter.wayname}" size="30"  maxlength="30" /></td>
			    </tr>
			  <tr>
			    <td valign="top" class="input_label">&nbsp;</td>
			    <td colspan="3" align="left"><input name="btnQuery" type="button" id="btnQuery" value="查询" class="btn_blue_75" disabled="disabled" /></td>
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
                   网点明细查询。 </div>
               </div>
          </div>
		</div>
    </div>
<!--/div-->
</body>
<script type="text/javascript" src="${ctx}/js/jQuery/table/jquery.table.js" ></script>
<script type="text/javascript" src="${ctx}/js/biz/info/way/way.js"></script>
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
	width:"74%",
	queryFrom: $("#frmQuery")//查询表单
};
var jaacOPERATION = "${jqac.OPERATION}";
//-->
</SCRIPT>
</html>