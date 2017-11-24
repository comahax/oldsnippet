<%@ page contentType="text/html;charset=GBK" pageEncoding="GBK"%>
<%@ include file="/common/jspHead.jsp"%>
<html>
<head>
<!-- 公共静态文件 -->
<%@ include file="/common/meta_allcss.jsp"%>
</head>
<body>
	<!-- 头部导航条
	include file="/common/include/inc_managerhead.jsp"
	
	 -->	
	<%@ include file="/common/include/inc_head.jsp" %>	
	<div class="divspan">
			<!--标准内容开始-->
			<!-- 公共用户资料 -->
			<%@ include file="/common/include/inc_menu.jsp"%>
		<div class="context">
			<div class="listmyposition">
				<span class="font_breadcrumbtitle">您现在的位置：</span><span class="font_breadcrumb">${location}</span>
			</div>
			
			<s:form action="ajaxQuery" method="POST" id="frmQuery">
			<div class="listboxtitle">查询条件</div>
            <table class="tb02" width="100%">
					  <tr>
					    <td class="input_label">店员姓名：</td>
						<s:if test="_PBOSS_WEB_USER.isnet == role.SHOP_ASSISTANT">
					 	 <td>${_PBOSS_WEB_USER.employeename }</td>
						</s:if>
						<s:else>
						  <td>
						  <input type="hidden" name="parameter.oprcode" id="oprcode"/>
						  <s:textfield cssClass="style_input" id="employeename" disabled="true"/>
						  <input type="button" class=""  value="..." id="btnEmployeeSelect" onclick="f_employeeSelect(this)"/>
						  </td>
						</s:else>
						<!--td class="input_label">业务编码：</td>
						<td>
					  	<s:textfield cssClass="style_input" name="parameter.opnid" id="opnid"/>
					  	<input type="button" class="" value="..." id="btnOpnSelect" onclick="f_opnSelect(this)"/>
						</td-->					  		
						<td class="input_label">品牌：</td>
					  	<td>
					  		<s:select list="brandType" cssClass="select_3L"  name="parameter.brand" id="brand"></s:select>
					  	</td>					     
					  </tr>
					  
					 	<tr>
							<td class="input_label">登记起始时间：</td>
							<td>
								<s:textfield name="parameter.startoprtime" cssClass="text_01" id="startoprtime">
									<s:param name="value">
										<s:date name="parameter.startoprtime" format="yyyy-MM-dd"/>
									</s:param>
								</s:textfield>
							</td>
							<td class="input_label">登记结束时间：</td>
							<td>
								<s:textfield name="parameter.endoprtime" cssClass="text_01" id="endoprtime" >
									<s:param name="value">
										<s:date name="parameter.endoprtime" format="yyyy-MM-dd"/>
									</s:param>
								</s:textfield>
							</td>
						  </tr>
						  <tr>
							<td class="input_label">激活起始时间：</td>
							<td>
								<s:textfield name="parameter.startactivedate" cssClass="text_01" id="startactivedate">
									<s:param name="value">
										<s:date name="parameter.startactivedate" format="yyyy-MM-dd"/>
									</s:param>
								</s:textfield>
							</td>
							<td class="input_label">激活结束时间：</td>
							<td>
								<s:textfield name="parameter.endactivedate" cssClass="text_01" id="endactivedate" >
									<s:param name="value">
										<s:date name="parameter.endactivedate" format="yyyy-MM-dd"/>
									</s:param>
								</s:textfield>
							</td>
						  </tr>
									  
					  <tr>
					    <td valign="top" class="input_label">&nbsp;</td>
					    <td colspan="5" align="left">
					    <input name="btnQuery" type="button" id="btnQuery" value="查询" class="btn_blue_75"  />&nbsp;&nbsp;
					    <input name="btnExport" type="button" id="btnExportExcel" value="导出" class="btn_blue_75" size="10"/>&nbsp;&nbsp;
					    <!-- <input name="btnRest" type="reset" id="btnQuery" value="重置" class="btn_blue_75" />  -->
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
                 <div class="listboxtitle">功能说明： </div>
                 <div class="reminder">套卡销售汇总。 </div>
               </div>
               <div class="column">
                 <div class="listboxtitle">温馨提醒： </div>
                 <!-- 
                 <div class="reminder">
                 	 <p>1、 如果查询时间为当前月，返回数据为本月1号到当前日前一天的数据。</p>
					 <p>2、 进入该功能页面时系统默认查询时间为当前月。</p> 
					 <p>3、 查询时必须输入查询时间。</p>
                  </div>
                   -->
               </div>
          </div>
		</div>
		<!--标准内容结束-->
	<%@ include file="/common/include/inc_foot.jsp"%>
</div>
<form name="doAction" method="post">
 	<input type="hidden" name="_se_startoprtime" id="_se_startoprtime">
 	<input type="hidden" name="_se_endoprtime" id="_se_endoprtime">
 	<input type="hidden" name="_se_startactivedate" id="_se_startactivedate">
 	<input type="hidden" name="_se_endactivedate" id="_se_endactivedate">
 	<input type="hidden" name="_se_brand" id="_se_brand">
 	<input type="hidden" name="_se_officetel"  id="_se_officetel">
 	<input type="hidden" name="_se_employeeid"  id="_se_employeeid">
 </form>
<iframe name="content" style="display: none;"></iframe>
</body>
<%@include file="/common/meta_js.jsp"%>
<script type="text/javascript" src="${ctx}/js/jQuery/table/jquery.table.js" ></script>
<script type="text/javascript" src="${ctx}/js/biz/info/lowsalesCardsTotal/salesCardsTotal.js"></script>
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
	width:"100%",
	queryFrom: $("#frmQuery")//查询表单
};
var jaacOPERATION = "${jqac.OPERATION}";
//-->
</SCRIPT>
</html>