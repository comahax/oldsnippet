<%@ page contentType="text/html;charset=GBK" pageEncoding="GBK"%>
<%@ include file="/common/jspHead.jsp"%>
<html>
<head>
<!-- 公共静态文件 -->
<%@ include file="/common/meta_allcss.jsp"%>
</head>
<body>
	<!-- 头部 -->
	<%@ include file="/common/include/inc_managerhead.jsp"%>	
	<!--标准内容开始-->
	<div class="divspan">
			<!-- 左则功能区-->
		<%@ include file="/common/include/inc_menu.jsp"%>
        <div class="context">
			<div class="listmyposition">
				<span class="font_breadcrumbtitle">您现在的位置：</span><span class="font_breadcrumb">${location}</span>
			</div>
			
			<s:form action="/salescardstotaldetail/ajaxQuery.do" method="POST" id="frmQuery">
			<table class="tb02" width="100%">
            	<input type="hidden" name="parameter.wayid" id="wayid" value="${parameter.wayid}">
            	<input type="hidden" name="parameter.countyid" id="countyid" value="${parameter.countyid}">
            	<input type="hidden" name="parameter.svccode" id="svccode" value="${parameter.svccode}">
            	<input type="hidden" name="parameter.brand" id="brand" value="${parameter.brand}">
            	<input type="hidden" name="parameter.starlevel" id="starlevel" value="${parameter.starlevel}">
            	<input type="hidden" name="parameter.startoprtimes" id="dateFrom" value="${parameter.startoprtimes}"/>
            	<input type="hidden" name="parameter.endoprtimes" id="dateTo" value="${parameter.endoprtimes}"/>
            	<input type="hidden" name="parameter.startactivedates" id="dateFrom" value="${parameter.startactivedates}"/>
            	<input type="hidden" name="parameter.endactivedates" id="dateTo" value="${parameter.endactivedates}"/>
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
            <input type="button" class="btn_blue"  onclick="location='/salescardstotal/show.do'" value="返回套卡销售汇总查询" />
            <!--帮助信息开始-->
            <div class="column">
                 <div class="listboxtitle">功能说明：</div>
                 <div class="reminder">
                   </div>
               </div>
               <div class="column">
                 <div class="listboxtitle">温馨提醒：</div>
                 <div class="reminder">
                  </div>
               </div>
          </div>
		</div>
		<!--标准内容结束-->
	<%@ include file="/common/include/inc_foot.jsp"%>
</div>
<iframe name="content" style="display: none;"></iframe>
</body>
<%@include file="/common/meta_js.jsp"%>
<script type="text/javascript" src="${ctx}/js/jQuery/table/jquery.table.js" ></script>
<script type="text/javascript" src="${ctx}/js/biz/info/salesCardsTotal/registersimList.js"></script>
<SCRIPT type="text/javascript">
//<!--
// 查询显示列信息
var showCols = ${ShowStCols};//取后台列设置类数组，对应如下  //dataKey,key,name,width
//表格配置数组
var optin = {
	showCols:showCols,//显示列
	fmtLink:fmtLink,//用户自定义单元格内容
	pageSize:10,//页内大小
	navigation:$("#navigation"),//翻页位置 jq对象
	unableBtu:$('#btnQuery'),
	width:"100%",
	queryFrom: $("#frmQuery")//查询表单
};
//-->
</SCRIPT>
</html>