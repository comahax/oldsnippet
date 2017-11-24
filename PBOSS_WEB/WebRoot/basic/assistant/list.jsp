<%@ page contentType="text/html;charset=GBK" pageEncoding="GBK"%>
<%@ include file="/common/jspHead.jsp"%>
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
			
			<s:form action="/assistant/AjaxList.do" method="POST" id="frmQuery">
			<div class="listboxtitle">查询条件</div>
            <table class="tb02" width="100%">
  <tr>
    <td class="input_label">公务机号码：</td>
	<td>
	<input name="officeTel" id="officeTel" class="text_01" onFocus="shover(this,'text_01_02')" onBlur="shover(this,'text_01')" 
				   value="${officeTel}" size="11"  maxlength="11" />
	<input name="btnQuery" type="button" id="btnQuery" value="查询" class="btn_blue_75" onMouseOver="shover(this,'btn_blue_75_02')" onMouseOut="shover(this,'btn_blue_75')" disabled />
	</td>
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
                   查询网点店员信息。 </div>
               </div>
               <div class="column">
                 <div class="listboxtitle">温馨提醒：</div>
                 <div class="reminder"></div>
               </div>
          </div>
		</div>
		<!--标准内容结束-->
	<%@ include file="/common/include/inc_foot.jsp"%>
</div>
<!-- 
<form name="doLoad" action="/assistant/Load.do" method="post">
	<input type="hidden" name="officeTel" id="load_officeTel">
</form>
<form name="doQuit" action="/assistant/Quit.do" method="post">
	<input type="hidden" name="officeTel" id="load_officeTel">
</form>
 -->
 <form name="doAction" method="post">
 	<input type="hidden" name="employeeid" id="employeeid">
 </form>
</body>
<%@include file="/common/meta_js.jsp"%>
<script type="text/javascript" src="${ctx}/js/jQuery/table/jquery.table.js" ></script>
<script type="text/javascript" src="${ctx}/js/jQuery/ac/jquery.autocomplete.js"></script>
<script type="text/javascript" src="${ctx}/js/jQuery/ac/auto.js"></script> 
<script type="text/javascript" src="${ctx}/js/biz/basic/assistant/list.js"></script> 
<SCRIPT LANGUAGE="JavaScript">
<!--
	// 查询显示列信息 该页面要用Action请求，在Action中实现：JSONArray.fromObject(getsetCols()).toString();
	var showCols = ${ShowCols};//取后台列设置类数组，对应如下  //dataKey,key,name,width
	//设定查询参数
	var optin = {
		showCols:showCols,//显示列
		fmtLink:fmtLink,//用户自定义单元格内容
		pageSize:10,//页内大小
		unableBtu:$('#btnQuery'),
		navigation:$("#navigation"),//翻页位置 jq对象
		width:"100%",
		queryFrom: $("#frmQuery")//查询表单
	};
//-->
</SCRIPT>
</html>