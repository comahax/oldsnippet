<%@ page contentType="text/html;charset=GBK" pageEncoding="GBK"%>
<%@ include file="/common/jspHead.jsp"%>
<html>
<head>
<!-- ������̬�ļ� -->
<%@ include file="/common/meta_allcss.jsp"%>
</head>
<body>
<!-- ͷ�������� -->
<%@ include file="/common/include/inc_head.jsp"%>	
<!--��׼���ݿ�ʼ-->
<div class="divspan">
<!-- ��������-->
<%@ include file="/common/include/inc_menu.jsp"%>
<div class="context">
<div class="listmyposition">
	<span class="font_breadcrumbtitle">�����ڵ�λ�ã�</span><span class="font_breadcrumb">${location}</span>
</div>

<s:form action="/reward/cityrecordStat.do" method="POST" id="frmQuery" onsubmit="return doSubmit();">
	<s:hidden name="parameter.supportPaymonth" id="supportPaymonth"></s:hidden>
	<div class="listboxtitle">��ѯ����</div>
    <table class="tb02" width="100%">
	  <tr>
		<td class="input_label" align="right">������룺</td>
		<td>
			${_PBOSS_WEB_USER.channel.wayid}
		</td>
		<td class="input_label" align="right">�����·ݣ�</td>
		<td>
			<input type="text" name="parameter.month" value="${parameter.month}" class="style_input" maxlength="6" id="month">
			<s:if test="!parameter.supportPaymonth"><font color='red'>*</font></s:if>(��:201109)
		</td>
	  </tr>
	  <tr>
	  	<td class="input_label" align="right">ҵ�����£�</td>
	    <td>
			<input type="text" name="parameter.oprmonth" value="${parameter.oprmonth}" class="style_input" maxlength="6" id="oprmonth">
			(��:201109)
		</td>
	    <s:if test="parameter.supportPaymonth">
		<td class="input_label" align="right">�����·ݣ�</td>
		<td>
			<input type="text" name="parameter.paymonth" value="${parameter.paymonth}" class="style_input" maxlength="6" id="paymonth">
			(��:201109)
		</td>
		</s:if>
	  </tr>
	  <tr>		
	     <td colspan="4"  align="center">
			<input type="submit" id="submit" value="�� ѯ" class="btn_blue_75" />&nbsp;&nbsp;	
		 </td>
	</tr>
	</table>
</s:form>

<div class="column">
<font color='red'><s:actionmessage/></font>
<div class="listboxtitle">������ϸ</div>
<s:if test="retlist.size>0">
<table class = "tb_comn" width="100%">	
	<thead >
		<tr align="center">
			<td>ҵ������</td>
			<td>ҵ�����</td>
			<td>�������</td>
			<td>ҵ������</td>
			<td>������</td>
			<td>����Ӧ�����</td>
			<td>����</td>
			
		</tr>
	</thead>
	<s:iterator value="retlist">
       <tr align="center" >					
		<s:if test="opn1count > 0">
		<td rowspan="<s:property value="opn1count"/>"><s:property value="opn1name"/></td>
		</s:if>
		<s:if test="opn2count > 0">
		<td rowspan="<s:property value="opn2count"/>"><s:property value="opn2name"/></td>
		</s:if>
		<s:if test="rewardcount > 0">
		<td rowspan="<s:property value="rewardcount"/>"><s:property value="rewardname"/></td>
		</s:if>
		<td><s:property value="oprmonth"/></td>
		<td><s:property value="busitotal"/></td>
		<td><s:property value="paytotal"/></td>	
		<td>
		<input type="button" id="reset" value="�� ϸ" class="btn_blue_75" 
			onclick="doShowDetail('${_PBOSS_WEB_USER.channel.wayid }','${opnid2}','${rewardtype}','${parameter.month}','${oprmonth}','${parameter.supportPaymonth}','${parameter.paymonth}');"/>
		</td>		
     </tr>
   </s:iterator>
   <tr align="center" >	
   	<td>&nbsp;</td><td >&nbsp;</td><td >&nbsp;</td><td >&nbsp;</td>
   	<td align="right">˰ǰ���</td>
   	<td align="left"><s:property value="paytotal"/></td>
   	<td>&nbsp;</td>
   </tr>	
</table>
</s:if>
</div>
<br>
<!--������Ϣ��ʼ-->
<div class="column">
	<div class="listboxtitle">����˵��</div>
    <div class="reminder">
        <p>1.ͳ�Ƹ�ҵ��<font color='red'>˰ǰ���</font>��������Ϣ��</p>
    </div>
</div>
<div class="column">
   <div class="listboxtitle">��ܰ����</div>
   <div class="reminder">
       <s:if test="!parameter.supportPaymonth">
       <p>1.��ѯ������<font color='red'>�������·ݡ�</font>����Ϊ<font color='red'>6λ��Ч���£�����</font>����201109��</p>
       </s:if>
       <s:else>
       <p>1.��ѯ������<font color='red'>�������·ݡ����������·ݡ�����ҵ�����¡�</font>����Ϊ<font color='red'>6λ��Ч���£�����ͬʱΪ��</font>����201109��</p>
       </s:else>
   </div>
</div>

</div>
<!--��׼���ݽ���-->
<%@ include file="/common/include/inc_foot.jsp"%>
</div>
</body>
<%@include file="/common/meta_js.jsp"%>
<script type="text/javascript" src="${ctx}/js/biz/info/reward/cityrecord/stat.js">
</script>
</html>