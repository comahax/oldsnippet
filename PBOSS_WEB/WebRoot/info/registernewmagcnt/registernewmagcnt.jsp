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
			<s:form action="ajaxQuery" method="POST" id="frmQuery">
				<div class="listboxtitle">查询条件</div>
	            <table class="tb02" width="100%">
				  <tr>
				    <td class="input_label">店员姓名：</td>
				    <td>
				    	<s:if test="parameter.flg=='show'">
				    		<input name="parameter.employeename" id="employeename" class="text_01" value="${parameter.employeename}" size="30"  maxlength="30" />
				    		<input type="button" value="..." onclick="showName(this);" />
				    	</s:if>
				    	<s:else>
				    		<input name="parameter.employeename" id="employeename" class="text_01" value="${parameter.employeename}" size="30"  maxlength="30" disabled="true"/>
				    	</s:else>
				    </td>
				    <td class="input_label">业务编码：</td>
				    <td>
				    	<input name="parameter.opnid" id="opnid" class="text_01" value="${parameter.opnid}" size="15"  maxlength="15" />
				    	<input type="button" value="..." onclick="showOpnid(this);" />
				    </td>
				 </tr>
				 <tr>
				    <td class="input_label">登记起始时间：</td>
				    <td>
				    	<s:textfield name="parameter.startoprtime" id="startoprtime" cssClass="text_01" >
							<s:param name="value">
								<s:date name="parameter.startoprtime" format="yyyy-MM-dd"/>
							</s:param>
						</s:textfield>
					</td>
				    <td class="input_label">登记结束时间：</td>
				    <td>
				    	<s:textfield name="parameter.endoprtime" id="endoprtime" cssClass="text_01" >
							<s:param name="value">
								<s:date name="parameter.endoprtime" format="yyyy-MM-dd"/>
							</s:param>
						</s:textfield>
					</td>
				 </tr>
				 <tr>
				    <td class="input_label">品牌：</td>
				    <td>
				    	<s:select list="brandType" cssClass="select_3L" name="parameter.brand" id="brand"></s:select>
				    </td>
				    <td class="input_label"></td>
				    <td></td>
				 </tr>
				  <tr>
				    <td valign="top" class="input_label">&nbsp;</td>
				    <td colspan="3" align="left"><input name="btnQuery" type="button" id="btnQuery" value="查询" class="btn_blue_75" disabled="disabled" />&nbsp;&nbsp;
				    <input name="btnExport" type="button" id="btnExport" value="导出" class="btn_blue_75" />
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
                   新业务销售汇总查询。 </div>
               </div>
               <div class="column">
                 <div class="listboxtitle">温馨提醒：</div>
                 <!-- <div class="reminder">
                 	 <p>1、 如果登记时间为当前月，返回数据为本月1号到当前日前一天的数据。</p>
					 <p>2、 进入该功能页面时系统默认查询时间为当前月。</p> 
					 <p>3、 查询时必须输入登记时间。</p>
                  </div> -->
               </div>
          </div>
		</div>
    </div>
	<!--标准内容结束-->
	<%@ include file="/common/include/inc_foot.jsp"%>
<!--/div-->
 <form name="doAction" method="post">
 	<input type="hidden" name="_se_employeename" id="_se_employeename">
 	<input type="hidden" name="_se_officetel" id="_se_officetel">
 	<input type="hidden" name="_se_brand" id="_se_brand">
 	<input type="hidden" name="_se_opnid" id="_se_opnid">
 	<input type="hidden" name="_se_startoprtime" id="_se_startoprtime">
 	<input type="hidden" name="_se_endoprtime" id="_se_endoprtime">
 </form>
 <iframe name="content" style="display: none;"></iframe>
</body>
<%@include file="/common/meta_js.jsp"%>
<script type="text/javascript" src="${ctx}/js/jQuery/table/jquery.table.js" ></script>
<script type="text/javascript" src="${ctx}/js/jQuery/validation/jquery.validation.js" ></script>
<script type="text/javascript" src="${ctx}/js/biz/info/registernewmagcnt/registernewmagcnt.js"></script>
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