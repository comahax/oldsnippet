<%@ page contentType="text/html;charset=GBK" pageEncoding="GBK"%>
<%@ include file="/common/jspHead.jsp"%>
<html>
<head>
<title>酬金一体化报表</title>
<!-- 公共静态文件 -->
<%@ include file="/common/meta_allcss.jsp"%>
</head>

<body>
	<!-- 头部 -->
	<%@ include file="/common/include/inc_gdhead.jsp"%>
	<!--标准内容开始-->
	<div class="divspan">
			<!-- 左则功能区-->
		<%@ include file="/common/include/inc_citymenu.jsp"%>
        <div class="context">
			<div class="listmyposition">
				<span class="font_breadcrumbtitle">您现在的位置：</span><span class="font_breadcrumb">${location}</span>
			</div>
           
			<form action="/gdView/paymentAjax.do" method="POST" id="frmQuery"> 
			<div class="listboxtitle">下载条件</div>
            <table class="tb02" width="100%">
			  <tr>
				
				<td class="input_label" align="right">付款月份：</td>
				<td>
				 <select name="rewardmonth" class="select_3L" id="selMonth" orgval="${rewardmonth}"></select>  <font color='red'>*</font>  </td>
					 
				</td>
			
				 <td align="center">
				 <input name="btnQuery" type="button" id="btnQuery" value="下载报表" class="btn_blue_75" />
				 </td>
				 
		 </tr> 
	  
			</table>
			</form>
    <!--帮助信息开始-->
	<div class="listboxlist">
			
			<span id="showTbl"></span>
			<table class="page_table">
				<tr valign="middle">
					<td align="left" height="30">&nbsp;&nbsp;</td>
					<td align="right" style="font-size:12px;" id="navigation"></td>
				</tr>
			</table>
          
          </div>
      
     <!--帮助信息结束-->
           
        </div>
	</div>
			<!--标准内容结束-->
	<%@ include file="/common/include/inc_foot.jsp"%>
	<div id="_rndImageDIV" style="border:solid 1px #545454;position:absolute;background:#E8FBFF;padding:3px;display:none;zIndex:3000"></div>
</body>
<%@include file="/common/meta_js.jsp"%>
<script type="text/javascript" src="${ctx}/js/jQuery/table/jquery.table.js" ></script>
<script type="text/javascript" src="${ctx}/js/biz/info/reward/common.js"></script>
<script type="text/javascript" src="${ctx}/js/biz/info/reward/payment/payment.js"></script> 
</html>