<%@ page contentType="text/html;charset=GBK" import="com.gmcc.pboss.biz.info.rewardtd.monthremuneration.support.WayrewardOther" pageEncoding="GBK"%>
<%
WayrewardOther info=request.getAttribute("info")==null?new WayrewardOther():(WayrewardOther)request.getAttribute("info");
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
			
			<s:form action="/reward/monthRemunerationAjax.do" method="POST" name="frmQuery" id="frmQuery" > 
			<div class="listboxtitle">��ѯ����</div>
            <table class="tb02" width="100%">
			  <tr>
				<td class="input_label" align="right">������룺</td>
				<td>
					${_PBOSS_WEB_USER.channel.wayid}
				</td>
				<td class="input_label" align="right">�����·ݣ�</td>
				<td>
					 <select name="parameter.rwmon" class="select_3L" id="selMonth" orgval="${parameter.rwmon}"></select>  <font color='red'>*</font>  </td>
					 
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
  <td rowspan=2 colspan=5 class=xl83 style='border-left:none'>�����</td>
  <td colspan=24 class=xl83 style='border-left:none'>ҵ������</td>
 </tr>
 <tr> 
  <td colspan=3 class=xl68 style='border-left:none'><%=info.getRwmon5() %></td>
  <td colspan=3 class=xl68 style='border-left:none'><%=info.getRwmon4() %></td>
  <td colspan=3 class=xl68 style='border-left:none'><%=info.getRwmon3() %></td>
  <td colspan=3 class=xl68 style='border-left:none'><%=info.getRwmon2() %></td>
  <td colspan=3 class=xl68 style='border-left:none'><%=info.getRwmon1() %></td>
  <td colspan=3 class=xl83 style='border-top:none'>�ϼ�</td>
  </tr>
 <tr height=27 style='mso-height-source:userset;height:20.25pt'>
  <td height=27 class=xl83  style='height:20.25pt;
  border-left:none'>�ͻ�����</td>
   <td height=27 class=xl83  style='height:20.25pt;
  border-left:none'>������ҵ��</td>
   <td height=27 class=xl83  style='height:20.25pt;
  border-left:none'>����ϸ��</td>
   <td height=27 class=xl83  style='height:20.25pt;
  border-left:none'>�������</td>
   <td height=27 class=xl83  style='height:20.25pt;
  border-left:none'>���ʳ���׼</td>
   <td class=xl68 style='border-top:none;border-left:none'>ҵ������</td>
  <td class=xl68 style='border-top:none;border-left:none'>����ͨ����</td>
  <td class=xl68 style='border-top:none;border-left:none'>Ӧ������</td> 
   <td class=xl68 style='border-top:none;border-left:none'>ҵ������</td>
  <td class=xl68 style='border-top:none;border-left:none'>����ͨ����</td>
  <td class=xl68 style='border-top:none;border-left:none'>Ӧ������</td>  
  <td class=xl68 style='border-top:none;border-left:none'>ҵ������</td>
  <td class=xl68 style='border-top:none;border-left:none'>����ͨ����</td>
  <td class=xl68 style='border-top:none;border-left:none'>Ӧ������</td>  
  <td class=xl68 style='border-top:none;border-left:none'>ҵ������</td>
  <td class=xl68 style='border-top:none;border-left:none'>����ͨ����</td>
  <td class=xl68 style='border-top:none;border-left:none'>Ӧ������</td>  
  <td class=xl68 style='border-top:none;border-left:none'>ҵ������</td>
  <td class=xl68 style='border-top:none;border-left:none'>����ͨ����</td>
  <td class=xl68 style='border-top:none;border-left:none'>Ӧ������</td>
  <td class=xl68 style='border-top:none;border-left:none'>�ܿ���ҵ����</td>
    <td class=xl68 style='border-top:none;border-left:none'>�ܿ���ͨ����</td>
  <td class=xl68 style='border-top:none;border-left:none'>�ܽ����</td>
 </tr>
 </thead>
 <s:iterator value="retlist">
     <tr align="center" style='mso-height-source:userset;height:20.25pt'>
     <s:if test="rwmonCount > 0">	
     <td rowspan="<s:property value="rwmonCount"/>" height=27 class=xl83  style='height:20.25pt;border-left:none'><s:property value="rwmon"/></td>
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
     <td height=27 class=xl70  style='height:20.25pt; border-left:none'><s:property value="period"/></td>
     <td height=27 class=xl70  style='height:20.25pt; border-left:none'><s:property value="rwstd"/></td>
  <td class=xl69 style='border-top:none;border-left:none'><s:property value="tbusicnt5"/></td>
  <td class=xl69 style='border-top:none;border-left:none'><s:property value="tpasscnt5"/></td>
  <td class=xl69 style='border-top:none;border-left:none'><s:property value="trwmoney5"/></td>
  <td class=xl69 style='border-top:none;border-left:none'><s:property value="tbusicnt4"/></td>
  <td class=xl69 style='border-top:none;border-left:none'><s:property value="tpasscnt4"/></td>
  <td class=xl69 style='border-top:none;border-left:none'><s:property value="trwmoney4"/></td>
  <td class=xl69 style='border-top:none;border-left:none'><s:property value="tbusicnt3"/></td>
  <td class=xl69 style='border-top:none;border-left:none'><s:property value="tpasscnt3"/></td>
  <td class=xl69 style='border-top:none;border-left:none'><s:property value="trwmoney3"/></td>
   <td class=xl69 style='border-top:none;border-left:none'><s:property value="tbusicnt2"/></td>
  <td class=xl69 style='border-top:none;border-left:none'><s:property value="tpasscnt2"/></td>
  <td class=xl69 style='border-top:none;border-left:none'><s:property value="trwmoney2"/></td>
  <td class=xl69 style='border-top:none;border-left:none'><s:property value="tbusicnt1"/></td>
  <td class=xl69 style='border-top:none;border-left:none'><s:property value="tpasscnt1"/></td>
  <td class=xl69 style='border-top:none;border-left:none'><s:property value="trwmoney1"/></td>
  <td class=xl69 style='border-top:none;border-left:none'><s:property value="sumbusicnt"/></td>
    <td class=xl69 style='border-top:none;border-left:none'><s:property value="sumpasscnt"/></td>
  <td class=xl69 style='border-top:none;border-left:none'><s:property value="sumrwmoney"/></td>
 </tr>
    </s:iterator>
    <tr align="center" style='mso-height-source:userset;height:20.25pt'>
  
   <td colspan="5" height=27 class=xl70  style='height:20.25pt; border-left:none'>���ϼ�</td>

  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'><%=info.getTrwmoney5() %></td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'><%=info.getTrwmoney4() %></td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'><%=info.getTrwmoney3() %></td>
   <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'><%=info.getTrwmoney2() %></td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'><%=info.getTrwmoney1() %></td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
    <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'><%=info.getSumrwmoney() %></td>
 </tr>
 <tr align="center" style='mso-height-source:userset;height:20.25pt'>
  
   <td colspan="5" height=27 class=xl70  style='height:20.25pt; border-left:none'>�������ϼ�</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
   <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
    <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'><%=info.getOtherrwmoney() %></td>
 </tr>
 <tr align="center" style='mso-height-source:userset;height:20.25pt'>
  
   <td colspan="5" height=27 class=xl70  style='height:20.25pt; border-left:none'>�ϼ�</td>

  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
   <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
    <td class=xl69 style='border-top:none;border-left:none'>&nbsp;&nbsp;</td>
  <td class=xl69 style='border-top:none;border-left:none'><%=info.getSumpaymoney1() %></td>
 </tr>
</table>
	</s:if>		
            <br>
            <!--������Ϣ��ʼ-->
            <div class="column">
                 <div class="listboxtitle">����˵����</div>
                   <div class="reminder">
      				  <p>1.ͳ�Ƹ�ҵ��<font color='red'>�¶�Ӧ����𱨱�</font>��</p>
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
<script type="text/javascript" src="${ctx}/js/biz/info/reward/rewardtd/monthremuneration/monthRemuneration.js"></script> 
<SCRIPT type="text/javascript">

</SCRIPT>
</html>