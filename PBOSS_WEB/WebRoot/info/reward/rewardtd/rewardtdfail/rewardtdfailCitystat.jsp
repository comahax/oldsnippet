<%@ page contentType="text/html;charset=GBK" pageEncoding="GBK"%>
<%@ page import="com.gmcc.pboss.common.constant.Constant" %>
<%@ include file="/common/jspHead.jsp"%>
<html>
<head>
<!-- ������̬�ļ� -->
<%@ include file="/common/meta_allcss.jsp"%>
</head>
<body>
	<!-- ͷ�� -->
	<%@ include file="/common/include/inc_cityhead.jsp"%>	
	<!--��׼���ݿ�ʼ-->
	<div class="divspan">
			<!-- ��������-->
		<%@ include file="/common/include/inc_citymenu.jsp"%>
        <div class="context">
			<div class="listmyposition">
				<span class="font_breadcrumbtitle">�����ڵ�λ�ã�</span><span class="font_breadcrumb">${location}</span>
			</div>
			
			<s:form action="/cityView/rewardTdFailAjax.do" method="POST" id="frmQuery"> 
			<div class="listboxtitle">��ѯ����</div>
            <table class="tb02" width="100%">
			  <tr>
					<td class="input_label" align="right">������룺</td>
				<td>
					<s:textfield cssClass="style_input" name="parameter.wayid" id="wayid"/>
					<font color='red'>*</font>
					<input type="button" class="" value="..." id="btnWaySelect" onclick="f_waySelect()"/>
				</td>
				<td class="input_label" align="right">�����·ݣ�</td>
				<td>
					 <select name="parameter.rewardmonth" class="select_3L" id="selMonth" orgval="${parameter.rewardmonth}"></select>  <font color='red'>*</font>  </td>
					 
				</td>
			 </tr>
			 <tr> 
			    
				<td class="input_label" align="right">������ͣ�</td>
				<td>
				 <select name ="parameter.rewardtype" id="parameter.rewardtype">
				    <option value="" ></option>
	  			    <option value="1" >��Լ�ն˳��</option>
	  			    <option value="2" >����ն˳��</option> 
	  		     </select>	
				</td> 
				 <td class="input_label" align="right">���У�</td>
				<td>
				<%=Constant.getConstantName(ConstantsType.BRANCH_NAME,_member.getCityid()) %>
				</td> 
				 
		 </tr> 
	   <tr> 
			    
			
				 <td colspan="4"  align="center">
						<input name="btnQuery" type="button" id="btnQuery" value="��ѯ" class="btn_blue_75" />&nbsp;&nbsp;  
						<input name="btnExportExcel" type="button" id="btnExportExcel" value="����" class="btn_blue_75" />&nbsp;&nbsp;	
				 </td>
				 
		 </tr> 
			</table>
			</s:form>
			<div class="listboxlist">
			<div class="listboxtitle">�����</div>
			<span id="showTbl"></span>
			<table class="page_table">
				<tr valign="middle">
					<td align="left" height="30">&nbsp;&nbsp;</td>
					<td align="right" style="font-size:12px;" id="navigation"></td>
				</tr>
			</table>
            <br>
            <!--������Ϣ��ʼ-->
            <div class="column">
                 <div class="listboxtitle">����˵����</div>
                   <div class="reminder">
      				  <p>1.ͳ�Ƹ�ҵ��<font color='red'>�ն˼Ƴ�ʧ����ϸ</font>��</p>
    				</div>
               </div>
               <div class="column">
                 <div class="listboxtitle">��ܰ���ѣ�</div>
                    <div class="reminder">
				       <p>1.��ѯ������<font color='red'>�������·ݡ�</font>����Ϊ<font color='red'>6λ��Ч���£�����</font>����201109����ֻ�ܲ�ѯ��T-3���µ����ݡ���TΪ��ǰ�£�</p>
   				 </div>
               </div>
          </div>
		</div>
		<!--��׼���ݽ���-->
	<%@ include file="/common/include/inc_foot.jsp"%>
</div>
<iframe name="content" style="display: none;"></iframe>
</body>
<%@include file="/common/meta_js.jsp"%>
<script type="text/javascript" src="${ctx}/js/jQuery/table/jquery.table.js" ></script>
<script type="text/javascript" src="${ctx}/js/biz/info/reward/common.js"></script>
<script type="text/javascript" src="${ctx}/js/biz/info/reward/rewardtd/rewardtdfail/rewardtdfailCitystat.js"></script> 
<SCRIPT type="text/javascript">
//<!--
// ��ѯ��ʾ����Ϣ
var showCols = ${ShowCols};//ȡ��̨�����������飬��Ӧ����  //dataKey,key,name,width
//�����������
var optin = {
	showCols:showCols,//��ʾ��
	fmtLink:fmtLink,//�û��Զ��嵥Ԫ������
	pageSize:10,//ҳ�ڴ�С
	navigation:$("#navigation"),//��ҳλ�� jq����
	unableBtu:$('#btnQuery'),
	width:"100%",
	queryFrom: $("#frmQuery")//��ѯ��
};
//-->
function f_waySelect(){
	var url="/magSaleDetail/waySelect.do";
	var rtn=window.showModalDialog(url,null,"dialogWidth:900px; dialogHeight:450px; status:no; resizable:no;");
    if (rtn != null && rtn.length) {
	   document.getElementById("wayid").value = rtn;//[0]
	   return rtn;
	}
}
</SCRIPT>
</html>