<%@ page contentType="text/html;charset=GBK" import="com.gmcc.pboss.biz.info.rewardtd.rewardbusiness.support.RewardBusinessOther" pageEncoding="GBK"%>
<%
RewardBusinessOther info=request.getAttribute("info")==null?new RewardBusinessOther():(RewardBusinessOther)request.getAttribute("info");
    %>
<%@ include file="/common/jspHead.jsp"%>
<html>
<head>
<!-- ������̬�ļ� -->
<%@ include file="/common/meta_allcss.jsp"%>
<style>
.xl68
	{mso-style-parent:style0;
	font-weight:700;
	text-align:center;
	border:.5pt solid windowtext;
	background:#E4DFEC;
	mso-pattern:black none;
	white-space:normal;}
.xl69
	{mso-style-parent:style0;
	text-align:center;
	border:.5pt solid windowtext;
	white-space:normal;}
.xl70
	{mso-style-parent:style0;
	text-align:center;
	border:.5pt solid windowtext;
	background:#FCD5B4;
	mso-pattern:black none;
	white-space:normal;}
.xl83
	{mso-style-parent:style0;
	color:red;
	font-size:12.0pt;
	font-weight:700;
	text-align:center;
	border:.5pt solid windowtext;
	background:#B7DEE8;
	mso-pattern:black none;
	white-space:normal;}
.xl87
	{mso-style-parent:style0;
	color:red;
	font-weight:700;
	text-align:center;
	border:.5pt solid windowtext;
	background:#8DB4E2;
	mso-pattern:black none;
	white-space:normal;}
</style>

</head>
<body>
	<!-- ͷ�������� -->
<%@ include file="/common/include/inc_managerhead.jsp"%>	
<!--��׼���ݿ�ʼ-->
<div class="divspan">
<!-- ��������-->
<%@ include file="/common/include/inc_menu.jsp"%>
        <div class="context">
			<div class="listmyposition">
				<span class="font_breadcrumbtitle">�����ڵ�λ�ã�</span><span class="font_breadcrumb">${location}</span>
			</div>
			
			<s:form action="/managerView/rewardBusinessAjax.do" method="POST" name="frmQuery" id="frmQuery"> 
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
					 <select name="parameter.oprmon" class="select_3L" id="selMonth" orgval="${parameter.oprmon}"></select>  <font color='red'>*</font>  </td>
					 
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
			<s:if test="retlist.size>0">
			 <table  class = "tb_comn" width="100%" >
			 <thead >
  <tr height=36 style='mso-height-source:userset;height:27.0pt'>
  <td rowspan=3 height=63 class=xl87 style='height:47.25pt;border-top:
  none'>��������</td>
  <td rowspan=2 colspan=6 class=xl83 style='border-left:none'>�����</td>
  <td colspan=24 class=xl83 style='border-left:none'>ҵ������</td>
 </tr>
 <tr> 
  <td colspan=2 class=xl68 style='border-left:none'><%=info.getOprmon1() %></td>
  <td colspan=2 class=xl68 style='border-left:none'><%=info.getOprmon2() %></td>
  <td colspan=2 class=xl68 style='border-left:none'><%=info.getOprmon3() %></td>
  <td colspan=2 class=xl68 style='border-left:none'><%=info.getOprmon4() %></td>
  <td colspan=2 class=xl68 style='border-left:none'><%=info.getOprmon5() %></td>
  <td colspan=2 class=xl68 style='border-left:none'><%=info.getOprmon6() %></td>
  <td colspan=2 class=xl68 style='border-left:none'><%=info.getOprmon7() %></td>
  </tr>
 <tr height=27 style='mso-height-source:userset;height:20.25pt'>
  <td height=27 class=xl83  style='height:20.25pt;
  border-left:none'>�ͻ�����</td>
   <td height=27 class=xl83  style='height:20.25pt;
  border-left:none'>������ҵ��</td>
   <td height=27 class=xl83  style='height:20.25pt;
  border-left:none'>����ϸ��</td>
   <td height=27 class=xl83  style='height:20.25pt;
  border-left:none'>���ʺϼƳ������</td>
   <td height=27 class=xl83  style='height:20.25pt;
  border-left:none'>ҵ����</td>
  <td height=27 class=xl83  style='height:20.25pt;
  border-left:none'>�ɼƳ���ܶ�</td>
  <td class=xl68 style='border-top:none;border-left:none'>������/��׼</td>
  <td class=xl68 style='border-top:none;border-left:none'>���³����</td>
  <td class=xl68 style='border-top:none;border-left:none'>������/��׼</td>
  <td class=xl68 style='border-top:none;border-left:none'>���³����</td> 
  <td class=xl68 style='border-top:none;border-left:none'>������/��׼</td>
  <td class=xl68 style='border-top:none;border-left:none'>���³����</td>
  <td class=xl68 style='border-top:none;border-left:none'>������/��׼</td>
  <td class=xl68 style='border-top:none;border-left:none'>���³����</td> 
  <td class=xl68 style='border-top:none;border-left:none'>������/��׼</td>
  <td class=xl68 style='border-top:none;border-left:none'>���³����</td> 
  <td class=xl68 style='border-top:none;border-left:none'>������/��׼</td>
  <td class=xl68 style='border-top:none;border-left:none'>���³����</td> 
  <td class=xl68 style='border-top:none;border-left:none'>������/��׼</td>
  <td class=xl68 style='border-top:none;border-left:none'>���³����</td>
 </tr>
 </thead>
 <s:iterator value="retlist">
     <tr align="center" style='mso-height-source:userset;height:20.25pt'>
     <s:if test="oprmonCount > 0">	
     <td rowspan="<s:property value="oprmonCount"/>" height=27 class=xl83  style='height:20.25pt;border-left:none'><s:property value="oprmon"/></td>
 	 </s:if>
 	 
 	  <s:if test="custtypeCount > 0">	
 	 <td rowspan="<s:property value="custtypeCount"/>" height=27 class=xl70  style='height:20.25pt; border-left:none'><s:property value="custtype"/></td>
      </s:if>
      
       <s:if test="rwtypenameCount > 0">	
      <td rowspan="<s:property value="rwtypenameCount"/>" height=27 class=xl70  style='height:20.25pt;border-left:none'><s:property value="rwtypename"/></td>
      </s:if>
      
       <s:if test="chkitemnameCount > 0">	
     <td rowspan="<s:property value="chkitemnameCount"/>" height=27 class=xl70  style='height:20.25pt; border-left:none'><s:property value="chkitemname"/></td>
     </s:if>
     <td height=27 class=xl70  style='height:20.25pt; border-left:none'><s:property value="rwhlvl"/></td>
     <td height=27 class=xl70  style='height:20.25pt; border-left:none'><s:property value="busicnt"/></td>
     <td height=27 class=xl70  style='height:20.25pt; border-left:none'><s:property value="maxrwmoney"/></td>
  <td class=xl69 style='border-top:none;border-left:none'><s:property value="trwstd1"/></td>
  <td class=xl69 style='border-top:none;border-left:none'><s:property value="trwmoney1"/></td>
  <td class=xl69 style='border-top:none;border-left:none'><s:property value="trwstd2"/></td>
  <td class=xl69 style='border-top:none;border-left:none'><s:property value="trwmoney2"/></td>
 <td class=xl69 style='border-top:none;border-left:none'><s:property value="trwstd3"/></td>
  <td class=xl69 style='border-top:none;border-left:none'><s:property value="trwmoney3"/></td>
  <td class=xl69 style='border-top:none;border-left:none'><s:property value="trwstd4"/></td>
  <td class=xl69 style='border-top:none;border-left:none'><s:property value="trwmoney4"/></td>
 <td class=xl69 style='border-top:none;border-left:none'><s:property value="trwstd5"/></td>
  <td class=xl69 style='border-top:none;border-left:none'><s:property value="trwmoney5"/></td>
   <td class=xl69 style='border-top:none;border-left:none'><s:property value="trwstd6"/></td>
  <td class=xl69 style='border-top:none;border-left:none'><s:property value="trwmoney6"/></td>
 <td class=xl69 style='border-top:none;border-left:none'><s:property value="trwstd7"/></td>
  <td class=xl69 style='border-top:none;border-left:none'><s:property value="trwmoney7"/></td>
 </tr>
    </s:iterator>
    <tr align="center" style='mso-height-source:userset;height:20.25pt'>
  
  <td colspan="6" height=27 class=xl70  style='height:20.25pt; border-left:none'>���ϼ�</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'><%=info.getTrwmoney1()%></td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'><%=info.getTrwmoney2() %></td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'><%=info.getTrwmoney3() %></td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'><%=info.getTrwmoney4() %></td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'><%=info.getTrwmoney5() %></td>
   <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'><%=info.getTrwmoney6() %></td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'><%=info.getTrwmoney7() %></td>
 </tr>
 
</table>
	</s:if>		
            <br>
            <!--������Ϣ��ʼ-->
            <div class="column">
                 <div class="listboxtitle">����˵����</div>
                   <div class="reminder">
      				  <p>1.ͳ�Ƹ�ҵ��<font color='red'>ҵ���������ڱ�</font>��</p><br/>
      				  
    				</div>
               </div>
               <div class="column">
                 <div class="listboxtitle">��ܰ���ѣ�</div>
                    <div class="reminder">
                      <p>1.��ѯ������<font color='red'>�������·ݡ�����Ϊ��</font>��
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
<script type="text/javascript" src="${ctx}/js/biz/info/reward/rewardtd/rewardbusiness/rewardBusiness.js"></script> 
<SCRIPT type="text/javascript">
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