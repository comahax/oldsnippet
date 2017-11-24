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
				<!-- 订单基本信息 Begin-->
                 <div class="listboxtitle">我的购物车明细</div>
				<table class = "tb02" width="100%">
						<tr>
							<td class="textRight" width="15%">卡类型：</td>
							<td>${saveGoods.type}</td>
   						</tr>
   						<tr>
   							<td class="textRight">包号：</td>
							<td >${saveGoods.name}</td>
   						</tr>
   						<tr>
   						  <td class="textRight">号码明细：</td>
   						  <td>${saveGoods.mobiles}</td>
				  </tr>
					</table>                    
              	<BR> 
				<div style="text-align:center">
				<input type="button" class="btn_blue_75" value="关 闭" onClick="window.parent.closePage();"></div>
		</div>
</body>
<!-- 公共JS文件 -->
<%@ include file="/common/meta_js.jsp"%>
</html>