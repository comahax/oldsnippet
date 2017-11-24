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
	<!-- ͷ�� -->
	<%@ include file="/common/include/inc_head.jsp"%>	
	<!--��׼���ݿ�ʼ-->
	<div class="divspan">
			<!-- ��������-->
		<%@ include file="/common/include/inc_menu.jsp"%>
	<!-- ͷ�������� -->
        <div class="context">
			<div class="listmyposition">
				<span class="font_breadcrumbtitle">�����ڵ�λ�ã�</span><span class="font_breadcrumb">${location}</span>
			</div>
        <div style="width:100%;text-align:left;">
<form action="ajaxComcateQuery.do" method="POST" id="frmComcatesQuery">
<INPUT TYPE="hidden" NAME="orderid" value="${orderid}">
</form>
<form action="ajaxResdetsQuery.do" method="POST" id="frmResdetsQuery">
<INPUT TYPE="hidden" NAME="orderid" value="${orderid}">
</form>
<form action="cnfrmOrder.do" method="POST" id="frmCnfrmOrder">
<INPUT TYPE="hidden" NAME="orderid" value="${orderid}">
<INPUT TYPE="hidden" NAME="advId" value="${advId}">
</form>
<form action="cancelOrder.do" method="POST" id="frmCancelOrder">
<INPUT TYPE="hidden" NAME="orderid" value="${orderid}">
<INPUT TYPE="hidden" NAME="advId" value="${advId}">
</form>
				<!-- ����������Ϣ Begin-->
                 <div class="listboxtitle">����������Ϣ</div>
				<table class = "tb02" width="100%">
						<tr>
							<td class="textRight" width="15%">������ţ�</td>
							<td colspan="3">${orderDtl.orderid}</td>
   						</tr>
   						<tr>
   							<td class="textRight">����;����</td>
							<td width="35%" >${orderDtl.orderaveName}</td>
					      <td width="15%"  class="textRight">����״̬��</td>
   						    <td >${orderDtl.orderstateName}</td>
   						</tr>
   						<tr>
   							<td class="textRight">Ӧ����</td>
							<td width="35%" >${orderDtl.recamt} Ԫ</td>
					      <td width="15%"  class="textRight">�Ѹ���</td>
   						    <td >${orderDtl.actamt} Ԫ</td>
   						</tr>
   						<tr>
   						  <td class="textRight">�������ƣ�</td>
   						  <td>${wayname}</td>
   						  <td class="textRight">�����������ڣ�</td>
   						  <td><fmt:formatDate value="${orderDtl.createtime}" type="both" pattern="yyyy-MM-dd HH:mm"/></td>
				  </tr>
					</table>
                    
				<!-- ������Ʒ���� -->
                 <div class="listboxtitle">������Ʒ���ࣺ</div>
			<span id="showComcateTbl"></span>
			<table class="page_table">
				<tr valign="middle">
					<td align="left" height="30">&nbsp;&nbsp;</td>
					<td align="right" style="font-size:12px;" id="comcateNavigation"></td>
				</tr>
			</table>
			<!--����
				<table class = "tb_comn" width="96%">
					<thead>
						<tr>
							<td>��Ʒ����</td>
							<td>��������</td>
							<td>��Ʒ����</td>
							<td>��Ʒ�ܼ�</td>
							<td>��ע</td>
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
				<!-- ������Դ��ϸ -->
                 <div class="listboxtitle">������Դ��ϸ��</div>				
			<span id="showResdetsTbl"></span>
			<table class="page_table">
				<tr valign="middle">
					<td align="left" height="30">&nbsp;&nbsp;</td>
					<td align="right" style="font-size:12px;" id="resdetsNavigation"></td>
				</tr>
			</table>
			<!--��ʹ��
				<table class = "tb_comn" width="96%">
	              	<thead>
	                    <tr>
	                    	 <td>��Ʒ����</td>
		                     <td>�׿�/��ֵ������</td>
		                     <td>��������</td>
	                    </tr>
	                </thead>
                 		<tr>
	                		<td class="red_01">resdetdtl.comcategoryName}</td>
	                		<td class="red_01">resdetdtl.comresid</td>
	                		<td class="red_01">resdetdtl.boxnum</td>
			            </tr>
              	</table>-->
				<!-- ����������Ϣ End-->
              	<BR> 
				<div style="text-align:center"><c:if test="${waitCon}">
					<INPUT type="button" class="btn_blue_75" value="ȷ�϶���" id="cnfrmOrder" style="width:75px;">
					<INPUT type="button" class="btn_blue_75" value="��������" id="cancelOrder" style="width:75px;"></c:if>
					<input type="button" class="btn_blue_75" value="������ҳ" style="width:75px;" onClick="window.location='/';"></div>
		</div>
        </div>
		<!--��׼���ݽ���-->
	<%@ include file="/common/include/inc_foot.jsp"%>
     </div>
</body>
<!-- ����JS�ļ� -->
<%@ include file="/common/meta_js.jsp"%>
<script type="text/javascript" src="${ctx}/js/jQuery/table/jquery.table.js" ></script>
<script type="text/javascript">
// ������Ʒ��������Ϣ
var showComcatesCols = ${showComcatesCols};//ȡ��̨�����������飬��Ӧ����  //dataKey,key,name,width
//�����������
var optin = {
	tableID:"tblComcates",
	showCols:showComcatesCols,//��ʾ��
	//fmtLink:fmtLink,//�û��Զ��嵥Ԫ������
	pageSize:5,//ҳ�ڴ�С
	navigation:$("#comcateNavigation"),//��ҳλ�� jq����
	width:"100%",
	queryFrom: $("#frmComcatesQuery")//��ѯ��
};

// ������Դ��ϸ����Ϣ
var showResdetsCols = ${showResdetsCols};//ȡ��̨�����������飬��Ӧ����  //dataKey,key,name,width
//�����������
var optin2 = {
	tableID:"tblResdets",
	showCols:showResdetsCols,//��ʾ��
	//fmtLink:fmtLink,//�û��Զ��嵥Ԫ������
	pageSize:5,//ҳ�ڴ�С
	navigation:$("#resdetsNavigation"),//��ҳλ�� jq����
	width:"100%",
	queryFrom: $("#frmResdetsQuery")//��ѯ��
};

//ҳ���ʼ�����ʱ����
	$(document).ready(function() {
		$("#showComcateTbl").queryTable(optin);
		$("#showResdetsTbl").queryTable(optin2);
		
		//�󶨲��Եķ���
		$("#cnfrmOrder").click(doConfirmOrder);
		$("#cancelOrder").click(doCancelOrder);
		
	});

//ȷ�϶���
var doConfirmOrder = function(){
	if (window.confirm('��Ҫȷ�϶���ô��')){
		sPaln = f_showPlan("���ڴ����У����Ժ�");
		$("#frmCnfrmOrder").submit();
	}
}
//ȡ������
var doCancelOrder = function(){
	if (window.confirm('��Ҫ��������ô��')){
		sPaln = f_showPlan("���ڴ����У����Ժ�");
		$("#frmCancelOrder").submit();
	}
}
</script>
</html>