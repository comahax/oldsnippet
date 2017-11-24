<%@ page language="java"contentType="text/html;charset=GBK" pageEncoding="GBK"%>
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
			
			<s:form action="/salesDetail/regSimAjax.do" method="POST" id="frmQuery">
			<div class="listboxtitle">查询条件</div>
            <table class="tb02" width="100%">
				  <tr>
					<td class="input_label">网点编码：</td>
					<td>${_PBOSS_WEB_USER.channel.wayid }</td>
					<td class="input_label">店员姓名：</td>
					<c:choose>
						<c:when test="${_PBOSS_WEB_USER.isnet==role.SHOP_ASSISTANT}">
						  <td>${_PBOSS_WEB_USER.employeename }</td>
						</c:when>
						<c:otherwise>
						  <td>
						  <input type="hidden" name="oprcode" id="oprcode"/>
						  <s:textfield cssClass="style_input" id="employeename" disabled="true"/>
						  <input type="button" class=""  value="..." id="btnEmployeeSelect" onclick="f_employeeSelect(this)"/>
						  </td>
						</c:otherwise>					
					</c:choose>
				  </tr>
				  <tr>
					<td class="input_label">分公司：</td>
					<td>${strCountyid}</td>
					<td class="input_label">销售服务中心：</td>
					<td>${_PBOSS_WEB_USER.channel.svccode }</td>
				  </tr>
				  <tr>
					<td class="input_label">套卡号码：</td>
					<td>
					  <!-- 
					  <s:textfield cssClass="style_input" name="opnid" id="opnid"/>
					  <input type="button" class="" value="..." id="btnOpnSelect" onclick="f_opnSelect(this)"/>
					  -->
					  <s:textfield cssClass="style_input" name="mobile" id="mobile"/>
					</td>
					<td class="input_label">品牌：</td>
					<td>
					  <s:select list="brandType" name="brand" id="brand"></s:select>
					</td>
				  </tr>
				  <tr>
					<td class="input_label">登记起始时间：</td>
					<td>
						<s:textfield name="timeFrom" cssClass="text_01" id="timeFrom">
							<s:param name="value">
								<s:date name="timeFrom" format="yyyy-MM-dd"/>
							</s:param>
						</s:textfield>
					</td>
					<td class="input_label">登记结束时间：</td>
					<td>
						<s:textfield name="timeTo" cssClass="text_01" id="timeTo" >
							<s:param name="value">
								<s:date name="timeTo" format="yyyy-MM-dd"/>
							</s:param>
						</s:textfield>
					</td>
				  </tr>
				  <tr>
					<td class="input_label">激活起始时间：</td>
					<td>
						<s:textfield name="activeFrom" cssClass="text_01" id="activeFrom">
							<s:param name="value">
								<s:date name="activeFrom" format="yyyy-MM-dd"/>
							</s:param>
						</s:textfield>
					</td>
					<td class="input_label">激活结束时间：</td>
					<td>
						<s:textfield name="activeTo" cssClass="text_01" id="activeTo" >
							<s:param name="value">
								<s:date name="activeTo" format="yyyy-MM-dd"/>
							</s:param>
						</s:textfield>
					</td>
				  </tr>
				 <tr>
					<td class="input_label">商品类型：</td>
					<td>
						<s:select list="comType" name="type" id="type"></s:select>
					</td>
					<td class="input_label">补登标识：</td>
					<td>
					  <s:select list="mendFlag" name="flag" id="flag"></s:select>
					</td>
				 </tr>
				 <tr>
				 	<td colspan="4"  align="left">
				 		<input name="btnQuery" type="button" id="btnQuery" value="查询" class="btn_blue_75" />&nbsp;&nbsp;
						<input name="btnExport" type="button" id="btnExportTxt" value="导出文本" class="btn_blue_75" size="10" style="width:80px"/>&nbsp;&nbsp;
						<input name="btnExport" type="button" id="btnExportExcel" value="导出Excel" class="btn_blue_75" size="10" style="width:80px"/>&nbsp;&nbsp;
						<input name="btnRest" type="reset" id="btnQuery" value="重置" class="btn_blue_75" />
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
                 <p>1. 查询套卡销售的明细，并能够导出数据到Excel文件和文本文件。</p>
                   </div>
               </div>
               <div class="column">
                 <div class="listboxtitle">温馨提醒：</div>
                 <div class="reminder">
                 <p>1.登记起始时间和登记结束时间不能为空，查询范围不能超过31天。</p>
                 <p>2.激活起始时间和激活结束时间必须同时设置，不能只设置其中一项，查询范围不能超过31天。</p>
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
<script type="text/javascript" src="${ctx}/js/biz/info/salesDetail/registersimList.js"></script>
<SCRIPT type="text/javascript">
//<!--
// 查询显示列信息
var showCols = ${ShowCols};//取后台列设置类数组，对应如下  //dataKey,key,name,width
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