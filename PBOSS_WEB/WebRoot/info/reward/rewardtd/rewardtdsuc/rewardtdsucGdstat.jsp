<%@ page contentType="text/html;charset=GBK" pageEncoding="GBK"%>
<%@ include file="/common/jspHead.jsp"%>
<html>
<head>
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
			
			<s:form action="/gdView/rewardTdSucAjax.do" method="POST" id="frmQuery"> 
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
					<select name="parameter.rewardmonth" class="select_3L" id="rewardmonth" orgval="${parameter.rewardmonth}"></select> </td>
					 
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
				
				<td class="input_label" align="right">�����·ݣ�</td>
				<td> 
					<select name="parameter.repairmonth" class="select_3L" id="repairmonth" orgval="${parameter.repairmonth}"></select>  </td>
				</td>  
		 </tr>
		  <tr>
		  	<td class="input_label" align="right">���У�</td>
				<td>
				 <select name ="parameter.city" id="parameter.city">
	  			    <option value="GZ" >����</option>
	  			    <option value="SZ" >����</option>
	  			    <option value="ZH" >�麣</option> 
	  			    <option value="FS" >��ɽ</option>
	  			    <option value="ST" >��ͷ</option>
	  			    <option value="HZ" >����</option> 
	  			    <option value="ZJ" >տ��</option>
	  			    <option value="JM" >����</option>
	  			    <option value="ZQ" >����</option> 
	  			    <option value="SG" >�ع�</option>
	  			    <option value="MZ" >÷��</option>
	  			    <option value="DG" >��ݸ</option> 
	  			    <option value="ZS" >��ɽ</option>
	  			    <option value="MM" >ï��</option>
	  			    <option value="SW" >��β</option> 
	  			    <option value="CZ" >����</option> 
	  			    <option value="JY" >����</option> 
	  			    <option value="YJ" >����</option> 
	  			    <option value="QY" >��Զ</option> 
	  	            <option value="HY" >��Դ</option> 
	  		        <option value="YF" >�Ƹ�</option> 
	  		     </select>	
				</td> 
				 <td colspan="2"  align="center">
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
      				  <p>1.ͳ�Ƹ�ҵ��<font color='red'>�ն˼Ƴ�ɹ���ϸ</font>��</p>
    				</div>
               </div>
               <div class="column">
                 <div class="listboxtitle">��ܰ���ѣ�</div>
                    <div class="reminder">
				       <p>1.��ѯ������<font color='red'>�������·ݡ����������·ݡ� ����ͬʱΪ��</font>��
				       
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
<script type="text/javascript" src="${ctx}/js/biz/info/reward/rewardtd/rewardtdsuc/rewardtdsucGdstat.js"></script>

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