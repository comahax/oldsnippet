<%@ page contentType="text/html;charset=GBK" pageEncoding="GBK"%>
<%@ include file="/common/jspHead.jsp"%>
<html>
<head>
<!-- ������̬�ļ� -->
<%@ include file="/common/meta_allcss.jsp"%>
</head>
<body>
	<!-- ͷ�� -->
	<%@ include file="/common/include/inc_head.jsp"%>	
	<!--��׼���ݿ�ʼ-->
	<div class="divspan">
			<!-- ��������-->
		<%@ include file="/common/include/inc_menu.jsp"%>
        <div class="context">
			<div class="listmyposition">
				<span class="font_breadcrumbtitle">�����ڵ�λ�ã�</span><span class="font_breadcrumb">${location}</span>
			</div>
			
			<s:form action="/reward/adjustmentAjax.do" method="POST" id="frmQuery">
			<s:hidden name="parameter.supportPaymonth" id="supportPaymonth"></s:hidden>
	        <s:hidden name="parameter.supportFee" id="supportFee"></s:hidden>
			<div class="listboxtitle">��ѯ����</div>
            <table class="tb02" width="100%">
			  <tr>
				<td class="input_label" align="right">������룺</td>
				<td>
					${_PBOSS_WEB_USER.channel.wayid}
				</td>
				<td class="input_label" align="right">�����·ݣ�</td>
				<td>
					<input type="text" name="parameter.rewardmonth" value="${parameter.rewardmonth}" class="style_input" maxlength="6" id="rewardmonth">
					<s:if test="!parameter.supportPaymonth"><font color='red'>*</font></s:if>(��:201109)
				</td>
			 </tr>
			 <tr> 
			    <s:if test="parameter.supportPaymonth">
				<td class="input_label" align="right">�����·ݣ�</td>
				<td>
					<input type="text" name="parameter.paymonth" value="${parameter.paymonth}" class="style_input" maxlength="6" id="paymonth">
					(��:201109)
				</td> 
				</s:if>
				 <td colspan="4"  align="center">
						<input name="btnQuery" type="button" id="btnQuery" value="��ѯ" class="btn_blue_75" />&nbsp;&nbsp;	
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
      				  <p>1.ͳ�Ƹ�ҵ��<font color='red'>˰����</font>��</p>
    				</div>
               </div>
               <div class="column">
                 <div class="listboxtitle">��ܰ���ѣ�</div>
                    <div class="reminder">
				       <s:if test="!parameter.supportPaymonth">
				       <p>1.��ѯ������<font color='red'>�������·ݡ�</font>����Ϊ<font color='red'>6λ��Ч���£�����</font>����201109��</p>
				       </s:if>
				       <s:else>
				       <p>1.��ѯ������<font color='red'>�������·ݡ����������·ݡ�</font>����Ϊ<font color='red'>6λ��Ч���£�����ͬʱΪ��</font>����201109��</p>
				       </s:else>
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
<script type="text/javascript" src="${ctx}/js/biz/info/reward/adjustment/adjustmentstat.js"></script>
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
</SCRIPT>
</html>