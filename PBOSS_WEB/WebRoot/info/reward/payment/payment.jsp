<%@ page contentType="text/html;charset=GBK" pageEncoding="GBK"%>
<%@ include file="/common/jspHead.jsp"%>
<html>
<head>
<title>���һ�廯����</title>
<!-- ������̬�ļ� -->
<%@ include file="/common/meta_allcss.jsp"%>
</head>

<body>
	<!-- ͷ�� -->
	<%@ include file="/common/include/inc_gdhead.jsp"%>
	<!--��׼���ݿ�ʼ-->
	<div class="divspan">
			<!-- ��������-->
		<%@ include file="/common/include/inc_citymenu.jsp"%>
        <div class="context">
			<div class="listmyposition">
				<span class="font_breadcrumbtitle">�����ڵ�λ�ã�</span><span class="font_breadcrumb">${location}</span>
			</div>
           
			<form action="/gdView/paymentAjax.do" method="POST" id="frmQuery"> 
			<div class="listboxtitle">��������</div>
            <table class="tb02" width="100%">
			  <tr>
				
				<td class="input_label" align="right">�����·ݣ�</td>
				<td>
				 <select name="rewardmonth" class="select_3L" id="selMonth" orgval="${rewardmonth}"></select>  <font color='red'>*</font>  </td>
					 
				</td>
			
				 <td align="center">
				 <input name="btnQuery" type="button" id="btnQuery" value="���ر���" class="btn_blue_75" />
				 </td>
				 
		 </tr> 
	  
			</table>
			</form>
    <!--������Ϣ��ʼ-->
	<div class="listboxlist">
			
			<span id="showTbl"></span>
			<table class="page_table">
				<tr valign="middle">
					<td align="left" height="30">&nbsp;&nbsp;</td>
					<td align="right" style="font-size:12px;" id="navigation"></td>
				</tr>
			</table>
          
          </div>
      
     <!--������Ϣ����-->
           
        </div>
	</div>
			<!--��׼���ݽ���-->
	<%@ include file="/common/include/inc_foot.jsp"%>
	<div id="_rndImageDIV" style="border:solid 1px #545454;position:absolute;background:#E8FBFF;padding:3px;display:none;zIndex:3000"></div>
</body>
<%@include file="/common/meta_js.jsp"%>
<script type="text/javascript" src="${ctx}/js/jQuery/table/jquery.table.js" ></script>
<script type="text/javascript" src="${ctx}/js/biz/info/reward/common.js"></script>
<script type="text/javascript" src="${ctx}/js/biz/info/reward/payment/payment.js"></script> 
</html>