<%@ page contentType="text/html;charset=GBK"%>
<%@ include file="/common/jspHead.jsp"%>
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
<body>
	<!-- 头部导航条 -->
        <div style="width:100%;text-align:left;">
<form action="ajaxComcateQuery.do" method="POST" id="frmComcatesQuery">
<INPUT TYPE="hidden" NAME="orderid" value="${orderid}">
</form>
<form action="ajaxResdetsQuery.do" method="POST" id="frmResdetsQuery">
<INPUT TYPE="hidden" NAME="orderid" value="${orderid}">
</form>
<form action="pcnfrmOrder.do" method="POST" id="frmCnfrmOrder">
<INPUT TYPE="hidden" NAME="orderid" value="${orderid}">
</form>
<form action="pcancelOrder.do" method="POST" id="frmCancelOrder">
<INPUT TYPE="hidden" NAME="orderid" value="${orderid}">
</form>
				<!-- 订单基本信息 Begin-->
                 <div class="listboxtitle">订单基本信息</div>
				<table class = "tb02" width="100%">
						<tr>
							<td class="textRight" width="15%">订单编号：</td>
							<td colspan="3">${orderDtl.orderid}</td>
   						</tr>
   						<tr>
   							<td class="textRight">订购途径：</td>
							<td width="35%" >${orderDtl.orderaveName}</td>
					      <td width="15%"  class="textRight">订单状态：</td>
   						    <td >${orderDtl.orderstateName}</td>
   						</tr>
   						<tr>
   							<td class="textRight">应付金额：</td>
							<td width="35%" >${orderDtl.recamt} 元</td>
					      <td width="15%"  class="textRight">已付金额：</td>
   						    <td >${orderDtl.actamt} 元</td>
   						</tr>
   						<tr>
   						  <td class="textRight">渠道名称：</td>
   						  <td>${wayname}</td>
   						  <td class="textRight">订单生成日期：</td>
   						  <td><fmt:formatDate value="${orderDtl.createtime}" type="both" pattern="yyyy-MM-dd HH:mm"/></td>
				  </tr>
					</table>
                    
				<!-- 订购商品种类 -->
                 <div class="listboxtitle">订购商品种类：</div>
			<span id="showComcateTbl"></span>
			<table class="page_table">
				<tr valign="middle">
					<td align="left" height="30">&nbsp;&nbsp;</td>
					<td align="right" style="font-size:12px;" id="comcateNavigation"></td>
				</tr>
			</table>
			<!--不用
				<table class = "tb_comn" width="96%">
					<thead>
						<tr>
							<td>商品类型</td>
							<td>订购数量</td>
							<td>商品单价</td>
							<td>商品总价</td>
							<td>备注</td>
						</tr>
					</thead>
						<tr>
							<td class="red_01">comDtl.comcategoryName</td>
							<td class="red_01">comDtl.orderam}</td>
							<td class="red_01">comDtl.unitprice</td>
							<td class="red_01">comDtl.totalprice</td>
							<td class="red_01">comDtl.ordercomtype</td>
						</tr>
				</table>-->
				<!-- 订购资源明细 -->
                 <div class="listboxtitle">订购资源明细：</div>				
			<span id="showResdetsTbl"></span>
			<table class="page_table">
				<tr valign="middle">
					<td align="left" height="30">&nbsp;&nbsp;</td>
					<td align="right" style="font-size:12px;" id="resdetsNavigation"></td>
				</tr>
			</table>
			<!--不使用
				<table class = "tb_comn" width="96%">
	              	<thead>
	                    <tr>
	                    	 <td>商品类型</td>
		                     <td>套卡/充值卡号码</td>
		                     <td>所属包号</td>
	                    </tr>
	                </thead>
                 		<tr>
	                		<td class="red_01">resdetdtl.comcategoryName}</td>
	                		<td class="red_01">resdetdtl.comresid</td>
	                		<td class="red_01">resdetdtl.boxnum</td>
			            </tr>
              	</table>-->
				<!-- 订单基本信息 End-->
              	<BR> 
				<div style="text-align:center"><c:if test="${waitCon}">
					<INPUT type="button" class="btn_blue_75" value="确认订购" id="cnfrmOrder" style="width:75px;">
					<INPUT type="button" class="btn_blue_75" value="放弃订购" id="cancelOrder" style="width:75px;"></c:if>
					<input type="button" class="btn_blue_75" value="关 闭" style="width:75px;" onClick="window.parent.closePage();"></div>
		</div>
</body>
<!-- 公共JS文件 -->
<%@ include file="/common/meta_js.jsp"%>
<script type="text/javascript" src="${ctx}/js/jQuery/table/jquery.table.js" ></script>
<script type="text/javascript">
// 订购商品种类列信息
var showComcatesCols = ${showComcatesCols};//取后台列设置类数组，对应如下  //dataKey,key,name,width
//表格配置数组
var optin = {
	tableID:"tblComcates",
	showCols:showComcatesCols,//显示列
	//fmtLink:fmtLink,//用户自定义单元格内容
	pageSize:5,//页内大小
	navigation:$("#comcateNavigation"),//翻页位置 jq对象
	width:"100%",
	queryFrom: $("#frmComcatesQuery")//查询表单
};

// 订购资源明细列信息
var showResdetsCols = ${showResdetsCols};//取后台列设置类数组，对应如下  //dataKey,key,name,width
//表格配置数组
var optin2 = {
	tableID:"tblResdets",
	showCols:showResdetsCols,//显示列
	//fmtLink:fmtLink,//用户自定义单元格内容
	pageSize:5,//页内大小
	navigation:$("#resdetsNavigation"),//翻页位置 jq对象
	width:"100%",
	queryFrom: $("#frmResdetsQuery")//查询表单
};

//页面初始化完成时调用
	$(document).ready(function() {
		$("#showComcateTbl").queryTable(optin);
		$("#showResdetsTbl").queryTable(optin2);
		
		//绑定确认的方法
		$("#cnfrmOrder").click(doConfirmOrder);
		$("#cancelOrder").click(doCancelOrder);
	});

//确认订购
var doConfirmOrder = function(){
	if (window.confirm('您要确认订购么？')){
		sPaln = f_showPlan("正在处理中，请稍候。");
		//$(":button").attr("disabled",true);
		window.parent.plsQuery = true;
		$("#frmCnfrmOrder").submit();
	}
}
//取消订购
var doCancelOrder = function(){
	if (window.confirm('您要放弃订购么？')){
		sPaln = f_showPlan("正在处理中，请稍候。");
		window.parent.plsQuery = true;
		$("#frmCancelOrder").submit();
	}
}

</script>
</html>