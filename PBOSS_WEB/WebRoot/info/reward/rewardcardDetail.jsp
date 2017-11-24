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
			
			<s:form action="/reward/ajax_cardrewdetDetail.do" method="POST" id="frmQuery">
			<div class="listboxtitle">查询条件</div>
            <table class="tb02" width="100%">
				  <tr>
					<td class="input_label">购销渠道编码：</td>
					<td>${_PBOSS_WEB_USER.channel.wayid }</td>
					<td class="input_label">号码：</td>
					<td>
					  <s:textfield cssClass="style_input" name="parameter.mobile" id="mobile"/>
					</td>	
				  </tr>
				  <tr>
					<td class="input_label">激活开始时间：</td>
					<td>
						<s:textfield name="parameter.activeFrom" cssClass="text_01" id="activeFrom">
							<s:param name="value">
								<s:date name="parameter.activeFrom" format="yyyy-MM-dd"/>
							</s:param>
						</s:textfield>
					</td>
					<td class="input_label">激活结束时间：</td>
					<td>
						<s:textfield name="parameter.activeTo" cssClass="text_01" id="activeTo" >
							<s:param name="value">
								<s:date name="parameter.activeTo" format="yyyy-MM-dd"/>
							</s:param>
						</s:textfield>
					</td>
				  </tr>
				  <tr>
					<td class="input_label">充值开始时间：</td>
					<td>
						<s:textfield name="parameter.rechargeFrom" cssClass="text_01" id="rechargeFrom">
							<s:param name="value">
								<s:date name="parameter.rechargeFrom" format="yyyy-MM-dd"/>
							</s:param>
						</s:textfield>
					</td>
					<td class="input_label">充值结束时间：</td>
					<td>
						<s:textfield name="parameter.rechargeTo" cssClass="text_01" id="rechargeTo" >
							<s:param name="value">
								<s:date name="parameter.rechargeTo" format="yyyy-MM-dd"/>
							</s:param>
						</s:textfield>
					</td>
			  </tr>
			
			  <tr>
			  	<td colspan="4" align="left">
			  		<input name="btnQuery" type="button" id="btnQuery" value="查询" class="btn_blue_75" />&nbsp;&nbsp;
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
                 <p>1.查询充值卡的激活情况。</p>
                   </div>
               </div>
               <div class="column">
                 <div class="listboxtitle">温馨提醒：</div>
                 <div class="reminder">
                 <p>1.如果查询的响应速度过慢，建议查询的时间跨度不要超过一个月。</p>
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
<script type="text/javascript" src="${ctx}/js/biz/info/rewardcard/cardrewdetDetail.js"></script>
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