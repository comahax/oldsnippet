<%@ page contentType="text/html;charset=GBK"%>
<%@ include file="/common/jspHead.jsp"%>
<html>
<head>
<!-- ����CSS�ļ� -->
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
	<!-- ͷ�������� -->
        <div style="width:100%;text-align:left;">
<form action="ajaxComcateQuery.do" method="POST" id="frmComcatesQuery">
<INPUT TYPE="hidden" NAME="orderid" value="${orderid}">
</form>
<form action="ajaxResdetsQuery.do" method="POST" id="frmResdetsQuery">
<INPUT TYPE="hidden" NAME="orderid" value="${orderid}">
</form>
				<!-- ����������Ϣ Begin-->
                 <div class="listboxtitle">�ҵĹ��ﳵ��ϸ</div>
				<table class = "tb02" width="100%">
						<tr>
							<td class="textRight" width="15%">�����ͣ�</td>
							<td>${saveGoods.type}</td>
   						</tr>
   						<tr>
   							<td class="textRight">���ţ�</td>
							<td >${saveGoods.name}</td>
   						</tr>
   						<tr>
   						  <td class="textRight">������ϸ��</td>
   						  <td>${saveGoods.mobiles}</td>
				  </tr>
					</table>                    
              	<BR> 
				<div style="text-align:center">
				<input type="button" class="btn_blue_75" value="�� ��" onClick="window.parent.closePage();"></div>
		</div>
</body>
<!-- ����JS�ļ� -->
<%@ include file="/common/meta_js.jsp"%>
</html>