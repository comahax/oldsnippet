<%@ page contentType="text/html;charset=GBK" pageEncoding="GBK"%>
<%@ include file="/common/jspHead.jsp"%>
<html>
<head>
<!-- 公共静态文件 -->
<%@ include file="/common/meta_allcss.jsp"%>
</head>
<body>
	<!-- 头部 -->
	<%@ include file="/common/include/inc_missionerhead.jsp"%>	
	<!--标准内容开始-->
	<div class="divspan">
			<!-- 左则功能区-->
		<%@ include file="/common/include/inc_menu.jsp"%>
        <div class="context">
			<div class="listmyposition">
				<span class="font_breadcrumbtitle">您现在的位置：</span><span class="font_breadcrumb">${location}</span>
			</div>
			
			<s:form action="/missioner/unvrcfaildayAjax.do" method="POST" id="frmQuery">
				<div class="listboxtitle">查询条件</div>
            	<table class="tb02" width="100%">
            	
            	<tr>
					<td class="input_label">专员号码：</td>
					<td>
						<s:textfield cssClass="style_input" name="parameter.rcno" id="rcno"/>
					</td>
					<td class="input_label">成员属性：</td>
					<td>
						<s:select list="empattr2" name="parameter.empattr2" cssStyle="width:130px" id="empattr2"></s:select>
					</td>
				</tr>
				
				<tr>
					<td class="input_label">业务编码：</td>
					<td>
						<s:textfield cssClass="style_input" name="parameter.opnid" id="opnid"/>
					</td>
					<td class="input_label">业务名称：</td>
					<td>
						<s:textfield cssClass="style_input" name="parameter.opnname" id="opnname"/>
					</td>
				</tr>
				
				<tr>
					<td class="input_label">业务发生时间>=：</td>
					<td>
						<s:textfield name="parameter.oprtimeFrom" cssClass="text_01" id="oprtimeFrom">
							<s:param name="value">
								<s:date name="parameter.oprtimeFrom" format="yyyy-MM-dd"/>
							</s:param>
						</s:textfield>
					</td>
					<td class="input_label">业务发生时间<=：</td>
					<td>
						<s:textfield name="parameter.oprtimeTo" cssClass="text_01" id="oprtimeTo" >
							<s:param name="value">
								<s:date name="parameter.oprtimeTo" format="yyyy-MM-dd"/>
							</s:param>
						</s:textfield>
					</td>
				  </tr>
            		
            	<tr>
            		<td>&nbsp;</td>
				 	<td colspan="3"  align="left">
				 		<input name="btnQuery" type="button" id="btnQuery" value="查询" class="btn_blue_75" />&nbsp;&nbsp;
						<input name="btnRest" type="reset" id="btnRest" value="重置" class="btn_blue_75" />
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
			</div>
		</div>
		<!--标准内容结束-->
	<%@ include file="/common/include/inc_foot.jsp"%>
</div>
<iframe name="content" style="display: none;"></iframe>
</body>
<%@include file="/common/meta_js.jsp"%>
<script type="text/javascript" src="${ctx}/js/jQuery/table/jquery.table.js" ></script>
<script type="text/javascript" src="${ctx}/js/biz/info/missioner/recommend/unvrcfailday.js"></script>
<SCRIPT type="text/javascript">
//<!--
// 查询显示列信息
var showCols = ${ShowCols};//取后台列设置类数组，对应如下  //dataKey,key,name,width
//表格配置数组
var optin = {
	showCols:showCols,//显示列
	//fmtLink:fmtLink,//用户自定义单元格内容
	pageSize:10,//页内大小
	navigation:$("#navigation"),//翻页位置 jq对象
	unableBtu:$('#btnQuery'),
	width:"100%",
	queryFrom: $("#frmQuery")//查询表单
};
//-->
</SCRIPT>
</html>