<%@ page contentType="text/html;charset=GBK"%>
<%@ include file="/common/jspHead.jsp"%>
<html>
<head>
<!-- ����CSS�ļ� -->
<%@ include file="/common/meta_allcss.jsp"%>
<jsp:useBean id="constants"  class="com.gmcc.pboss.common.dictionary.ConstantsType" />
<c:if test='${orderDtl.disstate eq constants.DISSTATE_WAITDIS}'><%--������ʱ����ʾ�������Ͱ�ť--%>
<c:set var="final" value="${constants.DISSTATE_DISING}" />
</c:if><c:if test='${orderDtl.disstate eq constants.DISSTATE_DISING}'><%--������ʱ����ʾ������Ͱ�ť--%>
<c:set var="final" value="${constants.DISSTATE_DISOVER}" /></c:if>
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
<form action="ajaxModify.do" method="POST" id="frmModify">
<INPUT TYPE="hidden" NAME="parameter.recids" value="${recid}">
<INPUT TYPE="hidden" NAME="parameter.disstate" value="${final}">
</form>
	<!-- ͷ�������� -->
        <div style="width:100%;text-align:left;">
<form action="ajaxComcateQuery.do" method="POST" id="frmComcatesQuery">
<INPUT TYPE="hidden" NAME="orderid" value="${orderid}">
</form>
<form action="ajaxResdetsQuery.do" method="POST" id="frmResdetsQuery">
<INPUT TYPE="hidden" NAME="orderid" value="${orderid}">
</form>
				<!-- ����������Ϣ Begin-->
                 <div class="listboxtitle">���͵�������Ϣ</div>
				<table class = "tb02" width="100%">
						<tr>
						  <td class="textRight">���͵��ţ�</td>
						  <td>${orderDtl.recid}</td>
							<td class="textRight">������ţ�</td>
					        <td>${orderDtl.orderid}</td>
						</tr>
   						<tr>
   							<td class="textRight">�ջ����㣺</td>
							<td width="35%" >${orderDtl.datas.wayname}</td>
					      <td width="15%"  class="textRight">�ջ�������</td>
   						    <td >${orderDtl.recename}</td>
   						</tr>
   						<tr>
   						  <td class="textRight">�ֹ�˾��</td>
   						  <td colspan="3">${orderDtl.datas.countyName}</td>
				  </tr>
   						<tr>
   						  <td class="textRight">�ջ��˵绰��</td>
   						  <td>${orderDtl.recetel}</td>
   						  <td  class="textRight">�ɷѷ�ʽ��</td>
   						  <td >${orderDtl.paytypeName}</td>
				  </tr>
   						<tr>
   						  <td class="textRight">�ջ��˵�ַ��</td>
   						  <td colspan="3">${orderDtl.receadd}</td>
				  </tr>
   						<tr>
   						  <td class="textRight">����ʱ�䣺</td>
   						  <td>${orderDtl.createtime}</td>
   						  <td  class="textRight">Ҫ��ﵽʱ�䣺</td>
   						  <td >${orderDtl.arrivetime}</td>
				  </tr>
   						<tr>
   						  <td class="textRight">ǩ��״̬��</td>
   						  <td>${orderDtl.signstateName}</td>
   						  <td  class="textRight">�����̵�״̬��</td>
   						  <td >${orderDtl.disstateName}
						  <c:if test='${orderDtl.disstate eq constants.DISSTATE_WAITDIS}'><%--������ʱ����ʾ�������Ͱ�ť--%>
			<input name="btnsetDis" type="button" id="btnsetDis" value="��������" class="btn_blue_75" style="width:75px;" onclick="doAJAXMdf()"/>
			</c:if><c:if test='${orderDtl.disstate eq constants.DISSTATE_DISING}'><%--������ʱ����ʾ������Ͱ�ť--%>
			<input name="btnsetDis" type="button" id="btnsetDis" value="�������" class="btn_blue_75" style="width:75px;" onclick="doAJAXMdf()" />
			</c:if></td>
				  <tr>
				  	<td class="textRight">�������ţ�</td>
				  	<td colspan="3">
				  	<form action="ajaxModify.do" method="POST" id="frmModifyLogi">
					<INPUT TYPE="hidden" NAME="parameter.recid" value="${recid}"/>	
					<input type="hidden" name="parameter.modlogi" value="true"/>				
				  	<input name="parameter.logisticsno" value="${orderDtl.logisticsno}" class="text_01" id="logisticsno" style="width:200px" maxlength="32"/>
				  	(ע:������32λ����ĸ������)
				  	</form>
				  	</td>
				  </tr>
   						<tr>
   						  <td class="textRight">��ע��</td>
   						  <td colspan="3">${orderDtl.memo}</td>
				  </tr>
					</table>
                 <div class="listboxtitle">������Դ��ϸ��</div>
				<table class = "tb_comn" width="100%">
	              	<thead>
	                    <tr>
	                    	 <td>��Ʒ����</td>
		                     <td>��λ</td>
		                     <td>����</td>
		                     <td>��Ʒ���</td>
		                     <td>���</td>
		                     <td>��ע</td>
	                    </tr>
	                </thead>
                  	<tbody>
					<c:forEach items="${comcates}" var="dtl" varStatus="i">
                 		<tr>
	                		<td class="red_01">${dtl.comcategoryName}</td>
			                <td class="red_01">${dtl.comcateUtil} </td>
			                <td class="red_01">${dtl.orderamt}</td>
			                <td class="red_01">${dtl.odrPackageInfo}</td>
			                <td class="red_01">${dtl.totalprice}</td>
			                <td class="red_01">${dtl.ordercomtypeName}</td>
			            </tr>
					</c:forEach>
		         	</tbody>
              	</table>
				<div style="text-align:center;padding-top:5px;">
				<input type="button" id="btnSubmit" class="btn_blue_75" value="�� ��" onClick="doAJAXlogisticsno()">
				<input type="button" id="btnClose" class="btn_blue_75" value="�� ��" onClick="window.parent.closePage();"></div>
		</div>
</body>
<!-- ����JS�ļ� -->
<%@ include file="/common/meta_js.jsp"%>

<script type="text/javascript" src="${ctx}/js/jQuery/table/jquery.table.js" ></script>
<script type="text/javascript">
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
		//$("#showResdetsTbl").queryTable(optin2);
		window.parent.plsQuery = false;
	});

	
//Ajax�ύ���̣�msgΪ�ɹ�����ʾ����Ϣ
var doAJAXMdf = function(msg){
	setMdfBtn(true);//�����޸İ�ť
	//var _o_li = f_showPlan("�����У����Ժ�")
	//AJAX�ύ
	var fromSuccuss = function(josnObj) {
		//_o_li.close();
		if (josnObj["isSuccess"]) {
			//�޸ĳɹ�
			alert("����ɹ�!");
			//$("#disstate").val("");
			window.parent.plsQuery = true;
			window.parent.closePage();
			//doQuery();
		}else{
			alert(josnObj["message"]);
			setMdfBtn(false);//�ָ�����
		}
	}//fromSuccuss
	//ajaxForm ����
	var ajaxOpn = {
		dataType:'json',
		//url:formUrl,
		success:fromSuccuss
	}
	$("#frmModify").ajaxSubmit(ajaxOpn);
	//ajax
}

var doAJAXlogisticsno = function(msg){
	setMdfBtn(true);//�����޸İ�ť
	var fromSuccuss = function(josnObj) {
		//_o_li.close();
		if (josnObj["isSuccess"]) {
			//�޸ĳɹ�
			alert("����ɹ�!");
			//$("#disstate").val("");
			window.parent.plsQuery = true;
			//window.parent.closePage();
			//doQuery();
			setMdfBtn(false);//�ָ�����
		}else{
			alert(josnObj["message"]);
			setMdfBtn(false);//�ָ�����
		}
	}//fromSuccuss
	//ajaxForm ����
	var ajaxOpn = {
		dataType:'json',
		//url:formUrl,
		success:fromSuccuss
	}
	$("#frmModifyLogi").ajaxSubmit(ajaxOpn);
}

//�����޸İ�ť������
var setMdfBtn = function(setBln){
	$("#btnsetDis").attr("disabled",setBln);//���ΰ�ť
	$("#btnClose").attr("disabled",setBln);//���ΰ�ť
	$("#btnSubmit").attr("disabled",setBln);
}
</script>
</html>